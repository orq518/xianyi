package com.xianyi.utils;

import android.widget.Toast;



public class Utils {

    private static Toast mToast;

    /**
     * 判断字符串是否为空
     *
     * @param @param txt
     * @return boolean true:字符串为空，false:非空
     * @Description:
     */
    public static boolean isEmpty(String txt) {
        boolean flag = false;
        if (txt == null || "".equals(txt))
            flag = true;
        return flag;
    }


}
