package com.ecovacs.data.bean;

import com.ecovacs.baselibrary.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import me.ghui.fruit.annotations.Pick;

@Pick(value = "div.box:last-child div > table")
public class NodesInfo extends ArrayList<NodesInfo.Item> implements IBase{

    private String mResponseBody;


    @Override
    public boolean isValid() {
        if (size() <= 0)
            return true;

        return StringUtils.isNull(new CharSequence[]{this.get(0).category});
    }

    @Override
    public String getResponse() {
        return this.mResponseBody;
    }

    @Override
    public void setResponse(String paramString) {
        this.mResponseBody = paramString;
    }


    public static class Item {
        @Pick(value = "span.fade", attr = "ownText")
        private String category;
        @Pick(value = "a")
        private List<NodeItem> nodes;
        public String getCategory() {
            return category;
        }

        public List<NodeItem> getNodes() {
            return nodes;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "category='" + category + '\'' +
                    ", nodes=" + nodes +
                    '}';
        }

        public static class NodeItem {
            @Pick(value = "a", attr = "href")
            private String link;

            @Pick(value = "a")
            private String name;

            public String getLink() {
                return link;
            }

            public String getName() {
                return name;
            }

            @Override
            public String toString() {
                return "NodeItem{" +
                        "link='" + link + '\'' +
                        ", name='" + name + '\'' +
                        '}';
            }
        }

    }

}
