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

/**
 * Created by liang.liu on 2018/3/15.
 */

public class V2exApiHelper implements IV2exApi {

    private final IV2exApi v2exApi;

    public V2exApiHelper() {
        v2exApi = DataSourceFactory.getInstance();
    }

    @Override
    public Flowable<SiteInfoBean> getSiteInfo() {
        return v2exApi.getSiteInfo();
    }

    @Override
    public Flowable<SiteStatsBean> getSiteStats() {
        return v2exApi.getSiteStats();
    }

    @Override
    public Flowable<TableBean> getTableInfoById(String id) {
        return v2exApi.getTableInfoById(id);
    }

    @Override
    public Flowable<TableBean> getTableInfoByName(String name) {
        return v2exApi.getTableInfoByName(name);
    }

    @Override
    public Flowable<List<TableBean>> getAllTableInfo() {
        return v2exApi.getAllTableInfo();
    }

    @Override
    public Flowable<MemberInfoBean> getMemberInfoById(String id) {
        return v2exApi.getMemberInfoById(id);
    }

    @Override
    public Flowable<MemberInfoBean> getMemberInfoByUserName(String username) {
        return v2exApi.getMemberInfoByUserName(username);
    }

    @Override
    public Single<List<TopicBean>> getHotTopics() {
        return v2exApi.getHotTopics();
    }

    @Override
    public Flowable<List<TopicBean>> getTopicsById(String id) {
        return v2exApi.getTopicsById(id);
    }

    @Override
    public Flowable<List<TopicBean>> getTopicsByUsername(String username) {
        return v2exApi.getTopicsByUsername(username);
    }

    @Override
    public Flowable<List<TopicBean>> getTopicsByNodeName(String node_name) {
        return v2exApi.getTopicsByNodeName(node_name);
    }

    @Override
    public Flowable<List<TopicBean>> getTopicsByNodeId(String node_id) {
        return v2exApi.getTopicsByNodeId(node_id);
    }

    @Override
    public Flowable<List<RepliesBean>> getReplies(String topic_id) {
        return v2exApi.getReplies(topic_id);
    }
}
