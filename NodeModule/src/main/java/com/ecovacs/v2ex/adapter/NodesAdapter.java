package com.ecovacs.v2ex.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ecovacs.baselibrary.base.BaseViewHolder;
import com.ecovacs.data.bean.NodesInfo;
import com.ecovacs.v2ex.databinding.ItemNodenavViewBinding;
import com.ecovacs.v2ex.viewmodel.NodesItemViewModel;

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
        return new NodeViewHolder(itemNodenavViewBinding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((NodeViewHolder) holder).onBind(position);
    }

    private class NodeViewHolder extends BaseViewHolder {

        private final ItemNodenavViewBinding mBinding;
        private NodesItemViewModel viewModel;

        public NodeViewHolder(ItemNodenavViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            NodesInfo.Item item = nodes.get(position);
            viewModel = new NodesItemViewModel(item);
            mBinding.setViewModel(viewModel);

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
