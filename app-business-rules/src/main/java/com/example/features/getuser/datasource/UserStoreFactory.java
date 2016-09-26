package com.example.features.getuser.datasource;

import com.example.features.getuser.UserCache;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Ander Túrrez on 25/09/16.
 */

@Singleton
public class UserStoreFactory {

    private UserCache userCache;

    @Inject
    public UserStoreFactory(UserCache userCache) {
        this.userCache = userCache;
    }

    /**
     * Maybe think on a better way of cheking if use Local or Cloud.
     * Not 100% convinced of this aproach
     * @return
     */
    public UserStore create(){
        //For now, return only Local
        return new LocalUserStore(this.userCache);
    }
}
