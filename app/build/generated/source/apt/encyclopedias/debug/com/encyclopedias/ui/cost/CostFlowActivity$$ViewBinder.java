// Generated code from Butter Knife. Do not modify!
package com.encyclopedias.ui.cost;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class CostFlowActivity$$ViewBinder<T extends com.encyclopedias.ui.cost.CostFlowActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558519, "field 'tlCost'");
    target.tlCost = finder.castView(view, 2131558519, "field 'tlCost'");
    view = finder.findRequiredView(source, 2131558520, "field 'costViewPage'");
    target.costViewPage = finder.castView(view, 2131558520, "field 'costViewPage'");
  }

  @Override public void unbind(T target) {
    target.tlCost = null;
    target.costViewPage = null;
  }
}
