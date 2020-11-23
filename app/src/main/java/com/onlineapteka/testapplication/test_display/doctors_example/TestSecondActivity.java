package com.onlineapteka.testapplication.test_display.doctors_example;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.onlineapteka.testapplication.R;
import com.onlineapteka.testapplication.model.Doctor;
import com.onlineapteka.testapplication.test_display.doctors_example.recycler.DoctorTestAdapter;
import com.onlineapteka.testapplication.test_display.doctors_example.recycler.DoctorTestViewHolder;

import java.util.ArrayList;

public class TestSecondActivity extends AppCompatActivity implements DoctorTestViewHolder.IOnClickListener {

    private String type;
    private String id;

    private RecyclerView mRecyclerView;
    private ArrayList<Doctor> doctors;
    private LinearLayoutManager linearLayoutManager;
    private DoctorTestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_second);
        initViews();
        initViewModels();
        Intent intent = getIntent();
        id = intent.getStringExtra("doctorId");
        type = intent.getStringExtra("doctorType");

        Log.d("TAG", "onCreate: doctorId " + id);
        Log.d("TAG", "onCreate: doctorType " + type);
    }

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    private void initViewModels() {
        db.collection("sidelka")
                .whereEqualTo("id","id")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("TAG", document.getId() + " => " + document.getData());
                            }
                        }else {
                            Log.d("TAG", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.doctors_recycler);

        doctors = new ArrayList<>();
        adapter = new DoctorTestAdapter(this);
        mRecyclerView.setAdapter(adapter);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        adapter.updateList(doctors);

    }

    @Override
    public void onClick(String position, String title) {

    }
}