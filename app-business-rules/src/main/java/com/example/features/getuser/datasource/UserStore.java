package com.example.features.getuser.datasource;

import com.example.features.getuser.UserEntity;

import java.util.List;

/**
 * Created by Ander Túrrez on 25/09/16.
 */

public interface UserStore {

    UserEntity entityUserDetails(int id);

    List<UserEntity> listOfAllEntityUsers();

    void saveUserToLocalCache(UserEntity user);
}
