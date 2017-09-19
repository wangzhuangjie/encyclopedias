package com.encyclopedias.ui.base;

public interface ViewRunnable<View extends MvpView>
{
    void run(View view);
}