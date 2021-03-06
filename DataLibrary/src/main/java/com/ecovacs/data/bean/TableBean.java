package com.ecovacs.data.bean;

import java.io.Serializable;

/**
 * Created by Joker on 2018/3/9.
 */

public class TableBean implements Serializable{

    /**
     * id : 1
     * name : babel
     * url : http://www.v2ex.com/go/babel
     * title : Project Babel
     * title_alternative : Project Babel
     * topics : 1119
     * stars : 363
     * header : Project Babel - 帮助你在云平台上搭建自己的社区
     * footer : V2EX 基于 Project Babel 驱动。Project Babel 是用 Python 语言写成的，运行于 Google App Engine 云计算平台上的社区软件。Project Babel 当前开发分支 2.5。最新版本可以从 <a href="http://github.com/livid/v2ex" target="_blank">GitHub</a> 获取。
     * created : 1272206882
     * avatar_mini : //cdn.v2ex.com/navatar/c4ca/4238/1_mini.png?m=1494924246
     * avatar_normal : //cdn.v2ex.com/navatar/c4ca/4238/1_normal.png?m=1494924246
     * avatar_large : //cdn.v2ex.com/navatar/c4ca/4238/1_large.png?m=1494924246
     */

    private int id;
    private String name;
    private String url;
    private String title;
    private String title_alternative;
    private int topics;
    private int stars;
    private String header;
    private String footer;
    private int created;
    private String avatar_mini;
    private String avatar_normal;
    private String avatar_large;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_alternative() {
        return title_alternative;
    }

    public void setTitle_alternative(String title_alternative) {
        this.title_alternative = title_alternative;
    }

    public int getTopics() {
        return topics;
    }

    public void setTopics(int topics) {
        this.topics = topics;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public String getAvatar_mini() {
        return avatar_mini;
    }

    public void setAvatar_mini(String avatar_mini) {
        this.avatar_mini = avatar_mini;
    }

    public String getAvatar_normal() {
        return avatar_normal;
    }

    public void setAvatar_normal(String avatar_normal) {
        this.avatar_normal = avatar_normal;
    }

    public String getAvatar_large() {
        return avatar_large;
    }

    public void setAvatar_large(String avatar_large) {
        this.avatar_large = avatar_large;
    }
}
