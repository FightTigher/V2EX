package com.ecovacs.v2ex.navigator;

/**
 * Created by liang.liu on 2018/4/11.
 */

public interface NodesNavigator {
    void showEmpty();

    void showLoading();

    void noNetWork();

    void handleError(Throwable throwable);
}
