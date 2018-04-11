package com.ecovacs.v2ex.provider;

import com.ecovacs.v2ex.fragment.NodesFragment;
import com.ecovacs.v2ex.fragment.TopicsFragment;
import com.ecovacs.v2ex.module.NodesFragmentModule;
import com.ecovacs.v2ex.module.TopicsFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by liang.liu on 2018/4/11.
 */
@Module
public abstract class NodesFragmentProvider {

    @ContributesAndroidInjector(modules = NodesFragmentModule.class)
    abstract NodesFragment provideNodesFragmentFactory();
}
