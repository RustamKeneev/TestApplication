package com.onlineapteka.testapplication.professions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.onlineapteka.testapplication.R;
import com.onlineapteka.testapplication.doctors.DoctorsActivity;
import com.onlineapteka.testapplication.interfaces.OnItemClickListener;
import com.onlineapteka.testapplication.model.Doctor;
import com.onlineapteka.testapplication.model.Professions;
import com.onlineapteka.testapplication.professions.recycler.ProfessionsAdapter;
import com.onlineapteka.testapplication.professions.recycler.ProfessionsViewHolder;

import java.util.ArrayList;

public class ProfessionsInMedicineActivity extends AppCompatActivity implements ProfessionsViewHolder.IOnClickListener {

    private EditText mSearchProfessionsEdit;
    private RecyclerView mRecyclerView;
    private ProfessionsAdapter mProfessionsAdapter;
    private ArrayList<Professions> mProfessions;
    private LinearLayoutManager linearLayoutManager;
    private ProfessionsViewModel mViewModel;


    public static void start(Context context){
        context.startActivity(new Intent(context, ProfessionsInMedicineActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professions_in_medicine);
        initViewModel();
        initviews();
    }

    private void initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(ProfessionsViewModel.class);
        mViewModel.getProfessions();
//        mViewModel.selectedProfessions.observe(this, new Observer<Pair<String, String>>() {
//            @Override
//            public void onChanged(Pair<String, String> stringStringPair) {
//                DoctorsActivity.startActivity(getBaseContext(),stringStringPair.first,stringStringPair.second);
//            }
//        });
//        mViewModel.isLoadedLiveData.observe(this, new Observer<Boolean>() {
//            @Override
//            public void onChanged(Boolean aBoolean) {
//                if (aBoolean){
//                    initviews();
//                }
//            }
//        });
    }

    private void initviews() {
        mSearchProfessionsEdit = findViewById(R.id.search_professions_edit);
        mRecyclerView = findViewById(R.id.professions_recycler);

        mProfessions = new ArrayList<>();

        mProfessions.add(new Professions("terapevt",R.drawable.ic_logotype_auth,"Терапевт","Специалист по терпапии","Терапия"));
        mProfessions.add(new Professions("urolog",R.drawable.ic_logotype_auth,"Уролог","Специалист по мочевыводящих путей","Урология"));

        mProfessionsAdapter = new ProfessionsAdapter(this);
        mRecyclerView.setAdapter(mProfessionsAdapter);
        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mProfessionsAdapter.updateList(mProfessions);
//        mProfessionsAdapter.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//                mViewModel.onProfessionsClick(position);
////                Toast.makeText(ProfessionsInMedicineActivity.this,"Pressed"+ position,Toast.LENGTH_LONG).show();
////                Intent intent = new Intent(ProfessionsInMedicineActivity.this, Doctor.class);
////                intent.putExtra("professionsId",position);
////                startActivity(intent);
////                mViewModel.onProfessionsClick(position);
//            }
//        });
    }


    @Override
    public void onClick(String position, String title) {
        Intent intent = new Intent(ProfessionsInMedicineActivity.this, DoctorsActivity.class);
        intent.putExtra("professionsId",position);
        intent.putExtra("professionsName",title);
        startActivity(intent);
    }
}