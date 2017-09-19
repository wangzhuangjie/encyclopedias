package com.encyclopedias.ui.main;

import com.encyclopedias.data.DataManager;
import com.encyclopedias.data.model.EventBus;
import com.encyclopedias.ui.base.BaseActivity;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final MembersInjector<BaseActivity> supertypeInjector;
  private final Provider<RootPresenter> mRootPresenterProvider;
  private final Provider<EventBus> mBusProvider;
  private final Provider<DataManager> mDataManagerProvider;

  public MainActivity_MembersInjector(MembersInjector<BaseActivity> supertypeInjector, Provider<RootPresenter> mRootPresenterProvider, Provider<EventBus> mBusProvider, Provider<DataManager> mDataManagerProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert mRootPresenterProvider != null;
    this.mRootPresenterProvider = mRootPresenterProvider;
    assert mBusProvider != null;
    this.mBusProvider = mBusProvider;
    assert mDataManagerProvider != null;
    this.mDataManagerProvider = mDataManagerProvider;
  }

  @Override
  public void injectMembers(MainActivity instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.mRootPresenter = mRootPresenterProvider.get();
    instance.mBus = mBusProvider.get();
    instance.mDataManager = mDataManagerProvider.get();
  }

  public static MembersInjector<MainActivity> create(MembersInjector<BaseActivity> supertypeInjector, Provider<RootPresenter> mRootPresenterProvider, Provider<EventBus> mBusProvider, Provider<DataManager> mDataManagerProvider) {  
      return new MainActivity_MembersInjector(supertypeInjector, mRootPresenterProvider, mBusProvider, mDataManagerProvider);
  }
}

