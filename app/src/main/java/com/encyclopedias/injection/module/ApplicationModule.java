package com.encyclopedias.injection.module;

import android.app.Application;
import android.content.Context;


import com.encyclopedias.data.model.EventBus;
import com.encyclopedias.data.remote.APIService;
import com.encyclopedias.injection.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provide application-level dependencies.
 */
@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    EventBus provideEventBus() {
        return new EventBus();
    }

    @Provides
    @Singleton
    APIService provideAPIService() {
        return APIService.Creator.newRibotsService();
    }

}
