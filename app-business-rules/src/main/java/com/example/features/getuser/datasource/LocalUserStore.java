package com.example.features.getuser.datasource;

import com.example.features.getuser.UserCache;
import com.example.features.getuser.UserEntity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Created by Ander Túrrez on 25/09/16.
 */

public class LocalUserStore implements UserStore {

    private UserCache userCache;

    public LocalUserStore(UserCache userCache) {
        this.userCache = userCache;
    }

    @Override
    public Observable<UserEntity> entityUserDetails(String id) {
        return this.userCache.getUserById(id);
    }

    @Override
    public Observable<ArrayList<UserEntity>> listOfAllEntityUsers() {
        return this.userCache.getAllUsersOnLocalCache();
    }

    @Override
    public Observable<UserEntity> saveUserToLocalCache(UserEntity user) {
        return this.userCache.saveUserToLocalCache(user);
    }

    @Override
    public Observable<ArrayList<UserEntity>> saveUsersListToLocalCache(ArrayList<UserEntity> usersList) {
        return this.userCache.saveUsersToLocalCache(usersList);
    }
}
