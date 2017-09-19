package com.encyclopedias.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.encyclopedias.R;
import com.encyclopedias.ui.base.BaseFragment;
import com.encyclopedias.ui.main.MainActivity;
import com.jakewharton.rxbinding.view.RxView;

import butterknife.Bind;

/**
 * Created by zhuangjie on 2016/7/29.
 */
public class SettingFragment extends BaseFragment {

    @Bind(R.id.rl_personnal)
    RelativeLayout mRLPersonnal;
    @Bind(R.id.rl_followup_price)
    RelativeLayout mRLFollowupPrice;
    @Bind(R.id.rl_remind_setting)
    RelativeLayout mRLRemind;
    @Bind(R.id.rl_about_us)
    RelativeLayout mRLAboutUs;
    @Bind(R.id.btn_logout)
    Button btnLogout;

    @Override
    protected void injectContext() {

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_setting;
    }

    @Override
    protected void initVariables(Bundle savedInstanceState) {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void handleUIEvent() {
        RxView.clicks(mRLPersonnal).subscribe(v -> {

            Intent itt = new Intent(getActivity(), MainActivity.class);
            startActivity(itt);
        });
    }
}
