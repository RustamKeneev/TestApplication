package com.onlineapteka.testapplication.login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.onlineapteka.testapplication.MainActivity;
import com.onlineapteka.testapplication.R;

import com.onlineapteka.testapplication.util.Constants;

import java.util.concurrent.TimeUnit;

import static com.onlineapteka.testapplication.util.Constants.CLIENT;

public class VerifyCodeActivity extends AppCompatActivity {

    private EditText mCodeVerifyEdit;
    private Button mButtonBack;
    private Button mVerifyCodeButton;
    private ProgressBar mVerifyProgressBar;
    private Button mNextButton;

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks changedCallbacks;
    private String mVerification;
    private PhoneAuthProvider.ForceResendingToken mResendingToken;
    private String code;
    private FirebaseFirestore db;
    private String phoneNumber;


    private static final String PHONE_NUMBER = "phonenumber";

    public static void start(Context context, String phoneNumber) {
        Intent intent = new Intent(context, VerifyCodeActivity.class);
        intent.putExtra(PHONE_NUMBER, phoneNumber);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_code);
        initViews();
        getPhoneNumber();

    }

    private void getPhoneNumber() {
        phoneNumber = getIntent().getStringExtra(PHONE_NUMBER);
        sendVerificationCode(phoneNumber);
    }

    private void sendVerificationCode(String phoneNumber) {
        verificationUser();
        mVerifyProgressBar.setVisibility(View.VISIBLE);
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,
                60,
                TimeUnit.SECONDS,
                VerifyCodeActivity.this,
                changedCallbacks
        );
    }

    private void verificationUser() {
        changedCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                code = phoneAuthCredential.getSmsCode();
                if (code !=null){
                    mVerifyProgressBar.setVisibility(View.INVISIBLE);
                    mCodeVerifyEdit.setText(code);
                }
                newUserSignIn(phoneAuthCredential);
            }

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                mVerification = s;
                mResendingToken = forceResendingToken;
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                Toast.makeText(VerifyCodeActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        };
    }

    private void newUserSignIn(PhoneAuthCredential phoneAuthCredential) {
        FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            mNextButton.setVisibility(View.VISIBLE);
                            mNextButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    db.collection(CLIENT)
                                            .document(phoneNumber)
                                            .addSnapshotListener(new EventListener<DocumentSnapshot>() {
                                                @Override
                                                public void onEvent(@Nullable DocumentSnapshot value,
                                                                    @Nullable FirebaseFirestoreException error) {
                                                    if (value == null && value.exists()) {
                                                        if (value.get("age") == null &&
                                                                value.get("firstName") == null &&
                                                                        value.get("secondName") ==null){
                                                            RegistrationActivity.start(VerifyCodeActivity.this);
                                                            finish();
                                                        }
                                                    }else {
                                                        MainActivity.start(VerifyCodeActivity.this);
                                                        finish();
                                                    }
                                                }
                                            });
                                }
                            });
                        }else {
                            Toast.makeText(VerifyCodeActivity.this,"Не успешно",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private void initViews() {
        mCodeVerifyEdit = findViewById(R.id.code_verify_edit);
        mButtonBack = findViewById(R.id.button_back);
        mVerifyCodeButton = findViewById(R.id.verify_code_button);
        mVerifyProgressBar = findViewById(R.id.verify_progress_bar);
        mNextButton = findViewById(R.id.next_button);

        mVerifyCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = mCodeVerifyEdit.getText().toString().trim();
                if (code.isEmpty() || code.length()<6){
                    mCodeVerifyEdit.setError("Смс код должен быть больше 6ти симфолов.");
                    mCodeVerifyEdit.requestFocus();
                    return;
                }
                verifyVerificationCode(code);
            }
        });

        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VerifyCodeActivity.this,PhoneAuthActivity.class));
                finish();
            }
        });

    }

    private void verifyVerificationCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerification,code);
        newUserSignIn(credential);
    }
}