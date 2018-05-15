package com.ecovacs.data.bean;

import java.util.List;

import me.ghui.fruit.annotations.Pick;

public class NodesInfo extends BaseInfo {

    @Pick(value = "div.cell")
    private List<Item> items;

    @Override
    public boolean isValid() {
        return false;
    }


    private static class Item {
        @Pick(value = "span.fade")
        private String fade;

    }
}
