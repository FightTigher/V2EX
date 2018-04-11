package com.ecovacs.data;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ecovacs.baselibrary.utils.NetUtils;
import com.ecovacs.baselibrary.utils.SystemUtils;

import dagger.android.AndroidInjection;

/**
 * Created by liang.liu on 2018/3/14.
 */

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel>
        extends AppCompatActivity implements BaseFragment.Callback {

    private ProgressDialog mProgressDialog;
    private T mViewDataBinding;
    private V mViewModel;

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        performDependencyInjection();
        super.onCreate(savedInstanceState);
        performDataBinding();
    }

    private void performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        this.mViewModel = mViewModel == null ? getViewModel() : mViewModel;
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.executePendingBindings();
    }

    protected abstract int getBindingVariable();

    protected abstract V getViewModel();

    @LayoutRes
    protected abstract int getLayoutId();

    private void performDependencyInjection() {
        AndroidInjection.inject(this);
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            SystemUtils.hideKeyBoard(this);
        }
    }

    ;

    public boolean isNetworkConnected() {
        return NetUtils.hasNetwork(this);
    }


    public abstract void openActivityOnTokenExpire();
}
