package com.ecovacs.v2ex.di.builder;

import com.ecovacs.v2ex.provider.NodesFragmentProvider;
import com.ecovacs.v2ex.provider.TopicsFragmentProvider;
import com.ecovacs.v2ex.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by liang.liu on 2018/3/15.
 */
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules =
            {TopicsFragmentProvider.class
                    , NodesFragmentProvider.class})
    abstract MainActivity bindMainActivity();
}
