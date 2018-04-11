package com.ecovacs.v2ex.module;

import android.arch.lifecycle.ViewModelProvider;

import com.ecovacs.baselibrary.base.rx.SchedulerProvider;
import com.ecovacs.baselibrary.data.DataManager;
import com.ecovacs.baselibrary.data.http.bean.TopicStartInfo;
import com.ecovacs.v2ex.ViewModelProviderFactory;
import com.ecovacs.v2ex.adapter.TopicsAdapter;
import com.ecovacs.v2ex.viewmodel.TopicsViewModel;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by liang.liu on 2018/3/15.
 */

@Module
public class TopicsFragmentModule {

    @Provides
    TopicsViewModel topicsViewModel(DataManager dataManager,
                                            SchedulerProvider schedulerProvider) {
        return new TopicsViewModel(dataManager, schedulerProvider);
    }

    @Provides
    TopicsAdapter provideTopicAdapter(){
        return new TopicsAdapter(new ArrayList<TopicStartInfo.Item>());
    }

    @Provides
    ViewModelProvider.Factory provideTopicsViewModel(TopicsViewModel topicsViewModel){
        return new ViewModelProviderFactory<>(topicsViewModel);
    }

//    @Provides
//    LinearLayoutManager provideLinearLayoutManager(TopicsFragment fragment) {
//        return new LinearLayoutManager(fragment.getActivity());
//    }

}
