package com.ecovacs.v2ex.utils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.ecovacs.baselibrary.entry.TopicBean;
import com.ecovacs.v2ex.adapter.TopicAdapter;

import java.util.List;

/**
 * Created by liang.liu on 2018/3/16.
 */

public class BindingUtils {

    @BindingAdapter({"adapter"})
    public static void addTopicItems(RecyclerView recyclerView, List<TopicBean> topics) {
        TopicAdapter adapter = (TopicAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(topics);
        }
    }

}
