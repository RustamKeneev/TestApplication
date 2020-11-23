package com.onlineapteka.testapplication.repository;


import com.onlineapteka.testapplication.model.Doctor;
import com.onlineapteka.testapplication.model.Professions;
import com.onlineapteka.testapplication.model.ProfessionsCategory;

import java.util.List;

import javax.security.auth.callback.Callback;

public interface IStorage {

    void getProfessions(CallBack<Professions> professionsCallBack);

//    void getProfessions(String professionsId, CallBack<Professions> callBack);
    void getDoctorsId(String doctorsId, CallBack<Doctor> doctorCallBack);
    void getProfessionsCategory(CallBack<ProfessionsCategory> professionsCategoryCallBack);


    interface CallBack<T>{

        void onSuccess(List<T> data);

        void onFailure(String message);

    }
}
