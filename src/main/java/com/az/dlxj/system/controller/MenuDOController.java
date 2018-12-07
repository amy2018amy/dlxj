package com.az.dlxj.system.controller;

import com.alibaba.fastjson.JSON;
import com.az.dlxj.common.util.ShiroUtils;
import com.az.dlxj.system.domain.User;
import com.az.dlxj.system.service.MenuDOService;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author : az
 * @Create : 2018-12-04 14:46
 * @Desc :
 */
@RequestMapping("/sys/menu")
@RestController
public class MenuDOController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MenuDOService menuDOService;

    @RequestMapping("/navs.json")
    public String navs(){
        User user = ShiroUtils.getUser();
        Map<String, Object> map = Maps.newHashMap();
        map.put("contentManagement",menuDOService.listMenuTree(user.getId()));
        logger.debug(JSON.toJSONString(map));
        return JSON.toJSONString(map);
    }



}
