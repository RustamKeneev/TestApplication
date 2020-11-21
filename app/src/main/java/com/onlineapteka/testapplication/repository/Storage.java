package com.onlineapteka.testapplication.repository;


import android.util.Log;

import com.onlineapteka.testapplication.model.ProfessionsCategory;
import com.onlineapteka.testapplication.repository.remote.IRemoteStorage;
import com.onlineapteka.testapplication.repository.remote.RemoteStorage;

import java.util.List;

public class Storage implements IStorage {
    private IRemoteStorage remoteStorage = new RemoteStorage();


    @Override
    public void getProfessionsCategory(CallBack<ProfessionsCategory> professionsCategoryCallBack) {
        remoteStorage.getProfessionsCategory(new CallBack<ProfessionsCategory>() {
            @Override
            public void onSuccess(List<ProfessionsCategory> data) {
                professionsCategoryCallBack.onSuccess(data);
                Log.d("TAG", "onSuccess: professionsCategoryCallBack" + data.size());
            }

            @Override
            public void onFailure(String message) {

            }
        });
    }
}
