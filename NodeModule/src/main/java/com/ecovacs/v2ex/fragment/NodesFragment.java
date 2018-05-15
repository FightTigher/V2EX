package com.ecovacs.v2ex.fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.ecovacs.data.BaseFragment;
import com.ecovacs.v2ex.BR;
import com.ecovacs.v2ex.R;
import com.ecovacs.v2ex.adapter.NodesAdapter;
import com.ecovacs.v2ex.databinding.FragmentNodesBinding;
import com.ecovacs.v2ex.navigator.NodesNavigator;
import com.ecovacs.v2ex.viewmodel.NodesViewModel;

import javax.inject.Inject;

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
        nodesViewModel.fetchNodes();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentNodesBinding = getViewDataBinding();

        setUp();
    }

    private void setUp() {
        mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mFragmentNodesBinding.rcvNodes.setLayoutManager(mLayoutManager);

    }
}
