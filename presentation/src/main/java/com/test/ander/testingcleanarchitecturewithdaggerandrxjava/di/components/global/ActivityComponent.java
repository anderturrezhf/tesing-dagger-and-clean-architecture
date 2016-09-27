package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.components.global;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentManager;

import com.example.customscopes.PerActivity;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.modules.global.ActivityModule;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.modules.ui.PresenterModule;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.modules.ui.UseCaseModule;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.activities.MVPMainActivity;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.MVPNewUserRegistration;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.NewUserFragment;
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

    BaseActivity getbaseActivity();

    Context getContext();

    FragmentManager getFragmentManager();

    Resources getResources();

    MVPNewUserRegistration.Presenter getGetUserPresenter();

    MVPMainActivity.Presenter getMainActivityPresenter();
}
