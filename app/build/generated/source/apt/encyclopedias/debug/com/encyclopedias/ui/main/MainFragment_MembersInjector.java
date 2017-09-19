package com.encyclopedias.ui.main;

import com.encyclopedias.data.model.EventBus;
import com.encyclopedias.ui.base.BaseFragment;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class MainFragment_MembersInjector implements MembersInjector<MainFragment> {
  private final MembersInjector<BaseFragment> supertypeInjector;
  private final Provider<MainPresenter> mMainPresenterProvider;
  private final Provider<EventBus> mBusProvider;

  public MainFragment_MembersInjector(MembersInjector<BaseFragment> supertypeInjector, Provider<MainPresenter> mMainPresenterProvider, Provider<EventBus> mBusProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert mMainPresenterProvider != null;
    this.mMainPresenterProvider = mMainPresenterProvider;
    assert mBusProvider != null;
    this.mBusProvider = mBusProvider;
  }

  @Override
  public void injectMembers(MainFragment instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.mMainPresenter = mMainPresenterProvider.get();
    instance.mBus = mBusProvider.get();
  }

  public static MembersInjector<MainFragment> create(MembersInjector<BaseFragment> supertypeInjector, Provider<MainPresenter> mMainPresenterProvider, Provider<EventBus> mBusProvider) {  
      return new MainFragment_MembersInjector(supertypeInjector, mMainPresenterProvider, mBusProvider);
  }
}

