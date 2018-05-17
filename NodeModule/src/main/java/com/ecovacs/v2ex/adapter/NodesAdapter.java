package com.ecovacs.v2ex.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ecovacs.baselibrary.base.BaseViewHolder;
import com.ecovacs.data.bean.NodesInfo;
import com.ecovacs.v2ex.databinding.ItemNodenavViewBinding;
import com.ecovacs.v2ex.viewmodel.NavItemViewModel;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

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

            ItemNodeAdapter itemNodeAdapter = new ItemNodeAdapter(item.getNodes());

            FlexboxLayoutManager mLayoutManager = new FlexboxLayoutManager(context);
            mLayoutManager.setFlexWrap(FlexWrap.WRAP);
            mLayoutManager.setFlexDirection(FlexDirection.ROW);
            mLayoutManager.setAlignItems(AlignItems.CENTER);
            mLayoutManager.setJustifyContent(JustifyContent.FLEX_START);


            mBinding.rcvItemNode.setLayoutManager(mLayoutManager);
            mBinding.rcvItemNode.setAdapter(itemNodeAdapter);

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
