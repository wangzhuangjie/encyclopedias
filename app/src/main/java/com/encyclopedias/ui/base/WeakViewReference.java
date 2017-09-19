package com.encyclopedias.ui.base;

import java.lang.ref.WeakReference;

public class WeakViewReference<View extends MvpView> extends WeakReference<View>
{
    public WeakViewReference(View r)
    {
        super(r);
    }

    public void safeExecute(ViewRunnable<View> runnable)
    {
        View view = get();
        if(view != null)
        {
            runnable.run(view);
        }
    }
}