package com.onlineapteka.testapplication.repository.remote;

import com.onlineapteka.testapplication.model.Professions;
import com.onlineapteka.testapplication.model.ProfessionsCategory;
import com.onlineapteka.testapplication.repository.IStorage;

public interface IRemoteStorage {
    void getProfessionsCategory(IStorage.CallBack<ProfessionsCategory> professionsCategoryCallBack);


    void getProfessions(String professionsId, IStorage.CallBack<Professions> callBack);
}
