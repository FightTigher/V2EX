package com.ecovacs.v2ex.fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.ecovacs.data.BaseFragment;
import com.ecovacs.v2ex.BR;
import com.ecovacs.v2ex.R;
import com.ecovacs.v2ex.databinding.FragmentMeBinding;
import com.ecovacs.v2ex.navigator.MeNavigator;
import com.ecovacs.v2ex.viewmodel.MeViewModel;

import javax.inject.Inject;

/**
 * Created by liang.liu on 2018/4/11.
 */

public class MeFragment extends BaseFragment<FragmentMeBinding, MeViewModel>
        implements MeNavigator {

    @Inject
    ViewModelProvider.Factory mViewModelFactory;
    private MeViewModel meViewModel;
    private FragmentMeBinding mFragmentMeBinding;

    public static MeFragment newInstance() {
        Bundle args = new Bundle();
        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_me;
    }

    @Override
    public MeViewModel getViewModel() {
        meViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MeViewModel.class);
        return meViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        meViewModel.setNavigator(this);

    }

    @Override
    public void fetchData() {

    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentMeBinding = getViewDataBinding();
    }
}
