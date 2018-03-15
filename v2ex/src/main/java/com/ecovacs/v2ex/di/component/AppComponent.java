package com.ecovacs.v2ex.di.component;

import android.app.Application;

import com.ecovacs.v2ex.V2exApplication;
import com.ecovacs.v2ex.di.builder.ActivityBuilder;
import com.ecovacs.v2ex.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;


/**
 * Created by liang.liu on 2018/3/15.
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(V2exApplication app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

}
