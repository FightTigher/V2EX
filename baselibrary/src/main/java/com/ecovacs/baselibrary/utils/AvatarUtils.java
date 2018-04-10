package com.ecovacs.baselibrary.utils;

/**
 * Created by liang.liu on 2018/4/10.
 */

public class AvatarUtils {
    public static String replaceAvatar(String paramString) {
        if (StringUtils.isNull(paramString)) {
            return null;
        }
        String str = paramString;
        if (!paramString.startsWith("https:")) {
            str = paramString;
            if (!paramString.startsWith("http:")) {
                str = "https:" + paramString;
            }
        }
        if (str.contains("_normal.png")) {
            str = str.replace("_normal.png", "_large.png");
        }

        if (str.contains("_mini.png")) {
            str = str.replace("_mini.png", "_large.png");
        }

        if (str.contains("_xxlarge.png")) {
            str = str.replace("_xxlarge.png", "_large.png");
        }
        paramString = str;

        return paramString;

    }
}
