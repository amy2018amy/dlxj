package com.az.dlxj.system.service.impl;

import com.az.dlxj.system.dao.RoleDODao;
import com.az.dlxj.system.service.RoleDOService;
import com.az.dlxj.system.shiro.bean.RoleDO;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @Author : az
 * @Create : 2018-12-05 22:04
 * @Desc :
 */
@Service("roleDOService")
public class RoleDOServiceImpl implements RoleDOService {

    @Autowired
    private RoleDODao roleDODao;

    @Override
    public List<RoleDO> getAll() {
        return roleDODao.getAll();
    }

    @Override
    public Set<String> getRoleStrByUserId(Integer uid) {
        List<String> roles = roleDODao.getRoleStrByUserId(uid);
        Set<String> sets = Sets.newHashSet();

        for (String role : roles) {
           sets.add(role);
        }

        return sets;
    }
}
