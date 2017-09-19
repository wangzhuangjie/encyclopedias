package com.encyclopedias.ui.user.mvp;

import com.encyclopedias.ui.base.MvpView;
import com.encyclopedias.ui.user.UserEntity;

/**
 * Created by zhuangjie on 2017/2/22.
 */

public interface LoginMvp extends MvpView {
    void onSuccess(UserEntity comments);
    void onError();
}
