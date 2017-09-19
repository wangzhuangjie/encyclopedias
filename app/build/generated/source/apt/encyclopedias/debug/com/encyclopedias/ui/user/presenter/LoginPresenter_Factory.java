package com.encyclopedias.ui.user.presenter;

import com.encyclopedias.data.DataManager;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class LoginPresenter_Factory implements Factory<LoginPresenter> {
  private final MembersInjector<LoginPresenter> membersInjector;
  private final Provider<DataManager> dataManagerProvider;

  public LoginPresenter_Factory(MembersInjector<LoginPresenter> membersInjector, Provider<DataManager> dataManagerProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert dataManagerProvider != null;
    this.dataManagerProvider = dataManagerProvider;
  }

  @Override
  public LoginPresenter get() {  
    LoginPresenter instance = new LoginPresenter(dataManagerProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<LoginPresenter> create(MembersInjector<LoginPresenter> membersInjector, Provider<DataManager> dataManagerProvider) {  
    return new LoginPresenter_Factory(membersInjector, dataManagerProvider);
  }
}

