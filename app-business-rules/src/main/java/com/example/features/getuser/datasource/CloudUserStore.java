package com.example.features.getuser.datasource;

import com.example.features.getuser.UserCache;
import com.example.features.getuser.UserEntity;

import java.util.ArrayList;

import rx.Observable;

/**
 * Created by Ander Túrrez on 25/09/16.
 */

public class CloudUserStore implements UserStore {

    private UserCache userCache;

    public CloudUserStore(UserCache userCache) {
        this.userCache = userCache;
    }

    @Override
    public Observable<UserEntity> entityUserDetails(String id) {
        return null;
    }

    @Override
    public Observable<ArrayList<UserEntity>> listOfAllEntityUsers() {
        return null;
    }

    @Override
    public Observable<UserEntity> saveUserToLocalCache(UserEntity user) {
        return null;
    }

    @Override
    public Observable<ArrayList<UserEntity>> saveUsersListToLocalCache(ArrayList<UserEntity> usersList) {
        return null;
    }
}
