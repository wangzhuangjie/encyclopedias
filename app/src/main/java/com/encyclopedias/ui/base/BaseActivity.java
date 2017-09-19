package com.encyclopedias.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.encyclopedias.FEApplication;
import com.encyclopedias.R;
import com.encyclopedias.injection.component.ActivityComponent;
import com.encyclopedias.injection.component.DaggerActivityComponent;
import com.encyclopedias.injection.module.ActivityModule;
import com.encyclopedias.ui.widget.dialog.FEProgressDialog;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    private ActivityComponent mActivityComponent;
    protected Context mContext;
    protected TextView mUILabelSwipeContent;
    protected ProgressBar mUISwipeProgress;
    protected ImageView mUIImageSwipeIndicator;
    protected Boolean mLastState = null;
    private Boolean mLastLoadState = null;
    protected ProgressBar mUILoadingProgress;
    protected ImageView mUIImageLoadingIndicator;
    protected TextView mUILabelLoadingContent;
    private FEProgressDialog mUIDialogProgress;

    protected abstract void injectContext();

    protected abstract int getLayoutResource();

    protected abstract void initVariables(Bundle savedInstanceState);

    protected abstract void initData(Bundle savedInstanceState);

    protected abstract void handleUIEvent();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectContext();
        setContentView(getLayoutResource());
        ButterKnife.bind(this);
        mContext = getApplicationContext();
        initVariables(savedInstanceState);
        initData(savedInstanceState);
        handleUIEvent();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public ActivityComponent getActivityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(FEApplication.get(this).getComponent())
                    .build();
        }
        return mActivityComponent;
    }

    /**
     * Start Activity with Bundle
     *
     * @param clazz
     * @param bundle
     */
    protected void startActivity(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(mContext, clazz);
        if (bundle != null)
            intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * Start Activity without Bundle
     *
     * @param clazz
     */
    protected void startActivity(Class<?> clazz) {
        startActivity(clazz, null);
    }

    protected View enquipSwipeFooterView() {
        View footerView = LayoutInflater.from(mContext)
                .inflate(R.layout.partial_swipe_refresh_footer, null);
        mUILoadingProgress = (ProgressBar) footerView
                .findViewById(R.id.pb_loading_progress);
        mUIImageLoadingIndicator = (ImageView) footerView
                .findViewById(R.id.iv_loading_ind);
        mUILabelLoadingContent = (TextView) footerView
                .findViewById(R.id.tv_footer_content);
        mUILoadingProgress.setVisibility(View.GONE);
        mUIImageLoadingIndicator.setVisibility(View.VISIBLE);
        mUIImageLoadingIndicator.setImageResource(R.mipmap.ic_pull_up);
        mUILabelLoadingContent.setText(R.string.pull_down_to_load_more);
        return footerView;
    }

    protected View enquipSwipeHeaderView() {
        View headerView = LayoutInflater.from(mContext)
                .inflate(R.layout.partial_swipe_refresh_header, null);
        mUISwipeProgress = (ProgressBar) headerView.findViewById(R.id.pb_loading_progress);
        mUILabelSwipeContent = (TextView) headerView.findViewById(R.id.tv_content);
        mUILabelSwipeContent.setText(R.string.pull_up_to_refresh);
        mUIImageSwipeIndicator = (ImageView) headerView.findViewById(R.id.iv_swipe_ind);
        mUIImageSwipeIndicator.setVisibility(View.VISIBLE);
        mUIImageSwipeIndicator.setImageResource(R.mipmap.ic_pull_down);
        mUISwipeProgress.setVisibility(View.GONE);
        return headerView;
    }

    protected void performRefreshing() {
        mUILabelSwipeContent.setText(R.string.loading);
        mUIImageSwipeIndicator.setVisibility(View.GONE);
        mUISwipeProgress.setVisibility(View.VISIBLE);
    }

    protected void performLoading() {
        mUILabelLoadingContent.setText(R.string.loading);
        mUIImageLoadingIndicator.setVisibility(View.GONE);
        mUILoadingProgress.setVisibility(View.VISIBLE);
    }

    protected void resetRefreshState(boolean enable) {
        if (mLastState != null && mLastState == enable)
            return;
        mLastState = enable;
        mUILabelSwipeContent.setText(enable ? getString(R.string.release_to_refresh) : getString(R.string.pull_up_to_refresh));
        mUIImageSwipeIndicator.setVisibility(View.VISIBLE);
        mUIImageSwipeIndicator.animate().rotation(enable ? 180 : 0);
    }

    protected void resetLoadState(boolean enable) {
        if (mLastLoadState != null && mLastLoadState == enable)
            return;
        mLastLoadState = enable;
        mUILabelLoadingContent.setText(enable ? getString(R.string.release_to_load_more) : getString(R.string.pull_down_to_load_more));
        mUIImageLoadingIndicator.setVisibility(View.VISIBLE);
        mUIImageLoadingIndicator.animate().rotation(enable ? 180 : 0);
    }

    public void showProgress() {
        mUIDialogProgress = FEProgressDialog.show(this);
    }

    public void dismissProgress() {
        if (mUIDialogProgress != null && mUIDialogProgress.isShowing())
            mUIDialogProgress.dismiss();
    }

    /**
     * 隐藏软键盘
     * hideSoftInputView
     *
     * @param
     * @return void
     * @throws
     * @Title: hideSoftInputView
     */
    public void hideSoftInputView() {
        InputMethodManager manager = ((InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE));
        if (getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
            if (getCurrentFocus() != null)
                manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public String getActivityName() {
        String contextString = this.toString();
        try {
            return contextString.substring(contextString.lastIndexOf(".") + 1, contextString.indexOf("@"));
        } catch (Exception e) {
            return contextString;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
