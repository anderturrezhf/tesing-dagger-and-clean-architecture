package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.modules.global;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentManager;

import com.example.customscopes.PerActivity;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.ui.basecomponents.BaseActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ander Túrrez on 23/09/16.
 */

@Module
public class ActivityModule {

    private BaseActivity baseActivity;

    public ActivityModule(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
    }

    @PerActivity
    @Provides
    BaseActivity providesBaseActivity(){
        return this.baseActivity;
    }

    @PerActivity
    @Provides
    FragmentManager providesFragmentManager(BaseActivity activity){
        return activity.getSupportFragmentManager();
    }

    @PerActivity
    @Provides
    Resources providesResources(Context context){
        return context.getResources();
    }
}
