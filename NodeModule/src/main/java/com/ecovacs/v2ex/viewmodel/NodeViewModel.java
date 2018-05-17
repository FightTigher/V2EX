package com.ecovacs.v2ex.viewmodel;

import android.databinding.ObservableField;

import com.ecovacs.data.bean.NodesInfo;

public class NodeViewModel {

    public ObservableField<String> name;
    public ObservableField<String> link;

    public NodeViewModel(NodesInfo.Item.NodeItem nodeItem) {
        this.name = new ObservableField<>(nodeItem.getName());
        this.link = new ObservableField<>(nodeItem.getLink());

    }


}
