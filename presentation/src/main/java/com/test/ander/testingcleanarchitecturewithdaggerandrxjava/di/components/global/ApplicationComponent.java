package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.components.global;

import android.content.SharedPreferences;

import com.example.features.getuser.UserCache;
import com.example.features.getuser.UserRepository;
import com.google.gson.Gson;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.modules.data.RepositoryModule;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.modules.global.ApplicationModule;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.ui.CustomApplication;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Ander Túrrez on 23/09/16.
 */

@Singleton
@Component(modules = {ApplicationModule.class, RepositoryModule.class})
public interface ApplicationComponent {

    CustomApplication getCustomApplication();

    @Named(ApplicationModule.DEFAULT_PREFERENCES) SharedPreferences getSharedPreferences();

    EventBus getEventBus();

    UserRepository getUserRepository();

    UserCache getUserCache();

    Gson getGson();
}
