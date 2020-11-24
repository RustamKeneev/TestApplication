package com.onlineapteka.testapplication.doctors.doctors_detail;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.onlineapteka.testapplication.App;
import com.onlineapteka.testapplication.model.Doctor;
import com.onlineapteka.testapplication.repository.IStorage;

import java.util.List;

public class DoctorDetailViewmodel  extends ViewModel {
    public MutableLiveData<Doctor> doctorMutableLiveData = new MutableLiveData<>();

    public void getDoctorDetail(String doctorId){
        App.storage.getDoctor(doctorId, new IStorage.CallBack<Doctor>() {
            @Override
            public void onSuccess(List<Doctor> data) {
                doctorMutableLiveData.setValue((Doctor) data);
            }

            @Override
            public void onFailure(String message) {

            }
        });
    }
}
