package com.az.dlxj.system.controller;

import com.alibaba.fastjson.JSON;
import com.az.dlxj.common.util.R;
import com.az.dlxj.system.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : az
 * @Create : 2018-12-04 14:46
 * @Desc :
 */
@RequestMapping("/sys")
@RestController
public class SystemController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequiresPermissions("sys:user:list")
    @GetMapping("/user/list")
    public R list(){
        R r = new R();
        r.put("data",userService.getAll());
        logger.debug(JSON.toJSONString(r));
        return r;
    }



}
