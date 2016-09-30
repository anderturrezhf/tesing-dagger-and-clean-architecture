package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.userinfo.userslist;

import android.content.res.Resources;

import com.example.customscopes.PerActivity;
import com.example.features.getuser.userinfo.UserInfoUseCase;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.R;

import javax.inject.Inject;

/**
 * Created by Ander Túrrez on 29/09/16.
 */
@PerActivity
public class ListOfUsersFragmentPresenter implements MVPUsersList.Presenter {

    private MVPUsersList.View view;
    private UserInfoUseCase interactor;
    private Resources resources;

    @Inject
    public ListOfUsersFragmentPresenter(UserInfoUseCase interactor, Resources resources) {
        this.interactor = interactor;
        this.resources = resources;
    }

    @Override
    public void setView(MVPUsersList.View view) {
        this.view = view;
    }

    @Override
    public void onActivityCreated() {
        this.interactor.getUsersList()
                .subscribe(userEntities -> this.view.initializeAndFillUserListWithCurrentUsers(userEntities),
                        throwable -> {
                            this.view.initializeAndFillUserListWithCurrentUsers(null);
                            this.view.showToastMessage(resources.getString(R.string.list_of_users_fragment_error_retrieving_users));
                        });
    }

    @Override
    public void updateUsersList() {
        this.interactor.getUsersList()
                .subscribe(userEntities -> this.view.displayUpdatedUsersList(userEntities),
                        throwable -> this.view.showToastMessage(resources.getString(R.string.list_of_users_fragment_error_retrieving_users)));
    }
}
