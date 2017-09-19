package com.encyclopedias.ui.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.encyclopedias.R;
import com.encyclopedias.data.model.EventBus;
import com.encyclopedias.ui.base.BaseFragment;
import com.encyclopedias.ui.cost.CostFlowActivity;
import com.encyclopedias.ui.widget.infinitepager.OnPageClickListener;
import com.encyclopedias.ui.widget.infinitepager.Page;
import com.jakewharton.rxbinding.view.RxView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by Frank on 2015/12/15.
 */
public class MainFragment extends BaseFragment implements MainMvpView, OnPageClickListener {
    @Inject
    MainPresenter mMainPresenter;
    @Inject
    EventBus mBus;

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    @Bind(R.id.iamg_voice)
    ImageView imageVoice;

    @Bind(R.id.edit_text)
    EditText editText;
    @Bind(R.id.voice_text)
    TextView textVoice;
    @Bind(R.id.emotion_send)
    Button sendButton;


    private ArrayList<Page> pageViews;

    @Override
    protected void injectContext() {
        ((MainActivity) mContext).getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initVariables(Bundle savedInstanceState) {
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mMainPresenter.attachView(this);
        mBus.register(this);


    }

    @Override
    protected void handleUIEvent() {
        RxView.clicks(textVoice).subscribe(v -> {
            Intent itt = new Intent(getActivity(), CostFlowActivity.class);
            startActivity(itt);
        });
        RxView.clicks(sendButton).subscribe(v -> {
            Intent itt = new Intent(getActivity(), CostFlowActivity.class);
            startActivity(itt);
        });

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMainPresenter.detachView();
        mBus.unregister(this);
    }


    public static MainFragment getInstance() {
        MainFragment mainFragment = new MainFragment();
        return mainFragment;
    }

    @Override
    public void onPageClick(int position, Page page) {
    }
}
