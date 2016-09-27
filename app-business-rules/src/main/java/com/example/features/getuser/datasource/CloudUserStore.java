package com.example.features.getuser.datasource;

import com.example.features.getuser.UserEntity;

import java.util.List;

import rx.Observable;

/**
 * Created by Ander Túrrez on 25/09/16.
 */

public class CloudUserStore implements UserStore {

    @Override
    public Observable<UserEntity> entityUserDetails(String id) {
        return null;
    }

    @Override
    public List<UserEntity> listOfAllEntityUsers() {
        return null;
    }

    @Override
    public Observable<UserEntity> saveUserToLocalCache(UserEntity user) {
        return null;
    }
}
