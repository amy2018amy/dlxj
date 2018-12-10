package com.az.dlxj.system.controller;

import com.alibaba.fastjson.JSON;
import com.az.dlxj.system.service.RoleDOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : az
 * @Create : 2018-12-04 14:46
 * @Desc :
 */
@RequestMapping("/sys/role")
@RestController
public class RoleDOController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoleDOService roleDOService;

    @RequestMapping("/selectData")
    public String selectData(){
        return JSON.toJSONString(roleDOService.getAll());
    }



}
