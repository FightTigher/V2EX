package com.ecovacs.v2ex.viewmodel;

import android.databinding.ObservableField;

import com.ecovacs.data.bean.TopicStartInfo;


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

    private TopicStartInfo.Item mTopic;

    public TopicItemViewModel(TopicItemViewModelListener listener, TopicStartInfo.Item topic) {
        mListener = listener;
        mTopic = topic;

        imageUrl = new ObservableField<>(mTopic.getAvatar());
        author = new ObservableField<>(mTopic.getUserName());
        date = new ObservableField<>(mTopic.getTime());
        comment = new ObservableField<>("评论" + mTopic.getCommentNum());
        typeTitle = new ObservableField<>(mTopic.getTag());
        title = new ObservableField<>(mTopic.getTitle());
    }

    public void onItemClick() {
        mListener.onItemClick(0);
    }

    public interface TopicItemViewModelListener {
        void onItemClick(int topicId);
    }
}
