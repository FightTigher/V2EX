package com.ecovacs.v2ex.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableList;
import android.util.Log;

import com.ecovacs.baselibrary.base.rx.SchedulerProvider;
import com.ecovacs.data.BaseViewModel;
import com.ecovacs.data.DataManager;
import com.ecovacs.data.bean.TopicStartInfo;
import com.ecovacs.v2ex.navigator.TopicsNavigator;

import java.util.List;

import io.reactivex.functions.Consumer;
import me.ghui.fruit.Fruit;

/**
 * Created by liang.liu on 2018/3/15.
 */

public class TopicsViewModel extends BaseViewModel<TopicsNavigator> {

    private ObservableList<TopicStartInfo.Item> topicObservableArrayList = new ObservableArrayList<>();

    private ObservableBoolean isLoading = new ObservableBoolean(false);

    private MutableLiveData<List<TopicStartInfo.Item>> topicListLiveData;

    public TopicsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        topicListLiveData = new MutableLiveData<>();
        Log.e("TopicsViewModel", "TopicsViewModel : create");
        fetchTopics();
    }

    public void addTopicItemsToList(List<TopicStartInfo.Item> topics) {
        topicObservableArrayList.clear();
        topicObservableArrayList.addAll(topics);
    }

    public void fetchTopics() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getTopicsByNode("all")
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String data) throws Exception {
                        TopicStartInfo topicStartInfo = new Fruit().fromHtml(data, TopicStartInfo.class);
                        List<TopicStartInfo.Item> list = topicStartInfo.getItems();
                        if (list != null) {
                            topicListLiveData.setValue(list);
                        } else {
                            if (topicListLiveData.getValue() == null) {
                                getNavigator().showEmpty();
                            }
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

    public void loadMoreTopics() {
        setIsLoading(true);
    }

    public ObservableList<TopicStartInfo.Item> getTopicObservableArrayList() {
        return topicObservableArrayList;
    }

    public MutableLiveData<List<TopicStartInfo.Item>> getTopicListLiveData() {
        return topicListLiveData;
    }

    public ObservableBoolean getIsLoading() {
        return isLoading;
    }

    public void setIsLoading(boolean isLoading) {
        this.isLoading.set(isLoading);
    }
}
