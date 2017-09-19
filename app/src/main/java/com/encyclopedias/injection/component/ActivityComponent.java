package com.encyclopedias.injection.component;

import com.encyclopedias.injection.PerActivity;
import com.encyclopedias.injection.module.ActivityModule;
import com.encyclopedias.ui.main.MainActivity;
import com.encyclopedias.ui.main.MainFragment;
import com.encyclopedias.ui.user.LoginActivity;

import dagger.Component;


/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    // Main
    void inject(MainActivity mainActivity);
    void inject(MainFragment mainFragment);
    void inject(LoginActivity loginActivity);

}
