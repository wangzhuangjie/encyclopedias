package com.encyclopedias.data.local;

import android.content.Context;
import android.content.SharedPreferences;


import com.encyclopedias.injection.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PreferencesHelper {

    public static final String PREF_FILE_NAME = "android_boilerplate_pref_file";

    private final SharedPreferences mPref;

    @Inject
    public PreferencesHelper(@ApplicationContext Context context) {
        mPref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    public void clear() {
        mPref.edit().clear().apply();
    }

    public String getString(String key){
        return getString(key,null);
    }

    public String getString(String key,String defaultValue){
        return mPref.getString(key,defaultValue);
    }

    public void putString(String key, String value){
        mPref.edit().putString(key,value).commit();
    }

    public void removeByKey(String key) {
        mPref.edit().remove(key).commit();
    }

    public void putInteger(String key, Integer value) {
        mPref.edit().putInt(key,value).commit();
    }

    public Integer getInteger(String key) {
        return mPref.getInt(key,0);
    }
}
