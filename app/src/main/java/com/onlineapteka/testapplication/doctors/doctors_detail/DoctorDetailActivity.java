package com.onlineapteka.testapplication.doctors.doctors_detail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.onlineapteka.testapplication.R;
import com.onlineapteka.testapplication.model.Doctor;


public class DoctorDetailActivity extends AppCompatActivity {

    private DoctorDetailViewmodel mViewModel;
    private Toolbar mToolbar;
    private TextView mToolbarText;
    private ImageView mDoctorImage;
    private TextView mSecondName;
    private TextView mFirstNameText;
    private TextView mLastNameText;
    private TextView mDoctorStatusText;
    private TextView mDoctorDetailWorkLocation;
    private TextView mDoctorEducationCardText;
    private TextView mDoctorInfoText;
    private CardView mCallToDoctorCard;
    private CardView mSendMessageToDoctorCard;


    private String id;
    private String title;
    private String phoneNumber;


    public static final String GET_STRING_EXTRA_DOCTORS_TITLE = "doctorTitle";
    public static final String GET_STRING_EXTRA_DOCTORS_ID = "doctorId";
    private final int REQUEST_PERMISSION_PHONE_STATE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);

        Intent intent = getIntent();
        id = intent.getStringExtra(GET_STRING_EXTRA_DOCTORS_ID);
        title = intent.getStringExtra(GET_STRING_EXTRA_DOCTORS_TITLE);
        initViewModels();
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

        mFirstNameText = findViewById(R.id.first_name_text);
        mLastNameText = findViewById(R.id.last_name_text);
        mDoctorStatusText = findViewById(R.id.doctor_status_text);
        mDoctorDetailWorkLocation = findViewById(R.id.doctor_detail_work_location);
        mDoctorEducationCardText = findViewById(R.id.doctor_education_card_text);
        mDoctorInfoText = findViewById(R.id.doctor_info_text);
        mCallToDoctorCard = findViewById(R.id.call_to_doctor_card);
        mSendMessageToDoctorCard = findViewById(R.id.send_message_to_doctor_card);


        mToolbarText.setText(doctor.getDoctor_type());
        Glide.with(this).load(doctor.getDoctorImage()).into(mDoctorImage);
        mSecondName.setText(doctor.getSecondName());
        mFirstNameText.setText(doctor.getFirstName());
        mLastNameText.setText(doctor.getLastName());
        mDoctorStatusText.setText(doctor.getDoctorStatus());
        mDoctorDetailWorkLocation.setText(doctor.getDoctorWorkLocation());
        mDoctorEducationCardText.setText(doctor.getDoctorEducation());
        mDoctorInfoText.setText(doctor.getDoctorInfo());

        mCallToDoctorCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DoctorDetailActivity.this, "Pressed Call", Toast.LENGTH_LONG).show();
                phoneNumber = doctor.getPhoneNumber();
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));

                if (ActivityCompat.checkSelfPermission(DoctorDetailActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(DoctorDetailActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            1);
                    return;
                }
                startActivity(intent);

            }
        });

        mSendMessageToDoctorCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DoctorDetailActivity.this,"Pressed Send Message",Toast.LENGTH_LONG).show();
            }
        });

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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    Toast.makeText(DoctorDetailActivity.this,
                            "Чтобы осуществлять звонок разрешите на чтение вашего внешнего хранилища ",
                            Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }
}