package com.example.features.getuser;

import java.util.List;

/**
 * Created by Ander Túrrez on 25/09/16.
 */

public interface UserRepository {

    UserEntity getUser(int id);

    List<UserEntity> getAllUsers();

    void saveUser(UserEntity user);
}
