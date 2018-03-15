package com.ecovacs.v2ex.provider;

import com.ecovacs.v2ex.fragment.TopicsFragment;
import com.ecovacs.v2ex.module.TopicsFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by liang.liu on 2018/3/15.
 */
@Module
public abstract class TopicsFragmentProvider {

    @ContributesAndroidInjector(modules = TopicsFragmentModule.class)
    abstract TopicsFragment provideTopicsFragmentFactory();
}
