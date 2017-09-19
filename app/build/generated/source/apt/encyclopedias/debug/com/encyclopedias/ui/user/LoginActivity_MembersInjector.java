package com.encyclopedias.ui.user;

import com.encyclopedias.ui.base.BaseActivity;
import com.encyclopedias.ui.user.presenter.LoginPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class LoginActivity_MembersInjector implements MembersInjector<LoginActivity> {
  private final MembersInjector<BaseActivity> supertypeInjector;
  private final Provider<LoginPresenter> presenterProvider;

  public LoginActivity_MembersInjector(MembersInjector<BaseActivity> supertypeInjector, Provider<LoginPresenter> presenterProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public void injectMembers(LoginActivity instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.presenter = presenterProvider.get();
  }

  public static MembersInjector<LoginActivity> create(MembersInjector<BaseActivity> supertypeInjector, Provider<LoginPresenter> presenterProvider) {  
      return new LoginActivity_MembersInjector(supertypeInjector, presenterProvider);
  }
}

