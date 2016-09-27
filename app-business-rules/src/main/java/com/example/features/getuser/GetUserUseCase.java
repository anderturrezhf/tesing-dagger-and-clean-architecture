package com.example.features.getuser;

import rx.Observable;

/**
 * Created by Ander Túrrez on 24/09/16.
 */

public interface GetUserUseCase {

    Observable<UserEntity> saveUser(UserEntity userEntity);
}
