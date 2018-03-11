package com.ecovacs.h5.config;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Message;
import android.util.AttributeSet;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ecovacs.baselibrary.utils.NetUtils;

/**
 * Created by liang.liu on 2018/3/9.
 */

public class MyWebView extends WebView {
    public MyWebView(Context context) {
        this(context, null);
    }

    public MyWebView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init();
    }

    private void init() {
        WebSettings webSettings = this.getSettings();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);
        }

        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setDefaultTextEncodingName("utf-8");
        webSettings.setLoadsImagesAutomatically(true);


        openView(webSettings);

        cacheData(webSettings);

        setWebChromeClient(mWebChromeClient);
        setWebViewClient(mWebViewClient);

    }

    private WebChromeClient mWebChromeClient = new WebChromeClient() {
        @Override
        public void onReceivedIcon(WebView view, Bitmap icon) {
            super.onReceivedIcon(view, icon);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
        }

        //=========HTML5定位==========================================================
        //需要先加入权限
        //<uses-permission android:name="android.permission.INTERNET"/>
        //<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
        //<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>

        @Override
        public void onGeolocationPermissionsHidePrompt() {
            super.onGeolocationPermissionsHidePrompt();
        }

        @Override
        public void onGeolocationPermissionsShowPrompt(final String origin, final GeolocationPermissions.Callback callback) {
            callback.invoke(origin, true, false);//注意个函数，第二个参数就是是否同意定位权限，第三个是是否希望内核记住
            super.onGeolocationPermissionsShowPrompt(origin, callback);
        }
        //=========HTML5定位==========================================================

        //=========多窗口的问题==========================================================
        @Override
        public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
            WebViewTransport transport = (WebViewTransport) resultMsg.obj;
            transport.setWebView(view);
            resultMsg.sendToTarget();
            return true;
        }
        //=========多窗口的问题==========================================================

    };

    private WebViewClient mWebViewClient = new WebViewClient() {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }

    };

    private void openView(WebSettings webSettings) {
        // 设置允许JS弹窗
        //html中的_bank标签就是新建窗口打开，有时会打不开，需要加以下
        //然后 复写 WebChromeClient的onCreateWindow方法
        webSettings.setSupportMultipleWindows(false);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    }

    private void cacheData(WebSettings webSettings) {
        if (NetUtils.hasNetwork(getContext())) {
            webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        } else {
            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }

        webSettings.setDomStorageEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDatabaseEnabled(true);
        String cachePath = getContext().getCacheDir().getAbsolutePath();
        webSettings.setAppCachePath(cachePath);
    }


}










