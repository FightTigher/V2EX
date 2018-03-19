package com.ecovacs.v2ex.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.util.Log;

import com.ecovacs.baselibrary.base.BaseViewModel;
import com.ecovacs.baselibrary.base.rx.SchedulerProvider;
import com.ecovacs.baselibrary.data.DataManager;
import com.ecovacs.baselibrary.entry.TopicBean;
import com.ecovacs.v2ex.navigator.TopicNavigator;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by liang.liu on 2018/3/15.
 */

public class TopicsViewModel extends BaseViewModel<TopicNavigator> {

    private ObservableList<TopicBean> topicObservableArrayList = new ObservableArrayList<>();

    private MutableLiveData<List<TopicBean>> topicListLiveData;

    public TopicsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        topicListLiveData = new MutableLiveData<>();
        Log.e("TopicsViewModel","TopicsViewModel : create");
        fetchTopics();
    }

    public void addTopicItemsToList(List<TopicBean> topics) {
        topicObservableArrayList.clear();
        topicObservableArrayList.addAll(topics);
    }

    public void fetchTopics() {
        Log.e("TopicsViewModel","fetchTopics");
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getLatestTopics()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<List<TopicBean>>() {
                    @Override
                    public void accept(List<TopicBean> list) throws Exception {
                        if (list != null) {
                            topicListLiveData.setValue(list);
                        }
                        setIsLoading(false);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        setIsLoading(false);
                        getNavigator().handleError(throwable);
                    }
                }));
    }

    public ObservableList<TopicBean> getTopicObservableArrayList() {
        return topicObservableArrayList;
    }

    public MutableLiveData<List<TopicBean>> getTopicListLiveData() {
        return topicListLiveData;
    }
}
