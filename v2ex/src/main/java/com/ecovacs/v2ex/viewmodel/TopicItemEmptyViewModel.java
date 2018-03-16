package com.ecovacs.v2ex.viewmodel;

/**
 * Created by liang.liu on 2018/3/16.
 */

public class TopicItemEmptyViewModel {

    public TopicItemEmptyViewModelListener mListener;

    public TopicItemEmptyViewModel(TopicItemEmptyViewModelListener listener) {
        mListener = listener;
    }

    public void onRetryClick(){
        mListener.onRetryClick();
    }

    public interface TopicItemEmptyViewModelListener {

        void onRetryClick();
    }
}
