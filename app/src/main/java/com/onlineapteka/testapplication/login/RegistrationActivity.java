package com.onlineapteka.testapplication.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import com.onlineapteka.testapplication.R;

public class RegistrationActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private EditText mFirstNameEdit;
    private EditText mSecondNameEdit;
    private Spinner mSexSpinner;
    private Spinner mAgeSpinner;
    private Button mVerifyRegisterButton;

    public static void start(Context context){
        context.startActivity(new Intent(context,RegistrationActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initViews();
    }

    private void initViews() {

        mFirstNameEdit = findViewById(R.id.first_name_edit);
        mSecondNameEdit = findViewById(R.id.second_name_edit);
        mSexSpinner = findViewById(R.id.sex_spinner);
        mAgeSpinner = findViewById(R.id.age_spinner);
        mVerifyRegisterButton = findViewById(R.id.verify_register_button);

        mVerifyRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegistrationActivity.this,"Pressed",Toast.LENGTH_LONG).show();
            }
        });
    }
}