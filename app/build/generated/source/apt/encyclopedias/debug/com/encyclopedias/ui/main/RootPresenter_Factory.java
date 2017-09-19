package com.encyclopedias.ui.main;

import com.encyclopedias.data.DataManager;
import com.encyclopedias.data.model.EventBus;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class RootPresenter_Factory implements Factory<RootPresenter> {
  private final MembersInjector<RootPresenter> membersInjector;
  private final Provider<DataManager> dataManagerProvider;
  private final Provider<EventBus> busProvider;

  public RootPresenter_Factory(MembersInjector<RootPresenter> membersInjector, Provider<DataManager> dataManagerProvider, Provider<EventBus> busProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert dataManagerProvider != null;
    this.dataManagerProvider = dataManagerProvider;
    assert busProvider != null;
    this.busProvider = busProvider;
  }

  @Override
  public RootPresenter get() {  
    RootPresenter instance = new RootPresenter(dataManagerProvider.get(), busProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<RootPresenter> create(MembersInjector<RootPresenter> membersInjector, Provider<DataManager> dataManagerProvider, Provider<EventBus> busProvider) {  
    return new RootPresenter_Factory(membersInjector, dataManagerProvider, busProvider);
  }
}

