package com.encyclopedias.injection.module;

import com.encyclopedias.data.remote.APIService;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ApplicationModule_ProvideAPIServiceFactory implements Factory<APIService> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideAPIServiceFactory(ApplicationModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public APIService get() {  
    APIService provided = module.provideAPIService();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<APIService> create(ApplicationModule module) {  
    return new ApplicationModule_ProvideAPIServiceFactory(module);
  }
}

