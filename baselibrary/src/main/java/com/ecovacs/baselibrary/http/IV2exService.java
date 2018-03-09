package com.ecovacs.baselibrary.http;

import com.ecovacs.baselibrary.entry.MemberInfoBean;
import com.ecovacs.baselibrary.entry.RepliesBean;
import com.ecovacs.baselibrary.entry.SiteInfoBean;
import com.ecovacs.baselibrary.entry.SiteStatsBean;
import com.ecovacs.baselibrary.entry.TableBean;
import com.ecovacs.baselibrary.entry.TopicBean;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by liang.liu on 2018/3/9.
 */

public interface IV2exService {

    @GET("/api/site/info.json")
    Flowable<SiteInfoBean> getSiteInfo(); //取网站信息

    @GET("/api/site/stats.json")
    Flowable<SiteStatsBean> getSiteStats();   //取网站状态

    @GET("/api/nodes/show.json?{id}")
    Flowable<TableBean> getTableInfoById(@Path("id") String id);  //（id 参数必须）通过节点 id 获取信息

    @GET("/api/nodes/show.json?{name}")
    Flowable<TableBean> getTableInfoByName(@Path("name") String name);  //（name 参数必须）通过节点名称获取信息

    @GET("/api/nodes/all.json")
    Flowable<List<TableBean>> getAllTableInfo();   //获取全部节点信息

    @GET("/api/members/show.json?{id}")
    Flowable<MemberInfoBean>  getMemberInfoById(@Path("id") String id);   //（id 参数必须）通过用户 id 获取用户信息

    @GET("/api/members/show.json?{username}")
    Flowable<MemberInfoBean>  getMemberInfoByUserName(@Path("username") String username);   //（username 参数必须）通过用户名称获取用户信息

    @GET("/api/topics/hot.json")
    Flowable<List<TopicBean>> getHotTopics();  //获取社区每天最热的10个主题

    @GET("/api/topics/show.json?{id}")
    Flowable<List<TopicBean>> getTopicsById(@Path("id") String id);  //（id 参数必须）通过主题 id 获取主题的信息

    @GET("/api/topics/show.json?{username}")
    Flowable<List<TopicBean>> getTopicsByUsername(@Path("username") String username);  //（username 参数必须） 通过用户名称获取用户的主题列表

    @GET("/api/topics/show.json?{node_name}")
    Flowable<List<TopicBean>> getTopicsByNodeName(@Path("node_name") String node_name);  //（node_name 参数必须） 通过节点名称获取该节点下的主题列表

    @GET("/api/topics/show.json?{node_id}")
    Flowable<List<TopicBean>> getTopicsByNodeId(@Path("node_id") String node_id);   //（id 参数必须） 通过节点 id 获取该节点下的主题列表

    @GET("/api/replies/show.json?{topic_id}")
    Flowable<List<RepliesBean>>  getReplies(@Path("topic_id") String topic_id);





}
