package com.ecovacs.v2ex.module;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.LinearLayoutManager;

import com.ecovacs.baselibrary.base.rx.SchedulerProvider;
import com.ecovacs.baselibrary.data.DataManager;
import com.ecovacs.baselibrary.entry.TopicBean;
import com.ecovacs.v2ex.ViewModelProviderFactory;
import com.ecovacs.v2ex.adapter.TopicAdapter;
import com.ecovacs.v2ex.fragment.TopicsFragment;
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
    TopicAdapter provideTopicAdapter(){
        return new TopicAdapter(new ArrayList<TopicBean>());
    }

    @Provides
    ViewModelProvider.Factory provideTopicsViewModel(TopicsViewModel topicsViewModel){
        return new ViewModelProviderFactory<>(topicsViewModel);
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(TopicsFragment fragment) {
        return new LinearLayoutManager(fragment.getActivity());
    }

}
