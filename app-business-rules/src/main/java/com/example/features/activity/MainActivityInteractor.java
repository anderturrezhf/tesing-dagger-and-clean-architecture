package com.example.features.activity;

import com.example.customscopes.PerActivity;
import com.example.features.getuser.UserEntity;
import com.example.features.getuser.UserRepository;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Ander Túrrez on 28/09/16.
 */
@PerActivity
public class MainActivityInteractor implements MainActivityUseCase {

    private UserRepository userRepository;

    @Inject
    public MainActivityInteractor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Observable<UserEntity> getCurrentUser() {
        return userRepository.getCurrentUser();
    }

    @Override
    public Observable<UserEntity> setPreviousCurrentUserFromPreferences(UserEntity user) {
        return userRepository.setCurrentUser(user);
    }

    @Override
    public Observable<ArrayList<UserEntity>> getCurrentUsersList() {
        return userRepository.getAllUsersList();
    }

    @Override
    public Observable<ArrayList<UserEntity>> setUsersListOnCache(ArrayList<UserEntity> usersList) {
        return userRepository.saveUsersListOnCache(usersList);
    }


}
