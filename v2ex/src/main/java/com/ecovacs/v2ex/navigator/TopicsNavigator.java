package com.ecovacs.v2ex.navigator;


import com.ecovacs.data.bean.TopicStartInfo;

import java.util.List;

/**
 * Created by liang.liu on 2018/3/15.
 */

public interface TopicsNavigator {

    void showEmpty();

    void showLoading();

    void noNetWork();

    void handleError(Throwable throwable);

    void loadMoreTopics(List<TopicStartInfo.Item> topicList);
}
