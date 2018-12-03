package com.az.dlxj.common.service.impl;

import com.az.dlxj.common.dao.LogDao;
import com.az.dlxj.common.domain.LogDO;
import com.az.dlxj.common.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


/**
 * @Author : az
 * @Create : 2018-11-08 22:47
 * @Desc :
 */
@Service("logService")
public class LogServiceImpl implements LogService {

    @Autowired
    LogDao logMapper;

    @Async
    @Override
    public void save(LogDO logDO) {
        logMapper.save(logDO);
    }


}
