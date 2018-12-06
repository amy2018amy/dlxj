package com.az.dlxj.system.service.impl;

import com.az.dlxj.system.dao.MenuDODao;
import com.az.dlxj.system.service.MenuDOService;
import com.az.dlxj.system.shiro.bean.MenuDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : az
 * @Create : 2018-12-05 22:04
 * @Desc :
 */
@Service("menuDOService")
public class MenuDOServiceImpl implements MenuDOService {

    @Autowired
    private MenuDODao menuDODao;

    @Override
    public List<MenuDO> getAll() {
        return menuDODao.getAll();
    }
}
