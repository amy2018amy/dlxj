package com.az.dlxj;

import com.alibaba.fastjson.JSON;
import com.az.dlxj.system.service.impl.MenuDOServiceImpl;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DlxjApplicationTests {

    @Autowired
    MenuDOServiceImpl menuDOService;
    @Test
    public void contextLoads() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("contentManagement",menuDOService.listMenuTree(2));
        System.out.println(JSON.toJSONString(map));
    }

}
