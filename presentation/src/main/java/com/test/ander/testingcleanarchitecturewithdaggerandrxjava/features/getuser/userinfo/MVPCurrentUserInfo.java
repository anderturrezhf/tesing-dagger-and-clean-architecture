package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.userinfo;

import com.example.features.getuser.UserEntity;

/**
 * Created by Ander Túrrez on 27/09/16.
 */

public interface MVPCurrentUserInfo {

    interface View {
        void setCurrentUserInfoOnFields(UserEntity user);

        void setEmptyUserInfo();

        void showToastMessage(String message);
    }

    interface Presenter {
        void setView(MVPCurrentUserInfo.View view);

        void updateUserInfo();
    }
}
