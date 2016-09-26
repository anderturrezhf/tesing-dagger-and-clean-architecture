package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser;

/**
 * Created by Ander Túrrez on 24/09/16.
 */

public interface MVPGetUser {

    interface View {
        void setNewUserOnTextView(String newUser);

        String getUserName();

        void showToastAlertWithText(String alertText);
    }

    interface Presenter {
        void setView(MVPGetUser.View view);

        void getNewUser();
    }
}
