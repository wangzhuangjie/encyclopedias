package com.encyclopedias.injection.component;

import android.app.Application;
import android.content.Context;
import com.encyclopedias.data.DataManager;
import com.encyclopedias.data.DataManager_Factory;
import com.encyclopedias.data.local.DatabaseHelper;
import com.encyclopedias.data.local.DatabaseHelper_Factory;
import com.encyclopedias.data.local.DbOpenHelper;
import com.encyclopedias.data.local.DbOpenHelper_Factory;
import com.encyclopedias.data.local.PreferencesHelper;
import com.encyclopedias.data.local.PreferencesHelper_Factory;
import com.encyclopedias.data.model.EventBus;
import com.encyclopedias.data.remote.APIService;
import com.encyclopedias.injection.module.ApplicationModule;
import com.encyclopedias.injection.module.ApplicationModule_ProvideAPIServiceFactory;
import com.encyclopedias.injection.module.ApplicationModule_ProvideApplicationFactory;
import com.encyclopedias.injection.module.ApplicationModule_ProvideContextFactory;
import com.encyclopedias.injection.module.ApplicationModule_ProvideEventBusFactory;
import com.encyclopedias.util.EventPosterHelper;
import com.encyclopedias.util.EventPosterHelper_Factory;
import dagger.MembersInjector;
import dagger.internal.MembersInjectors;
import dagger.internal.ScopedProvider;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DaggerApplicationComponent implements ApplicationComponent {
  private Provider<Context> provideContextProvider;
  private Provider<Application> provideApplicationProvider;
  private Provider<APIService> provideAPIServiceProvider;
  private Provider<PreferencesHelper> preferencesHelperProvider;
  private Provider<DbOpenHelper> dbOpenHelperProvider;
  private Provider<DatabaseHelper> databaseHelperProvider;
  private Provider<EventBus> provideEventBusProvider;
  private Provider<EventPosterHelper> eventPosterHelperProvider;
  private Provider<DataManager> dataManagerProvider;

  private DaggerApplicationComponent(Builder builder) {  
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {  
    return new Builder();
  }

  private void initialize(final Builder builder) {  
    this.provideContextProvider = ApplicationModule_ProvideContextFactory.create(builder.applicationModule);
    this.provideApplicationProvider = ApplicationModule_ProvideApplicationFactory.create(builder.applicationModule);
    this.provideAPIServiceProvider = ScopedProvider.create(ApplicationModule_ProvideAPIServiceFactory.create(builder.applicationModule));
    this.preferencesHelperProvider = ScopedProvider.create(PreferencesHelper_Factory.create(provideContextProvider));
    this.dbOpenHelperProvider = DbOpenHelper_Factory.create((MembersInjector) MembersInjectors.noOp(), provideContextProvider);
    this.databaseHelperProvider = ScopedProvider.create(DatabaseHelper_Factory.create(dbOpenHelperProvider));
    this.provideEventBusProvider = ScopedProvider.create(ApplicationModule_ProvideEventBusFactory.create(builder.applicationModule));
    this.eventPosterHelperProvider = EventPosterHelper_Factory.create(provideEventBusProvider);
    this.dataManagerProvider = ScopedProvider.create(DataManager_Factory.create(provideAPIServiceProvider, preferencesHelperProvider, databaseHelperProvider, eventPosterHelperProvider));
  }

  @Override
  public Context context() {  
    return provideContextProvider.get();
  }

  @Override
  public Application application() {  
    return provideApplicationProvider.get();
  }

  @Override
  public APIService apiService() {  
    return provideAPIServiceProvider.get();
  }

  @Override
  public PreferencesHelper preferencesHelper() {  
    return preferencesHelperProvider.get();
  }

  @Override
  public DatabaseHelper databaseHelper() {  
    return databaseHelperProvider.get();
  }

  @Override
  public DataManager dataManager() {  
    return dataManagerProvider.get();
  }

  @Override
  public EventBus eventBus() {  
    return provideEventBusProvider.get();
  }

  public static final class Builder {
    private ApplicationModule applicationModule;
  
    private Builder() {  
    }
  
    public ApplicationComponent build() {  
      if (applicationModule == null) {
        throw new IllegalStateException("applicationModule must be set");
      }
      return new DaggerApplicationComponent(this);
    }
  
    public Builder applicationModule(ApplicationModule applicationModule) {  
      if (applicationModule == null) {
        throw new NullPointerException("applicationModule");
      }
      this.applicationModule = applicationModule;
      return this;
    }
  }
}

