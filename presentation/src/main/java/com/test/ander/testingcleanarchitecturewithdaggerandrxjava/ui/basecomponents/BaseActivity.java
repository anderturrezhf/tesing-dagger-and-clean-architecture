package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.ui.basecomponents;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.components.global.ActivityComponent;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.components.global.ApplicationComponent;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.components.global.DaggerActivityComponent;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.modules.global.ActivityModule;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.modules.ui.PresenterModule;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.modules.ui.UseCaseModule;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.ui.CustomApplication;

/**
 * Created by Ander Túrrez on 23/09/16.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivityComponent();
        setContentView(getActivityLayout());
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
    }

    protected ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    protected abstract int getActivityLayout();

    protected abstract void injectDependencies();
}
