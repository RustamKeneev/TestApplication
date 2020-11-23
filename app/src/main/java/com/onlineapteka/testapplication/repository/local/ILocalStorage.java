package com.onlineapteka.testapplication.repository.local;

import com.onlineapteka.testapplication.model.Doctor;
import com.onlineapteka.testapplication.model.Professions;
import com.onlineapteka.testapplication.repository.remote.IRemoteStorage;

import java.util.List;

public interface ILocalStorage extends IRemoteStorage {
    List<Long> saveProfessions(List<Professions> professions);
    List<Long> saveDoctors(List<Doctor> doctors);


}
