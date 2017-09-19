package com.encyclopedias.injection.module;

import com.encyclopedias.data.model.EventBus;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ApplicationModule_ProvideEventBusFactory implements Factory<EventBus> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideEventBusFactory(ApplicationModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public EventBus get() {  
    EventBus provided = module.provideEventBus();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<EventBus> create(ApplicationModule module) {  
    return new ApplicationModule_ProvideEventBusFactory(module);
  }
}

