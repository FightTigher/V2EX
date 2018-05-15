package com.ecovacs.v2ex.module;

import android.arch.lifecycle.ViewModelProvider;

import com.ecovacs.baselibrary.base.rx.SchedulerProvider;
import com.ecovacs.data.DataManager;
import com.ecovacs.data.ViewModelProviderFactory;
import com.ecovacs.v2ex.viewmodel.MeViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by liang.liu on 2018/4/11.
 */
@Module
public class MeFragmentModule {

    @Provides
    MeViewModel meViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new MeViewModel(dataManager, schedulerProvider);
    }

    @Provides
    ViewModelProvider.Factory provideMeViewModel(MeViewModel meViewModel) {
        return new ViewModelProviderFactory<>(meViewModel);
    }

}
