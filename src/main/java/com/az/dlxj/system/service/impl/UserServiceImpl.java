package com.az.dlxj.system.service.impl;

import com.az.dlxj.system.dao.UserDao;
import com.az.dlxj.system.domain.User;
import com.az.dlxj.system.service.UserService;
import com.az.dlxj.system.shiro.bean.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author : az
 * @Create : 2018-12-05 16:41
 * @Desc :
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByUserName(String userName){
        return  userDao.getUserByUserName(userName);
    }
}
