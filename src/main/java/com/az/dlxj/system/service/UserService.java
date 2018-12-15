package com.az.dlxj.system.service;

import com.az.dlxj.system.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @Author : az
 * @Create : 2018-12-05 16:41
 * @Desc :
 */
public interface UserService {
    // 登录
    public User getUserByUserName(String userName);

    public List<User> getAll();
    public Long getPageDataCount();

    public List<User> list(Map<String,Object> map);
    public long count(Map<String,Object> map);

    public int save(User user);
    public User get(Integer id);

    public int remove(Integer id);

    public int batchRemove(Integer[] ids);

}
