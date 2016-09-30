package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.userinfo.userslist;

import com.example.customscopes.PerActivity;
import com.example.features.getuser.userinfo.UserInfoUseCase;

import javax.inject.Inject;

/**
 * Created by Ander Túrrez on 29/09/16.
 */
@PerActivity
public class ListOfUsersFragmentPresenter implements MVPUsersList.Presenter {

    private MVPUsersList.View view;
    private UserInfoUseCase interactor;

    @Inject
    public ListOfUsersFragmentPresenter(UserInfoUseCase interactor) {
        this.interactor = interactor;
    }

    @Override
    public void setView(MVPUsersList.View view) {
        this.view = view;
    }

    @Override
    public void onActivityCreated() {
        this.interactor.getUsersList()
                .subscribe(userEntities -> this.view.displayUpdatedUsersList(userEntities),
                        throwable -> this.view.initializeAndFillUserListWithCurrentUsers(null));
    }
}
