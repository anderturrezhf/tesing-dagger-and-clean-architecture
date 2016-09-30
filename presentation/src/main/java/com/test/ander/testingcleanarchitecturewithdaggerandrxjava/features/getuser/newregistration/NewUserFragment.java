package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.newregistration;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.features.getuser.UserEntity;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.R;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.ui.basecomponents.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Ander Túrrez on 26/09/16.
 */

public class NewUserFragment extends BaseFragment implements MVPNewUserRegistration.View {

    @Inject protected MVPNewUserRegistration.Presenter presenter;

    @BindView(R.id.newUserFragmentNameEditText) protected EditText nameEditText;
    @BindView(R.id.newUserFragmentAgeEditText) protected EditText ageEditText;
    @BindView(R.id.newUserFragmentCityEditText) protected EditText cityEditText;
    @BindView(R.id.newUserFragmentAliasEditText) protected EditText aliasEditText;
    @BindView(R.id.newUserFragmentSaveUserButton) protected Button saveNewUserButton;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivityComponent().inject(this);
        presenter.setView(this);
    }

    //Layout elements Methods
    @OnClick(R.id.newUserFragmentSaveUserButton)
    void performClick(){
        presenter.saveNewUser();
    }

    //Superclass abstract Methods
    @Override
    protected int getFragmentLayout() {
        return R.layout.new_user_fragment_layout;
    }

    //View Methods
    @Override
    public String getUserName() {
        return nameEditText.getText().toString();
    }

    @Override
    public String getAge() {
        return ageEditText.getText().toString();
    }

    @Override
    public String getCity() {
        return cityEditText.getText().toString();
    }

    @Override
    public String getAlias() {
        return aliasEditText.getText().toString();
    }

    @Override
    public void showToastAlertWithText(String alertText) {
        Toast.makeText(getActivity(), alertText, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUserCorrectlySaved(UserEntity userEntity) {
        eventBus.post(new NewUserSavedEvent(userEntity));
    }

    @Override
    public void cleanAllEditTexts() {
        nameEditText.setText("");
        ageEditText.setText("");
        cityEditText.setText("");
        aliasEditText.setText("");
    }
}
