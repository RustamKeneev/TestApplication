package com.onlineapteka.testapplication.repository.remote;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.onlineapteka.testapplication.App;
import com.onlineapteka.testapplication.model.Doctor;
import com.onlineapteka.testapplication.model.Professions;
import com.onlineapteka.testapplication.model.ProfessionsCategory;
import com.onlineapteka.testapplication.repository.IStorage;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class RemoteStorage implements IRemoteStorage {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private StorageReference storageReference = FirebaseStorage.getInstance().getReference();

    private List<ProfessionsCategory> professionsCategories;
    private List<Doctor> doctors;

    private final String TABLE_PROFESSIONS_CATEGORIES = "medical_professions";


    @Override
    public void getProfessionsCategory(IStorage.CallBack<ProfessionsCategory> professionsCategoryCallBack) {
        professionsCategories = new ArrayList<>();
        db.collection(TABLE_PROFESSIONS_CATEGORIES)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                                professionsCategories.add(documentSnapshot.toObject(ProfessionsCategory.class));
//                                professionsCategories.get(professionsCategories.size()-1)
//                                        .setProfessionsId(documentSnapshot.getId());
                            }
                            professionsCategoryCallBack.onSuccess(professionsCategories);
                        } else {
                            professionsCategoryCallBack.onFailure(task.getException().getMessage());
                        }
                    }
                });

    }

    @Override
    public void getProfessions(IStorage.CallBack<Professions> callBack) {
        db.collection("doctors")
                .whereEqualTo("type_professions", "Сиделка")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("TAG", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.d("TAG", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }

    @Override
    public void getDoctors(String professionsId, IStorage.CallBack<Doctor> callBack) {
        doctors = new ArrayList<>();
        db.collection("doctors")
                .whereEqualTo("id",professionsId)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot documentSnapshot: task.getResult()){
                                doctors.add(documentSnapshot.toObject(Doctor.class));
                                doctors.get(doctors.size()-1).setId(documentSnapshot.getId());
                                Log.d(TAG, "onComplete: Doctors" + documentSnapshot.getId() + "=>" + documentSnapshot.getData());
                                Log.d(TAG, "onComplete: " + task.getResult());
                            }
                            callBack.onSuccess(doctors);
                        }else {
                            callBack.onFailure(task.getException().getMessage());
                            Log.d("TAG", "Error getting documents: ", task.getException());

                        }
                    }
                });
    }

//
//    @Override
//    public void getProfessions(String professionsId, IStorage.CallBack<Professions> callBack) {
//        getTerapevts();
//    }


//    public void getTerapevts() {
//        db.collection("doctors")
//                .whereEqualTo("type_professions", "sidelka")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                Log.d("TAG", document.getId() + " => " + document.getData());
//                            }
//                        } else {
//                            Log.d("TAG", "Error getting documents: ", task.getException());
//                        }
//                    }
//                });
//    }
}
