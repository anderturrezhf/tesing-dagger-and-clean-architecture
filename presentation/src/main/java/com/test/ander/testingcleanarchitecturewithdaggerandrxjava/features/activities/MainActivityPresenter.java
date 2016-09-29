package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.activities;

import android.content.res.Resources;
import android.util.Log;

import com.example.customscopes.PerActivity;
import com.example.features.activity.MainActivityInteractor;
import com.example.features.activity.MainActivityUseCase;
import com.example.features.getuser.UserEntity;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.R;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.newregistration.NewUserFragment;

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
        this.view.updateCurrentUserLayoutInfo(userEntity);
        this.view.showOrHideRegisterNewUserFragment(false);
        this.view.showToastText(resources.getString(R.string.main_activity_new_user_registered));
    }

    @Override
    public void activityOnCreate() {
        Log.d("TEST", "activityOnCreate: ");
        this.interactor.setPreviousCurrentUserFromPreferences(this.view.getPreviousCurrentUserFromPreferencesIfAny())
                .subscribe(userEntity ->{
                    this.view.updateCurrentUserLayoutInfo(userEntity);
                    Log.d("TEST", "activityOnCreate: " + userEntity.getAlias());
                } ,
                        throwable -> {
                            this.view.setNoUserStateLayout();
                            Log.d("TEST", "activityOnCreate: null user" );
                        });
    }

    @Override
    public void activityOnStop() {
        Log.d("TEST", "activityOnStop: ");
        this.interactor.getCurrentUser()
                .subscribe(userEntity -> {
                    this.view.saveCurrentUserOnPreferences(userEntity);
                    Log.d("TEST", "activityOnStop: " + userEntity.getAlias());

                        },
                        throwable -> {
                            this.view.saveCurrentUserOnPreferences(null);
                            Log.d("TEST", "activityOnStop: null user" );

                        });
    }

    @Override
    public void backButtonPressed() {
        if (this.view.isBackPressedFromActivity()) {
            if (this.view.isBottomSheetExpanded()) {
                this.view.showOrCollapseBottomSheet(false);
            } else {
                this.view.performActivityOnBackPressed();
            }
        } else if (this.view.getBackStackTopFragmentTag().equals(NewUserFragment.class.getName())) {
            this.view.showOrHideRegisterNewUserFragment(false);
        }

    }

    @Override
    public void createNewUserButtonClicked() {
        this.view.showOrHideRegisterNewUserFragment(true);
    }

    @Override
    public void showCurrentUserInfoButtonClicked() {
        this.view.showOrCollapseBottomSheet(true);
    }
}
