package com.onlineapteka.testapplication.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.TaskExecutor;

import android.app.Activity;
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
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.onlineapteka.testapplication.MainActivity;
import com.onlineapteka.testapplication.ProfileActivity;
import com.onlineapteka.testapplication.R;

import java.util.concurrent.TimeUnit;

public class RegistrationActivity extends AppCompatActivity {

    public static void start(Context context){
        context.startActivity(new Intent(context,RegistrationActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phone);

    }
}