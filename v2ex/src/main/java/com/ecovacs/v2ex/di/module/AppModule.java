package com.ecovacs.v2ex.di.module;

import android.app.Application;
import android.content.Context;

import com.ecovacs.baselibrary.base.rx.AppSchedulerProvider;
import com.ecovacs.baselibrary.base.rx.SchedulerProvider;
import com.ecovacs.data.AppDataManager;
import com.ecovacs.data.DataManager;
import com.ecovacs.data.http.IV2exApi;
import com.ecovacs.data.http.V2exApiHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by liang.liu on 2018/3/15.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    IV2exApi provideIV2exApi(V2exApiHelper v2exApiHelper){
        return v2exApiHelper;
    }

    @Provides
    @Singleton
    Context provideContext(Application application){
        return application;
    }

    @Provides
    @Singleton
    Gson provideGson(){
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager){
        return appDataManager;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider(){
        return new AppSchedulerProvider();
    }
}
