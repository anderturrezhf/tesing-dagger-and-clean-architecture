package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.userinfo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.example.features.getuser.UserEntity;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.R;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.ui.basecomponents.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ander Túrrez on 27/09/16.
 */

public class UserInfoFragment extends BaseFragment implements MVPCurrentUserInfo.View {

    @Inject protected MVPCurrentUserInfo.Presenter presenter;

    @BindView(R.id.userInfoFragmentTitleTextView) protected TextView titletextView;
    @BindView(R.id.userInfoFragmentAgeTextView) protected TextView ageTextView;
    @BindView(R.id.userInfoFragmentCityTextView) protected TextView cityTextView;
    @BindView(R.id.userInfoFragmentAliasTextView) protected TextView aliasTextView;
    @BindView(R.id.userInfoFragmentBottomTextView) protected TextView bottomTextView;

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
        presenter.updateUserInfo();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.user_info_layout;
    }

    @Override
    public void setCurrentUserInfoOnFields(UserEntity user) {
        this.titletextView.setText(resources.getString(R.string.user_info_fragment_title, user.getName()));
        this.titletextView.setText(resources.getString(R.string.user_info_fragment_age, String.valueOf(user.getAge())));
        this.titletextView.setText(resources.getString(R.string.user_info_fragment_city, user.getCity()));
        this.titletextView.setText(resources.getString(R.string.user_info_fragment_alias, user.getAlias()));
    }

    @Override
    public void setEmptyUserInfo() {
        this.titletextView.setText(resources.getString(R.string.user_info_fragment_no_current_user));
        this.titletextView.setText("");
        this.titletextView.setText("");
        this.titletextView.setText("");
        this.bottomTextView.setText("");
    }
}
