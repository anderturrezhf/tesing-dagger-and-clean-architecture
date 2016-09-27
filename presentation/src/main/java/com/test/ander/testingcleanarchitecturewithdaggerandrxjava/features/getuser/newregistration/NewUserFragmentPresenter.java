package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.newregistration;

import android.content.res.Resources;

import com.example.features.getuser.GetUserUseCase;
import com.example.features.getuser.UserEntity;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.R;
import com.example.customscopes.PerActivity;

import javax.inject.Inject;

/**
 * Created by Ander Túrrez on 24/09/16.
 */
@PerActivity
public class NewUserFragmentPresenter implements MVPNewUserRegistration.Presenter {

    private GetUserUseCase interactor;
    private MVPNewUserRegistration.View view;
    private Resources resources;

    @Inject
    public NewUserFragmentPresenter(GetUserUseCase interactor, Resources resources) {
        this.interactor = interactor;
        this.resources = resources;
    }

    @Override
    public void setView(MVPNewUserRegistration.View view) {
        this.view = view;
    }

    @Override
    public void saveNewUser() {

        if (checkIfelementIsEmptyOrNull(this.view.getUserName()) ||
                checkIfelementIsEmptyOrNull(this.view.getAge()) ||
                checkIfelementIsEmptyOrNull(this.view.getCity()) ||
                checkIfelementIsEmptyOrNull(this.view.getAlias())) {

            this.view.showToastAlertWithText(resources.getString(R.string.new_user_fragment_show_empty_field_error));
        } else {
            this.interactor.saveUser(createNewUserEntityForSave())
                    .subscribe(userEntity -> this.userCorrectlySaved(userEntity),
                            throwable -> this.view.showToastAlertWithText(throwable.getMessage()));

        }
    }

    @Override
    public void userCorrectlySaved(UserEntity userEntity){
        this.view.onUserCorrectlySaved(userEntity);
        this.view.cleanAllEditTexts();
    }

    private UserEntity createNewUserEntityForSave() {
        return new UserEntity(this.view.getUserName(), Integer.valueOf(this.view.getAge()), this.view.getCity(), this.view.getAlias());
    }

    private boolean checkIfelementIsEmptyOrNull(String element) {

        return element == null || element.isEmpty();
    }


}
