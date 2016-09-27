package com.example.features.getuser.newregistration;

import com.example.features.getuser.UserEntity;

import rx.Observable;

/**
 * Created by Ander Túrrez on 24/09/16.
 */

public interface RegisterNewUserUseCase {

    Observable<UserEntity> saveUser(UserEntity userEntity);
}
