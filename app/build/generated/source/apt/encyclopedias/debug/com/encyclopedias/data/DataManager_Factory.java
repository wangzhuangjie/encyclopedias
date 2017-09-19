package com.encyclopedias.data;

import com.encyclopedias.data.local.DatabaseHelper;
import com.encyclopedias.data.local.PreferencesHelper;
import com.encyclopedias.data.remote.APIService;
import com.encyclopedias.util.EventPosterHelper;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DataManager_Factory implements Factory<DataManager> {
  private final Provider<APIService> APIServiceProvider;
  private final Provider<PreferencesHelper> preferencesHelperProvider;
  private final Provider<DatabaseHelper> databaseHelperProvider;
  private final Provider<EventPosterHelper> eventPosterHelperProvider;

  public DataManager_Factory(Provider<APIService> APIServiceProvider, Provider<PreferencesHelper> preferencesHelperProvider, Provider<DatabaseHelper> databaseHelperProvider, Provider<EventPosterHelper> eventPosterHelperProvider) {  
    assert APIServiceProvider != null;
    this.APIServiceProvider = APIServiceProvider;
    assert preferencesHelperProvider != null;
    this.preferencesHelperProvider = preferencesHelperProvider;
    assert databaseHelperProvider != null;
    this.databaseHelperProvider = databaseHelperProvider;
    assert eventPosterHelperProvider != null;
    this.eventPosterHelperProvider = eventPosterHelperProvider;
  }

  @Override
  public DataManager get() {  
    return new DataManager(APIServiceProvider.get(), preferencesHelperProvider.get(), databaseHelperProvider.get(), eventPosterHelperProvider.get());
  }

  public static Factory<DataManager> create(Provider<APIService> APIServiceProvider, Provider<PreferencesHelper> preferencesHelperProvider, Provider<DatabaseHelper> databaseHelperProvider, Provider<EventPosterHelper> eventPosterHelperProvider) {  
    return new DataManager_Factory(APIServiceProvider, preferencesHelperProvider, databaseHelperProvider, eventPosterHelperProvider);
  }
}

