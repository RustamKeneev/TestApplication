package com.onlineapteka.testapplication.repository.local;

import com.onlineapteka.testapplication.model.Doctor;
import com.onlineapteka.testapplication.model.Professions;
import com.onlineapteka.testapplication.model.ProfessionsCategory;
import com.onlineapteka.testapplication.repository.IStorage;

import java.util.List;

public class LocalStorage implements ILocalStorage{
    @Override
    public List<Long> saveProfessions(List<Professions> professions) {
        return null;
    }

    @Override
    public List<Long> saveDoctors(List<Doctor> doctors) {
        return null;
    }

    @Override
    public void getProfessionsCategory(IStorage.CallBack<ProfessionsCategory> professionsCategoryCallBack) {

    }

    @Override
    public void getProfessions(IStorage.CallBack<Professions> callBack) {

    }

    @Override
    public void getDoctor(String doctorId, IStorage.CallBack<Doctor> callBack) {

    }

    @Override
    public void getDoctors(String professionsId, IStorage.CallBack<Doctor> callBack) {

    }
}
