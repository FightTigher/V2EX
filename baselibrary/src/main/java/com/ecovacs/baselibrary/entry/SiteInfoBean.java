package com.ecovacs.baselibrary.entry;

import java.io.Serializable;

/**
 * Created by Joker on 2018/3/9.
 */

public class SiteInfoBean implements Serializable{


    /**
     * title : V2EX
     * slogan : way to explore
     * description : 创意工作者们的社区
     * domain : www.v2ex.com
     */

    private String title;
    private String slogan;
    private String description;
    private String domain;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
