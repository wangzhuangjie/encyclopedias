package com.encyclopedias.ui.user;

/**
 * Created by zhuangjie on 2017/2/22.
 */


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.encyclopedias.R;
import com.encyclopedias.ui.base.BaseActivity;
import com.encyclopedias.ui.main.MainActivity;
import com.encyclopedias.ui.user.mvp.LoginMvp;
import com.encyclopedias.ui.user.presenter.LoginPresenter;
import com.jakewharton.rxbinding.view.RxView;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by zhuangjie on 2016/7/27.
 * */
public class LoginActivity extends BaseActivity implements LoginMvp {
    @Inject
    LoginPresenter presenter;
    @Bind(R.id.et_username)
    EditText mETusername;
    @Bind(R.id.et_password)
    EditText mETpassword;
    @Bind(R.id.btn_login)
    Button mBtnLogin;


    @Override
    protected void injectContext() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }

    @Override
    protected void initVariables(Bundle savedInstanceState) {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        presenter.attachView(this);
    }

    @Override
    protected void handleUIEvent() {
        RxView.clicks(mBtnLogin).subscribe(v -> {
            String username =  mETusername.getText().toString().trim();
            String password = mETpassword.getText().toString().trim();
//            finish();
//            Intent itt = new Intent(LoginActivity.this, MainActivity.class);
//            startActivity(itt);
            presenter.getLzList(username, password);
        });
    }

    @Override
    public void onSuccess(UserEntity comments) {
        Log.e("ajdhaksjhdaksjhdkas",">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

    }

    @Override
    public void onError() {
        Log.e("ajdhaksjhdaksjhdkas","111111111111111111111111111111111111");
    }
}
