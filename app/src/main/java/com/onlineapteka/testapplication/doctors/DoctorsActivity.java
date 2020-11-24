package com.onlineapteka.testapplication.doctors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.onlineapteka.testapplication.R;
import com.onlineapteka.testapplication.doctors.recycler.DoctorAdapter;
import com.onlineapteka.testapplication.doctors.recycler.DoctorViewHolder;
import com.onlineapteka.testapplication.model.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorsActivity extends AppCompatActivity implements DoctorViewHolder.IOnClickListener {

    private DoctorsViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private DoctorAdapter mDoctorAdapter;
    private List<Doctor> mDoctors;
    private TextView mToolbarText;
    private Toolbar mToolbar;


    private String subTitle;
    private String id;

    public static final String GET_STRING_EXTRA_PROFESSIONS_TITLE = "professionsName";
    public static final String GET_STRING_EXTRA_PROFESSIONS_ID = "professionsId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors);
        Intent intent = getIntent();

        subTitle = intent.getStringExtra(GET_STRING_EXTRA_PROFESSIONS_TITLE);
        id = intent.getStringExtra(GET_STRING_EXTRA_PROFESSIONS_ID);

        initViews();
        initViewModels();
        mViewModel.getDoctorsList(id);
        mViewModel.getDoctorsList(subTitle);

    }

    private void initViewModels() {
        mViewModel = ViewModelProviders.of(this).get(DoctorsViewModel.class);
        mViewModel.doctorsLiveData.observe(this, new Observer<List<Doctor>>() {
            @Override
            public void onChanged(List<Doctor> doctors) {
                mDoctorAdapter.setData(doctors);
                mDoctors = new ArrayList<>();
                mDoctors.addAll(doctors);
            }
        });
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.doctors_recycler);
        mToolbarText = findViewById(R.id.doctors_toolbar_text);
        mToolbar = findViewById(R.id.doctors_toolbar);

        mToolbarText.setText(subTitle);
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

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mDoctorAdapter = new DoctorAdapter(this);
        mRecyclerView.setAdapter(mDoctorAdapter);
    }

    @Override
    public void onClick(int position) {

    }
}