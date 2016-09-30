package com.example.features.getuser;

import java.util.ArrayList;

import rx.Observable;

/**
 * Created by Ander Túrrez on 25/09/16.
 */

public interface UserRepository {

    Observable<UserEntity> getUser(String id);

    Observable<ArrayList<UserEntity>> getAllUsersList();

    Observable<UserEntity> saveUser(UserEntity user);

    Observable<UserEntity> getCurrentUser();

    Observable<UserEntity> setCurrentUser(UserEntity userEntity);
}
