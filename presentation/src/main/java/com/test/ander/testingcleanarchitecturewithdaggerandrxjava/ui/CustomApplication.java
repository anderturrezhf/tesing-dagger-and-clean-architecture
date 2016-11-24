package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.ui;

import android.support.multidex.MultiDexApplication;

import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.components.global.ApplicationComponent;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.components.global.DaggerApplicationComponent;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.modules.data.RepositoryModule;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.modules.global.ApplicationModule;

/**
 * Created by Ander Túrrez on 23/09/16.
 */

public class CustomApplication extends MultiDexApplication {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initApplicationComponent();
    }

    private void initApplicationComponent() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .repositoryModule(new RepositoryModule())
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
