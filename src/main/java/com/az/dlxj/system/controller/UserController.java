package com.az.dlxj.system.controller;

import com.az.dlxj.common.annotation.Log;
import com.az.dlxj.common.util.R;
import com.az.dlxj.system.domain.User;
import com.az.dlxj.system.service.UserService;
import com.az.dlxj.system.util.LayuiResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Log("添加用户")
    @PostMapping("/save")
    public R add(@RequestBody User user, @RequestParam("rid") Integer rid){
        logger.debug("user = [" + user + "], rid = [" + rid + "]");
        return R.ok("添加成功");
    }

    @Log("删除用户")
    @PostMapping("/del")
    public R del(Integer id){
        logger.debug("del id:"+id);
        try {
            userService.remove(id);
        } catch (Exception e){
            return R.error("删除失败");
        }
        return R.ok("删除成功");
    }
    @Log("批量删除用户")
    @PostMapping("/dels")
    public R batchDel(@RequestParam("ids[]") Integer[] ids){
        logger.debug("batchDel id:"+ids);
        try {
            userService.batchRemove(ids);
        } catch (Exception e){
            return R.error("删除失败");
        }
        return R.ok("删除成功");
    }


}
