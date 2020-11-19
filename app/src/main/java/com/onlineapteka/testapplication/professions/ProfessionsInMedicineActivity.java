package com.onlineapteka.testapplication.professions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;

import com.onlineapteka.testapplication.R;

public class ProfessionsInMedicineActivity extends AppCompatActivity {

    private EditText mSearchProfessionsEdit;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professions_in_medicine);
        initviews();
    }

    private void initviews() {
        mSearchProfessionsEdit = findViewById(R.id.search_professions_edit);
        mRecyclerView = findViewById(R.id.professions_recycler);
    }
}