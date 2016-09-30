package com.test.ander.testingcleanarchitecturewithdaggerandrxjava.features.getuser.userinfo.userslist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.features.getuser.UserEntity;
import com.test.ander.testingcleanarchitecturewithdaggerandrxjava.R;

import java.util.ArrayList;

/**
 * Created by Ander Túrrez on 29/09/16.
 */

public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.UsersViewHolder> {

    private ArrayList<UserEntity> usersList;

    public UsersListAdapter(ArrayList<UserEntity> usersList) {
        this.usersList = usersList;
    }

    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_list_item_layout, parent, false);

        return new UsersViewHolder(itemLayout);
    }

    @Override
    public void onBindViewHolder(UsersViewHolder viewHolder, int position) {
        UserEntity user = this.usersList.get(position);

        viewHolder.setUser(user);
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public void setUserListsAndRefresh(ArrayList<UserEntity> usersList){
        this.usersList = usersList;
        notifyDataSetChanged();
    }

    //Nested class that represents the Item to display on the RecyclerView
    static class UsersViewHolder extends RecyclerView.ViewHolder{

        private TextView userName;

        public UsersViewHolder(View itemView) {
            super(itemView);

            this.userName = (TextView) itemView.findViewById(R.id.usersListItemTextView);
        }

        public void setUser(UserEntity user){

            this.userName.setText(user.getName());
        }
    }
}
