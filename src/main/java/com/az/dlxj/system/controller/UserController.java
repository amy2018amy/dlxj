package com.az.dlxj.system.controller;

import com.az.dlxj.common.annotation.Log;
import com.az.dlxj.system.domain.User;
import com.az.dlxj.system.service.UserService;
import com.az.dlxj.system.util.LayuiResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author : az
 * @Create : 2018-12-08 15:39
 * @Desc :
 */
@RequestMapping("/sys/user")
@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Log("查询用户记录")
    @RequestMapping("/list.json")
    public String list(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                            @RequestParam(required = false,defaultValue = "5") Integer pageSize,
                            @RequestParam(required = false) Integer rid,
                            @RequestParam(required = false) String username){
        logger.debug("pageNum = [" + pageNum + "], pageSize = [" + pageSize + "], rid = [" + rid + "], username = [" + username + "]");
        LayuiResult result = new LayuiResult();

        Map<String, Object> map =  Maps.newHashMap();
        map.put("rid",rid);
        map.put("username",username);

        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userService.list(map);
        PageInfo<User> info = new PageInfo<>(list,pageSize);

        result.setCode(200);
        result.setMsg("");
        result.setCount(info.getTotal());
        result.setData(info.getList());

        logger.debug(result.toString());

        return result.toString();
    }

}
