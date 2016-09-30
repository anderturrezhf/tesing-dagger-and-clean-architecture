package com.example.features.getuser.userinfo;

import com.example.customscopes.PerActivity;
import com.example.features.getuser.UserEntity;
import com.example.features.getuser.UserRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Ander Túrrez on 27/09/16.
 */
@PerActivity
public class UserInfoInteractor implements UserInfoUseCase {

    private UserRepository userRepository;

    @Inject
    public UserInfoInteractor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Observable<UserEntity> getCurrentUser() {
        return this.userRepository.getCurrentUser();
    }

    @Override
    public Observable<List<UserEntity>> getUsersList() {
        return this.userRepository.getAllUsersList();
    }
}
