package com.ecovacs.v2ex.utils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.ecovacs.baselibrary.entry.TopicBean;
import com.ecovacs.v2ex.adapter.TopicAdapter;

import java.util.List;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;

/**
 * Created by liang.liu on 2018/3/16.
 */

public class BindingUtils {

    @BindingAdapter({"adapter"})
    public static void addTopicItems(RecyclerView recyclerView, List<TopicBean> topics) {
        ScaleInAnimationAdapter scaleInAnimationAdapter = (ScaleInAnimationAdapter) recyclerView.getAdapter();
        if (scaleInAnimationAdapter != null) {
            AlphaInAnimationAdapter alphaInAnimationAdapter = (AlphaInAnimationAdapter) scaleInAnimationAdapter.getWrappedAdapter();

            if (alphaInAnimationAdapter != null) {
                TopicAdapter topicAdapter = (TopicAdapter) alphaInAnimationAdapter.getWrappedAdapter();
                if (topicAdapter != null) {
                    topicAdapter.clearItems();
                    topicAdapter.addItems(topics);
                }
            }

        }

//        TopicAdapter topicAdapter = (TopicAdapter) recyclerView.getAdapter();
//                if (topicAdapter != null) {
//                    topicAdapter.clearItems();
//                    topicAdapter.addItems(topics);
//                }
    }

}
