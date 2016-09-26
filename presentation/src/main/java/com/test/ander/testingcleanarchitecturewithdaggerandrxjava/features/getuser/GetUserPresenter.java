package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser;

import android.content.res.Resources;

import com.example.features.getuser.GetUserUseCase;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.R;
import com.example.customscopes.PerActivity;

import javax.inject.Inject;

/**
 * Created by Ander Túrrez on 24/09/16.
 */
@PerActivity
public class GetUserPresenter implements MVPGetUser.Presenter {

    private GetUserUseCase interactor;
    private MVPGetUser.View view;
    private Resources resources;

    @Inject
    public GetUserPresenter(GetUserUseCase interactor, Resources resources) {
        this.interactor = interactor;
        this.resources = resources;
    }

    @Override
    public void setView(MVPGetUser.View view) {
        this.view = view;
    }

    //Not using the interactor for now. Implementing it
    @Override
    public void getNewUser() {
        String newUser = this.view.getUserName();

        if (newUser.isEmpty()) {
            this.view.showToastAlertWithText(resources.getString(R.string.main_activity_show_empty_name_error));
        } else {
            this.view.setNewUserOnTextView("I am " + newUser);
        }
    }
}
