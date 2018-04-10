package com.ecovacs.baselibrary.utils;

/**
 * Created by liang.liu on 2018/4/10.
 */

public class StringUtils {

    public static boolean isNull(CharSequence paramCharSequence)
    {
        return (paramCharSequence == null) || (paramCharSequence.length() <= 0);
    }


    public static boolean isNull(CharSequence... paramVarArgs) {
        int j = paramVarArgs.length;
        int i = 0;
        while (i < j) {
            if (isNull(paramVarArgs[i])) {
                return false;
            }
            i += 1;
        }
        return true;
    }
}
