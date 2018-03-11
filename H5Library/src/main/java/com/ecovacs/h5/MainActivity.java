package com.ecovacs.h5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.ecovacs.h5.config.MyWebView;

public class MainActivity extends AppCompatActivity {

    private String mUrl;
    private MyWebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Bundle bundle = getIntent().getBundleExtra("bundle");
        if (bundle != null) {
            mUrl = bundle.getString("url");
        }

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.framelayout);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        mWebView = new MyWebView(this);
        mWebView.setLayoutParams(params);
        frameLayout.addView(mWebView);

        mWebView.loadUrl(mUrl);
    }


    private long mOldTime;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - mOldTime < 1500) {
                mWebView.clearHistory();
                mWebView.loadUrl(mUrl);
            } else if (mWebView.canGoBack()) {
                mWebView.goBack();
            } else {
                MainActivity.this.finish();
            }
            mOldTime = System.currentTimeMillis();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        if (mWebView != null) {
            mWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            mWebView.clearHistory();

            ((ViewGroup) mWebView.getParent()).removeView(mWebView);
            mWebView.destroy();
            mWebView = null;
        }
        super.onDestroy();
    }
}
