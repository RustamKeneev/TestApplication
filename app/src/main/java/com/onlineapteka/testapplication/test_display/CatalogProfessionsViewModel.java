package com.onlineapteka.testapplication.test_display;

import androidx.lifecycle.ViewModel;

import com.onlineapteka.testapplication.App;
import com.onlineapteka.testapplication.model.ProfessionsCategory;
import com.onlineapteka.testapplication.repository.IStorage;

import java.util.ArrayList;
import java.util.List;

public class CatalogProfessionsViewModel extends ViewModel {
    private List<ProfessionsCategory> professionsCategories = new ArrayList<>();

    public void getProfessionsCategory(){
        App.storage.getProfessionsCategory(new IStorage.CallBack<ProfessionsCategory>() {
            @Override
            public void onSuccess(List<ProfessionsCategory> data) {
                professionsCategories.addAll(data);
            }

            @Override
            public void onFailure(String message) {

            }
        });
    }
}
