package com.ecovacs.baselibrary.entry;

import java.io.Serializable;

/**
 * Created by Joker on 2018/3/9.
 */

public class RepliesBean implements Serializable{

    /**
     * id : 5412154
     * thanks : 0
     * content : 如果价格比较稳定，那和其他货币有什么区别，如果价格不稳定，私下交易的风险又太高。。
     * content_rendered : 如果价格比较稳定，那和其他货币有什么区别，如果价格不稳定，私下交易的风险又太高。。
     * member : {"id":108163,"username":"leir","tagline":"None","avatar_mini":"//cdn.v2ex.com/gravatar/3084ec0677daed055556ea5f941855f2?s=24&d=retro","avatar_normal":"//cdn.v2ex.com/gravatar/3084ec0677daed055556ea5f941855f2?s=48&d=retro","avatar_large":"//cdn.v2ex.com/gravatar/3084ec0677daed055556ea5f941855f2?s=73&d=retro"}
     * created : 1520560997
     * last_modified : 1520560997
     */

    private int id;
    private int thanks;
    private String content;
    private String content_rendered;
    private MemberBean member;
    private int created;
    private int last_modified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getThanks() {
        return thanks;
    }

    public void setThanks(int thanks) {
        this.thanks = thanks;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent_rendered() {
        return content_rendered;
    }

    public void setContent_rendered(String content_rendered) {
        this.content_rendered = content_rendered;
    }

    public MemberBean getMember() {
        return member;
    }

    public void setMember(MemberBean member) {
        this.member = member;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public int getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(int last_modified) {
        this.last_modified = last_modified;
    }

    public static class MemberBean {
        /**
         * id : 108163
         * username : leir
         * tagline : None
         * avatar_mini : //cdn.v2ex.com/gravatar/3084ec0677daed055556ea5f941855f2?s=24&d=retro
         * avatar_normal : //cdn.v2ex.com/gravatar/3084ec0677daed055556ea5f941855f2?s=48&d=retro
         * avatar_large : //cdn.v2ex.com/gravatar/3084ec0677daed055556ea5f941855f2?s=73&d=retro
         */

        private int id;
        private String username;
        private String tagline;
        private String avatar_mini;
        private String avatar_normal;
        private String avatar_large;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getTagline() {
            return tagline;
        }

        public void setTagline(String tagline) {
            this.tagline = tagline;
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
}
