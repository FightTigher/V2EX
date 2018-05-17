package com.ecovacs.v2ex.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableList;
import android.util.Log;

import com.ecovacs.baselibrary.base.rx.SchedulerProvider;
import com.ecovacs.data.BaseViewModel;
import com.ecovacs.data.DataManager;
import com.ecovacs.data.bean.NodesInfo;
import com.ecovacs.v2ex.navigator.NodesNavigator;
import com.google.gson.Gson;

import java.util.List;

import io.reactivex.functions.Consumer;
import me.ghui.fruit.Fruit;

/**
 * Created by liang.liu on 2018/4/11.
 */

public class NodesViewModel extends BaseViewModel<NodesNavigator> {

    private ObservableList<NodesInfo.Item> nodesObservableArrayList = new ObservableArrayList<>();

    private ObservableBoolean isLoading = new ObservableBoolean(false);

    private MutableLiveData<List<NodesInfo.Item>> nodesLiveData;

    public NodesViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        nodesLiveData = new MutableLiveData<>();
    }

    public void addNodeItemToList(List<NodesInfo.Item> items) {
        if (items != null && items.size() > 0) {
            nodesObservableArrayList.clear();
            nodesObservableArrayList.addAll(items);
        }
    }

    public void fetchNodes() {

        setIsLoading(true);
        getCompositeDisposable().add(getDataManager().getNodes()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String data) throws Exception {
                        setIsLoading(false);
                        NodesInfo nodesInfo = new Fruit().fromHtml(data, NodesInfo.class);
                        Log.e("tag", new Gson().toJson(nodesInfo));
                        if (nodesInfo != null) {
                            nodesLiveData.setValue(nodesInfo.getItems());
                        } else {
                            if (nodesLiveData.getValue() == null) {
                                getNavigator().showEmpty();
                            }

                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        setIsLoading(false);
                        getNavigator().handleError(throwable);
                    }
                }));
    }


    public ObservableList<NodesInfo.Item> getNodesObservableArrayList() {
        return nodesObservableArrayList;
    }

    public MutableLiveData<List<NodesInfo.Item>> getNodesLiveData() {
        return nodesLiveData;
    }

    public void setIsLoading(boolean isLoading) {
        this.isLoading.set(isLoading);
    }

    public ObservableBoolean getIsLoading() {
        return isLoading;
    }


}
