package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.newregistration;

import com.example.features.getuser.UserEntity;

/**
 * Created by Ander Túrrez on 27/09/16.
 */

public class NewUserSavedEvent {

   private UserEntity user;

    public NewUserSavedEvent(UserEntity user) {
        this.user = user;
    }

    public UserEntity getUser() {
        return user;
    }
}
