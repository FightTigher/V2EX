package com.ecovacs.v2ex.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.util.Log;

import com.ecovacs.baselibrary.base.rx.SchedulerProvider;
import com.ecovacs.data.BaseViewModel;
import com.ecovacs.data.DataManager;
import com.ecovacs.data.bean.NodesInfo;
import com.ecovacs.data.bean.TopicStartInfo;
import com.ecovacs.v2ex.navigator.NodesNavigator;
import com.google.gson.Gson;

import java.util.List;

import io.reactivex.functions.Consumer;
import me.ghui.fruit.Fruit;

/**
 * Created by liang.liu on 2018/4/11.
 */

public class NodesViewModel extends BaseViewModel<NodesNavigator> {

    private ObservableList<TopicStartInfo.Item> nodesObservableArrayList = new ObservableArrayList<>();

    private MutableLiveData<List<TopicStartInfo.Item>> nodesLiveData;

    public NodesViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        nodesLiveData = new MutableLiveData<>();
    }

    public void fetchNodes() {

        getCompositeDisposable().add(getDataManager().getNodes()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String data) throws Exception {
                        NodesInfo nodesInfo = new Fruit().fromHtml(data, NodesInfo.class);
                        Log.e("tag", new Gson().toJson(nodesInfo));

                    }
                }));
    }


    public ObservableList<TopicStartInfo.Item> getNodesObservableArrayList() {
        return nodesObservableArrayList;
    }

    public MutableLiveData<List<TopicStartInfo.Item>> getNodesLiveData() {
        return nodesLiveData;
    }

}
