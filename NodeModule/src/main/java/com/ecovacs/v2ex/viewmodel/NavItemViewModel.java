package com.ecovacs.v2ex.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;

import com.ecovacs.data.bean.NodesInfo;

import java.util.List;

public class NavItemViewModel {

    public ObservableField<String> category;

    public ObservableList<NodesInfo.Item.NodeItem> nodeArrayList;

    public NavItemViewModel(NodesInfo.Item item) {

        this.category = new ObservableField<>(item.getCategory());
        this.nodeArrayList = new ObservableArrayList<>();
        nodeArrayList.clear();
        nodeArrayList.addAll(item.getNodes());


    }

}
