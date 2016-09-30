package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.userinfo.userslist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.features.getuser.UserEntity;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.R;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.ui.basecomponents.BaseFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ander Túrrez on 29/09/16.
 */

public class ListOfUsersFragment extends BaseFragment implements MVPUsersList.View {

    @Inject protected MVPUsersList.Presenter presenter;

    @BindView(R.id.usersListFragmentRecyclerView) protected RecyclerView usersList;

    private UsersListAdapter usersListAdapter;

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

    @Override
    public void onStart() {
        super.onStart();
        eventBus.register(this);
    }

    @Override
    public void onStop() {
        eventBus.unregister(this);
        super.onStop();
    }

    //Internal methods
    private void setUpListViewAndAdapter(){

    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.list_of_users_fragment_layout;
    }

    @Override
    public void displayUsersList(ArrayList<UserEntity> usersList) {
        this.usersListAdapter.setUserListsAndRefresh(usersList);
    }
}
