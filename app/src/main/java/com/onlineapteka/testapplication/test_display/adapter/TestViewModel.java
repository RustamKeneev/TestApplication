package com.onlineapteka.testapplication.test_display.adapter;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.onlineapteka.testapplication.App;
import com.onlineapteka.testapplication.model.Professions;
import com.onlineapteka.testapplication.repository.IStorage;

import java.util.List;

public class TestViewModel extends ViewModel {
    public MutableLiveData<List<Professions>> professionsMutableLiveData = new MutableLiveData<>();

    public void getProfessionsCategory(final String professionsId){
        App.storage.getProfessions(professionsId, new IStorage.CallBack<Professions>() {
            @Override
            public void onSuccess(List<Professions> data) {
                professionsMutableLiveData.setValue(data);
            }

            @Override
            public void onFailure(String message) {

            }
        });
    }
}
