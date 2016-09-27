package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.features.getuser.UserEntity;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.R;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.activities.MVPMainActivity;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.newregistration.NewUserFragment;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.newregistration.NewUserSavedEvent;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.userinfo.UserInfoFragment;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.ui.basecomponents.BaseActivity;

import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MVPMainActivity.View {

    @Inject protected MVPMainActivity.Presenter presenter;

    @BindView(R.id.mainActivityRegisterNewUserButton) protected Button mainButton;
    @BindView(R.id.mainActivityCurrentUserTextView) protected TextView mainTextView;

    private NewUserFragment newUserFragment;
    private UserInfoFragment userInfoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initDependencies();
        initFragmentsIfNecessary();
        presenter.setView(this);
        presenter.activityOnCreate();
    }

    @Override
    protected void onStart() {
        super.onStart();
        eventBus.register(this);
    }

    @Override
    protected void onStop() {
        eventBus.unregister(this);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        presenter.activityOnDestroy();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {

      presenter.backButtonPressed();
    }

    @Subscribe
    public void onEvent(NewUserSavedEvent event){
        presenter.newUserSaved(event.getUser());
    }

    //Superclass Abstract Methods
    @Override
    protected int getActivityLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initFragmentsIfNecessary() {
        newUserFragment = (NewUserFragment) Fragment.instantiate(this, NewUserFragment.class.getName());
        userInfoFragment = (UserInfoFragment) Fragment.instantiate(this, UserInfoFragment.class.getName());

        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, newUserFragment, NewUserFragment.class.getName())
                .hide(newUserFragment)
                .add(R.id.fragment_container, userInfoFragment, UserInfoFragment.class.getName())
                .hide(userInfoFragment)
                .commit();
    }

    @Override
    protected void initDependencies() {
        getActivityComponent().inject(this);
    }

    //Layout Listeners Elements Methods
    @OnClick(R.id.mainActivityRegisterNewUserButton)
    void performClick() {
        presenter.showCreateNewUserFragment();
    }


    //View Methods
    @Override
    public void setNewCurrentUser(UserEntity user) {
        this.mainTextView.setText(user.getName());
    }

    @Override
    public void saveCurrentUserOnPreferences(UserEntity currentuser) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(currentuser == null){
            editor.putString(resources.getString(R.string.current_user_preferences_id), resources.getString(R.string.main_activity_no_user_text));
        } else {
            editor.putString(resources.getString(R.string.current_user_preferences_id), currentuser.getAlias());
            editor.putString(currentuser.getAlias(), gson.toJson(currentuser));
        }

        editor.commit();
    }

    @Override
    public void getPreviousUserFromPreferencesIfAnyAndPutOnTheLabel() {
        String previousUserId = sharedPreferences.getString(resources.getString(R.string.current_user_preferences_id), resources.getString(R.string.main_activity_no_user_text));

        if(!previousUserId.equals(resources.getString(R.string.main_activity_no_user_text))){
            String previousCurrentUserAsString = sharedPreferences.getString(previousUserId, "");
            UserEntity previousCurrentuser = gson.fromJson(previousCurrentUserAsString, UserEntity.class);
            mainTextView.setText(previousCurrentuser.getName());
        } else {
            mainTextView.setText(resources.getString(R.string.main_activity_no_user_text));
        }
    }

    @Override
    public boolean isBackPressedfromActivityOrFromFragment() {
        return fragmentManager.getBackStackEntryCount() == 0;
    }

    @Override
    public void performActivityOnBackPressed() {
        this.finish();
    }

    @Override
    public void showToastText(String textToShow) {
        Toast.makeText(this, textToShow, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showRegisterNewUserViewFragment() {
        fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right)
                .show(newUserFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void hideNewUserFragment() {
        fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right)
                .hide(newUserFragment)
                .commit();
        fragmentManager.popBackStack();
    }

    @Override
    public void showCurrentUserInfofragment() {
        fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_left)
                .show(userInfoFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void hideCurrentUserInfofragment() {
        fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right)
                .hide(userInfoFragment)
                .commit();
        fragmentManager.popBackStack();
    }
}
