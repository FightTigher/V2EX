package com.ecovacs.v2ex.viewmodel;

import android.databinding.ObservableField;

import com.ecovacs.baselibrary.entry.TopicBean;

/**
 * Created by liang.liu on 2018/3/15.
 */

public class TopicItemViewModel {

    public ObservableField<String> author;

    public ObservableField<String> title;

    public ObservableField<String> date;

    public ObservableField<String> comment;

    public ObservableField<String> type;

    public ObservableField<String> imageUrl;

    public TopicItemViewModelListener mListener;

    private TopicBean mTopic;

    public TopicItemViewModel(TopicItemViewModelListener listener, TopicBean topic) {
        mListener = listener;
        mTopic = topic;

        imageUrl = new ObservableField<>(mTopic.getMember().getAvatar_mini());
        author = new ObservableField<>(mTopic.getMember().getUsername());
        date = new ObservableField<>(mTopic.getContent_rendered());
        comment = new ObservableField<>(mTopic.getTitle());
        type = new ObservableField<>(mTopic.getNode().getName());
        title = new ObservableField<>(mTopic.getTitle());
    }

    public void onItemClick() {
        mListener.onItemClick(mTopic.getId());
    }

    public interface TopicItemViewModelListener {
        void onItemClick(int topicId);
    }
}
