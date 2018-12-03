package com.az.dlxj.system.controller;

import com.az.dlxj.common.annotation.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author : az
 * @Create : 2018-12-04 0:43
 * @Desc :
 */
@Controller
public class LoginController {

    @Log("登录")
    @ResponseBody
    @GetMapping("/login")
    public String login(){
        return "Hello World";
    }

}
