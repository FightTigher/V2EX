package com.ecovacs.v2ex.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ecovacs.baselibrary.base.BaseViewHolder;
import com.ecovacs.baselibrary.data.http.bean.TopicStartInfo;
import com.ecovacs.baselibrary.entry.TopicBean;
import com.ecovacs.baselibrary.utils.AppLogger;
import com.ecovacs.v2ex.databinding.ItemTopicEmptyViewBinding;
import com.ecovacs.v2ex.databinding.ItemTopicViewBinding;
import com.ecovacs.v2ex.viewmodel.TopicItemEmptyViewModel;
import com.ecovacs.v2ex.viewmodel.TopicItemViewModel;

import java.util.List;

/**
 * Created by liang.liu on 2018/3/15.
 */

public class TopicAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;

    public static final int VIEW_TYPE_NORMAL = 1;

    private List<TopicStartInfo.Item> mTopicList;

    private TopicAdapterListener mListener;

    public TopicAdapter(List<TopicStartInfo.Item> topicList) {
        mTopicList = topicList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                ItemTopicViewBinding topicViewBinding = ItemTopicViewBinding.inflate(
                        LayoutInflater.from(parent.getContext()), parent, false);
                return new TopicViewHolder(topicViewBinding);
            case VIEW_TYPE_EMPTY:
            default:
                ItemTopicEmptyViewBinding topicEmptyViewBinding = ItemTopicEmptyViewBinding.inflate(
                        LayoutInflater.from(parent.getContext()), parent, false);

                return new EmptyViewHolder(topicEmptyViewBinding);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TopicViewHolder) {
            ((TopicViewHolder) holder).onBind(position);
        } else {
            ((EmptyViewHolder) holder).onBind(position);
        }
    }

    public void addItems(List<TopicStartInfo.Item> list) {
        mTopicList.addAll(list);
        notifyDataSetChanged();
    }

    public void clearItems() {
        mTopicList.clear();
    }

    @Override
    public int getItemCount() {
        if (mTopicList != null && mTopicList.size() > 0)
            return mTopicList.size();
        else
            return 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (mTopicList != null && !mTopicList.isEmpty()) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    public void setListener(TopicAdapterListener listener) {
        this.mListener = listener;
    }

    public interface TopicAdapterListener {

        void onRetryClick();
    }

    public class TopicViewHolder extends BaseViewHolder implements TopicItemViewModel.TopicItemViewModelListener {

        private final ItemTopicViewBinding mBinding;
        private TopicItemViewModel mTopicItemViewModel;

        public TopicViewHolder(ItemTopicViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            TopicStartInfo.Item topicBean = mTopicList.get(position);

            mTopicItemViewModel = new TopicItemViewModel(this, topicBean);
            mBinding.setViewModel(mTopicItemViewModel);

            mBinding.executePendingBindings();
        }

        @Override
        public void onItemClick(int topicId) {
            if (topicId != 0) {
                try {
//                    Intent intent = new Intent();
//                    intent.setAction(Intent.ACTION_VIEW);
//                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
//                    itemView.getContext().startActivity(intent);
                } catch (Exception e) {
                    AppLogger.d("url error");
                }
            }
        }
    }


    public class EmptyViewHolder extends BaseViewHolder implements TopicItemEmptyViewModel.TopicItemEmptyViewModelListener {

        private final ItemTopicEmptyViewBinding binding;

        public EmptyViewHolder(ItemTopicEmptyViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onBind(int position) {
            TopicItemEmptyViewModel viewModel = new TopicItemEmptyViewModel(this);
            binding.setViewModel(viewModel);
        }

        @Override
        public void onRetryClick() {
            mListener.onRetryClick();
        }
    }

}
