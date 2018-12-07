package com.az.dlxj.system.controller;

import com.az.dlxj.common.annotation.Log;
import com.az.dlxj.common.util.R;
import com.az.dlxj.system.service.UserService;
import com.az.dlxj.system.util.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;

    @Log("登录")
    @PostMapping("/login")
    public R login(
            @RequestParam("userName") String userName,
            @RequestParam("password") String password,
            @RequestParam("checkCode") String checkCode,
            HttpSession session){
        logger.debug("userName = [" + userName + "], password = [" + password + "], checkCode = [" + checkCode + "]");

        if(StringUtils.isBlank(checkCode)){
            return  R.error("验证码不能为空");
        }
        if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)){
            return R.error("用户名或者密码不能为空");
        }
        if(session == null){
            return R.error("session超时");
        }
        String sessionCode =  (String)session.getAttribute(Constants.VALIDATE_CODE);
        if(StringUtils.isBlank(sessionCode)){
            return R.error("验证码超时");
        }
        String error="";
        if(StringUtils.isBlank(checkCode) || !sessionCode.toLowerCase().equals(checkCode.toLowerCase())){
            return R.error(1,"验证码错误");
        }else{
            // 执行登录
            Subject user = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
            try {
                user.login(token);
//            } catch (IncorrectCredentialsException e) {
//                error = "登录密码错误.";
//            } catch (ExcessiveAttemptsException e) {
//                error = "登录失败次数过多";
            } catch (LockedAccountException e) {
                error = "帐号已被锁定.";
//            } catch (DisabledAccountException e) {
//                error = "帐号已被禁用.";
//            } catch (ExpiredCredentialsException e) {
//                error = "帐号已过期.";
//            } catch (UnknownAccountException e) {
//                error = "帐号不存在";
//            } catch (UnauthorizedException e) {
//                error = "您没有得到相应的授权！";
            } catch (AuthenticationException e) {
                error = "用户或密码错误";
            }
        }
        if(StringUtils.isBlank(error)){
            return R.ok();
        }
        return R.error(error);
    }

}
