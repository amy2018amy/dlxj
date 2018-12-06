package com.az.dlxj.system.dao;

import com.az.dlxj.common.dao.BaseDao;
import com.az.dlxj.system.shiro.bean.RoleDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author : az
 * @Create : 2018-12-05 21:56
 * @Desc :
 */
@Mapper
public interface RoleDODao extends BaseDao<RoleDO> {

    public List<RoleDO> getAll();

}
