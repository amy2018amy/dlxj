package com.az.dlxj.system.service;

import com.az.dlxj.system.domain.Pole;

import java.util.List;

public interface PoleService {
    List<Pole> allPole();//获取全部坐标点
    int getPole(String title);//查询当前坐标编号存不存在
    int addPole(String title,Double lng,Double lat);//添加坐标点

    int getCircuitryByPoleId(String id);//查找当前塔杆有没有在路线集合中

    int delPole(String id);
}
