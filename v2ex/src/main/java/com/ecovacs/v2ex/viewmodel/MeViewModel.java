package com.ecovacs.v2ex.viewmodel;

import com.ecovacs.baselibrary.base.rx.SchedulerProvider;
import com.ecovacs.data.BaseViewModel;
import com.ecovacs.data.DataManager;
import com.ecovacs.v2ex.navigator.MeNavigator;

/**
 * Created by liang.liu on 2018/4/11.
 */

public class MeViewModel extends BaseViewModel<MeNavigator> {

    public MeViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}
