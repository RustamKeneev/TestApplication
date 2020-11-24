package com.onlineapteka.testapplication.repository;


import com.onlineapteka.testapplication.model.Doctor;
import com.onlineapteka.testapplication.model.Professions;

import java.util.List;

public interface IStorage {

    void getProfessions(CallBack<Professions> professionsCallBack);

    void getDoctorsId(String doctorsId, CallBack<Doctor> doctorCallBack);

    void getDoctor(String doctorId, CallBack<Doctor> callBack);

    Doctor getSelectedDoctor(int position);

    interface CallBack<T>{

        void onSuccess(List<T> data);

        void onFailure(String message);

    }
}
