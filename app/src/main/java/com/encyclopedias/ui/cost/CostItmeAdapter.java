package com.encyclopedias.ui.cost;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.encyclopedias.R;

import butterknife.ButterKnife;

/**
 * Created by zhuangjie on 2016/8/15.
 */
public class CostItmeAdapter extends RecyclerView.Adapter<CostItmeAdapter.CostItmeViewHodler> {

    @Override
    public CostItmeViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_cost, parent, false);
        return new CostItmeViewHodler(itemView);
    }

    @Override
    public void onBindViewHolder(CostItmeViewHodler holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    class CostItmeViewHodler extends RecyclerView.ViewHolder {


        public CostItmeViewHodler(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
