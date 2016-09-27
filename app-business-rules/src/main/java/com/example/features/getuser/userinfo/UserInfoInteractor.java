package com.example.features.getuser.userinfo;

import com.example.features.getuser.UserEntity;
import com.example.features.getuser.UserRepository;

import rx.Observable;

/**
 * Created by Ander Túrrez on 27/09/16.
 */

public class UserInfoInteractor implements UserInfoUseCase {

    private UserRepository userRepository;

    public UserInfoInteractor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Observable<UserEntity> getCurrentUserInfo() {
        return userRepository.getCurrentUser();
    }
}
