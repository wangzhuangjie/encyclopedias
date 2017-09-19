package com.encyclopedias.ui.main;

import android.text.TextUtils;


import com.encyclopedias.data.DataManager;
import com.encyclopedias.data.model.EventBus;
import com.encyclopedias.ui.base.BasePresenter;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;

public class RootPresenter extends BasePresenter<RootMvpView> {

    private final DataManager mDataManager;
    private final EventBus mBus;
    private Subscription mSubscription;

    @Inject
    public RootPresenter(DataManager dataManager, EventBus bus) {
        mDataManager = dataManager;
        mBus = bus;
    }

    @Override
    public void attachView(RootMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mSubscription != null) mSubscription.unsubscribe();
    }

//    public void reloadUnreadMessageCount() {
//        checkViewAttached();
//        mSubscription = mDataManager.reloadUnreadMessageCount()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Subscriber<UnreadMessageCount>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        // Timber.e(e.getMessage());
//                        mDataManager.getPreferencesHelper().putInteger(ConstantPool.PREF_UNREAD_MESSAGE_COUNT, 0);
//                    }
//
//                    @Override
//                    public void onNext(UnreadMessageCount unreadMessageCount) {
//                        Timber.e("获取未读消息数目成功，数量为：" + unreadMessageCount.getUnread_count());
//                        mDataManager.getPreferencesHelper().putInteger(ConstantPool.PREF_UNREAD_MESSAGE_COUNT, unreadMessageCount.getUnread_count());
//                        mBus.post(unreadMessageCount);
//                    }
//                });
//    }
//
//
//    public boolean isRereshTokenExpired(String refreshToken) {
//        String savedRefreshToken = mDataManager.getPreferencesHelper().getString(ConstantPool.PREF_REFRESH_TOKEN);
//        return refreshToken != null && savedRefreshToken != null && !refreshToken.equals(MDUtil.getMD5(savedRefreshToken));
//    }
//
//
//    public boolean hasAccessTokenExpired() {
//        String token = mDataManager.getPreferencesHelper().getString(ConstantPool.PREF_ACCESS_TOKEN);
//        return !TextUtils.isEmpty(token);
//    }
//
//    public void logout() {
//        mDataManager.getPreferencesHelper().removeByKey(ConstantPool.PREF_ACCESS_TOKEN);
//        mDataManager.getPreferencesHelper().removeByKey(ConstantPool.PREF_REFRESH_TOKEN);
//        mDataManager.getPreferencesHelper().removeByKey(ConstantPool.PREF_USER_ID);
//        mDataManager.getPreferencesHelper().removeByKey(ConstantPool.PREF_USER_NICKNAME);
//        mDataManager.getPreferencesHelper().removeByKey(ConstantPool.PREF_USER_MOBILE);
//        mDataManager.getPreferencesHelper().removeByKey(ConstantPool.PREF_USER_AVATAR);
//        mDataManager.getPreferencesHelper().removeByKey(ConstantPool.PREF_UNREAD_MESSAGE_COUNT);    // TODO 处理其他要删除的数据
//        mBus.post(new UnreadMessageCount());
//        mBus.post(new SessionUser());//清除“我的”界面 头像以及昵称/手机号
//        mBus.post(new EventLoginOut());//清空贴吧缓存，重新加载
//    }
//
//    public void reloadRefreshToken() {
//        checkViewAttached();
//        mSubscription = mDataManager.reloadRefreshToken()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Subscriber<SessionToken>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        // Timber.e(e.getMessage(), "刷新TOKEN失败，需要重新登录");
//                        logout();
//                        getMvpView().tokenFailedToRefresh();
//                    }
//
//                    @Override
//                    public void onNext(SessionToken sessionToken) {
//                        mDataManager.getPreferencesHelper().putString(ConstantPool.PREF_ACCESS_TOKEN, sessionToken.getAccess_token());
//                        mDataManager.getPreferencesHelper().putString(ConstantPool.PREF_REFRESH_TOKEN, sessionToken.getRefresh_token());
//                    }
//                });
//    }
}
