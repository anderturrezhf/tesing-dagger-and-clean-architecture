package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.activities;

import android.content.res.Resources;

import com.example.customscopes.PerActivity;
import com.example.features.getuser.UserEntity;
import com.example.features.getuser.UserRepository;
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
    private UserRepository userRepository;
    private Resources resources;

    @Inject
    public MainActivityPresenter(UserRepository userRepository, Resources resources) {
        this.userRepository = userRepository;
        this.resources = resources;
    }

    @Override
    public void setView(MVPMainActivity.View view) {
        this.view = view;
    }

    @Override
    public void newUserSaved(UserEntity userEntity) {
        this.view.hideNewUserFragment();
        this.view.setNewCurrentUser(userEntity);
        this.view.showToastText(resources.getString(R.string.main_activity_new_user_registered));
    }

    @Override
    public void activityOnCreate() {
        this.view.getPreviousUserFromPreferencesIfAnyAndPutOnTheLabel();
    }

    @Override
    public void activityOnDestroy() {
        this.userRepository.getCurrentUser()
                .subscribe(userEntity -> this.view.saveCurrentUserOnPreferences(userEntity));
    }

    @Override
    public void backButtonPressed() {

        if(this.view.isBackPressedfromActivity()){
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
