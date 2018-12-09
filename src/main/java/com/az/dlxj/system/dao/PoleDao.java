package com.az.dlxj.system.dao;

import com.az.dlxj.system.domain.Pole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PoleDao {
    List<Pole> allPole();//查询所有坐标点
    int getPole(@Param("title") String title);//查询当前坐标编号存不存在
    int addPole(@Param("title")String title,@Param("lng")Double lng,@Param("lat")Double lat);//添加坐标点

    int circuitryById(@Param("id") String id);//查找当前id在不在路线中

    int circuitryByPole(@Param("id") String id);

    int delPole(@Param("id") String id);
}
