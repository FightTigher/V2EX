package com.ecovacs.v2ex.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.ecovacs.data.BaseFragment;
import com.ecovacs.data.bean.NodesInfo;
import com.ecovacs.v2ex.BR;
import com.ecovacs.v2ex.R;
import com.ecovacs.v2ex.adapter.NodesAdapter;
import com.ecovacs.v2ex.databinding.FragmentNodesBinding;
import com.ecovacs.v2ex.navigator.NodesNavigator;
import com.ecovacs.v2ex.viewmodel.NodesViewModel;

import java.util.List;

import javax.inject.Inject;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

/**
 * Created by liang.liu on 2018/4/11.
 */
public class NodesFragment extends BaseFragment<FragmentNodesBinding, NodesViewModel>
        implements NodesNavigator {

    @Inject
    ViewModelProvider.Factory mViewModelFactory;
    @Inject
    NodesAdapter nodesAdapter;
    private NodesViewModel nodesViewModel;
    private FragmentNodesBinding mFragmentNodesBinding;
    private LinearLayoutManager mLayoutManager;

    public static NodesFragment newInstance() {
        Bundle args = new Bundle();
        NodesFragment nodesFragment = new NodesFragment();
        nodesFragment.setArguments(args);
        return nodesFragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_nodes;
    }

    @Override
    public NodesViewModel getViewModel() {
        nodesViewModel = ViewModelProviders.of(this, mViewModelFactory).get(NodesViewModel.class);
        return nodesViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nodesViewModel.setNavigator(this);
    }

    @Override
    public void fetchData() {
        showLoading();
        nodesViewModel.fetchNodes();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentNodesBinding = getViewDataBinding();
        setUp();
        nodesViewModel.getNodesLiveData().observe(this, new Observer<List<NodesInfo.Item>>() {
            @Override
            public void onChanged(@Nullable List<NodesInfo.Item> items) {
                mFragmentNodesBinding.multipleStatusView.showContent();
                nodesViewModel.addNodeItemToList(items);
            }
        });
    }

    private void setUp() {
        mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mFragmentNodesBinding.rcvNodes.setLayoutManager(mLayoutManager);
        mFragmentNodesBinding.rcvNodes.setItemViewCacheSize(4);

        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(nodesAdapter);
        alphaAdapter.setFirstOnly(false);
        alphaAdapter.setDuration(300);

        ScaleInAnimationAdapter scaleAdapter = new ScaleInAnimationAdapter(alphaAdapter, 0.9f);
        scaleAdapter.setFirstOnly(false);
        scaleAdapter.setDuration(300);
        mFragmentNodesBinding.rcvNodes.setAdapter(scaleAdapter);

    }

    @Override
    public void showEmpty() {
        mFragmentNodesBinding.multipleStatusView.showEmpty();
    }

    @Override
    public void showLoading() {
        mFragmentNodesBinding.multipleStatusView.showLoading();
    }

    @Override
    public void noNetWork() {
        mFragmentNodesBinding.multipleStatusView.showNoNetwork();
    }

    @Override
    public void handleError(Throwable throwable) {
        Log.e("TopicFragment", "throwable : " + throwable.toString());
        mFragmentNodesBinding.multipleStatusView.showError();
    }
}
