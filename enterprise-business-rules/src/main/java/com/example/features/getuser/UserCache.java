package com.example.features.getuser;

import java.util.List;

/**
 * Created by Ander Túrrez on 25/09/16.
 */

public interface UserCache {

    void saveUserToLocalCache(UserEntity user);
    UserEntity getUserById(int id);
    void deleteLocalCache();
    boolean existsUserOnLocalCache(int userId);
    List<UserEntity> getAllUsersOnLocalCache();
}
