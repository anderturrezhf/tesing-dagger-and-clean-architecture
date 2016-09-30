package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.userinfo.userslist;

import com.example.features.getuser.UserEntity;

import java.util.ArrayList;

/**
 * Created by Ander Túrrez on 29/09/16.
 */

public interface MVPUsersList {

    interface View {
        void displayUpdatedUsersList(ArrayList<UserEntity> usersList);

        void initializeAndFillUserListWithCurrentUsers(ArrayList<UserEntity> usersList);

    }

    interface Presenter {
        void setView (MVPUsersList.View view);

        void onActivityCreated();
    }
}
