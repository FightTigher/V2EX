package com.ecovacs.v2ex.module;

import com.ecovacs.baselibrary.base.rx.SchedulerProvider;
import com.ecovacs.baselibrary.data.DataManager;
import com.ecovacs.v2ex.viewmodel.TopicsViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by liang.liu on 2018/3/15.
 */

@Module
public class TopicsFragmentModule {

    @Provides
    TopicsViewModel topicsViewModel(DataManager dataManager,
                                            SchedulerProvider schedulerProvider) {
        return new TopicsViewModel(dataManager, schedulerProvider);
    }


}
