package com.onlineapteka.testapplication.test_display;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.onlineapteka.testapplication.R;

public class TestSecondActivity extends AppCompatActivity {

    private String type;
    private String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_second);
        Intent intent = getIntent();
        id = intent.getStringExtra("doctorId");
        type = intent.getStringExtra("doctorType");

        Log.d("TAG", "onCreate: doctorId " + id);
        Log.d("TAG", "onCreate: doctorType " + type);
    }
}