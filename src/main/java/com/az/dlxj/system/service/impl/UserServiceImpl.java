package com.az.dlxj.system.service.impl;

import com.az.dlxj.system.dao.UserDao;
import com.az.dlxj.system.domain.User;
import com.az.dlxj.system.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author : az
 * @Create : 2018-12-05 16:41
 * @Desc :
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByUserName(String userName){
        return  userDao.getUserByUserName(userName);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public Long getPageDataCount() {
        return userDao.getPageDataCount();
    }

    @Override
    public List<User> list(Map<String, Object> map) {
        logger.info("（User）执行查询list....");
        return userDao.list(map);
    }

    @Override
    public long count(Map<String, Object> map) {
        return userDao.count(map);
    }

    @Override
    public int save(User user) {
        logger.info("(User)执行添加add....");
        userDao.save(user);

        return 0;
    }

    @Override
    public User get(Integer id) {
        return userDao.get(id);
    }

    @Override
    public int remove(Integer id) {
        logger.info("(User)执行删除....");
        return userDao.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return userDao.batchRemove(ids);
    }

    @Override
    public int update(User user) {
        logger.info("(User)执行修改...");
        return userDao.update(user);
    }
}
