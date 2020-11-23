package com.onlineapteka.testapplication.doctors;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.onlineapteka.testapplication.App;
import com.onlineapteka.testapplication.model.Doctor;
import com.onlineapteka.testapplication.repository.IStorage;

import java.util.List;

public class DoctorsViewModel extends ViewModel {
    public MutableLiveData<List<Doctor>> doctorsLiveData = new MutableLiveData<>();

    public void getDoctorsList(final String doctorsId){
        App.storage.getDoctorsId(doctorsId, new IStorage.CallBack<Doctor>() {
            @Override
            public void onSuccess(List<Doctor> data) {
                doctorsLiveData.setValue(data);
            }

            @Override
            public void onFailure(String message) {

            }
        });
    }
}
