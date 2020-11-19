package com.onlineapteka.testapplication.professions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;

import com.onlineapteka.testapplication.R;
import com.onlineapteka.testapplication.model.Professions;
import com.onlineapteka.testapplication.professions.recycler.ProfessionsAdapter;
import com.onlineapteka.testapplication.professions.recycler.ProfessionsViewHolder;

import java.util.ArrayList;

public class ProfessionsInMedicineActivity extends AppCompatActivity implements ProfessionsViewHolder.IOnClickListener {

    private EditText mSearchProfessionsEdit;
    private RecyclerView mRecyclerView;
    private ProfessionsAdapter mProfessionsAdapter;
    private ArrayList<Professions> mProfessions;
    private GridLayoutManager gridLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professions_in_medicine);
        initviews();
    }

    private void initviews() {
        mSearchProfessionsEdit = findViewById(R.id.search_professions_edit);
        mRecyclerView = findViewById(R.id.professions_recycler);

        mProfessions = new ArrayList<>();
        mProfessions.add(new Professions("id",R.drawable.ic_logotype_auth, "Аллерголог","Специалист по аллергии","Аллергология"));
        mProfessions.add(new Professions("id",R.drawable.ic_logotype_auth, "Аллерголог","Специалист по аллергии","Аллергология"));
        mProfessions.add(new Professions("id",R.drawable.ic_logotype_auth, "Аллерголог","Специалист по аллергии","Аллергология"));
        mProfessions.add(new Professions("id",R.drawable.ic_logotype_auth, "Аллерголог","Специалист по аллергии","Аллергология"));
        mProfessions.add(new Professions("id",R.drawable.ic_logotype_auth, "Аллерголог","Специалист по аллергии","Аллергология"));
        mProfessions.add(new Professions("id",R.drawable.ic_logotype_auth, "Аллерголог","Специалист по аллергии","Аллергология"));
        mProfessions.add(new Professions("id",R.drawable.ic_logotype_auth, "Аллерголог","Специалист по аллергии","Аллергология"));
        mProfessions.add(new Professions("id",R.drawable.ic_logotype_auth, "Аллерголог","Специалист по аллергии","Аллергология"));
        mProfessions.add(new Professions("id",R.drawable.ic_logotype_auth, "Аллерголог","Специалист по аллергии","Аллергология"));
        mProfessions.add(new Professions("id",R.drawable.ic_logotype_auth, "Аллерголог","Специалист по аллергии","Аллергология"));
        mProfessions.add(new Professions("id",R.drawable.ic_logotype_auth, "Аллерголог","Специалист по аллергии","Аллергология"));
        mProfessions.add(new Professions("id",R.drawable.ic_logotype_auth, "Аллерголог","Специалист по аллергии","Аллергология"));
        mProfessions.add(new Professions("id",R.drawable.ic_logotype_auth, "Аллерголог","Специалист по аллергии","Аллергология"));

        mProfessionsAdapter = new ProfessionsAdapter(this);
        gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(mProfessionsAdapter);
        mProfessionsAdapter.updateList(mProfessions);
    }

    @Override
    public void onClick(String position, String title) {

    }
}