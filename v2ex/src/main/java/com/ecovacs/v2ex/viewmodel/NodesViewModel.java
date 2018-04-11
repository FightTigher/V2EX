package com.ecovacs.v2ex.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import com.ecovacs.baselibrary.base.BaseViewModel;
import com.ecovacs.baselibrary.base.rx.SchedulerProvider;
import com.ecovacs.baselibrary.data.DataManager;
import com.ecovacs.baselibrary.data.http.bean.TopicStartInfo;
import com.ecovacs.v2ex.navigator.NodesNavigator;

import java.util.List;

/**
 * Created by liang.liu on 2018/4/11.
 */

public class NodesViewModel extends BaseViewModel<NodesNavigator>{

    private ObservableList<TopicStartInfo.Item> nodesObservableArrayList = new ObservableArrayList<>();

    private MutableLiveData<List<TopicStartInfo.Item>> nodesLiveData;

    public NodesViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        nodesLiveData = new MutableLiveData<>();
    }


    public ObservableList<TopicStartInfo.Item> getNodesObservableArrayList() {
        return nodesObservableArrayList;
    }

    public MutableLiveData<List<TopicStartInfo.Item>> getNodesLiveData() {
        return nodesLiveData;
    }

}
