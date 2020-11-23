package com.onlineapteka.testapplication.professions;

import android.util.Log;

import androidx.core.util.Pair;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.onlineapteka.testapplication.App;
import com.onlineapteka.testapplication.model.Professions;
import com.onlineapteka.testapplication.repository.IStorage;

import java.util.ArrayList;
import java.util.List;

public class ProfessionsViewModel extends ViewModel {
    private List<Professions> professions = new ArrayList<>();
    public MutableLiveData<Pair<String, String>> selectedProfessions = new MutableLiveData<>();
    public MutableLiveData<Boolean> isLoadedLiveData = new MutableLiveData<>();



    public void getProfessions() {
        App.storage.getProfessions(new IStorage.CallBack<Professions>() {
            @Override
            public void onSuccess(List<Professions> data) {
                professions.addAll(data);

            }

            @Override
            public void onFailure(String message) {

            }
        });
    }

    public void onProfessionsClick(int position) {
        selectedProfessions.setValue(new Pair<String, String>(professions.get(position).getId(),
                professions.get(position).getProfessionsTitle()));
    }
}