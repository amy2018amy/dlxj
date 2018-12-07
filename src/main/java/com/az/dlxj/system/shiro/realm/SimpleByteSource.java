package com.az.dlxj.system.shiro.realm;

import java.io.Serializable;

/**
 * @Author : az
 * @Create : 2018-12-07 14:35
 * @Desc :
 */
public class SimpleByteSource  extends org.apache.shiro.util.SimpleByteSource
        implements Serializable{

    private static final long serialVersionUID = 5528101080905698238L;

    public SimpleByteSource(byte[] bytes) {
        super(bytes);
        // TODO 自动生成的构造函数存根
    }

}
