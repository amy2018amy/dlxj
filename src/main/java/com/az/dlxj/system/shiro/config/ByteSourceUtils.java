package com.az.dlxj.system.shiro.config;

import org.apache.shiro.util.ByteSource;

/**
 * @Author : az
 * @Create : 2018-12-07 14:37
 * @Desc :
 */
public class ByteSourceUtils {
    public static ByteSource bytes(byte[] bytes){
        return new SimpleByteSource(bytes);
    }
    public static ByteSource bytes(String arg0){
        return new SimpleByteSource(arg0.getBytes());
    }

}
