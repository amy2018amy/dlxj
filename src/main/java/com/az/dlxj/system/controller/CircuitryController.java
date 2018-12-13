package com.az.dlxj.system.controller;

import com.alibaba.fastjson.JSON;
import com.az.dlxj.common.util.R;
import com.az.dlxj.system.domain.Circuitry;
import com.az.dlxj.system.domain.Pole;
import com.az.dlxj.system.service.CircuitryService;
import com.az.dlxj.system.service.PoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/circ")
public class CircuitryController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CircuitryService circuitryService;
    @Autowired
    private PoleService poleService;

    @RequestMapping("/allCircuitry")
    public String allCircuitry(){
        Map<String,Object> map = new HashMap<>();
        List<Circuitry> circuitryList = circuitryService.allCircuitry();
        List<Pole> allPole = poleService.allPole();
        map.put("circ",circuitryList);
        map.put("pole",allPole);
        map.put("code",200);
        return JSON.toJSONString(map);
    }
    @RequestMapping("/addcirc")
    public String addcirc(@RequestParam Map<String,Object> map){
        logger.debug(JSON.toJSONString(map));
        int code =  circuitryService.addcirc(map);
        Map<String,Object> map1 = new HashMap<>();
        map1.put("code",code);
//        logger.debug(JSON.toJSONString(c));
//        Map<String,Object> map = new HashMap<>();
//        map.put("circ",c);
//        map.put("code",200);
        return JSON.toJSONString(map1);
    }
    @RequestMapping("allCirc")
    public String allCirc(){
        Map<String,Object> map = new HashMap<>();
        List<Circuitry> circuitryList = circuitryService.allCircuitry();
        map.put("circ",circuitryList);
        map.put("code",200);
        return JSON.toJSONString(map);
    }
    @RequestMapping("/delCirc")
    public String delCirc(Integer circId){
        Map<String,Object> map = new HashMap<>();
        int num  = circuitryService.delCirc(circId);
        if(num >0){
            map.put("code",200);
        }else{
            map.put("code",500);
        }
        return JSON.toJSONString(map);
    }
}
