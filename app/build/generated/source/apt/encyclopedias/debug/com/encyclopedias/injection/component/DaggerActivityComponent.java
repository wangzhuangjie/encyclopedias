package com.encyclopedias.injection.component;

import com.encyclopedias.data.DataManager;
import com.encyclopedias.data.model.EventBus;
import com.encyclopedias.injection.module.ActivityModule;
import com.encyclopedias.ui.main.MainActivity;
import com.encyclopedias.ui.main.MainActivity_MembersInjector;
import com.encyclopedias.ui.main.MainFragment;
import com.encyclopedias.ui.main.MainFragment_MembersInjector;
import com.encyclopedias.ui.main.MainPresenter;
import com.encyclopedias.ui.main.MainPresenter_Factory;
import com.encyclopedias.ui.main.RootPresenter;
import com.encyclopedias.ui.main.RootPresenter_Factory;
import com.encyclopedias.ui.user.LoginActivity;
import com.encyclopedias.ui.user.LoginActivity_MembersInjector;
import com.encyclopedias.ui.user.presenter.LoginPresenter;
import com.encyclopedias.ui.user.presenter.LoginPresenter_Factory;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DaggerActivityComponent implements ActivityComponent {
  private Provider<DataManager> dataManagerProvider;
  private Provider<EventBus> eventBusProvider;
  private Provider<RootPresenter> rootPresenterProvider;
  private MembersInjector<MainActivity> mainActivityMembersInjector;
  private Provider<MainPresenter> mainPresenterProvider;
  private MembersInjector<MainFragment> mainFragmentMembersInjector;
  private Provider<LoginPresenter> loginPresenterProvider;
  private MembersInjector<LoginActivity> loginActivityMembersInjector;

  private DaggerActivityComponent(Builder builder) {  
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {  
    return new Builder();
  }

  private void initialize(final Builder builder) {  
    this.dataManagerProvider = new Factory<DataManager>() {
      private final ApplicationComponent applicationComponent = builder.applicationComponent;
      @Override public DataManager get() {
        DataManager provided = applicationComponent.dataManager();
        if (provided == null) {
          throw new NullPointerException("Cannot return null from a non-@Nullable component method");
        }
        return provided;
      }
    };
    this.eventBusProvider = new Factory<EventBus>() {
      private final ApplicationComponent applicationComponent = builder.applicationComponent;
      @Override public EventBus get() {
        EventBus provided = applicationComponent.eventBus();
        if (provided == null) {
          throw new NullPointerException("Cannot return null from a non-@Nullable component method");
        }
        return provided;
      }
    };
    this.rootPresenterProvider = RootPresenter_Factory.create((MembersInjector) MembersInjectors.noOp(), dataManagerProvider, eventBusProvider);
    this.mainActivityMembersInjector = MainActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), rootPresenterProvider, eventBusProvider, dataManagerProvider);
    this.mainPresenterProvider = MainPresenter_Factory.create((MembersInjector) MembersInjectors.noOp(), dataManagerProvider);
    this.mainFragmentMembersInjector = MainFragment_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), mainPresenterProvider, eventBusProvider);
    this.loginPresenterProvider = LoginPresenter_Factory.create((MembersInjector) MembersInjectors.noOp(), dataManagerProvider);
    this.loginActivityMembersInjector = LoginActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), loginPresenterProvider);
  }

  @Override
  public void inject(MainActivity mainActivity) {  
    mainActivityMembersInjector.injectMembers(mainActivity);
  }

  @Override
  public void inject(MainFragment mainFragment) {  
    mainFragmentMembersInjector.injectMembers(mainFragment);
  }

  @Override
  public void inject(LoginActivity loginActivity) {  
    loginActivityMembersInjector.injectMembers(loginActivity);
  }

  public static final class Builder {
    private ActivityModule activityModule;
    private ApplicationComponent applicationComponent;
  
    private Builder() {  
    }
  
    public ActivityComponent build() {  
      if (activityModule == null) {
        throw new IllegalStateException("activityModule must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException("applicationComponent must be set");
      }
      return new DaggerActivityComponent(this);
    }
  
    public Builder activityModule(ActivityModule activityModule) {  
      if (activityModule == null) {
        throw new NullPointerException("activityModule");
      }
      this.activityModule = activityModule;
      return this;
    }
  
    public Builder applicationComponent(ApplicationComponent applicationComponent) {  
      if (applicationComponent == null) {
        throw new NullPointerException("applicationComponent");
      }
      this.applicationComponent = applicationComponent;
      return this;
    }
  }
}

