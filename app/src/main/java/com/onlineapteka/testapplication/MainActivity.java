package com.onlineapteka.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.google.firebase.auth.FirebaseAuth;
import com.onlineapteka.testapplication.login.PhoneAuthActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSplashScreenTime();

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (FirebaseAuth.getInstance().getCurrentUser() ==null){
            startActivity(new Intent(this, PhoneAuthActivity.class));
            finish();
        }
    }

    private void setSplashScreenTime() {
        new CountDownTimer(1000,1000){
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                getRegistrationActivity();
            }
        };
    }

    private void getRegistrationActivity() {
        PhoneAuthActivity.start(this);
        finish();
    }
}