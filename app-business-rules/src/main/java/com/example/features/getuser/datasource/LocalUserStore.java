package com.example.features.getuser.datasource;

import com.example.features.getuser.UserCache;
import com.example.features.getuser.UserEntity;

import java.util.List;

/**
 * Created by Ander Túrrez on 25/09/16.
 */

public class LocalUserStore implements UserStore {

    private UserCache userCache;

    public LocalUserStore(UserCache userCache) {
        this.userCache = userCache;
    }

    @Override
    public UserEntity entityUserDetails(int id) {
        return this.userCache.getUserById(id);
    }

    @Override
    public List<UserEntity> listOfAllEntityUsers() {
        return this.userCache.getAllUsersOnLocalCache();
    }

    @Override
    public void saveUserToLocalCache(UserEntity user) {
        this.userCache.saveUserToLocalCache(user);
    }
}
