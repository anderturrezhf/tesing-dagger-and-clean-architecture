package com.example.features.getuser;


import com.example.features.getuser.datasource.UserStoreFactory;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Ander Túrrez on 25/09/16.
 */

@Singleton
public class UserDataRepository implements UserRepository {

    private UserStoreFactory userStoreFactory;

    @Inject
    public UserDataRepository(UserStoreFactory userStoreFactory) {
        this.userStoreFactory = userStoreFactory;
    }

    @Override
    public UserEntity getUser(int id) {
        return this.userStoreFactory.create().entityUserDetails(id);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return this.userStoreFactory.create().listOfAllEntityUsers();
    }

    @Override
    public void saveUser(UserEntity user) {
        this.userStoreFactory.create().saveUserToLocalCache(user);
    }
}
