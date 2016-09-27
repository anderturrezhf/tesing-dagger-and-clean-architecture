package com.example.features.getuser.newregistration;

import com.example.customscopes.PerActivity;
import com.example.features.getuser.UserEntity;
import com.example.features.getuser.UserRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Ander Túrrez on 24/09/16.
 */
@PerActivity
public class RegisterNewUserInteractor implements GetUserUseCase{

    private UserRepository userRepository;

    @Inject
    public RegisterNewUserInteractor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Observable<UserEntity> saveUser(UserEntity userEntity) {
        return this.userRepository.saveUser(userEntity);
    }

}
