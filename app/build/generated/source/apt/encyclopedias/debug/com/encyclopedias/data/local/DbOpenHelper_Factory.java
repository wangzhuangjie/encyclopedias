package com.encyclopedias.data.local;

import android.content.Context;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DbOpenHelper_Factory implements Factory<DbOpenHelper> {
  private final MembersInjector<DbOpenHelper> membersInjector;
  private final Provider<Context> contextProvider;

  public DbOpenHelper_Factory(MembersInjector<DbOpenHelper> membersInjector, Provider<Context> contextProvider) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public DbOpenHelper get() {  
    DbOpenHelper instance = new DbOpenHelper(contextProvider.get());
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<DbOpenHelper> create(MembersInjector<DbOpenHelper> membersInjector, Provider<Context> contextProvider) {  
    return new DbOpenHelper_Factory(membersInjector, contextProvider);
  }
}

