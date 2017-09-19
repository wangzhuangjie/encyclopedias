// Generated code from Butter Knife. Do not modify!
package com.encyclopedias.ui.user;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LoginActivity$$ViewBinder<T extends com.encyclopedias.ui.user.LoginActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558549, "field 'mETusername'");
    target.mETusername = finder.castView(view, 2131558549, "field 'mETusername'");
    view = finder.findRequiredView(source, 2131558551, "field 'mETpassword'");
    target.mETpassword = finder.castView(view, 2131558551, "field 'mETpassword'");
    view = finder.findRequiredView(source, 2131558553, "field 'mBtnLogin'");
    target.mBtnLogin = finder.castView(view, 2131558553, "field 'mBtnLogin'");
  }

  @Override public void unbind(T target) {
    target.mETusername = null;
    target.mETpassword = null;
    target.mBtnLogin = null;
  }
}
