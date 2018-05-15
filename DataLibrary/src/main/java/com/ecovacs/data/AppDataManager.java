package com.ecovacs.data;

import android.content.Context;

import com.ecovacs.data.bean.MemberInfoBean;
import com.ecovacs.data.bean.RepliesBean;
import com.ecovacs.data.bean.SiteInfoBean;
import com.ecovacs.data.bean.SiteStatsBean;
import com.ecovacs.data.bean.TableBean;
import com.ecovacs.data.bean.TopicBean;
import com.ecovacs.data.http.IV2exApi;
import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

//import com.ecovacs.baselibrary.data.http.V2exApiHelper;

/**
 * Created by liang.liu on 2018/3/19.
 */
@Singleton
public class AppDataManager implements DataManager {

    private IV2exApi iv2exApi = null;

    private final Context mContext;

    private final Gson mGson;

    @Inject
    public AppDataManager(Context mContext, Gson mGson, IV2exApi iv2exApi) {
        this.mContext = mContext;
        this.mGson = mGson;
        this.iv2exApi = iv2exApi;
    }



    @Override
    public Single<SiteInfoBean> getSiteInfo() {
        return iv2exApi.getSiteInfo();
    }

    @Override
    public Single<SiteStatsBean> getSiteStats() {
        return iv2exApi.getSiteStats();
    }

    @Override
    public Single<TableBean> getTableInfoById(String id) {
        return iv2exApi.getTableInfoById(id);
    }

    @Override
    public Single<TableBean> getTableInfoByName(String name) {
        return iv2exApi.getTableInfoByName(name);
    }

    @Override
    public Single<List<TableBean>> getAllTableInfo() {
        return iv2exApi.getAllTableInfo();
    }

    @Override
    public Single<MemberInfoBean> getMemberInfoById(String id) {
        return iv2exApi.getMemberInfoById(id);
    }

    @Override
    public Single<MemberInfoBean> getMemberInfoByUserName(String username) {
        return iv2exApi.getMemberInfoById(username);
    }



    @Override
    public Single<List<TopicBean>> getLatestTopics() {
        return iv2exApi.getLatestTopics();
    }

    @Override
    public Single<List<TopicBean>> getHotTopics() {
        return iv2exApi.getHotTopics();
    }

    @Override
    public Single<List<TopicBean>> getTopicsById(String id) {
        return iv2exApi.getTopicsById(id);
    }

    @Override
    public Single<List<TopicBean>> getTopicsByUsername(String username) {
        return iv2exApi.getTopicsByUsername(username);
    }

    @Override
    public Single<List<TopicBean>> getTopicsByNodeName(String node_name) {
        return iv2exApi.getTopicsByNodeName(node_name);
    }

    @Override
    public Single<List<TopicBean>> getTopicsByNodeId(String node_id) {
        return iv2exApi.getTopicsByNodeId(node_id);
    }

    @Override
    public Single<List<RepliesBean>> getReplies(String topic_id) {
        return iv2exApi.getReplies(topic_id);
    }

    @Override
    public Single<String> getTopicsByNode(String tab) {
        return iv2exApi.getTopicsByNode(tab);
    }

    @Override
    public Single<String> loadMoreTopicsByNode(String tab, String p) {
        return null;
    }

    @Override
    public Single<String> getNodes() {
        return iv2exApi.getNodes();
    }
}
