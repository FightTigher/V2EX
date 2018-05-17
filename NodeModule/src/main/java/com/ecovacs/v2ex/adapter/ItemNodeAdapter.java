package com.ecovacs.v2ex.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ecovacs.baselibrary.base.BaseViewHolder;
import com.ecovacs.data.bean.NodesInfo;
import com.ecovacs.v2ex.databinding.ItemNodenavViewBinding;

import java.util.List;

public class ItemNodeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NodesInfo.Item.NodeItem> nodeItems;

    public ItemNodeAdapter(List<NodesInfo.Item.NodeItem> nodeItems) {
        this.nodeItems = nodeItems;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ItemNodeViewHolder) holder).onBind(position);
    }

    @Override
    public int getItemCount() {
        if (nodeItems != null && nodeItems.size() > 0)
            return nodeItems.size();
        else
            return 0;
    }

    public void clearItems() {
        this.nodeItems.clear();
    }

    public void addItems(List<NodesInfo.Item.NodeItem> nodeItems) {
        this.nodeItems.addAll(nodeItems);
        notifyDataSetChanged();
    }

    public class ItemNodeViewHolder extends BaseViewHolder {

        public ItemNodeViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void onBind(int position) {

        }
    }

}
