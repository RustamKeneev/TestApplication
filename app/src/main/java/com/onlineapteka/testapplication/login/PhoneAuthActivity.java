package com.onlineapteka.testapplication.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.onlineapteka.testapplication.R;

public class PhoneAuthActivity extends AppCompatActivity {

    private EditText mPhoneNumberEdit;
    private Button mContinuePhoneNumberButton;


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
                startActivity(new Intent(PhoneAuthActivity.this,VerifyCodeActivity.class));
//                finish();
            }
        });
    }
}