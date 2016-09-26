package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.R;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.modules.global.ApplicationModule;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.GetUserPresenter;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.MVPGetUser;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.ui.basecomponents.BaseActivity;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MVPGetUser.View {

    @Inject @Named(ApplicationModule.DEFAULT_PREFERENCES) protected SharedPreferences sharedPreferences;
    @Inject protected EventBus eventBus;
    @Inject protected MVPGetUser.Presenter presenter;

    @BindView(R.id.mainActivityButton) protected Button mainButton;
    @BindView(R.id.mainActivityTextView) protected TextView mainTextView;
    @BindView(R.id.mainActivityNewUserEditText) protected EditText mainEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        injectDependencies();
        presenter.setView(this);
    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void injectDependencies() {
        getActivityComponent().inject(this);
    }

    @OnClick(R.id.mainActivityButton)
    void performClick(){
        presenter.getNewUser();
    }

    @Override
    public void setNewUserOnTextView(String newUser) {
        this.mainEditText.setText("");
        this.mainTextView.setText(newUser);
    }

    @Override
    public String getUserName() {
        return mainEditText.getText().toString();
    }

    @Override
    public void showToastAlertWithText(String alertText) {
        Toast.makeText(this, alertText, Toast.LENGTH_LONG).show();
    }
}
