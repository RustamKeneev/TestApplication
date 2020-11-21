package com.onlineapteka.testapplication.repository.remote;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.onlineapteka.testapplication.model.ProfessionsCategory;
import com.onlineapteka.testapplication.repository.IStorage;

import java.util.ArrayList;
import java.util.List;

public class RemoteStorage implements IRemoteStorage {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private StorageReference storageReference = FirebaseStorage.getInstance().getReference();

    private List<ProfessionsCategory> professionsCategories;

    private final String TABLE_PROFESSIONS_CATEGORIES = "medical_professions";


    @Override
    public void getProfessionsCategory(IStorage.CallBack<ProfessionsCategory> professionsCategoryCallBack) {
        professionsCategories = new ArrayList<>();
        db.collection(TABLE_PROFESSIONS_CATEGORIES)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot documentSnapshot: task.getResult()){
                                professionsCategories.add(documentSnapshot.toObject(ProfessionsCategory.class));
//                                professionsCategories.get(professionsCategories.size()-1)
//                                        .setProfessionsId(documentSnapshot.getId());
                            }
                            professionsCategoryCallBack.onSuccess(professionsCategories);
                        }else {
                            professionsCategoryCallBack.onFailure(task.getException().getMessage());
                        }
                    }
                });

    }
}