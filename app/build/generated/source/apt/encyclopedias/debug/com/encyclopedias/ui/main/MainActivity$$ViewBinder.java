// Generated code from Butter Knife. Do not modify!
package com.encyclopedias.ui.main;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainActivity$$ViewBinder<T extends com.encyclopedias.ui.main.MainActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558556, "field 'mUIPagerContent'");
    target.mUIPagerContent = finder.castView(view, 2131558556, "field 'mUIPagerContent'");
    view = finder.findRequiredView(source, 2131558545, "field 'mUITabNavigation'");
    target.mUITabNavigation = finder.castView(view, 2131558545, "field 'mUITabNavigation'");
  }

  @Override public void unbind(T target) {
    target.mUIPagerContent = null;
    target.mUITabNavigation = null;
  }
}
