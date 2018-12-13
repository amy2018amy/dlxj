package com.az.dlxj.system.service.impl;

import com.az.dlxj.system.dao.CircuitryDao;
import com.az.dlxj.system.domain.Circuitry;
import com.az.dlxj.system.domain.CircuitryPole;
import com.az.dlxj.system.service.CircuitryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    //"id":"1234",
// "name":"234",
// "voltage":"234",
// "startNo":"100011",
// "endNo":"10013",
// "jihe":"10012 ",
// "arroundlength":"136公里",
// "towercount":"3"
    @Override
    public int addcirc(Map<String,Object> map) {
        Circuitry c = new Circuitry();
        c.setId(map.get("id").toString());
        c.setName(map.get("name").toString());
        c.setVoltage(Integer.parseInt(map.get("voltage").toString()));
        c.setStartNo(Integer.parseInt(map.get("startNo").toString()));
        c.setEndNo(Integer.parseInt(map.get("endNo").toString()));
        c.setJihe(map.get("jihe").toString());
        c.setLength(map.get("arroundlength").toString());
        c.setArroundlength(map.get("arroundlength").toString());
        c.setTowercount(Integer.parseInt(map.get("towercount").toString()));
        c.setState(1);
        c.setRemark("");
        int num = circuitryDao.addcirc(c);
        if(num>0){
            circuitryDao.addCircuitryPole(c.getStartNo().toString(),c.getId());
            String[] nums = c.getJihe().split(" ");
            for (int i = 0; i < nums.length; i++) {
                circuitryDao.addCircuitryPole(nums[i],c.getId());
            }
            circuitryDao.addCircuitryPole(c.getEndNo().toString(),c.getId());
        }else{
            num =500;
        }
        return num;
    }

    @Override
    public int delCirc(Integer circId) {
        int num = circuitryDao.delCirc(circId);
        if(num>0){
            num = circuitryDao.delCircPole(circId);
        }else{
            num = 0;
        }
        return num;
    }
}
