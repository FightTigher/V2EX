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

    public ObservableField<String> typeTitle;

    public ObservableField<String> imageUrl;

    public TopicItemViewModelListener mListener;

    private TopicBean mTopic;

    public TopicItemViewModel(TopicItemViewModelListener listener, TopicBean topic) {
        mListener = listener;
        mTopic = topic;

        imageUrl = new ObservableField<>("https:" + mTopic.getMember().getAvatar_normal());
        author = new ObservableField<>(mTopic.getMember().getUsername());
        date = new ObservableField<>("时间" + mTopic.getLast_modified());
        comment = new ObservableField<>("评论" + mTopic.getReplies());
        typeTitle = new ObservableField<>(mTopic.getNode().getTitle());
        title = new ObservableField<>(mTopic.getTitle());
    }

    public void onItemClick() {
        mListener.onItemClick(mTopic.getId());
    }

    public interface TopicItemViewModelListener {
        void onItemClick(int topicId);
    }
}
