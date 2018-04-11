package com.ecovacs.v2ex.provider;

import com.ecovacs.v2ex.fragment.MeFragment;
import com.ecovacs.v2ex.module.MeFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by liang.liu on 2018/4/11.
 */
@Module
public abstract class MeFragmentProvider {

    @ContributesAndroidInjector(modules = MeFragmentModule.class)
    abstract MeFragment provideMeFragmentFactory();
}
