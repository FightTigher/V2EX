package com.ecovacs.v2ex.util;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.ecovacs.data.bean.NodesInfo;
import com.ecovacs.v2ex.adapter.ItemNodeAdapter;
import com.ecovacs.v2ex.adapter.NodesAdapter;

import java.util.List;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

/**
 * Created by liang.liu on 2018/4/12.
 */

public class BindingUtils {


    @BindingAdapter({"nodes"})
    public static void showNodesData(RecyclerView recyclerView, List<NodesInfo.Item> nodes) {
        ScaleInAnimationAdapter scaleInAnimationAdapter = (ScaleInAnimationAdapter) recyclerView.getAdapter();
        if (scaleInAnimationAdapter != null) {
            AlphaInAnimationAdapter alphaInAnimationAdapter = (AlphaInAnimationAdapter) scaleInAnimationAdapter.getWrappedAdapter();
            if (alphaInAnimationAdapter != null) {
                NodesAdapter topicAdapter = (NodesAdapter) alphaInAnimationAdapter.getWrappedAdapter();
                if (topicAdapter != null) {
                    topicAdapter.clearItems();
                    topicAdapter.addItems(nodes);
                }
            }
        }
    }

    @BindingAdapter({"item_nodes"})
    public static void showItemNodesData(RecyclerView recyclerView, List<NodesInfo.Item.NodeItem> nodeItems) {
        ItemNodeAdapter adapter = (ItemNodeAdapter) recyclerView.getAdapter();

        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(nodeItems);
        }
    }
}
