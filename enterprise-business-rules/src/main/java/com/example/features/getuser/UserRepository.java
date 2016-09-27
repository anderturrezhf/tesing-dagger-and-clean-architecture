package com.example.features.getuser;

import java.util.List;

import rx.Observable;

/**
 * Created by Ander Túrrez on 25/09/16.
 */

public interface UserRepository {

    Observable<UserEntity> getUser(String id);

    List<UserEntity> getAllUsers();

    Observable<UserEntity> saveUser(UserEntity user);

    Observable<UserEntity> getCurrentUser();

    void setCurrentUser(UserEntity userEntity);
}
