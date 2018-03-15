package com.ecovacs.v2ex.navigator;

import com.ecovacs.baselibrary.entry.TopicBean;

import java.util.List;

/**
 * Created by liang.liu on 2018/3/15.
 */

public interface TopicNavigator {

    void handleError(Throwable throwable);

    void updateTopic(List<TopicBean> topicList);
}
