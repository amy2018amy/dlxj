package com.az.dlxj.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DispatcherRouteController {
    @RequestMapping("/addRoute")
    public String add(){
        return "/page/pole/routeLine";
    }
    @RequestMapping("/addcirc")
    public String circ(){
        return "/page/pole/addCirc";
    }
}
