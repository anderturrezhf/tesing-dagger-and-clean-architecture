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

    private static final String NO_CURRENT_ERROR_MESSAGE = "No Current User";

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
    public Observable<List<UserEntity>> getAllUsers() {
        return this.userStoreFactory.create().listOfAllEntityUsers();
    }

    @Override
    public Observable<UserEntity> saveUser(UserEntity user) {
        return this.userStoreFactory.create().saveUserToLocalCache(user)
                .doOnNext(this::setCurrentUser);
    }

    @Override
    public Observable<UserEntity> getCurrentUser() {
        return this.currentUser == null ? Observable.error(new Throwable(NO_CURRENT_ERROR_MESSAGE)) : Observable.just(currentUser);
    }

    @Override
    public Observable<UserEntity> setCurrentUser(UserEntity userEntity) {
        this.currentUser = userEntity;

        return getCurrentUser();
    }
}
