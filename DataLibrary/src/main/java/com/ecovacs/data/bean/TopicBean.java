package com.ecovacs.data.bean;


/**
 * Created by Joker on 2018/3/9.
 */

public class TopicBean {

    /**
     * id : 436390
     * title : 这两天开发外贸站才感叹道，比特币这么好的一副牌被打成一坨翔了
     * url : http://www.v2ex.com/t/436390
     * content : 国人开发外贸站基本就是噩梦，因为目前你根本没有好用的支付方式，大家可以可以看看这个比较老的帖子： https://www.v2ex.com/t/129714  ，我对支付方式的总结：
     1.	PayPal：PayPal 完全是保护买家，卖家和蚂蚁没什么区别，被 GBC 告版权，被用户撤单等等 PayPal 都是搞你卖家没商量
     2.	stripe：国人没法申请，像什么在美国注册公司不太现实，太麻烦
     3.	2checkout：费用太高，这不是雁过拔毛了，这是雁过拔大腿了
     4.	另外对于信用卡网关，谁会把自己的信用卡号输入到一个陌生的小站上？？？

     比特币这个好东西便应运而生，没有中间商赚差价，比瓜子还良心，不用担心任何雁过拔毛的问题，而且根本不用担心任何支付被告的问题（大家可以谷歌“ PayPal GBC 侵权”这类的关键词），而且连每年 5 万美元的额度都不用担心，但是这么好一副牌，被打成一坨屎一样，天天炒、夜夜炒、完全就把它当做一款投机商品来炒，其价值完全被淹没，真实悲哀。那么问题来了，除了比特币，国人开发外贸站，还有没有比较良心的收款方式？？？
     * content_rendered : <p>国人开发外贸站基本就是噩梦，因为目前你根本没有好用的支付方式，大家可以可以看看这个比较老的帖子： <a href="https://www.v2ex.com/t/129714" rel="nofollow">https://www.v2ex.com/t/129714</a>  ，我对支付方式的总结：</p>
     <ol>
     <li>PayPal：PayPal 完全是保护买家，卖家和蚂蚁没什么区别，被 GBC 告版权，被用户撤单等等 PayPal 都是搞你卖家没商量</li>
     <li>stripe：国人没法申请，像什么在美国注册公司不太现实，太麻烦</li>
     <li>2checkout：费用太高，这不是雁过拔毛了，这是雁过拔大腿了</li>
     <li>另外对于信用卡网关，谁会把自己的信用卡号输入到一个陌生的小站上？？？</li>
     </ol>
     <p>比特币这个好东西便应运而生，没有中间商赚差价，比瓜子还良心，不用担心任何雁过拔毛的问题，而且根本不用担心任何支付被告的问题（大家可以谷歌“ PayPal GBC 侵权”这类的关键词），而且连每年 5 万美元的额度都不用担心，但是这么好一副牌，被打成一坨屎一样，天天炒、夜夜炒、完全就把它当做一款投机商品来炒，其价值完全被淹没，真实悲哀。那么问题来了，除了比特币，国人开发外贸站，还有没有比较良心的收款方式？？？</p>

     * replies : 91
     * member : {"id":158237,"username":"alwayshere","tagline":"","avatar_mini":"//cdn.v2ex.com/avatar/704b/889d/158237_mini.png?m=1456660512","avatar_normal":"//cdn.v2ex.com/avatar/704b/889d/158237_normal.png?m=1456660512","avatar_large":"//cdn.v2ex.com/avatar/704b/889d/158237_large.png?m=1456660512"}
     * node : {"id":300,"name":"programmer","title":"程序员","url":"http://www.v2ex.com/go/programmer","topics":20349,"avatar_mini":"//cdn.v2ex.com/navatar/94f6/d7e0/300_mini.png?m=1520491580","avatar_normal":"//cdn.v2ex.com/navatar/94f6/d7e0/300_normal.png?m=1520491580","avatar_large":"//cdn.v2ex.com/navatar/94f6/d7e0/300_large.png?m=1520491580"}
     * created : 1520560440
     * last_modified : 1520560612
     * last_touched : 1520599696
     */

    private int id;
    private String title;
    private String url;
    private String content;
    private String content_rendered;
    private int replies;
    private MemberBean member;
    private NodeBean node;
    private int created;
    private int last_modified;
    private int last_touched;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public int getReplies() {
        return replies;
    }

    public void setReplies(int replies) {
        this.replies = replies;
    }

    public MemberBean getMember() {
        return member;
    }

    public void setMember(MemberBean member) {
        this.member = member;
    }

    public NodeBean getNode() {
        return node;
    }

    public void setNode(NodeBean node) {
        this.node = node;
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

    public int getLast_touched() {
        return last_touched;
    }

    public void setLast_touched(int last_touched) {
        this.last_touched = last_touched;
    }

    public static class MemberBean {
        /**
         * id : 158237
         * username : alwayshere
         * tagline :
         * avatar_mini : //cdn.v2ex.com/avatar/704b/889d/158237_mini.png?m=1456660512
         * avatar_normal : //cdn.v2ex.com/avatar/704b/889d/158237_normal.png?m=1456660512
         * avatar_large : //cdn.v2ex.com/avatar/704b/889d/158237_large.png?m=1456660512
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

    public static class NodeBean {
        /**
         * id : 300
         * name : programmer
         * title : 程序员
         * url : http://www.v2ex.com/go/programmer
         * topics : 20349
         * avatar_mini : //cdn.v2ex.com/navatar/94f6/d7e0/300_mini.png?m=1520491580
         * avatar_normal : //cdn.v2ex.com/navatar/94f6/d7e0/300_normal.png?m=1520491580
         * avatar_large : //cdn.v2ex.com/navatar/94f6/d7e0/300_large.png?m=1520491580
         */

        private int id;
        private String name;
        private String title;
        private String url;
        private int topics;
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getTopics() {
            return topics;
        }

        public void setTopics(int topics) {
            this.topics = topics;
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
