package com.encyclopedias.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.encyclopedias.R;
import com.encyclopedias.ui.base.BaseActivity;
import com.jakewharton.rxbinding.view.RxView;

import butterknife.Bind;

/**
 * Created by zhuangjie on 2016/8/15.
 */
public class PersonnalActivity extends BaseActivity {
    @Bind(R.id.rl_avatar)
    RelativeLayout mRLAcatar;
    @Bind(R.id.rl_name)
    RelativeLayout mRLName;

    @Bind(R.id.rl_title)
    RelativeLayout mRLtitle;

    @Bind(R.id.rl_department)
    RelativeLayout mRLDepartment;

    @Bind(R.id.rl_hospitall)
    RelativeLayout mRLhospitall;

    @Bind(R.id.rl_business_card)
    RelativeLayout mRLBusinessCard;

    @Bind(R.id.rl_good)
    RelativeLayout mRLGood;

    @Bind(R.id.rl_practice_experience)
    RelativeLayout mRLPracticeExperience;

    @Override
    protected void injectContext() {

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_personnal;
    }

    @Override
    protected void initVariables(Bundle savedInstanceState) {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void handleUIEvent() {
        RxView.clicks(mRLAcatar).subscribe(v -> {

//            Intent itt = new Intent(getActivity(), MainActivity.class);
//            startActivity(itt);
        });
        RxView.clicks(mRLBusinessCard).subscribe(v -> {
        });
        RxView.clicks(mRLGood).subscribe(v -> {

            Intent itt = new Intent(PersonnalActivity.this, GoodActivity.class);
            startActivity(itt);
        });
        RxView.clicks(mRLPracticeExperience).subscribe(v -> {

            Intent itt = new Intent(PersonnalActivity.this, GoodActivity.class);
            startActivity(itt);
        });

    }
}
