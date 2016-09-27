package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser;

import com.example.features.getuser.UserEntity;

/**
 * Created by Ander Túrrez on 24/09/16.
 */

public interface MVPNewUserRegistration {

    interface View {
        String getUserName();

        String getAge();

        String getCity();

        String getAlias();

        void showToastAlertWithText(String alertText);

        void onUserCorrectlySaved(UserEntity user);

        void cleanAllEditTexts();
    }

    interface Presenter {
        void setView(MVPNewUserRegistration.View view);

        void saveNewUser();

        void userCorrectlySaved(UserEntity user);
    }
}
