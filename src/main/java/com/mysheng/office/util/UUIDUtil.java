package com.mysheng.office.util;

import java.util.UUID;

public class UUIDUtil {
    /**
     * 获取一个UUID值
     * @return UUID值[String]
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","").toLowerCase();
    }

}
