package com.az.dlxj.system.util;

/**
 * @Author : az
 * @Create : 2018-11-13 0:35
 * @Desc : APP 所使用的全局常量
 */
public class Constants {

    /**
     * 验证码
     */
    public static final String VALIDATE_CODE = "validateCode";
    /**
     * shiro采用加密算法
     */
    public static final String HASH_ALGORITHM = "SHA-1";
    /**
     * 生成Hash值的迭代次数
     */
    public static final int HASH_INTERATIONS = 1024;
    /**
     * 生成盐的长度
     */
    public static final int SALT_SIZE = 8;
}
