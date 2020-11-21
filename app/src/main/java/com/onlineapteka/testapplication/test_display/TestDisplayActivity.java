package com.onlineapteka.testapplication.test_display;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.onlineapteka.testapplication.R;
import com.onlineapteka.testapplication.model.ProfessionsCategory;

import java.util.ArrayList;

public class TestDisplayActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private TestProfessionsAdapter testProfessionsAdapter;
    private ArrayList<ProfessionsCategory> categories;
    private LinearLayoutManager linearLayoutManager;

    private CatalogProfessionsViewModel viewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_display);
        mRecyclerView = findViewById(R.id.test_recycler);
        initViews();
        initViewModels();
    }

    private void initViewModels() {
        viewModel = ViewModelProviders.of(this).get(CatalogProfessionsViewModel.class);
//        viewModel.getProfessionsCategory();
    }

    private void initViews() {
        categories = new ArrayList<>();
        categories.add(new ProfessionsCategory("Aллергия",R.drawable.ic_logotype_auth));
        testProfessionsAdapter = new TestProfessionsAdapter(this,categories);
        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(testProfessionsAdapter);

    }
}