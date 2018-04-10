package com.ecovacs.v2ex.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableList;
import android.util.Log;

import com.ecovacs.baselibrary.base.BaseViewModel;
import com.ecovacs.baselibrary.base.rx.SchedulerProvider;
import com.ecovacs.baselibrary.data.DataManager;
import com.ecovacs.baselibrary.data.http.bean.TopicInfo;
import com.ecovacs.baselibrary.data.http.bean.TopicStartInfo;
import com.ecovacs.baselibrary.entry.TopicBean;
import com.ecovacs.v2ex.navigator.TopicNavigator;
import com.google.gson.JsonElement;

import java.util.List;

import io.reactivex.functions.Consumer;
import me.ghui.fruit.Fruit;

/**
 * Created by liang.liu on 2018/3/15.
 */

public class TopicsViewModel extends BaseViewModel<TopicNavigator> {

    private ObservableList<TopicStartInfo.Item> topicObservableArrayList = new ObservableArrayList<>();

    private ObservableBoolean mIsLoading = new ObservableBoolean(false);

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
        Log.e("TopicsViewModel", "fetchTopics");
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getTopicsByNode("all")
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        TopicStartInfo topicStartInfo = new Fruit().fromHtml(s, TopicStartInfo.class);
                        Log.e("ssss", topicStartInfo.getTotal() + "");
                        List<TopicStartInfo.Item> list = topicStartInfo.getItems();
                        if (list != null) {
                            topicListLiveData.setValue(list);
                        }
                        setIsLoading(false);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("topics", throwable.getMessage());
                    }
                }));
//                .subscribe(new Consumer<List<TopicBean>>() {
//                    @Override
//                    public void accept(List<TopicBean> list) throws Exception {
//                        if (list != null) {
//                            topicListLiveData.setValue(list);
//                        }
//                        setIsLoading(false);
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        setIsLoading(false);
//                        getNavigator().handleError(throwable);
//                    }
//                }));
    }

    public ObservableList<TopicStartInfo.Item> getTopicObservableArrayList() {
        return topicObservableArrayList;
    }

    public MutableLiveData<List<TopicStartInfo.Item>> getTopicListLiveData() {
        return topicListLiveData;
    }

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }
}
