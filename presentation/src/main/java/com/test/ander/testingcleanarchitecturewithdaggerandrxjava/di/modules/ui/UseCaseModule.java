package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.modules.ui;

import com.example.features.getuser.GetUserInteractor;
import com.example.features.getuser.GetUserUseCase;
import com.example.customscopes.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ander Túrrez on 24/09/16.
 */

@Module
public class UseCaseModule {

    public UseCaseModule() {
    }

    @PerActivity
    @Provides
    GetUserUseCase providesGetUserUserCase(GetUserInteractor interactor){
        return interactor;
    }
}
