package com.encyclopedias.util;

import com.encyclopedias.data.model.EventBus;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class EventPosterHelper_Factory implements Factory<EventPosterHelper> {
  private final Provider<EventBus> busProvider;

  public EventPosterHelper_Factory(Provider<EventBus> busProvider) {  
    assert busProvider != null;
    this.busProvider = busProvider;
  }

  @Override
  public EventPosterHelper get() {  
    return new EventPosterHelper(busProvider.get());
  }

  public static Factory<EventPosterHelper> create(Provider<EventBus> busProvider) {  
    return new EventPosterHelper_Factory(busProvider);
  }
}

