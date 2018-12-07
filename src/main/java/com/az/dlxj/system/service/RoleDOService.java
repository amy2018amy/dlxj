package com.az.dlxj.system.service;

import com.az.dlxj.system.shiro.bean.RoleDO;

import java.util.List;
import java.util.Set;

/**
 * @Author : az
 * @Create : 2018-12-05 22:00
 * @Desc :
 */
public interface RoleDOService {
    public List<RoleDO> getAll();
    public Set<String> getRoleStrByUserId(Integer uid);
}
