package com.ecovacs.baselibrary.data.http;

import com.ecovacs.baselibrary.entry.MemberInfoBean;
import com.ecovacs.baselibrary.entry.RepliesBean;
import com.ecovacs.baselibrary.entry.SiteInfoBean;
import com.ecovacs.baselibrary.entry.SiteStatsBean;
import com.ecovacs.baselibrary.entry.TableBean;
import com.ecovacs.baselibrary.entry.TopicBean;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by liang.liu on 2018/3/9.
 */

public interface IV2exApi {

    @GET("/api/site/info.json")
    Single<SiteInfoBean> getSiteInfo(); //取网站信息

    @GET("/api/site/stats.json")
    Single<SiteStatsBean> getSiteStats();   //取网站状态

    @GET("/api/nodes/show.json?{id}")
    Single<TableBean> getTableInfoById(@Path("id") String id);  //（id 参数必须）通过节点 id 获取信息

    @GET("/api/nodes/show.json?{name}")
    Single<TableBean> getTableInfoByName(@Path("name") String name);  //（name 参数必须）通过节点名称获取信息

    @GET("/api/nodes/all.json")
    Single<List<TableBean>> getAllTableInfo();   //获取全部节点信息

    @GET("/api/members/show.json?{id}")
    Single<MemberInfoBean>  getMemberInfoById(@Path("id") String id);   //（id 参数必须）通过用户 id 获取用户信息

    @GET("/api/members/show.json?{username}")
    Single<MemberInfoBean>  getMemberInfoByUserName(@Path("username") String username);   //（username 参数必须）通过用户名称获取用户信息

    @GET("/api/topics/latest.json")
    Single<List<TopicBean>> getLatestTopics();

    @GET("/api/topics/hot.json")
    Single<List<TopicBean>> getHotTopics();  //获取社区每天最热的10个主题

    @GET("/api/topics/show.json?{id}")
    Single<List<TopicBean>> getTopicsById(@Path("id") String id);  //（id 参数必须）通过主题 id 获取主题的信息

    @GET("/api/topics/show.json?{username}")
    Single<List<TopicBean>> getTopicsByUsername(@Path("username") String username);  //（username 参数必须） 通过用户名称获取用户的主题列表

    @GET("/api/topics/show.json?{node_name}")
    Single<List<TopicBean>> getTopicsByNodeName(@Path("node_name") String node_name);  //（node_name 参数必须） 通过节点名称获取该节点下的主题列表

    @GET("/api/topics/show.json?{node_id}")
    Single<List<TopicBean>> getTopicsByNodeId(@Path("node_id") String node_id);   //（id 参数必须） 通过节点 id 获取该节点下的主题列表

    @GET("/api/replies/show.json?{topic_id}")
    Single<List<RepliesBean>>  getReplies(@Path("topic_id") String topic_id);





}
