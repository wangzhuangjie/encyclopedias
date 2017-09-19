package com.encyclopedias.ui.cost;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.encyclopedias.R;
import com.encyclopedias.ui.base.BaseActivity;
import com.encyclopedias.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by zhuangjie on 2016/8/2.
 */
public class CostFlowActivity extends BaseActivity {
    @Bind(R.id.tabl_cost)
    TabLayout tlCost;
    @Bind(R.id.cost_vp)
    ViewPager costViewPage;

    private FragmentManager mFragmentManager;
    private List<BaseFragment> fragmentList;
    private List<String> listTitle;
    @Override
    protected void injectContext() {

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_cost_flow;
    }

    @Override
    protected void initVariables(Bundle savedInstanceState) {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mFragmentManager = this.getSupportFragmentManager();
        listTitle = new ArrayList<>();
        listTitle.add("全部流水");
        listTitle.add("问诊流水");
        listTitle.add("直播流水");
        listTitle.add("随访流水");
        listTitle.add("会诊流水");
        tlCost.setSmoothScrollingEnabled(true);


        fragmentList = new ArrayList<BaseFragment>();
        fragmentList.add(new AllCostFragment());
        fragmentList.add(new ConsultationCostFragment());
        fragmentList.add(new FollowUpCostFragment());
        fragmentList.add(new InquiryCostFragment());
        fragmentList.add(new TelecastCostFragment());
        CostFragmentAdapter costAdapter = new CostFragmentAdapter(mFragmentManager, fragmentList,listTitle);
        costViewPage.setAdapter(costAdapter);
        tlCost.setupWithViewPager(costViewPage);
        setCuttingLine();
        costViewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    private void setCuttingLine(){
        for (int i = 0; i < tlCost.getTabCount(); i++) {
            TabLayout.Tab tab = tlCost.getTabAt(i);
            RelativeLayout relativeLayout = (RelativeLayout)
                    LayoutInflater.from(mContext).inflate(R.layout.livehomepage_tablayout_title, tlCost, false);
            View cuttingline=(View) relativeLayout.findViewById(R.id.cuttingline);
            TextView tabTextView = (TextView) relativeLayout.findViewById(R.id.tab_title);
            if(i==0){
                cuttingline.setVisibility(View.GONE);
            }else{
                cuttingline.setVisibility(View.VISIBLE);
            }
            tabTextView.setText(tab.getText());
            tab.setCustomView(relativeLayout);
//        tab.select();
        }
    }

    @Override
    protected void handleUIEvent() {

    }
}
