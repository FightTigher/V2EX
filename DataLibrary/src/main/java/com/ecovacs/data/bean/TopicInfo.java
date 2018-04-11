package com.ecovacs.data.bean;

import me.ghui.fruit.annotations.Pick;

/**
 * Created by liang.liu on 2018/4/10.
 */

public class TopicInfo extends BaseInfo{

    @Pick(value = "div.box")
    private ContentInfo contentInfo;


    @Override
    public boolean isValid() {
        return false;
    }

    private class ContentInfo {
    }
}
