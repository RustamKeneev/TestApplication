package com.onlineapteka.testapplication.test_display;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.onlineapteka.testapplication.model.ProfessionsCategory;

import java.util.List;

public class TestDisplayViewModel extends ViewModel {
    public MutableLiveData<List<ProfessionsCategory>> categoryLiveData  = new MutableLiveData<>();

}
