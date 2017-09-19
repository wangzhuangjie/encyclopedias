package com.encyclopedias.injection.component;

import android.app.Application;
import android.content.Context;

import com.encyclopedias.data.DataManager;
import com.encyclopedias.data.local.DatabaseHelper;
import com.encyclopedias.data.local.PreferencesHelper;
import com.encyclopedias.data.model.EventBus;
import com.encyclopedias.data.remote.APIService;
import com.encyclopedias.injection.ApplicationContext;
import com.encyclopedias.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context context();
    Application application();
    APIService apiService();
    PreferencesHelper preferencesHelper();
    DatabaseHelper databaseHelper();
    DataManager dataManager();
    EventBus eventBus();

}
