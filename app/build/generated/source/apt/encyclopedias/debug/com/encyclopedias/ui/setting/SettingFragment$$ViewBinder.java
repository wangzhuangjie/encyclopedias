// Generated code from Butter Knife. Do not modify!
package com.encyclopedias.ui.setting;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class SettingFragment$$ViewBinder<T extends com.encyclopedias.ui.setting.SettingFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558599, "field 'mRLPersonnal'");
    target.mRLPersonnal = finder.castView(view, 2131558599, "field 'mRLPersonnal'");
    view = finder.findRequiredView(source, 2131558601, "field 'mRLFollowupPrice'");
    target.mRLFollowupPrice = finder.castView(view, 2131558601, "field 'mRLFollowupPrice'");
    view = finder.findRequiredView(source, 2131558605, "field 'mRLRemind'");
    target.mRLRemind = finder.castView(view, 2131558605, "field 'mRLRemind'");
    view = finder.findRequiredView(source, 2131558606, "field 'mRLAboutUs'");
    target.mRLAboutUs = finder.castView(view, 2131558606, "field 'mRLAboutUs'");
    view = finder.findRequiredView(source, 2131558607, "field 'btnLogout'");
    target.btnLogout = finder.castView(view, 2131558607, "field 'btnLogout'");
  }

  @Override public void unbind(T target) {
    target.mRLPersonnal = null;
    target.mRLFollowupPrice = null;
    target.mRLRemind = null;
    target.mRLAboutUs = null;
    target.btnLogout = null;
  }
}
