package com.az.dlxj.system.controller;

import com.az.dlxj.common.annotation.Log;
import com.az.dlxj.common.util.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author : az
 * @Create : 2018-12-04 0:43
 * @Desc : 登录
 */
@RestController
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Log("登录")
    @PostMapping("/login")
    public R login(
            @RequestParam("userName") String userName,
            @RequestParam("password") String password,
            @RequestParam("checkCode") String checkCode,
            HttpSession session){

        System.out.println("userName = [" + userName + "], password = [" + password + "], checkCode = [" + checkCode + "]");
        if("az".equals(userName)){
            return R.ok();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return R.error("登录失败");
    }

}
