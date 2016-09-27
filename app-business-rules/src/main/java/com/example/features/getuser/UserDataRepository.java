package com.example.features.getuser;


import com.example.features.getuser.datasource.UserStoreFactory;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by Ander Túrrez on 25/09/16.
 */

@Singleton
public class UserDataRepository implements UserRepository {

    private UserStoreFactory userStoreFactory;
    private UserEntity currentUser;

    @Inject
    public UserDataRepository(UserStoreFactory userStoreFactory) {
        this.userStoreFactory = userStoreFactory;
    }

    @Override
    public Observable<UserEntity> getUser(String id) {
        return this.userStoreFactory.create().entityUserDetails(id);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return this.userStoreFactory.create().listOfAllEntityUsers();
    }

    @Override
    public Observable<UserEntity> saveUser(UserEntity user) {
        return this.userStoreFactory.create().saveUserToLocalCache(user)
                .doOnNext(userEntity -> this.setCurrentUser(userEntity));
    }

    @Override
    public Observable<UserEntity> getCurrentUser() {
        return Observable.just(currentUser);
    }

    @Override
    public void setCurrentUser(UserEntity userEntity) {
        this.currentUser = userEntity;
    }
}
