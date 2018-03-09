package com.ecovacs.baselibrary.http;

import android.os.Environment;

import com.ecovacs.baselibrary.BuildConfig;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by liang.liu on 2018/3/9.
 */

public class DataSourceFactory {

    private static final Object monitor = new Object();

    private static IV2exService mIV2exService = null;

    public static IV2exService getInstance() {

        if (mIV2exService == null) {

            synchronized (monitor) {
                if (mIV2exService == null) {
                    mIV2exService = new V2EXBuilder().build();
                }
            }
        }

        return mIV2exService;
    }


    private static class V2EXBuilder {
        private String apiUrl = "https://www.v2ex.com";

        private IV2exService build() {

            HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;

            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    // TODO: 2018/3/9 log message
                }
            });

            httpLoggingInterceptor.setLevel(level);

            File httpCacheDirectory = new File(Environment.getExternalStorageDirectory()
                    + "/v2ex/cache");

            long cacheSize = 1024 * 1024 * 20;

            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .connectTimeout(3, TimeUnit.SECONDS)
                    .readTimeout(3, TimeUnit.SECONDS)
                    .writeTimeout(3, TimeUnit.SECONDS)
                    .cache(new Cache(httpCacheDirectory, cacheSize));

            if (BuildConfig.DEBUG) {
                builder.addInterceptor(httpLoggingInterceptor);
            }

            OkHttpClient client = builder.build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(apiUrl)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();

            return retrofit.create(IV2exService.class);

        }
    }

}
