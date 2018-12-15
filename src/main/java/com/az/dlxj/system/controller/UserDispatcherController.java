package com.az.dlxj.system.controller;

import com.az.dlxj.system.service.RoleDOService;
import com.az.dlxj.system.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @Author : az
 * @Create : 2018-12-09 15:51
 * @Desc :
 */

@RequestMapping("/sys/user")
@Controller
public class UserDispatcherController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private UserService userService;
    @Autowired
    private RoleDOService roleDOService;

    // ========User
    @GetMapping("/list.html")
    public String userList(){
        return "/page/sys/user/list";
    }
    @GetMapping("/add.html")
    public String addUser(){
        return "/page/sys/user/add";
    }
    @GetMapping("/edit.html/{id}")
    public String editUser(@PathVariable Integer id, Map<String,Object> map){
        map.put("roles", roleDOService.getAll());
        map.put("user",userService.get(id));
        return "/page/sys/user/edit";
    }

}
