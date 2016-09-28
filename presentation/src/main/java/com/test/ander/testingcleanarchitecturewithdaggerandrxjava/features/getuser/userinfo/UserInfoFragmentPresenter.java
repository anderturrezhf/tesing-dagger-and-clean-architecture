package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.userinfo;

import com.example.customscopes.PerActivity;
import com.example.features.getuser.userinfo.UserInfoUseCase;

import javax.inject.Inject;

/**
 * Created by Ander Túrrez on 27/09/16.
 */
@PerActivity
public class UserInfoFragmentPresenter implements MVPCurrentUserInfo.Presenter {

    private UserInfoUseCase interactor;
    private MVPCurrentUserInfo.View view;

    @Inject
    public UserInfoFragmentPresenter(UserInfoUseCase interactor) {
        this.interactor = interactor;
    }

    @Override
    public void setView(MVPCurrentUserInfo.View view) {
        this.view = view;
    }

    @Override
    public void updateUserInfo() {
        this.interactor.getCurrentUser()
                .subscribe(userEntity -> this.view.setCurrentUserInfoOnFields(userEntity),
                        throwable -> {
                            this.view.showToastMessage(throwable.getMessage());
                            this.view.setEmptyUserInfo();
                        });
    }
}
