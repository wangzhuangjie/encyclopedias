package com.encyclopedias.ui.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.encyclopedias.R;

import butterknife.ButterKnife;

/**
 * Created by Frank on 2015/12/15.
 */
public abstract class BaseFragment extends Fragment {

    protected Context mContext;

    protected abstract void injectContext();

    protected abstract int getLayoutResource();

    protected abstract void initVariables(Bundle savedInstanceState);

    protected abstract void initData(Bundle savedInstanceState);

    protected abstract void handleUIEvent();

    protected TextView mUILabelSwipeContent;
    protected ProgressBar mUISwipeProgress;
    protected ImageView mUIImageSwipeIndicator;
    protected Boolean mLastState = null;
    private Boolean mLastLoadState = null;
    protected ProgressBar mUILoadingProgress;
    protected ImageView mUIImageLoadingIndicator;
    protected TextView mUILabelLoadingContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        injectContext();
        View rootView = inflater.inflate(getLayoutResource(), container, false);
        ButterKnife.bind(this, rootView);
        initVariables(savedInstanceState);
        initData(savedInstanceState);
        handleUIEvent();
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    /**
     * Start Activity with Bundle
     *
     * @param clazz
     * @param bundle
     */
    protected void startActivity(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clazz);
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

    @Override
    public void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }

    public String getFragmentName() {
        String contextString = this.toString();
        try {
            return contextString.substring(0, contextString.indexOf("{"));
        } catch (Exception e) {
            return contextString;
        }
    }

}
