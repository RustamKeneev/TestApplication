package com.onlineapteka.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;

import com.onlineapteka.testapplication.login.PhoneAuthActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSplashScreenTime();

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