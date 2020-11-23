package com.onlineapteka.testapplication.doctors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.onlineapteka.testapplication.R;
import com.onlineapteka.testapplication.doctors.recycler.DoctorAdapter;
import com.onlineapteka.testapplication.doctors.recycler.DoctorViewHolder;
import com.onlineapteka.testapplication.model.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorsActivity extends AppCompatActivity implements DoctorViewHolder.IOnClickListener {

    private static final String EXTRA_PROFESSIONS_ID = "professionsId";
    private static final String EXTRA_PROFESSIONS_NAME = "professionsName";

    private DoctorsViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private DoctorAdapter mDoctorAdapter;
    private List<Doctor> mDoctors;


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
        initViews();
        initViewModels();
    }

    private void initViewModels() {
        mViewModel = ViewModelProviders.of(this).get(DoctorsViewModel.class);
        mViewModel.getDoctorsList(getIntent().getStringExtra(DoctorsActivity.EXTRA_PROFESSIONS_ID));
        mViewModel.doctorsLiveData.observe(this, new Observer<List<Doctor>>() {
            @Override
            public void onChanged(List<Doctor> doctors) {
                mDoctorAdapter.setData(doctors);
                mDoctors = new ArrayList<>();
                mDoctors.addAll(doctors);

                Log.d("TAG", "onChanged: doctors size" + doctors.size());
            }
        });
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.doctors_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mDoctorAdapter = new DoctorAdapter(this);
        mRecyclerView.setAdapter(mDoctorAdapter);
    }

    @Override
    public void onClick(int position) {

    }
}