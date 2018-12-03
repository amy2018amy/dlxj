package com.az.dlxj.common.service;

import com.az.dlxj.common.domain.LogDO;
import org.springframework.stereotype.Service;

/**
 * @Author : az
 * @Create : 2018-11-08 22:42
 * @Desc :
 */
@Service
public interface LogService {
    void save(LogDO logDO);
}
