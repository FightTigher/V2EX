package com.ecovacs.data.bean;

/**
 * Created by liang.liu on 2018/4/10.
 */

public abstract class BaseInfo
        implements IBase {

    public String rawResponse;

    public String getResponse() {
        return this.rawResponse;
    }

    public void setResponse(String paramString) {
        this.rawResponse = paramString;
    }
}
