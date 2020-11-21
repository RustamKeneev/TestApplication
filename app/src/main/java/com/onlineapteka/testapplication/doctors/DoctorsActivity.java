package com.onlineapteka.testapplication.doctors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.onlineapteka.testapplication.R;

public class DoctorsActivity extends AppCompatActivity {

    private static final String EXTRA_PROFESSIONS_ID = "professionsId";
    private static final String EXTRA_PROFESSIONS_NAME = "professionsName";

    public static void startActivity(Context context, String professionsId, String professionsName){
        Intent intent = new Intent(context, DoctorsActivity.class);
        intent.putExtra(DoctorsActivity.EXTRA_PROFESSIONS_ID,professionsId);
        intent.putExtra(DoctorsActivity.EXTRA_PROFESSIONS_NAME,professionsName);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors);
    }
}