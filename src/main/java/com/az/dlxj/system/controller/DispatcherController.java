package com.az.dlxj.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author : az
 * @Create : 2018-12-04 12:30
 * @Desc : 页面跳转
 */
@Controller
public class DispatcherController {

    // 后台主页内容
    @GetMapping("/page/main")
    public String pageMain(){
        return "page/main";
    }

    // 404
    @GetMapping("/404")
    public String notFound(){
        return "page/404";
    }

    // 登录
    @GetMapping("/login")
    public String login(){
        return "page/login/login";
    }

    // 后台主页框架
    @GetMapping("/main")
    public String index(){
        return "index";
    }
}
