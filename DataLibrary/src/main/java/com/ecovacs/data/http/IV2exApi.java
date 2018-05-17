package com.ecovacs.data.http;


import com.ecovacs.data.bean.MemberInfoBean;
import com.ecovacs.data.bean.RepliesBean;
import com.ecovacs.data.bean.SiteInfoBean;
import com.ecovacs.data.bean.SiteStatsBean;
import com.ecovacs.data.bean.TableBean;
import com.ecovacs.data.bean.TopicBean;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by liang.liu on 2018/3/9.
 */

public interface IV2exApi {

    @GET("/api/site/info.json")
    Single<SiteInfoBean> getSiteInfo(); //取网站信息

    @GET("/api/site/stats.json")
    Single<SiteStatsBean> getSiteStats();   //取网站状态

    @GET("/api/nodes/show.json")
    Single<TableBean> getTableInfoById(@Query("id") String id);  //（id 参数必须）通过节点 id 获取信息

    @GET("/api/nodes/show.json")
    Single<TableBean> getTableInfoByName(@Query("name") String name);  //（name 参数必须）通过节点名称获取信息

    @GET("/api/nodes/all.json")
    Single<List<TableBean>> getAllTableInfo();   //获取全部节点信息

    @GET("/api/members/show.json")
    Single<MemberInfoBean> getMemberInfoById(@Query("id") String id);   //（id 参数必须）通过用户 id 获取用户信息

    @GET("/api/members/show.json")
    Single<MemberInfoBean> getMemberInfoByUserName(@Query("username") String username);   //（username 参数必须）通过用户名称获取用户信息

    @GET("/api/topics/latest.json")
    Single<List<TopicBean>> getLatestTopics();

    @GET("/api/topics/hot.json")
    Single<List<TopicBean>> getHotTopics();  //获取社区每天最热的10个主题

    @GET("/api/topics/show.json")
    Single<List<TopicBean>> getTopicsById(@Query("id") String id);  //（id 参数必须）通过主题 id 获取主题的信息

    @GET("/api/topics/show.json")
    Single<List<TopicBean>> getTopicsByUsername(@Query("username") String username);  //（username 参数必须） 通过用户名称获取用户的主题列表

    @GET("/api/topics/show.json")
    Single<List<TopicBean>> getTopicsByNodeName(@Query("node_name") String node_name);  //（node_name 参数必须） 通过节点名称获取该节点下的主题列表

    @GET("/api/topics/show.json")
    Single<List<TopicBean>> getTopicsByNodeId(@Query("node_id") String node_id);   //（id 参数必须） 通过节点 id 获取该节点下的主题列表

    @GET("/api/replies/show.json")
    Single<List<RepliesBean>> getReplies(@Query("topic_id") String topic_id);

    @GET("/")
    Single<String> getTopicsByNode(@Query("tab") String tab);

    @GET("/")
    Single<String> loadMoreTopicsByNode(@Query("tab") String tab,
                                        @Query("p") String p);

    @GET("/")
    Single<String> getNodes();


}
