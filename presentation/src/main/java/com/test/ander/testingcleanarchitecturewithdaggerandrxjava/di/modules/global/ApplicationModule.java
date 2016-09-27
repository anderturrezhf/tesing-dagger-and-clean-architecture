package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.modules.global;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.example.features.getuser.UserCache;
import com.example.features.getuser.datasource.UserDataCache;
import com.google.gson.Gson;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.ui.CustomApplication;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ander Túrrez on 23/09/16.
 */

@Module
public class ApplicationModule {

    public static final String DEFAULT_PREFERENCES = "DefaultPreferences";
    private CustomApplication customApplication;

    public ApplicationModule(CustomApplication customApplication) {
        this.customApplication = customApplication;
    }

    @Singleton
    @Provides
    @NonNull
    CustomApplication providesCustomApplication(){
        return this.customApplication;
    }

    @Singleton
    @Provides
    @Named(DEFAULT_PREFERENCES)
    SharedPreferences providesSharedPreferences(CustomApplication customApplication){
        return customApplication.getSharedPreferences("DefaultPreferences", Context.MODE_PRIVATE);
    }

    @Singleton
    @Provides
    EventBus providesEventBus(){
        return EventBus.getDefault();
    }

    @Singleton
    @Provides
    UserCache providesUserCache(UserDataCache userDataCache){
        return userDataCache;
    }

    @Singleton
    @Provides
    Gson providesGson(){
        return new Gson();
    }

}
