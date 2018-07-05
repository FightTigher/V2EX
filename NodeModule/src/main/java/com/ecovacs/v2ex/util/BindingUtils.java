package com.ecovacs.v2ex.util;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ecovacs.data.bean.NodesInfo;
import com.ecovacs.v2ex.adapter.NodesAdapter;
import com.google.android.flexbox.FlexboxLayout;

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
    public static void showItemNodesData(FlexboxLayout flexboxLayout, List<NodesInfo.Item.NodeItem> nodeItems) {

        for (NodesInfo.Item.NodeItem nodeItem : nodeItems) {
            TextView textView = new TextView(flexboxLayout.getContext());
//            textView.setBackground(getResources().getDrawable(R.drawable.label_bg_shape));
            textView.setText(nodeItem.getName());
            textView.setGravity(Gravity.CENTER);
            textView.setPadding(10, 5, 10, 5);
//            textView.setTextColor(getResources().getColor(R.color.text_color));
            flexboxLayout.addView(textView);
            //通过FlexboxLayout.LayoutParams 设置子元素支持的属性
            ViewGroup.LayoutParams params = textView.getLayoutParams();
            if (params instanceof FlexboxLayout.LayoutParams) {
                FlexboxLayout.LayoutParams layoutParams = (FlexboxLayout.LayoutParams) params;
                layoutParams.setFlexBasisPercent(0.5f);
            }
        }


    }
}
