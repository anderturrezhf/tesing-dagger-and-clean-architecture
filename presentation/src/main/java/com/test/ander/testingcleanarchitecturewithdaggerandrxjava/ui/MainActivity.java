package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.features.getuser.UserEntity;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.R;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.activities.MVPMainActivity;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.newregistration.NewUserFragment;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.newregistration.NewUserSavedEvent;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.ui.basecomponents.BaseActivity;

import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MVPMainActivity.View {

    @Inject protected MVPMainActivity.Presenter presenter;

    //Main Activity laypout Views
    @BindView(R.id.mainActivityRegisterNewUserButton) protected Button registerNewUserButton;
    @BindView(R.id.mainActivityCurrentUserInfoButton) protected Button currentUserInfoButton;
    @BindView(R.id.mainActivityBottomSheet) protected RelativeLayout bottomSheetlayout;
    //Bottom Sheet Views
    @BindView(R.id.userInfoFragmentTitleTextView) protected TextView titletextView;
    @BindView(R.id.userInfoFragmentAgeTextView) protected TextView ageTextView;
    @BindView(R.id.userInfoFragmentCityTextView) protected TextView cityTextView;
    @BindView(R.id.userInfoFragmentAliasTextView) protected TextView aliasTextView;
    @BindView(R.id.userInfoFragmentBottomTextView) protected TextView bottomTextView;

    private BottomSheetBehavior bottomSheet;

    private NewUserFragment newUserFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        bottomSheet = BottomSheetBehavior.from(bottomSheetlayout);
        initDependencies();
        initFragmentsIfNecessary();
        presenter.setView(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        eventBus.register(this);
        presenter.activityOnStart();
    }

    @Override
    protected void onStop() {
        eventBus.unregister(this);
        presenter.activityOnStop();
        super.onStop();
    }

    @Override
    public void onBackPressed() {
        presenter.backButtonPressed();
    }

    //EventBus method
    @Subscribe
    public void onEvent(NewUserSavedEvent event) {
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

        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, newUserFragment, NewUserFragment.class.getName())
                .hide(newUserFragment)
                .commit();
    }

    @Override
    protected void initDependencies() {
        getActivityComponent().inject(this);
    }

    //Layout Listeners Elements Methods
    @OnClick(R.id.mainActivityRegisterNewUserButton)
    protected void performRegisterNewUserClick() {
        presenter.createNewUserButtonClicked();
    }

    @OnClick(R.id.mainActivityCurrentUserInfoButton)
    protected void performShowCurrentUserInfoClick(){
        presenter.showCurrentUserInfoButtonClicked();
    }


    //View Methods
    @Override
    public void saveCurrentUserOnPreferences(UserEntity currentuser) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(resources.getString(R.string.current_user_preferences_id), currentuser.getAlias());
        editor.putString(currentuser.getAlias(), gson.toJson(currentuser));

        editor.commit();
    }

    @Override
    public UserEntity getPreviousCurrentUserFromPreferencesIfAny() {
        String previousUserId = sharedPreferences.getString(resources.getString(R.string.current_user_preferences_id), resources.getString(R.string.main_activity_no_user_text));

        if (!previousUserId.equals(resources.getString(R.string.main_activity_no_user_text))) {
            String previousCurrentUserAsString = sharedPreferences.getString(previousUserId, "");
            return gson.fromJson(previousCurrentUserAsString, UserEntity.class);
        } else {
            return null;
        }
    }

    @Override
    public boolean isBackPressedFromActivity() {
        return fragmentManager.getBackStackEntryCount() == 0;
    }

    @Override
    public boolean isBottomSheetExpanded() {
        return bottomSheet.getState() == BottomSheetBehavior.STATE_EXPANDED;
    }

    @Override
    public void performActivityOnBackPressed() {
        this.finish();
    }

    @Override
    public String getBackStackTopFragmentTag() {
        return fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
    }

    @Override
    public void updateCurrentUserLayoutInfo(UserEntity user) {
        this.titletextView.setText(resources.getString(R.string.user_info_fragment_title, user.getName()));
        this.ageTextView.setText(resources.getString(R.string.user_info_fragment_age, user.getAge() + ""));
        this.cityTextView.setText(resources.getString(R.string.user_info_fragment_city, user.getCity()));
        this.aliasTextView.setText(resources.getString(R.string.user_info_fragment_alias, user.getAlias()));
        this.bottomTextView.setText(resources.getString(R.string.user_info_fragment_bottom_text));
    }

    @Override
    public void setNoUserStateLayout() {
        this.titletextView.setText(resources.getString(R.string.user_info_fragment_no_current_user));
        this.ageTextView.setText("");
        this.cityTextView.setText("");
        this.aliasTextView.setText("");
        this.bottomTextView.setText("");
    }

    @Override
    public void showToastText(String textToShow) {
        Toast.makeText(this, textToShow, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showOrHideRegisterNewUserFragment(boolean show) {
        if(show){
            fragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right)
                    .show(newUserFragment)
                    .addToBackStack(NewUserFragment.class.getName())
                    .commit();
            bottomSheet.setState(BottomSheetBehavior.STATE_HIDDEN);
        } else {
            fragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right)
                    .hide(newUserFragment)
                    .commit();
            fragmentManager.popBackStack();
            bottomSheet.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }
    }

    @Override
    public void showOrCollapseBottomSheet(boolean show) {
        if(show){
            bottomSheet.setState(BottomSheetBehavior.STATE_EXPANDED);
        } else {
            bottomSheet.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }
    }
}