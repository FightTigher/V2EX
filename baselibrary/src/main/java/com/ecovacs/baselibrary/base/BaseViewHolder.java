package com.ecovacs.baselibrary.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by liang.liu on 2018/3/14.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder{
    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBind(int position);
}
