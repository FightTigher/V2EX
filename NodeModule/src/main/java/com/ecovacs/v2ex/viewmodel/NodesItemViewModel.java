package com.ecovacs.v2ex.viewmodel;

import android.databinding.ObservableField;

import com.ecovacs.data.bean.NodesInfo;

import java.util.List;

public class NodesItemViewModel {

    public ObservableField<String> category;

    public ObservableField<List<NodesInfo.Item.NodeItem>> nodeitem;

    public NodesItemViewModel(NodesInfo.Item item) {

        this.category = new ObservableField<>(item.getCategory());
        this.nodeitem = new ObservableField<>(item.getNodes());
    }
}
