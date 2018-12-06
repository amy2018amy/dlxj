package com.az.dlxj.system.shiro.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author : az
 * @Create : 2018-12-05 16:18
 * @Desc :
 */
public class RoleDO implements Serializable {

    private Integer id;
    // 角色名称
    private String name;
    // 角色描述
    private String desc;
    // 是否可用，如果不可用不会添加给用户
    private Boolean available = Boolean.FALSE;
    // 角色 -- 权限 ：多对多关系
    private Set<MenuDO> menus = new HashSet<>();;

    @Override
    public String toString() {
        return "RoleDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", available=" + available +
                ", menus=" + menus +
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Set<MenuDO> getMenus() {
        return menus;
    }

    public void setMenus(Set<MenuDO> menus) {
        this.menus = menus;
    }
}
