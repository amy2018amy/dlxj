package com.az.dlxj.system.service;

import com.az.dlxj.system.domain.User;

/**
 * @Author : az
 * @Create : 2018-12-05 16:41
 * @Desc :
 */
public interface UserService {
    // 登录
    public User getUserByUserName(String userName);


}
