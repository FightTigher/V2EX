package com.ecovacs.data.bean;

import com.ecovacs.baselibrary.utils.AvatarUtils;
import com.ecovacs.baselibrary.utils.StringUtils;

import java.util.List;

import me.ghui.fruit.annotations.Pick;

/**
 * Created by liang.liu on 2018/4/10.
 */
@Pick(value = "div#Wrapper")
public class TopicStartInfo extends BaseInfo {

    @Pick(value = "div.cell.item")
    private List<Item> items;
    @Pick(value = "div.fr.f12 strong.gray")
    private int total = 0;

    @Override
    public boolean isValid() {
        if (items == null || items.size() <= 0)
            return true;

        return StringUtils.isNull(new CharSequence[]{this.items.get(0).title});
    }

    public static class Item {
        @Pick(value = "img.avatar", attr = "src")
        private String avatar;
        @Pick(value = "a[class^=count_]")
        private int commentNum;
        @Pick(value = "span.item_title a", attr = "href")
        private String link;
        @Pick(value = "a.node")
        private String tag;
        @Pick(value = "a.node", attr = "href")
        private String tagLink;
        @Pick(value = "span.topic_info", attr = "ownText")
        private String time;
        @Pick(value = "span.item_title")
        private String title;
        @Pick(value = "td>a[href^=/member]", attr = "href")
        private String userLink;

        public String getAvatar() {
            return AvatarUtils.replaceAvatar(this.avatar);
        }

        public int getCommentNum() {
            return commentNum;
        }

        public String getLink() {
            return link;
        }

        public String getTag() {
            return tag;
        }

        public String getTagLink() {
            return tagLink;
        }

        public String getTime() {
            if (StringUtils.isNull(this.time) || !(this.time.contains("前")))
                return "";

            this.time = this.time.replaceAll(" ", "");
            int j = time.indexOf("前");
            int i = j - 1;
            if (i >= 0) {
                for (; ; i--) {
                    if (time.charAt(i) == '•') {
                        return time.substring(i + 1, j + 1).trim();
                    }
                }
            }

            return "未知";

        }

        public String getTitle() {
            return title;
        }

        public String getUserLink() {
            return userLink;
        }

        public String getUserName() {
            if (StringUtils.isNull(this.userLink)) {
                return null;
            }
            return this.userLink.substring(this.userLink.lastIndexOf("/") + 1);
        }

        @Override
        public String toString() {
            return "Item{" +
                    "avatar='" + avatar + '\'' +
                    ", commentNum=" + commentNum +
                    ", link='" + link + '\'' +
                    ", tag='" + tag + '\'' +
                    ", tagLink='" + tagLink + '\'' +
                    ", time='" + time + '\'' +
                    ", title='" + title + '\'' +
                    ", userLink='" + userLink + '\'' +
                    '}';
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "TopicStarInfo{total=" + this.total + ", items=" + this.items + '}';
    }
}
