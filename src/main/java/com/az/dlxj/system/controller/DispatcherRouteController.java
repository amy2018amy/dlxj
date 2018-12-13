package com.az.dlxj.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DispatcherRouteController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/addRoute")
    public String add(){
        return "/page/pole/routeLine";
    }
    @RequestMapping("/addcirc")
    public String circ(){
        return "/page/pole/addCirc";
    }
    @RequestMapping("/delcirc")
    public String aelcirc(){
        return "/page/pole/delCirc";
    }
}
