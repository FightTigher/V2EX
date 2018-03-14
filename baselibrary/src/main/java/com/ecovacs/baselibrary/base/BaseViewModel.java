package com.ecovacs.baselibrary.base;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import com.ecovacs.baselibrary.base.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by liang.liu on 2018/3/14.
 */

public abstract class BaseViewModel<N> extends ViewModel {

    private final ObservableBoolean mIsLoading = new ObservableBoolean(true);

    private final SchedulerProvider mSchedulerProvider;

    private CompositeDisposable mCompositeDisposable;

    private N mNavigator;

    public BaseViewModel(SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        mSchedulerProvider = schedulerProvider;
        mCompositeDisposable = compositeDisposable;
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public N getNavigator() {
        return mNavigator;
    }

    public void setNavigator(N navigator) {
        mNavigator = navigator;
    }
}
