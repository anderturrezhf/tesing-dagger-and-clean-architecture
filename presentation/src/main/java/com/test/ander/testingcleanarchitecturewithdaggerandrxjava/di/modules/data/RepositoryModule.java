package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.modules.data;

import com.example.features.getuser.UserDataRepository;
import com.example.features.getuser.UserRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ander Túrrez on 25/09/16.
 */

@Module
public class RepositoryModule {

    public RepositoryModule() {
    }

    @Singleton
    @Provides
    UserRepository providesUserRepository(UserDataRepository userDataRepository){
        return userDataRepository;
    }

}
