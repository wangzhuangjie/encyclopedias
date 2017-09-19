package com.encyclopedias.ui.user.presenter;


import android.util.Log;

import com.encyclopedias.data.DataManager;
import com.encyclopedias.ui.base.BasePresenter;
import com.encyclopedias.ui.user.UserEntity;
import com.encyclopedias.ui.user.mvp.LoginMvp;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by zhuangjie on 2017/2/22.
 */

public class LoginPresenter extends BasePresenter<LoginMvp> {
    private DataManager mDataManager;
    private Subscription mSubscription;
    private CompositeSubscription mCompositeSubscription = new CompositeSubscription();


    @Inject
    public LoginPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(LoginMvp mvpView) {
        super.attachView(mvpView);
    }

    public void getLzList(String name,String key){
        checkViewAttached();
        mSubscription = mDataManager.getcity(name,key)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<UserEntity>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(e.getMessage(), "获取数据失败");
                        getMvpView().safeExecute(view -> view.onError());
                    }

                    @Override
                    public void onNext(UserEntity comments) {
                        getMvpView().safeExecute(view -> view.onSuccess(comments));
                    }
                });
        mCompositeSubscription.add(mSubscription);

    }

    @Override
    public void detachView() {
        super.detachView();
        if (mCompositeSubscription != null) mCompositeSubscription.unsubscribe();
    }

}
