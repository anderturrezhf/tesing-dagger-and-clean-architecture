package com.example.features.getuser;

import com.example.customscopes.PerActivity;

import javax.inject.Inject;

/**
 * Created by Ander Túrrez on 24/09/16.
 */
@PerActivity
public class GetUserInteractor implements GetUserUseCase{

    private UserRepository userRepository;

    @Inject
    public GetUserInteractor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void getUser(int id) {
        this.userRepository.getUser(id);
    }
}
