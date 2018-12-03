package com.az.dlxj.common.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author : az
 * @Create : 2018-11-08 22:36
 * @Desc : 抽取公共dao方法
 */
@Mapper
public interface BaseDao<T> {
    T get(Long id);

    List<T> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(T t);

    int update(T t);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
