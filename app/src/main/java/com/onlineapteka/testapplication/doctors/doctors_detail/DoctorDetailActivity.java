package com.onlineapteka.testapplication.doctors.doctors_detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.onlineapteka.testapplication.R;

public class DoctorDetailActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TextView mToolbarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);
        initViews();
        initViewModels();
    }

    private void initViewModels() {
        mToolbar = findViewById(R.id.doctors_detail_toolbar);
        mToolbarText = findViewById(R.id.doctors_detail_toolbar_text);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);
        if (getSupportActionBar() !=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
    }

    private void initViews() {

    }
}