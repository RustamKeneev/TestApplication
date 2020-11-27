package com.onlineapteka.testapplication;

import android.app.Application;

import com.onlineapteka.testapplication.repository.IStorage;
import com.onlineapteka.testapplication.repository.Storage;
import com.onlineapteka.testapplication.repository.local.ILocalStorage;

public class App extends Application {
    public static IStorage storage;
    public static ILocalStorage iLocalStorage;

    @Override
    public void onCreate() {
        super.onCreate();

        storage = new Storage(iLocalStorage);
    }
}
