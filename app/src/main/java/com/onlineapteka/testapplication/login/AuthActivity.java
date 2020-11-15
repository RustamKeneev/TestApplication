package com.onlineapteka.testapplication.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.onlineapteka.testapplication.R;

public class AuthActivity extends AppCompatActivity {

    public static void start(Context context){
        context.startActivity(new Intent(context,AuthActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        setTitle("Авторизация");
    }
}