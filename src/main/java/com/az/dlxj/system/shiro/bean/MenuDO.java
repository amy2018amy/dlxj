package com.az.dlxj.system.shiro.bean;

import java.io.Serializable;

/**
 * @Author : az
 * @Create : 2018-12-05 15:58
 * @Desc :
 */
public class MenuDO implements Serializable {

    private Integer id;
    // 菜单名称
    private String name;
    // 菜单URL
    private String url;
    // 图标
    private String icon;
    // 父级菜单ID：一级菜单为0
    private Integer pid;
    // 授权(多个用逗号分隔，如：user:list,user:create)
    private String perms;
    // 类型 0：目录 1：菜单 2：按钮
    private Integer mtype;
    // 是否可用
    private Boolean available = Boolean.FALSE;

    @Override
    public String toString() {
        return "MenuDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", pid=" + pid +
                ", perms='" + perms + '\'' +
                ", mtype=" + mtype +
                ", available=" + available +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Integer getMtype() {
        return mtype;
    }

    public void setMtype(Integer mtype) {
        this.mtype = mtype;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
