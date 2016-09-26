package com.example.features.getuser.datasource;

import com.example.features.getuser.UserCache;
import com.example.features.getuser.UserEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Ander Túrrez on 25/09/16.
 */

@Singleton
public class UserDataCache implements UserCache {

    private HashMap<Integer, UserEntity> userHashMap;

    @Inject
    public UserDataCache() {
        this.userHashMap = new HashMap<>();
    }

    @Override
    public void saveUserToLocalCache(UserEntity user) {
        this.userHashMap.put(user.getId(), user);
    }

    @Override
    public UserEntity getUserById(int id) {
        return userHashMap.get(id);
    }

    @Override
    public void deleteLocalCache() {
        this.userHashMap.clear();
    }

    @Override
    public boolean existsUserOnLocalCache(int userId) {
        return this.userHashMap.containsKey(userId);
    }

    @Override
    public List<UserEntity> getAllUsersOnLocalCache() {
        return new ArrayList<>(this.userHashMap.values());
    }


}
