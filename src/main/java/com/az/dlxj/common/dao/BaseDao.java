package com.az.dlxj.common.dao;

import java.util.List;
import java.util.Map;

/**
 * @Author : az
 * @Create : 2018-11-08 22:36
 * @Desc : 抽取公共dao方法
 */
public interface BaseDao<T> {
    T get(Integer id);

    List<T> list(Map<String, Object> map);

    long count(Map<String, Object> map);

    int save(T t);

    int update(T t);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
