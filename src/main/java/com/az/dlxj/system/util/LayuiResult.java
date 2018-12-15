package com.az.dlxj.system.util;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @Author : az
 * @Create : 2018-12-08 13:29
 * @Desc : layui 表单返回数据
 */
public class LayuiResult implements Serializable {

    // 状态码
    private Integer code;
    // 消息
    private String msg;
    // 数据总记录数
    private Long count;
    // 数据
    private Object data;


    public LayuiResult() {
    }


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
