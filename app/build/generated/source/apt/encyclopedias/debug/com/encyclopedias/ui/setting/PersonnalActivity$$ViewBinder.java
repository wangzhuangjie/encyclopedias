// Generated code from Butter Knife. Do not modify!
package com.encyclopedias.ui.setting;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class PersonnalActivity$$ViewBinder<T extends com.encyclopedias.ui.setting.PersonnalActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558558, "field 'mRLAcatar'");
    target.mRLAcatar = finder.castView(view, 2131558558, "field 'mRLAcatar'");
    view = finder.findRequiredView(source, 2131558561, "field 'mRLName'");
    target.mRLName = finder.castView(view, 2131558561, "field 'mRLName'");
    view = finder.findRequiredView(source, 2131558564, "field 'mRLtitle'");
    target.mRLtitle = finder.castView(view, 2131558564, "field 'mRLtitle'");
    view = finder.findRequiredView(source, 2131558568, "field 'mRLDepartment'");
    target.mRLDepartment = finder.castView(view, 2131558568, "field 'mRLDepartment'");
    view = finder.findRequiredView(source, 2131558571, "field 'mRLhospitall'");
    target.mRLhospitall = finder.castView(view, 2131558571, "field 'mRLhospitall'");
    view = finder.findRequiredView(source, 2131558575, "field 'mRLBusinessCard'");
    target.mRLBusinessCard = finder.castView(view, 2131558575, "field 'mRLBusinessCard'");
    view = finder.findRequiredView(source, 2131558579, "field 'mRLGood'");
    target.mRLGood = finder.castView(view, 2131558579, "field 'mRLGood'");
    view = finder.findRequiredView(source, 2131558583, "field 'mRLPracticeExperience'");
    target.mRLPracticeExperience = finder.castView(view, 2131558583, "field 'mRLPracticeExperience'");
  }

  @Override public void unbind(T target) {
    target.mRLAcatar = null;
    target.mRLName = null;
    target.mRLtitle = null;
    target.mRLDepartment = null;
    target.mRLhospitall = null;
    target.mRLBusinessCard = null;
    target.mRLGood = null;
    target.mRLPracticeExperience = null;
  }
}
