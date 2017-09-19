package com.encyclopedias.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;

import com.encyclopedias.R;
import com.encyclopedias.data.DataManager;
import com.encyclopedias.data.model.EventBus;
import com.encyclopedias.ui.base.BaseActivity;
import com.encyclopedias.ui.setting.SettingFragment;
import com.encyclopedias.util.AlertUtil;
import com.jakewharton.rxbinding.support.v4.view.RxViewPager;

import java.util.Set;

import javax.inject.Inject;

import butterknife.Bind;
import timber.log.Timber;

public class MainActivity extends BaseActivity implements RootMvpView {
    @Inject
    RootPresenter mRootPresenter;
    @Inject
    EventBus mBus;
    @Inject
    DataManager mDataManager;

    @Bind(R.id.vp_content)
    ViewPager mUIPagerContent;
    @Bind(R.id.tabl_navigation)
    TabLayout mUITabNavigation;

    private String[] mTabTitles;
    private Integer[] mTabIcons;
    private Fragment[] mFragments;
    private FragmentPageAdapter mContentPagerAdapter;

    private static final int MSG_SET_ALIAS = 1001;


    @Override
    protected void injectContext() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void initVariables(Bundle savedInstanceState) {
        mTabTitles = new String[]{getString(R.string.homepage), getString(R.string.followup_patients), getString(R.string.medical_circle), getString(R.string.setting)};
        mTabIcons = new Integer[]{R.drawable.selector_tab_homepage, R.drawable.selector_tab_followup_patients, R.drawable.selector_tab_medical_circle, R.drawable.selector_tab_setting};
        mFragments = new Fragment[]{MainFragment.getInstance(),MainFragment.getInstance(),MainFragment.getInstance(),new SettingFragment()};
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mBus.register(this);
        mRootPresenter.attachView(this);
        setupViewPager(mUIPagerContent);
        setupTabLayout(mUITabNavigation);
    }


    @Override
    protected void handleUIEvent() {
        RxViewPager.pageSelections(mUIPagerContent).subscribe(page -> {
            mFragments[page].setUserVisibleHint(true);
        });
    }

    @Override
    public void onStart() {
        super.onStart();
//        mRootPresenter.reloadUnreadMessageCount();
        if (mUIPagerContent.getCurrentItem() == 0) {    // 如果为首页，则发送通知告知刷新轮播图
//            mBus.post(new SpotlightRefreshingEvent());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRootPresenter.detachView();
        mBus.unregister(this);
    }


    private void setupTabLayout(TabLayout tabLayout) {
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(mUIPagerContent);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
//            tab.setCustomView(mContentPagerAdapter.getTabView(i));
        }
        tabLayout.requestFocus();
    }

    private void setupViewPager(ViewPager viewPager) {
        mContentPagerAdapter = new FragmentPageAdapter(mContext, getSupportFragmentManager(), mFragments, mTabTitles, mTabIcons);
        viewPager.setAdapter(mContentPagerAdapter);
        viewPager.setOffscreenPageLimit(3);
    }


    @Override
    public void showError() {

    }

    @Override
    public void finishLoading() {

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                AlertUtil.toast(this,R.string.finish_app);
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
