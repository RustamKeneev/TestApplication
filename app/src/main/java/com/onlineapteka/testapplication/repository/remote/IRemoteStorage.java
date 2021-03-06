package com.onlineapteka.testapplication.repository.remote;

import com.onlineapteka.testapplication.model.Doctor;
import com.onlineapteka.testapplication.model.Professions;
import com.onlineapteka.testapplication.model.ProfessionsCategory;
import com.onlineapteka.testapplication.repository.IStorage;

public interface IRemoteStorage {
    void getProfessionsCategory(IStorage.CallBack<ProfessionsCategory> professionsCategoryCallBack);

    void getDoctors(String professionsId, IStorage.CallBack<Doctor> callBack);

    void getProfessions(IStorage.CallBack<Professions> callBack);

    void getDoctorById(String doctorId,IStorage.SingleCallBack<Doctor> callBack);

    void getDoctor(String doctorId, IStorage.CallBack<Doctor> callBack);
}
