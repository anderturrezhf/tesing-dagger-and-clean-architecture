package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.ui.basecomponents;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.di.components.global.ActivityComponent;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * Created by Ander Túrrez on 26/09/16.
 */

public abstract class BaseFragment extends Fragment {

    @Inject protected Context context;
    @Inject protected Resources resources;
    @Inject protected EventBus eventBus;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivityComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(getFragmentLayout(), container, false);
    }

    protected ActivityComponent getActivityComponent(){

        return ((BaseActivity) getActivity()).getActivityComponent();
    }

    protected abstract int getFragmentLayout();

}
