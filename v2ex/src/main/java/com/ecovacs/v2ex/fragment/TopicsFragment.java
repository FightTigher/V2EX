package com.ecovacs.v2ex.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
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
        implements TopicNavigator, TopicAdapter.TopicAdapterListener {

    @Inject
    TopicAdapter mTopicAdapter;
    FragmentTopicsBinding mFragmentTopicsBinding;
    //    @Inject
    LinearLayoutManager mLayoutManager;
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
        mTopicAdapter.setListener(this);
        Log.e("TopicFragment","onCreate");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentTopicsBinding = getViewDataBinding();
        setUp();
        mTopicsViewModel.getTopicListLiveData().observe(this, new Observer<List<TopicBean>>() {
            @Override
            public void onChanged(@Nullable List<TopicBean> list) {
                mTopicsViewModel.addTopicItemsToList(list);
            }
        });
    }

    private void setUp() {
        mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mFragmentTopicsBinding.rcvTopics.setLayoutManager(mLayoutManager);
        mFragmentTopicsBinding.rcvTopics.setItemAnimator(new DefaultItemAnimator());
        mFragmentTopicsBinding.rcvTopics.setAdapter(mTopicAdapter);
    }

    @Override
    public void handleError(Throwable throwable) {
        Log.e("TopicFragment","throwable : " + throwable.toString());
    }

    @Override
    public void updateTopic(List<TopicBean> topicList) {
        Log.e("TopicFragment","updateTopic");
        mTopicAdapter.addItems(topicList);
    }

    @Override
    public void onRetryClick() {
        Log.e("TopicFragment","onRetryClick");
        mTopicsViewModel.fetchTopics();
    }


}
