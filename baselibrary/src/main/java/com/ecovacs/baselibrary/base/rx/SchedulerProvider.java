package com.ecovacs.baselibrary.base.rx;

import io.reactivex.Scheduler;

/**
 * Created by liang.liu on 2018/3/14.
 */

public interface SchedulerProvider {

    Scheduler computation();

    Scheduler io();

    Scheduler ui();
}
