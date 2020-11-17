package com.onlineapteka.testapplication.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.onlineapteka.testapplication.MainActivity;
import com.onlineapteka.testapplication.R;

public class PhoneAuthActivity extends AppCompatActivity {

    private EditText mPhoneNumberEdit;
    private Button mContinuePhoneNumberButton;

    public static void start(Context context){
        context.startActivity(new Intent(context,PhoneAuthActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_auth);
        initViews();
    }

    private void initViews() {
        mPhoneNumberEdit = findViewById(R.id.phone_number_edit);
        mContinuePhoneNumberButton = findViewById(R.id.continue_register_phone_button);
        mContinuePhoneNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUserPhoneNumber();
//                startActivity(new Intent(PhoneAuthActivity.this,VerifyCodeActivity.class));
//                finish();
            }
        });
    }

    private void getUserPhoneNumber() {
        String phoneNumber = mPhoneNumberEdit.getText().toString().trim();
        if (phoneNumber.isEmpty() || phoneNumber.length() > 13){
            mPhoneNumberEdit.setError("Номер должен содержать не менее 13-ти символов");
            return;
        }
        VerifyCodeActivity.start(this,phoneNumber);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (FirebaseAuth.getInstance().getCurrentUser() !=null){
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }
}