package com.onlineapteka.testapplication.repository;


import com.onlineapteka.testapplication.model.Doctor;
import com.onlineapteka.testapplication.model.Professions;
import com.onlineapteka.testapplication.repository.local.ILocalStorage;
import com.onlineapteka.testapplication.repository.remote.IRemoteStorage;
import com.onlineapteka.testapplication.repository.remote.RemoteStorage;

import java.util.ArrayList;
import java.util.List;

public class Storage implements IStorage {
    private IRemoteStorage remoteStorage = new RemoteStorage();
    private List<Doctor> mDoctors = new ArrayList<>();
    private ILocalStorage iLocalStorage;

    public Storage(ILocalStorage iLocalStorage) {
        this.iLocalStorage = iLocalStorage;
    }

    @Override
    public void getProfessions(CallBack<Professions> professionsCallBack) {
        remoteStorage.getProfessions(professionsCallBack);
    }

    @Override
    public void getDoctorsId(String doctorsId, CallBack<Doctor> doctorCallBack) {
        remoteStorage.getDoctors(doctorsId, new CallBack<Doctor>() {
            @Override
            public void onSuccess(List<Doctor> data) {
                doctorCallBack.onSuccess(data);
            }

            @Override
            public void onFailure(String message) {

            }
        });
    }

    @Override
    public void getDoctorsById(String doctorId,SingleCallBack<Doctor> callBack) {
        remoteStorage.getDoctorById(doctorId, callBack);
    }

    @Override
    public void getDoctor(String doctorId, CallBack<Doctor> callBack) {
        remoteStorage.getDoctor(doctorId, new CallBack<Doctor>() {
            @Override
            public void onSuccess(List<Doctor> data) {
                callBack.onSuccess(data);
                mDoctors.clear();
                mDoctors.addAll(data);
            }

            @Override
            public void onFailure(String message) {

            }
        });
    }

    @Override
    public Doctor getSelectedDoctor(int position) {
        return null;
    }

}
