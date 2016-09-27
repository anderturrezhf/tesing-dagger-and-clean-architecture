package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.ui.basecomponents;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.components.global.ActivityComponent;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.components.global.ApplicationComponent;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.components.global.DaggerActivityComponent;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.modules.global.ActivityModule;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.modules.global.ApplicationModule;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.modules.ui.PresenterModule;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.modules.ui.UseCaseModule;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.ui.CustomApplication;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Ander Túrrez on 23/09/16.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Inject @Named(ApplicationModule.DEFAULT_PREFERENCES) protected SharedPreferences sharedPreferences;
    @Inject protected EventBus eventBus;
    @Inject protected Gson gson;
    @Inject protected Resources resources;

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivityComponent();
        setContentView(getActivityLayout());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public ApplicationComponent getApplicationComponent() {
        return ((CustomApplication) getApplication()).getApplicationComponent();
    }

    private void initActivityComponent(){
        this.activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .presenterModule(new PresenterModule())
                .useCaseModule(new UseCaseModule())
                .build();

        this.activityComponent.inject(this);
    }

    protected ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    protected abstract int getActivityLayout();

    protected abstract void initFragmentsIfNecessary();

    protected abstract void initDependencies();
}
