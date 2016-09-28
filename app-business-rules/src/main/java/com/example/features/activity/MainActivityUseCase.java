package com.example.features.activity;

import com.example.features.getuser.UserEntity;

import rx.Observable;

/**
 * Created by Ander Túrrez on 28/09/16.
 */

public interface MainActivityUseCase {

    Observable<UserEntity> getCurrentUser();

    Observable<UserEntity> setPreviousCurrentUserFromPreferences(UserEntity user);
}
