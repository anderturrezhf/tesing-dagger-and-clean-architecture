package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.modules.ui;

import com.example.features.getuser.newregistration.RegisterNewUserInteractor;
import com.example.features.getuser.newregistration.RegisterNewUserUseCase;
import com.example.customscopes.PerActivity;
import com.example.features.getuser.userinfo.UserInfoInteractor;
import com.example.features.getuser.userinfo.UserInfoUseCase;

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
    RegisterNewUserUseCase providesGetUserUserCase(RegisterNewUserInteractor interactor){
        return interactor;
    }

    @PerActivity
    @Provides
    UserInfoUseCase providesUserInfoUseCase(UserInfoInteractor interactor){
        return interactor;
    }
}
