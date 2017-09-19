package com.encyclopedias.ui.main;


import com.encyclopedias.data.DataManager;
import com.encyclopedias.ui.base.BasePresenter;
import com.encyclopedias.util.ConstantPool;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<MainMvpView> {

    private final DataManager mDataManager;
    private Subscription mSubscription;

    @Inject
    public MainPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(MainMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
//        if (mSubscription != null) mSubscription.unsubscribe();
    }

//    public void loadHomeData() {
//        checkViewAttached();
//        mSubscription = mDataManager.loadHomeData()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Subscriber<HomeDataModel>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        // Timber.e(e.getMessage(), "获取数据失败");
//                        getMvpView().safeExecute(view -> view.showError());
//                    }
//
//                    @Override
//                    public void onNext(HomeDataModel homeData) {
////                        if (homeData==null || homeData.getItems()==null || homeData.getItems().isEmpty()) {
////                            getMvpView().show();
////                        } else {
//                            getMvpView().safeExecute(view -> view.showHomePage(homeData));
////                        }
//                    }
//                });
//    }

    public Integer getUnreadMessageCount() {
        return mDataManager.getPreferencesHelper().getInteger(ConstantPool.PREF_UNREAD_MESSAGE_COUNT);
    }

    public boolean checkIsLogin() {
        return mDataManager.getPreferencesHelper().getString(ConstantPool.PREF_ACCESS_TOKEN)!=null;
    }
}
