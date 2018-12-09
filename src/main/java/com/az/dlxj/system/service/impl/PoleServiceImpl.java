package com.az.dlxj.system.service.impl;

import com.az.dlxj.system.dao.PoleDao;
import com.az.dlxj.system.domain.Pole;
import com.az.dlxj.system.service.PoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoleServiceImpl implements PoleService {
    @Autowired
    private PoleDao poleDao;

    @Override
    public List<Pole> allPole() {
        return poleDao.allPole();
    }

    @Override
    public int getPole(String title) {
        return poleDao.getPole(title);
    }

    @Override
    public int addPole(String title, Double lng, Double lat) {
        return poleDao.addPole(title,lng,lat);
    }

    @Override
    public int getCircuitryByPoleId(String id) {
        int result = poleDao.circuitryById(id);
        int num = 0;
        if(result>0){
            num = 1;
        }else{
            result = poleDao.circuitryByPole(id);
            if(result>0){
                num =1;
            }else{
                num = 0;
            }
        }
        return num;
    }

    @Override
    public int delPole(String id) {
        return poleDao.delPole(id);
    }
}
