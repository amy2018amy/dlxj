package com.az.dlxj.system.controller;

import com.alibaba.fastjson.JSON;
import com.az.dlxj.system.domain.Circuitry;
import com.az.dlxj.system.domain.Pole;
import com.az.dlxj.system.service.CircuitryService;
import com.az.dlxj.system.service.PoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/circ")
public class CircuitryController {
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
}
