package com.ecovacs.data.bean;

import com.ecovacs.baselibrary.utils.StringUtils;

import java.util.List;

import me.ghui.fruit.annotations.Pick;

@Pick(value = "div#Main")
public class NodesInfo extends BaseInfo {

    @Pick(value = "div.cell table")
    private List<Item> items;

    @Override
    public boolean isValid() {
        if (items == null || items.size() <= 0)
            return true;

        return StringUtils.isNull(new CharSequence[]{this.items.get(0).fade});
    }


    private static class Item {
        @Pick(value = "span.fade", attr = "ownText")
        private String fade;
        @Pick(value = "td>a[href^=/go]")
        private List<Node> nodes;


        private static class Node {
            @Pick(value = "td>a[href^=/go]", attr = "href")
            private String nodeLink;

            @Pick(value = "td>a[href^=/go]")
            private String nodeName;

            public String getNodeLink() {
                return nodeLink;
            }

            public String getNodeName() {
                return nodeName;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "nodeLink='" + nodeLink + '\'' +
                        ", nodeName='" + nodeName + '\'' +
                        '}';
            }
        }

        public String getFade() {
            return fade;
        }

        public List<Node> getNodes() {
            return nodes;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "fade='" + fade + '\'' +
                    ", nodes=" + nodes +
                    '}';
        }
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "NodesInfo{" +
                "items=" + items +
                '}';
    }
}
