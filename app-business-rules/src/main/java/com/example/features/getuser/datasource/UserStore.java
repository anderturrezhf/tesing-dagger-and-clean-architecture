package com.example.features.getuser.datasource;

import com.example.features.getuser.UserEntity;

import java.util.ArrayList;
import rx.Observable;

/**
 * Created by Ander Túrrez on 25/09/16.
 */

public interface UserStore {

    Observable<UserEntity> entityUserDetails(String id);

    Observable<ArrayList<UserEntity>> listOfAllEntityUsers();

    Observable<UserEntity> saveUserToLocalCache(UserEntity user);
}
