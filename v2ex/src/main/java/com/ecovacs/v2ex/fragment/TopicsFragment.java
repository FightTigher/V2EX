package com.ecovacs.v2ex.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.ecovacs.baselibrary.view.LinearLayoutColorDivider;
import com.ecovacs.data.BaseFragment;
import com.ecovacs.data.bean.TopicStartInfo;
import com.ecovacs.v2ex.BR;
import com.ecovacs.v2ex.R;
import com.ecovacs.v2ex.adapter.TopicsAdapter;
import com.ecovacs.v2ex.databinding.FragmentTopicsBinding;
import com.ecovacs.v2ex.navigator.TopicsNavigator;
import com.ecovacs.v2ex.viewmodel.TopicsViewModel;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import javax.inject.Inject;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;


/**
 * Created by liang.liu on 2018/3/14.
 */

public class TopicsFragment extends BaseFragment<FragmentTopicsBinding, TopicsViewModel>
        implements TopicsNavigator, TopicsAdapter.TopicAdapterListener {

    @Inject
    TopicsAdapter mTopicAdapter;
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
        Log.e("TopicFragment", "onCreate");
    }

    @Override
    public void fetchData() {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentTopicsBinding = getViewDataBinding();
        setUp();
        showLoading();
        mTopicsViewModel.getTopicListLiveData().observe(this, new Observer<List<TopicStartInfo.Item>>() {
            @Override
            public void onChanged(@Nullable List<TopicStartInfo.Item> list) {
                mFragmentTopicsBinding.multipleStatusView.showContent();
                mTopicsViewModel.addTopicItemsToList(list);
            }
        });
    }

    private void setUp() {
        mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mFragmentTopicsBinding.rcvTopics.setLayoutManager(mLayoutManager);
        mFragmentTopicsBinding.rcvTopics.addItemDecoration(new LinearLayoutColorDivider(getResources(),
                R.color.node_nav_color, R.dimen.item_divider, LinearLayoutManager.VERTICAL));
        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(mTopicAdapter);
        alphaAdapter.setFirstOnly(false);
        alphaAdapter.setDuration(300);

        ScaleInAnimationAdapter scaleAdapter = new ScaleInAnimationAdapter(alphaAdapter, 1.1f);
        scaleAdapter.setFirstOnly(false);
        scaleAdapter.setDuration(300);
        mFragmentTopicsBinding.rcvTopics.setAdapter(scaleAdapter);

        mFragmentTopicsBinding.refreshLayout.setEnableHeaderTranslationContent(true);
        if (((MaterialHeader) mFragmentTopicsBinding.refreshLayout.getRefreshHeader()) != null) {
            ((MaterialHeader) mFragmentTopicsBinding.refreshLayout.getRefreshHeader()).setShowBezierWave(true);
        }

        mFragmentTopicsBinding.refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mTopicsViewModel.fetchTopics();
            }
        });

        mFragmentTopicsBinding.rcvTopics.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int childCount = recyclerView.getChildCount();
                    int itemCount = recyclerView.getLayoutManager().getItemCount();
                    int firstVisibleItem = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();

                    if (firstVisibleItem + childCount == itemCount) {
                        if (!mTopicsViewModel.getIsLoading().get()) {
                            mTopicsViewModel.fetchTopics();
                        }
                    }
                }
            }

        });
    }

    @Override
    public void showEmpty() {
        mFragmentTopicsBinding.multipleStatusView.showEmpty();
    }

    @Override
    public void showLoading() {
        mFragmentTopicsBinding.multipleStatusView.showLoading();
    }

    @Override
    public void noNetWork() {
        mFragmentTopicsBinding.multipleStatusView.showNoNetwork();
    }

    @Override
    public void handleError(Throwable throwable) {
        mFragmentTopicsBinding.multipleStatusView.showError();
    }

    @Override
    public void loadMoreTopics(List<TopicStartInfo.Item> topicList) {
        mTopicAdapter.addItems(topicList);

    }

    @Override
    public void onRetryClick() {
        mTopicsViewModel.fetchTopics();
    }

}
