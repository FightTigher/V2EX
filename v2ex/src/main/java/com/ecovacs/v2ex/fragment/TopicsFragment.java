package com.ecovacs.v2ex.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import com.ecovacs.baselibrary.base.BaseFragment;
import com.ecovacs.baselibrary.entry.TopicBean;
import com.ecovacs.v2ex.BR;
import com.ecovacs.v2ex.R;
import com.ecovacs.v2ex.adapter.TopicAdapter;
import com.ecovacs.v2ex.databinding.FragmentTopicsBinding;
import com.ecovacs.v2ex.navigator.TopicNavigator;
import com.ecovacs.v2ex.viewmodel.TopicsViewModel;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import javax.inject.Inject;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;
import jp.wasabeef.recyclerview.animators.ScaleInAnimator;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

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
        Log.e("TopicFragment", "onCreate");
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
        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(mTopicAdapter);
        alphaAdapter.setFirstOnly(false);
        alphaAdapter.setDuration(300);

        ScaleInAnimationAdapter scaleAdapter = new ScaleInAnimationAdapter(alphaAdapter, 1.1f);
        scaleAdapter.setFirstOnly(false);
        scaleAdapter.setDuration(300);
        mFragmentTopicsBinding.rcvTopics.setAdapter(scaleAdapter);

        mFragmentTopicsBinding.refreshLayout.setEnableHeaderTranslationContent(true);
        if (((MaterialHeader)mFragmentTopicsBinding.refreshLayout.getRefreshHeader()) != null) {
            ((MaterialHeader)mFragmentTopicsBinding.refreshLayout.getRefreshHeader()).setShowBezierWave(true);
        }

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
    public void handleError(Throwable throwable) {
        Log.e("TopicFragment", "throwable : " + throwable.toString());
        mFragmentTopicsBinding.multipleStatusView.showError();
    }

    @Override
    public void updateTopic(List<TopicBean> topicList) {
        Log.e("TopicFragment", "updateTopic");
        mTopicAdapter.addItems(topicList);

    }

    @Override
    public void onRetryClick() {
        Log.e("TopicFragment", "onRetryClick");
        mTopicsViewModel.fetchTopics();
    }


}
