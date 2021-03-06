package com.az.dlxj.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author : az
 * @Create : 2018-11-08 21:32
 * @Desc : 日志
 */
public class LogDO {
    private Long id;
    // 用户Id
    private Long userId;
    // 用户名
    private String username;
    // 日志概述
    private String operation;
    // 方法
    private String method;
    // 参数
    private String params;
    // ip
    private String ip;
    // 请求方式
    private String type;
    // request_uri
    private String requestUri;
    // http_method
    private String httpMethod;
    // 时间
    private Integer time;
    // GMT中央时区 ，比北京时区晚8小时
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;


    @Override
    public String toString() {
        return "LogDO{" +
                "id=" + id +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", operation='" + operation + '\'' +
                ", method='" + method + '\'' +
                ", params='" + params + '\'' +
                ", ip='" + ip + '\'' +
                ", type='" + type + '\'' +
                ", requestUri='" + requestUri + '\'' +
                ", httpMethod='" + httpMethod + '\'' +
                ", time=" + time +
                ", gmtCreate=" + gmtCreate +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}
