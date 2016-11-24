package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.modules.ui;

import com.example.customscopes.PerActivity;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.activities.MVPMainActivity;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.activities.MainActivityPresenter;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.newregistration.NewUserFragmentPresenter;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.newregistration.MVPNewUserRegistration;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.userinfo.userslist.ListOfUsersFragmentPresenter;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.userinfo.userslist.MVPUsersList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ander Túrrez on 24/09/16.
 */
@Module
public class PresenterModule {

    @PerActivity
    @Provides
    MVPNewUserRegistration.Presenter providesMVPUserRegistrationPresenter(NewUserFragmentPresenter newUserFragmentPresenter){
        return newUserFragmentPresenter;
    }

    @PerActivity
    @Provides
    MVPMainActivity.Presenter providesMVPMainActivityPresenter(MainActivityPresenter mainActivityPresenter){
        return mainActivityPresenter;
    }

    @PerActivity
    @Provides
    MVPUsersList.Presenter providesMVPUsersListPresenter(ListOfUsersFragmentPresenter listOfUsersFragmentPresenter){
        return listOfUsersFragmentPresenter;
    }
}
