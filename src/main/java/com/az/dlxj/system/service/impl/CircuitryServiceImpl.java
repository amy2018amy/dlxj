package com.az.dlxj.system.service.impl;

import com.az.dlxj.system.dao.CircuitryDao;
import com.az.dlxj.system.domain.Circuitry;
import com.az.dlxj.system.domain.CircuitryPole;
import com.az.dlxj.system.service.CircuitryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircuitryServiceImpl implements CircuitryService {
    @Autowired
    private CircuitryDao circuitryDao;

    @Override
    public List<Circuitry> allCircuitry() {
        List<Circuitry> list = circuitryDao.allCircuitry();
        for (Circuitry c:list){
            List<CircuitryPole> CircuitryPoleList = circuitryDao.CircuitryByPole(c.getId());
            for (CircuitryPole cp :CircuitryPoleList){
                cp.setPole(circuitryDao.poleById(cp.getPid()));
            }
            c.setAllPole(CircuitryPoleList);
        }
        return list;
    }
}
