package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.activities;

import com.example.features.getuser.UserEntity;

/**
 * Created by Ander Túrrez on 26/09/16.
 */

public interface MVPMainActivity {

    interface View {
        void showToastText(String textToShow);

        void showRegisterNewUserViewFragment();

        void hideNewUserFragment();

        void showCurrentUserInfofragment();

        void hideCurrentUserInfofragment();

        void setNewCurrentUserNameOnTitle(UserEntity user);

        void saveCurrentUserOnPreferences(UserEntity currentuser);

        UserEntity getPreviousUserFromPreferencesIfAny();

        boolean isBackPressedfromActivity();

        void performActivityOnBackPressed();

        String getBackStackTopFragmentTag();

        void updateCurrentUserFragmentInfo();
    }

    interface Presenter {
        void setView(MVPMainActivity.View view);

        void createNewUserButtonClicked();

        void showCurrentUserInfoButtonClicked();

        void newUserSaved(UserEntity userEntity);

        void activityOnCreate();

        void activityOnDestroy();

        void backButtonPressed();
    }
}
