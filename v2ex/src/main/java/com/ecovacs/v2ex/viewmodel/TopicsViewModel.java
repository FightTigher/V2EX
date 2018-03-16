package com.ecovacs.v2ex.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import com.ecovacs.baselibrary.base.BaseViewModel;
import com.ecovacs.baselibrary.base.rx.SchedulerProvider;
import com.ecovacs.baselibrary.data.DataManager;
import com.ecovacs.baselibrary.entry.TopicBean;
import com.ecovacs.v2ex.navigator.TopicNavigator;

import java.util.List;


/**
 * Created by liang.liu on 2018/3/15.
 */

public class TopicsViewModel extends BaseViewModel<TopicNavigator> {

    private ObservableList<TopicBean> topicObservableArrayList = new ObservableArrayList<>();

    private MutableLiveData<List<TopicBean>> topicListLiveData;

    public TopicsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        topicListLiveData = new MutableLiveData<>();
        fetchTopics();
    }

    public void addTopicItemsToList(List<TopicBean> topics) {
        topicObservableArrayList.clear();
        topicObservableArrayList.addAll(topics);
    }

    public void fetchTopics() {
        setIsLoading(true);

    }

    public ObservableList<TopicBean> getTopicObservableArrayList() {
        return topicObservableArrayList;
    }

    public MutableLiveData<List<TopicBean>> getTopicListLiveData() {
        return topicListLiveData;
    }

    public void setTopicObservableArrayList(ObservableList<TopicBean> topicObservableArrayList) {
        this.topicObservableArrayList = topicObservableArrayList;
    }

    public void setTopicListLiveData(MutableLiveData<List<TopicBean>> topicListLiveData) {
        this.topicListLiveData = topicListLiveData;
    }
}
