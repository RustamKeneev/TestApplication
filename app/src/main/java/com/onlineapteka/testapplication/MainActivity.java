package com.onlineapteka.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.onlineapteka.testapplication.chat.ChatMainActivity;
import com.onlineapteka.testapplication.login.PhoneAuthActivity;
import com.onlineapteka.testapplication.professions.ProfessionsInMedicineActivity;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button chatButton;


    public static void start(Context context){
        context.startActivity(new Intent(context, MainActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setSplashScreenTime();

    }

    private void initViews() {
        button = findViewById(R.id.button);
        chatButton = findViewById(R.id.button_chat);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfessionsInMedicineActivity.start(MainActivity.this);
            }
        });

        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ChatMainActivity.class));
            }
        });
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