package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.activities;

import android.content.res.Resources;

import com.example.customscopes.PerActivity;
import com.example.features.activity.MainActivityInteractor;
import com.example.features.activity.MainActivityUseCase;
import com.example.features.getuser.UserEntity;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.R;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.newregistration.NewUserFragment;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.userinfo.UserInfoFragment;

import javax.inject.Inject;

/**
 * Created by Ander Túrrez on 26/09/16.
 */
@PerActivity
public class MainActivityPresenter implements MVPMainActivity.Presenter {

    private MVPMainActivity.View view;
    private MainActivityUseCase interactor;
    private Resources resources;

    @Inject
    public MainActivityPresenter(MainActivityInteractor interactor, Resources resources) {
        this.interactor = interactor;
        this.resources = resources;
    }

    @Override
    public void setView(MVPMainActivity.View view) {
        this.view = view;
    }

    @Override
    public void newUserSaved(UserEntity userEntity) {
        this.view.updateCurrentUserFragmentInfo();
        this.view.setNewCurrentUserNameOnTitle(userEntity);
        this.view.hideNewUserFragment();
        this.view.showToastText(resources.getString(R.string.main_activity_new_user_registered));
    }

    @Override
    public void activityOnCreate() {
        this.interactor.setPreviousCurrentUserFromPreferences(this.view.getPreviousCurrentUserFromPreferencesIfAny())
                .subscribe(userEntity -> {
                    this.view.setNewCurrentUserNameOnTitle(userEntity);
                    this.view.updateCurrentUserFragmentInfo();
                },
                        throwable -> this.view.updateCurrentUserFragmentInfo());
    }

    @Override
    public void activityOnDestroy() {
        this.interactor.getCurrentUser()
                .subscribe(userEntity -> this.view.saveCurrentUserOnPreferences(userEntity),
                        throwable -> {});
    }

    @Override
    public void backButtonPressed() {
        if(this.view.isBackPressedFromActivity()){
            this.view.performActivityOnBackPressed();
        } else {
            if(this.view.getBackStackTopFragmentTag().equals(NewUserFragment.class.getName())){
                this.view.hideNewUserFragment();
            } else if(this.view.getBackStackTopFragmentTag().equals(UserInfoFragment.class.getName())){
                this.view.hideCurrentUserInfofragment();
            }
        }
    }

    @Override
    public void createNewUserButtonClicked() {
        this.view.showRegisterNewUserViewFragment();
    }

    @Override
    public void showCurrentUserInfoButtonClicked() {
        this.view.showCurrentUserInfofragment();
    }
}
