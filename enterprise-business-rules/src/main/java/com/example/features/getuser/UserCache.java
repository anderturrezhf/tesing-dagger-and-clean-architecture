package com.example.features.getuser;

import java.util.List;

import rx.Observable;

/**
 * Created by Ander Túrrez on 25/09/16.
 */

public interface UserCache {

    Observable<UserEntity> saveUserToLocalCache(UserEntity user);
    Observable<UserEntity> getUserById(String id);
    void deleteLocalCache();
    boolean existsUserOnLocalCache(String userId);
    List<UserEntity> getAllUsersOnLocalCache();
}
