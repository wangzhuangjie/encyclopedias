package com.encyclopedias.data;


import com.encyclopedias.data.local.DatabaseHelper;
import com.encyclopedias.data.local.PreferencesHelper;
import com.encyclopedias.data.remote.APIService;
import com.encyclopedias.ui.user.UserEntity;
import com.encyclopedias.util.ConstantPool;
import com.encyclopedias.util.EventPosterHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;


@Singleton
public class DataManager {

    private final APIService mAPIService;
    private final DatabaseHelper mDatabaseHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final EventPosterHelper mEventPoster;

    @Inject
    public DataManager(APIService APIService, PreferencesHelper preferencesHelper,
                       DatabaseHelper databaseHelper, EventPosterHelper eventPosterHelper) {
        mAPIService = APIService;
        mPreferencesHelper = preferencesHelper;
        mDatabaseHelper = databaseHelper;
        mEventPoster = eventPosterHelper;
    }
    public Observable<UserEntity> getcity(String name,String key) {
        return mAPIService.getcity("http://jisutqybmf.market.alicloudapi.com/weather/query", name, key);
    }
    public PreferencesHelper getPreferencesHelper() {
        return mPreferencesHelper;
    }



}
