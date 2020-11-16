package com.onlineapteka.testapplication.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.onlineapteka.testapplication.R;

public class VerifyCodeActivity extends AppCompatActivity {

    private EditText mCodeVerifyEdit;
    private Button mButtonBack;
    private Button mVerifyCodeButton;
    private ProgressBar mVerifyProgressBar;
    private Button mNextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_code);
        initViews();
    }

    private void initViews() {
        mCodeVerifyEdit = findViewById(R.id.code_verify_edit);
        mButtonBack = findViewById(R.id.button_back);
        mVerifyCodeButton = findViewById(R.id.verify_code_button);
        mVerifyProgressBar = findViewById(R.id.verify_progress_bar);
        mNextButton = findViewById(R.id.next_button);


    }
}