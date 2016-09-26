package com.example.features.getuser.datasource;

import com.example.features.getuser.UserEntity;

import java.util.List;

/**
 * Created by Ander Túrrez on 25/09/16.
 */

public class CloudUserStore implements UserStore {

    @Override
    public UserEntity entityUserDetails(int id) {
        return null;
    }

    @Override
    public List<UserEntity> listOfAllEntityUsers() {
        return null;
    }

    @Override
    public void saveUserToLocalCache(UserEntity user) {

    }
}
