package com.onlineapteka.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;

import com.onlineapteka.testapplication.login.AuthActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSplashScreenTime();
    }

    private void setSplashScreenTime() {
        new CountDownTimer(3000,100){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                getRegistrationActivity();
            }
        }.start();
    }

    private void getRegistrationActivity() {
        AuthActivity.start(this);
        finish();
    }
}