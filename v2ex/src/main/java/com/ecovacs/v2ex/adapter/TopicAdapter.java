package com.ecovacs.v2ex.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.ecovacs.baselibrary.base.BaseViewHolder;
import com.ecovacs.baselibrary.entry.TopicBean;

import java.util.List;

/**
 * Created by liang.liu on 2018/3/15.
 */

public class TopicAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;

    public static final int VIEW_TYPE_NORMAL = 1;

    private List<TopicBean> mTopicList;

    public TopicAdapter(List<TopicBean> topicList) {
        mTopicList = topicList;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:

                break;
            case VIEW_TYPE_EMPTY:
            default:
                break;
        }


        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if (mTopicList != null && mTopicList.size() > 0)
            return mTopicList.size();
        else
            return 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (mTopicList != null && !mTopicList.isEmpty()) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }


    public class TopicViewHolder extends BaseViewHolder{

        public TopicViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void onBind(int position) {

        }
    }

}
