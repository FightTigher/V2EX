package com.ecovacs.v2ex.fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ecovacs.baselibrary.base.BaseFragment;
import com.ecovacs.baselibrary.entry.TopicBean;
import com.ecovacs.v2ex.BR;
import com.ecovacs.v2ex.R;
import com.ecovacs.v2ex.adapter.TopicAdapter;
import com.ecovacs.v2ex.databinding.FragmentTopicsBinding;
import com.ecovacs.v2ex.navigator.TopicNavigator;
import com.ecovacs.v2ex.viewmodel.TopicsViewModel;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by liang.liu on 2018/3/14.
 */

public class TopicsFragment extends BaseFragment<FragmentTopicsBinding, TopicsViewModel>
        implements TopicNavigator {

    @Inject
    TopicAdapter mTopicAdapter;
    FragmentTopicsBinding mFragmentTopicsBinding;

    @Inject
    ViewModelProvider.Factory mViweModelFactory;
    private TopicsViewModel mTopicsViewModel;

    public static TopicsFragment newInstance() {
        Bundle args = new Bundle();
        TopicsFragment fragment = new TopicsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public TopicsViewModel getViewModel() {
        mTopicsViewModel = ViewModelProviders.of(this, mViweModelFactory).get(TopicsViewModel.class);
        return mTopicsViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_topics;
    }

    @Override
    public int getBindingVariable() {

        return BR.viewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTopicsViewModel.setNavigator(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentTopicsBinding = getViewDataBinding();
    }

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void updateTopic(List<TopicBean> topicList) {

    }
}
