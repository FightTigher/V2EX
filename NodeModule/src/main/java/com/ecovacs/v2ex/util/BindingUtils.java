package com.ecovacs.v2ex.util;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.ecovacs.data.bean.TopicStartInfo;

import java.util.List;

/**
 * Created by liang.liu on 2018/4/12.
 */

public class BindingUtils {


    @BindingAdapter({"nodes"})
    public static void showNodesData(RecyclerView recyclerView, List<TopicStartInfo.Item> nodes) {

    }
}
