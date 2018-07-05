package com.ecovacs.v2ex.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ecovacs.baselibrary.base.BaseViewHolder;
import com.ecovacs.data.bean.NodesInfo;
import com.ecovacs.v2ex.R;
import com.ecovacs.v2ex.databinding.ItemNodenavViewBinding;
import com.ecovacs.v2ex.viewmodel.NavItemViewModel;

import java.util.List;

/**
 * Created by liang.liu on 2018/4/11.
 */

public class NodesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NodesInfo.Item> nodes;

    public NodesAdapter(List<NodesInfo.Item> nodes) {
        this.nodes = nodes;
    }

    public void clearItems() {
        nodes.clear();
    }

    public void addItems(List<NodesInfo.Item> nodes) {
        this.nodes.addAll(nodes);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ItemNodenavViewBinding itemNodenavViewBinding = ItemNodenavViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new NodeViewHolder(itemNodenavViewBinding, parent.getContext());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((NodeViewHolder) holder).onBind(position);
    }


    private class NodeViewHolder extends BaseViewHolder {

        private final Context context;
        private ItemNodenavViewBinding mBinding;
        private NavItemViewModel viewModel;
        private boolean hasAdd = false;

        public NodeViewHolder(ItemNodenavViewBinding binding, Context context) {
            super(binding.getRoot());
            this.mBinding = binding;
            this.context = context;
        }

        @Override
        public void onBind(int position) {
            NodesInfo.Item item = nodes.get(position);
            viewModel = new NavItemViewModel(item);
            mBinding.setViewModel(viewModel);
            mBinding.fblNodes.removeAllViews();
            for (NodesInfo.Item.NodeItem nodeItem : item.getNodes()) {
                TextView nodeName = (TextView) LayoutInflater.from(context).inflate(R.layout.item_node_view_cp, null);
                nodeName.setText(nodeItem.getName());
                mBinding.fblNodes.addView(nodeName);
            }
            mBinding.executePendingBindings();
        }
    }

    @Override
    public int getItemCount() {
        if (nodes != null && nodes.size() > 0) {
            return nodes.size();
        }
        return 0;
    }

}
