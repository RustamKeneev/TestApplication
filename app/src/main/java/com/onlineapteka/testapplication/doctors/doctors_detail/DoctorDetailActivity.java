package com.onlineapteka.testapplication.doctors.doctors_detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.onlineapteka.testapplication.App;
import com.onlineapteka.testapplication.R;
import com.onlineapteka.testapplication.model.Doctor;

import java.util.List;

public class DoctorDetailActivity extends AppCompatActivity {

    private DoctorDetailViewmodel mViewModel;
    private Toolbar mToolbar;
    private TextView mToolbarText;
    private ImageView mDoctorImage;
    private TextView mSecondName;


    private String id;
    private String title;



    public static final String GET_STRING_EXTRA_DOCTORS_TITLE = "doctorTitle";
    public static final String GET_STRING_EXTRA_DOCTORS_ID = "doctorId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);

        Intent intent = getIntent();
        id = intent.getStringExtra(GET_STRING_EXTRA_DOCTORS_ID);
        title = intent.getStringExtra(GET_STRING_EXTRA_DOCTORS_TITLE);
        initViewModels();


//        mViewModel.getDoctorDetail(title);
    }


    private void initViewModels() {
      mViewModel = ViewModelProviders.of(this).get(DoctorDetailViewmodel.class);
      mViewModel.getDoctorId(id);
      mViewModel.doctorMutableLiveData.observe(this, new Observer<Doctor>() {
          @Override
          public void onChanged(Doctor doctor) {
              initViews(doctor);
          }
      });
    }

    private void initViews(Doctor doctor) {
        mToolbar = findViewById(R.id.doctors_detail_toolbar);
        mToolbarText = findViewById(R.id.doctors_detail_toolbar_text);
        mDoctorImage = findViewById(R.id.doctors_detail_image);
        mSecondName = findViewById(R.id.second_name_text);

        mSecondName.setText(doctor.getSecondName());
        Glide.with(this).load(doctor.getDoctorImage()).into(mDoctorImage);




//        mToolbarText.setText(title);
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
}