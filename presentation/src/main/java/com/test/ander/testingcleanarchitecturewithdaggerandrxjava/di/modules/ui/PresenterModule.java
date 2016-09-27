package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.modules.ui;

import com.example.customscopes.PerActivity;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.activities.MVPMainActivity;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.activities.MainActivityPresenter;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.newregistration.NewUserFragmentPresenter;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.newregistration.MVPNewUserRegistration;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.userinfo.MVPCurrentUserInfo;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.userinfo.UserInfoFragmentPresenter;

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
    MVPNewUserRegistration.Presenter providesMVPGetUserPresenter(NewUserFragmentPresenter newUserFragmentPresenter){
        return newUserFragmentPresenter;
    }

    @PerActivity
    @Provides
    MVPMainActivity.Presenter providesMVPMainActivityPresenter(MainActivityPresenter mainActivityPresenter){
        return mainActivityPresenter;
    }

    @PerActivity
    @Provides
    MVPCurrentUserInfo.Presenter providesMVPCurrentUserInfoPresenter(UserInfoFragmentPresenter presenter){
        return presenter;
    }
}
