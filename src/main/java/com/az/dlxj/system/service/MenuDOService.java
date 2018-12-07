package com.az.dlxj.system.service;

import com.az.dlxj.common.domain.Tree;
import com.az.dlxj.system.shiro.bean.MenuDO;

import java.util.List;
import java.util.Set;

/**
 * @Author : az
 * @Create : 2018-12-05 22:00
 * @Desc :
 */
public interface MenuDOService {
    public List<MenuDO> getAll();

    /**
     * 查询权限字符串
     * @param uid
     * @return
     */
    public Set<String> getPermsByUserId(Integer uid);

    /**
     * 获取菜单
     * @param uid
     * @return
     */
    public List<Tree<MenuDO>> listMenuTree(Integer uid);

}
