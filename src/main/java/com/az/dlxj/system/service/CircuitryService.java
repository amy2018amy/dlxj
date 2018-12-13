package com.az.dlxj.system.service;

import com.az.dlxj.system.domain.Circuitry;

import java.util.List;
import java.util.Map;

public interface CircuitryService {
    List<Circuitry> allCircuitry();//查询所有路线

    int addcirc(Map<String,Object> map);//添加路线

    int delCirc(Integer circId);//删除路线
}
