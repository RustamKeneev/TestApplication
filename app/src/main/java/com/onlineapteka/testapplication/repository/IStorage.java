package com.onlineapteka.testapplication.repository;


import com.onlineapteka.testapplication.model.ProfessionsCategory;

import java.util.List;

public interface IStorage {

//    void getProfessions(CallBack<Professions> professionsCallBack);
//    void getDoctorsId(String doctorsId, CallBack<Doctor> doctorCallBack);
      void getProfessionsCategory(CallBack<ProfessionsCategory> professionsCategoryCallBack);


    interface CallBack<T>{

        void onSuccess(List<T> data);

        void onFailure(String message);

    }
}
