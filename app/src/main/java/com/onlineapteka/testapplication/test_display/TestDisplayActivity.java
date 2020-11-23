package com.onlineapteka.testapplication.test_display;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.onlineapteka.testapplication.R;
import com.onlineapteka.testapplication.model.Professions;
import com.onlineapteka.testapplication.test_display.adapter.TestDisplayAdapter;
import com.onlineapteka.testapplication.test_display.adapter.TestDisplayViewHolder;
import com.onlineapteka.testapplication.test_display.doctors_example.TestSecondActivity;

import java.util.ArrayList;

public class TestDisplayActivity extends AppCompatActivity implements TestDisplayViewHolder.IOnClickListener {

    private RecyclerView mRecyclerView;
    private ArrayList<Professions> categories;
    private LinearLayoutManager linearLayoutManager;
    private TestDisplayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_display);
        initViews();
        initViewModels();
    }

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    private void initViewModels() {
//        db.collection("doctors")
//                .whereEqualTo("id", "clinical_psychologist")
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        for (QueryDocumentSnapshot document : task.getResult()) {
//                            Log.d("TAG", document.getId() + " => " + document.getData());
//                        }
//                    } else {
//                        Log.d("TAG", "Error getting documents: ", task.getException());
//                    }
//                });
//        db.collection("doctors")
//                .whereEqualTo("id", "sidelka")
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        for (QueryDocumentSnapshot document : task.getResult()) {
//                            Log.d("TAG", document.getId() + " => " + document.getData());
//                        }
//                    } else {
//                        Log.d("TAG", "Error getting documents: ", task.getException());
//                    }
//                });
//        db.collection("doctors").document("id").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//
//            }
//        });
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.test_recycler);
        categories = new ArrayList<>();
        categories.add(new Professions("sidelka",R.drawable.ic_logotype_auth,"Сиделка","Специалист по уходу за пациентами в условиях дома","-"));
        categories.add(new Professions("clinical_psychologist", R.drawable.ic_logotype_auth, "Клинический психолог", "Специалист по психологической диагностике и психотерапии", "Психолог"));
//        categories.add(new Professions(R.drawable.ic_logotype_auth,"Уролог","Специалист по мочевыводящих путей","Урология"));
//        categories.add(new Professions(R.drawable.ic_logotype_auth,"Уролог","Специалист по мочевыводящих путей","Урология"));
//        categories.add(new Professions(R.drawable.ic_logotype_auth,"Уролог","Специалист по мочевыводящих путей","Урология"));
//        categories.add(new Professions(R.drawable.ic_logotype_auth,"Уролог","Специалист по мочевыводящих путей","Урология"));
//        categories.add(new Professions(R.drawable.ic_logotype_auth,"Уролог","Специалист по мочевыводящих путей","Урология"));
//        categories.add(new Professions(R.drawable.ic_logotype_auth,"Уролог","Специалист по мочевыводящих путей","Урология"));
        adapter = new TestDisplayAdapter(this);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(adapter);
        adapter.updateList(categories);

    }

    @Override
    public void onClick(String position, String title) {
        Intent intent = new Intent(this, TestSecondActivity.class);
        intent.putExtra("doctorId", position);
        intent.putExtra("doctorType", title);
        startActivity(intent);

    }
}