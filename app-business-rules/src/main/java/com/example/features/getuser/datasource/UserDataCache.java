package com.example.features.getuser.datasource;

import com.example.features.getuser.UserCache;
import com.example.features.getuser.UserEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by Ander Túrrez on 25/09/16.
 */

@Singleton
public class UserDataCache implements UserCache {

    private HashMap<String, UserEntity> userHashMap;

    @Inject
    public UserDataCache() {
        this.userHashMap = new HashMap<>();
    }

    @Override
    public Observable<UserEntity> saveUserToLocalCache(UserEntity user) {

        if (this.userHashMap.containsKey(user.getAlias())) {

            return Observable.error(new Throwable("User already Exists"));
        } else {

            this.userHashMap.put(user.getAlias(), user);
        }

        return Observable.just(user);
    }

    @Override
    public Observable<UserEntity> getUserById(String id) {
        return Observable.just(userHashMap.get(id));
    }

    @Override
    public void deleteLocalCache() {
        this.userHashMap.clear();
    }

    @Override
    public boolean existsUserOnLocalCache(String userId) {
        return this.userHashMap.containsKey(userId);
    }

    @Override
    public List<UserEntity> getAllUsersOnLocalCache() {
        return new ArrayList<>(this.userHashMap.values());
    }


}
