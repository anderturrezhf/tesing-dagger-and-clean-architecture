package com.example.features.getuser.userinfo;

import com.example.features.getuser.UserEntity;

import java.util.ArrayList;
import rx.Observable;

/**
 * Created by Ander Túrrez on 27/09/16.
 */

public interface UserInfoUseCase {

    Observable<UserEntity> getCurrentUser();

    Observable<ArrayList<UserEntity>> getUsersList();
}
