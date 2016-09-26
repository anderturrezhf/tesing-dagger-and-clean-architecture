package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.modules.ui;

import com.example.customscopes.PerActivity;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.GetUserPresenter;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.MVPGetUser;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ander Túrrez on 24/09/16.
 */
@Module
public class PresenterModule {

    public PresenterModule() {
    }

    @PerActivity
    @Provides
    MVPGetUser.Presenter providesMVPPresenter(GetUserPresenter getUserPresenter){
        return getUserPresenter;
    }
}
