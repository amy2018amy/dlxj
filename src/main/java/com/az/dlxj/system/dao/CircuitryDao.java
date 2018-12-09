package com.az.dlxj.system.dao;

import com.az.dlxj.system.domain.Circuitry;
import com.az.dlxj.system.domain.CircuitryPole;
import com.az.dlxj.system.domain.Pole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface CircuitryDao {
    List<Circuitry> allCircuitry();//查询所有路线

    List<CircuitryPole> CircuitryByPole(@Param("id") String id);

    Pole poleById(@Param("id") String cid);
}
