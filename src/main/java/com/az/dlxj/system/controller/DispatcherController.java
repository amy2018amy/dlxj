package com.az.dlxj.system.controller;

import com.az.dlxj.common.annotation.Log;
import com.az.dlxj.common.util.ShiroUtils;
import com.az.dlxj.system.util.Constants;
import com.az.dlxj.system.util.VerifyCodeUtil;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author : az
 * @Create : 2018-12-04 12:30
 * @Desc : 页面跳转
 */
@Controller
public class DispatcherController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 后台主页内容
    @GetMapping("/page/main")
    public String pageMain(){
        return "/page/main";
    }

    // 500
    @GetMapping("/500")
    public String e500(){
        return "/page/500";
    }

    // 404
    @GetMapping("/404")
    public String e404(){
        return "/page/404";
    }

    // 403
    @GetMapping("/403")
    public String e403(){
        return "/page/403";
    }

    // 后台主页框架
    @Log("请求访问主页")
    @GetMapping("/main")
    public String index(Model model){
        model.addAttribute("username", ShiroUtils.getUser().getUsername());
        return "/index";
    }

    // 获取验证码图片和文本(验证码文本会保存在HttpSession中)
    @GetMapping("/genCaptcha")
    public void genCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置页面不缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        String verifyCode = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_ALL_MIXED, 4, null);
        //将验证码放到HttpSession里面
        request.getSession().setAttribute(Constants.VALIDATE_CODE, verifyCode);
        logger.info("本次生成的验证码为[" + verifyCode + "],已存放到HttpSession中");
        //设置输出的内容的类型为JPEG图像
        response.setContentType("image/jpeg");
        BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(verifyCode, 116, 36, 5, true, new Color(249,205,173), null, null);
        //写给浏览器
        ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
    }

    // 登出
    @Log("登出")
    @GetMapping("/logout")
    String logout(){
        ShiroUtils.logout();
        return "redirect:/login";
    }

    // 登录
    @GetMapping("/login")
    public String login(){
        Subject subjct = ShiroUtils.getSubjct();
        return subjct.isAuthenticated() ? "redirect:/main" : "/page/login/login";
    }
}
