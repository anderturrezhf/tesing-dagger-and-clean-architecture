package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.activities;

import com.example.features.getuser.UserEntity;

/**
 * Created by Ander Túrrez on 26/09/16.
 */

public interface MVPMainActivity {

    interface View {
        void showToastText(String textToShow);

        void showOrHideRegisterNewUserFragment(boolean show);

        void showOrCollapseBottomSheet(boolean show);

        void saveCurrentUserOnPreferences(UserEntity currentuser);

        UserEntity getPreviousCurrentUserFromPreferencesIfAny();

        boolean isBackPressedFromActivity();

        boolean isBottomSheetExpanded();

        void performActivityOnBackPressed();

        String getBackStackTopFragmentTag();

        void updateCurrentUserLayoutInfo(UserEntity user);

        void setNoUserStateLayout();
    }

    interface Presenter {
        void setView(MVPMainActivity.View view);

        void createNewUserButtonClicked();

        void showCurrentUserInfoButtonClicked();

        void newUserSaved(UserEntity userEntity);

        void activityOnCreate();

        void activityOnStop();

        void backButtonPressed();
    }
}
