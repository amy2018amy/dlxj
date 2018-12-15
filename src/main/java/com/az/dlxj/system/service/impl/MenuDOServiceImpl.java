package com.az.dlxj.system.service.impl;

import com.az.dlxj.common.domain.Tree;
import com.az.dlxj.common.util.BuildTree;
import com.az.dlxj.system.dao.MenuDODao;
import com.az.dlxj.system.service.MenuDOService;
import com.az.dlxj.system.shiro.bean.MenuDO;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @Author : az
 * @Create : 2018-12-05 22:04
 * @Desc :
 */
@Service("menuDOService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class MenuDOServiceImpl implements MenuDOService {

    @Autowired
    private MenuDODao menuDODao;

    @Override
    public List<MenuDO> getAll() {
        return menuDODao.getAll();
    }

    @Override
    public Set<String> getPermsByUserId(Integer uid) {
        List<String> perms = menuDODao.getPermsByUserId(uid);
        Set<String> sets = Sets.newHashSet();

        for (String perm : perms) {
            if(StringUtils.isNotBlank(perm)){
                sets.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }

        return sets;
    }

//    @Cacheable(value="menus",key = "'az_menus_'+#uid",unless = "#result == null or #result.size() == 0")
    @Cacheable(cacheNames = {"main-menus"},key="'menus_'+#uid",sync=true)
    @Override
    public List<Tree<MenuDO>> listMenuTree(Integer uid) {
        List<Tree<MenuDO>> trees = new ArrayList<Tree<MenuDO>>();
        List<MenuDO> menuDOS = menuDODao.listMenuTreeByUid(uid);

        Tree<MenuDO> tree = null;
        for (MenuDO m : menuDOS) {
            if(m.getAvailable() != 1) continue;
            tree = new Tree<>();
            tree.setTitle(m.getName());
            tree.setIcon(m.getIcon());
            tree.setHref(m.getUrl());
            tree.setId(m.getId().toString());
            tree.setParentId(m.getPid().toString());
            trees.add(tree);
        }

        List<Tree<MenuDO>> list = BuildTree.build(trees,"0");
        return list;
    }

}
