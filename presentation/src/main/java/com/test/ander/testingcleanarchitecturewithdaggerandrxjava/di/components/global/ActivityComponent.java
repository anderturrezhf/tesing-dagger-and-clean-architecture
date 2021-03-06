package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.components.global;

import android.content.res.Resources;
import android.support.v4.app.FragmentManager;

import com.example.customscopes.PerActivity;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.modules.global.ActivityModule;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.modules.ui.PresenterModule;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.modules.ui.UseCaseModule;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.activities.MVPMainActivity;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.newregistration.MVPNewUserRegistration;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.newregistration.NewUserFragment;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.userinfo.userslist.ListOfUsersFragment;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.userinfo.userslist.MVPUsersList;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.ui.MainActivity;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.ui.basecomponents.BaseActivity;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.ui.basecomponents.BaseFragment;

import dagger.Component;

/**
 * Created by Ander Túrrez on 23/09/16.
 */
@PerActivity
@Component(dependencies = {ApplicationComponent.class}, modules = {ActivityModule.class, PresenterModule.class, UseCaseModule.class})
public interface ActivityComponent {

    void inject(BaseActivity mainActivity);
    void inject(BaseFragment baseFragment);
    void inject(MainActivity mainActivity);
    void inject(NewUserFragment newUserFragment);
    void inject(ListOfUsersFragment listOfUsersFragment);

    BaseActivity getbaseActivity();

    FragmentManager getFragmentManager();

    Resources getResources();

    MVPNewUserRegistration.Presenter getUserRegistrationFragmentPresenter();

    MVPMainActivity.Presenter getMainActivityPresenter();

    MVPUsersList.Presenter getUsersListPresenter();
}
