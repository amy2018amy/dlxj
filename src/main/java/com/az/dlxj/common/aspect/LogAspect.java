package com.az.dlxj.common.aspect;

import com.az.dlxj.common.annotation.Log;
import com.az.dlxj.common.domain.LogDO;
import com.az.dlxj.common.service.LogService;
import com.az.dlxj.common.util.HttpContextUtils;
import com.az.dlxj.common.util.IPUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author : az
 * @Create : 2018-12-04 0:00
 * @Desc : 记录@Log注解标注的方法操作日志到数据库
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    private LogService logService;

    // 定义切点
    @Pointcut("@annotation(com.az.dlxj.common.annotation.Log)")
    public void pointCut(){}

    // 切面
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Instant start = Instant.now();
        // 执行方法
        Object result = proceedingJoinPoint.proceed();
        // 记录方法执行时长(毫秒)
        long exeTime = Duration.between(start,Instant.now()).toMillis();
        // 异步保存日志
        saveLog(proceedingJoinPoint,exeTime);

        return result;
    }

    // 异步保存日志
    void saveLog(ProceedingJoinPoint proceedingJoinPoint,long time){
        MethodSignature methodSignature = (MethodSignature)proceedingJoinPoint.getSignature();// 方法签名
        Method method = methodSignature.getMethod();

        // 记录日志
        LogDO sysLog = new LogDO();
        // 获取方法上的注解
        Log log = method.getAnnotation(Log.class);
        if(log != null){
            // i.注解上的描述
            sysLog.setOperation(log.value());
        }
        // i.请求的方法名
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        String methodName = methodSignature.getName();
        sysLog.setMethod(className+"."+methodName+"()");
        // i.请求的参数
        Object[] args = proceedingJoinPoint.getArgs();
        try {
//            String params = JSONUtils.beanToJson(args[0]).substring(0, 4999);
            sysLog.setParams(Arrays.toString(args));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // i.IP地址
        sysLog.setIp(IPUtils.getIpAddr(request));
        // i.用户名

        // ....shiro获取

        // i.日志时间
        sysLog.setTime((int)time);
        // i.系统当前时间
        sysLog.setGmtCreate(new Date());
        // 保存系统日志
        logService.save(sysLog);
    }

}
