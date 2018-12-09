package com.az.dlxj.system.controller;

import com.alibaba.fastjson.JSON;
import com.az.dlxj.system.domain.Pole;
import com.az.dlxj.system.service.PoleService;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/route")
public class RouteLineController {
    @Autowired
    private PoleService poleService;

    @RequestMapping("/allRoute")
    public String allRoute(){
        List<Pole> allPole = poleService.allPole();
        Map<String,Object> map = new HashMap<>();
        map.put("pole",allPole);
        map.put("code",200);
        return JSON.toJSONString(map);
    }
    @RequestMapping("/addPole")
    public String addPole(Double lng,Double lat,String title){
        Map<String,Object> map = new HashMap<>();
        int result = poleService.getPole(title);
        if(result>0){
            map.put("code",404);
        }else{
            map.put("code",200);
            poleService.addPole(title,lng,lat);
        }
        return JSON.toJSONString(map);
    }
    @RequestMapping("/delPole")
    public String delPole(@RequestParam("id") String id){
        Map<String,Object> map= new HashMap<>();
        int result = poleService.getCircuitryByPoleId(id);
        if(result>0){
            map.put("code",404);
        }else{
            poleService.delPole(id);
            map.put("code",200);
        }
        return JSON.toJSONString(map);
    }

}
