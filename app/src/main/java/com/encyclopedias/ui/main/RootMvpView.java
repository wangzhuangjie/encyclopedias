package com.encyclopedias.ui.main;


import com.encyclopedias.ui.base.MvpView;

public interface RootMvpView extends MvpView {

    void showError();

    void finishLoading();

}
