// Generated code from Butter Knife. Do not modify!
package com.encyclopedias.ui.main;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainFragment$$ViewBinder<T extends com.encyclopedias.ui.main.MainFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558598, "field 'recyclerView'");
    target.recyclerView = finder.castView(view, 2131558598, "field 'recyclerView'");
    view = finder.findRequiredView(source, 2131558611, "field 'imageVoice'");
    target.imageVoice = finder.castView(view, 2131558611, "field 'imageVoice'");
    view = finder.findRequiredView(source, 2131558612, "field 'editText'");
    target.editText = finder.castView(view, 2131558612, "field 'editText'");
    view = finder.findRequiredView(source, 2131558613, "field 'textVoice'");
    target.textVoice = finder.castView(view, 2131558613, "field 'textVoice'");
    view = finder.findRequiredView(source, 2131558615, "field 'sendButton'");
    target.sendButton = finder.castView(view, 2131558615, "field 'sendButton'");
  }

  @Override public void unbind(T target) {
    target.recyclerView = null;
    target.imageVoice = null;
    target.editText = null;
    target.textVoice = null;
    target.sendButton = null;
  }
}
