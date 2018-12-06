package com.az.dlxj.system.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.az.dlxj.system.shiro.realm.LoginRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author : az
 * @Create : 2018-12-05 15:43
 * @Desc :
 */
@Configuration
public class ShiroConfig {

    private static final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

    @Value("${spring.redis.host}")
    private String jedisHost;

    @Value("${spring.redis.port}")
    private Integer jedisPort;

    @Value("${spring.redis.password}")
    private String jedisPassword;

    /*
     * =========================================================
     * Shiro 核心配置
     * =========================================================
     */

    // SecurityManager 安全管理器；Shiro的核心
    @Bean
    public SecurityManager securityManager(@Qualifier("loginRealm")LoginRealm loginRealm){
        logger.info("- - - - - - -shiro  securityManager- - - - - - ");
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(loginRealm);
//        defaultWebSecurityManager.setRememberMeManager(rememberMeManager());
        defaultWebSecurityManager.setSessionManager(webSessionManager());
        defaultWebSecurityManager.setCacheManager(cacheManager());
        return defaultWebSecurityManager;
    }

    /*
     * =========================================================
     * Shiro spring集成
     * =========================================================
     */
    // 配置拦截器
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shirFilter(@Qualifier("loginRealm") LoginRealm loginRealm) {
        logger.info("=============ShiroConfig.shirFilter()..");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        LinkedHashMap<String, Filter> filtersMap = new LinkedHashMap<>();// 自定义拦截器
        //配置访问权限
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
//        filterChainDefinitionMap.put("/layui/**", "anon"); // 静态资源匿名访问
//        filterChainDefinitionMap.put("*.js", "anon"); // 静态资源匿名访问
//        filterChainDefinitionMap.put("*.css", "anon"); // 静态资源匿名访问
//        filterChainDefinitionMap.put("/favicon.ico", "anon"); // 静态资源匿名访问
//        filterChainDefinitionMap.put("/login", "anon");// 匿名访问
//        filterChainDefinitionMap.put("/", "anon");// 匿名访问
//        filterChainDefinitionMap.put("/genCaptcha","anon"); // 验证码
//        filterChainDefinitionMap.put("/logout", "logout"); // 用户退出，只需配置logout即可实现该功能
//        filterChainDefinitionMap.put("/**", "authc");  //其他资源都需要认证  authc 表示需要认证才能进行访问 user表示配置记住我或认证通过可以访问的地址
        filterChainDefinitionMap.put("/**", "anon");  //其他资源都需要认证  authc 表示需要认证才能进行访问 user表示配置记住我或认证通过可以访问的地址
        shiroFilterFactoryBean.setSecurityManager(securityManager(loginRealm));
        shiroFilterFactoryBean.setFilters(filtersMap);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        shiroFilterFactoryBean.setLoginUrl("/login"); // 登录的路径
        shiroFilterFactoryBean.setSuccessUrl("/main"); // 登录成功后跳转的路径
        shiroFilterFactoryBean.setUnauthorizedUrl("/403"); // 验证失败后跳转的路径
        return shiroFilterFactoryBean;
    }

    /**
     * AOP式方法级权限检查.
     * 自动创建代理类，若不添加，Shiro的注解可能不会生效。
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator creator=new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }
    // 配置 Shiro 的生命周期处理器
    @Bean
    public static LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
    // 开启Shiro的注解
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("loginRealm") LoginRealm loginRealm) {
        SecurityManager manager= securityManager(loginRealm);
        AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        return advisor;
    }
    // sessionManager
    @Bean
    public SessionManager webSessionManager(){
        DefaultWebSessionManager manager = new DefaultWebSessionManager();
        //设置session过期时间为1小时(单位：毫秒)，默认为30分钟
        manager.setGlobalSessionTimeout(60 * 60 * 1000);
        manager.setSessionValidationSchedulerEnabled(true);
        manager.setSessionDAO(redisSessionDAO());
        return manager;
    }
    // =====Redis Properties=======
    // RedisManager
    @Bean
    public RedisManager redisManager(){
        RedisManager manager = new RedisManager();
        manager.setHost(jedisHost);
        manager.setPort(jedisPort);
        //这里是用户session的时长 跟上面的setGlobalSessionTimeout 应该保持一直（上面是1个小时 下面是秒做单位的 我们设置成3600）
        manager.setExpire(60 * 60);
        manager.setPassword(jedisPassword);
        return manager;
    }
    @Bean
    public RedisSessionDAO redisSessionDAO(){
        RedisSessionDAO sessionDAO = new RedisSessionDAO();
        sessionDAO.setKeyPrefix("az_");
        sessionDAO.setRedisManager(redisManager());
        return sessionDAO;
    }
    @Bean("myCacheManager")
    public RedisCacheManager cacheManager(){
        RedisCacheManager manager = new RedisCacheManager();
        manager.setRedisManager(redisManager());
        return manager;
    }
    // 授权代理
    @Bean
    public FilterRegistrationBean delegatingFilterProxy(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        DelegatingFilterProxy proxy = new DelegatingFilterProxy();
        proxy.setTargetFilterLifecycle(true);
        proxy.setTargetBeanName("shiroFilter");
        filterRegistrationBean.setFilter(proxy);
        filterRegistrationBean.setDispatcherTypes(DispatcherType.ERROR,DispatcherType.REQUEST,DispatcherType.FORWARD,DispatcherType.INCLUDE);
        return filterRegistrationBean;
    }
    // 配置加密匹配，使用MD5的方式，进行1024次加密
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        logger.info("=============ShiroConfig.hashedCredentialsMatcher()..");
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");// 散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(1024);// 加密次数
        return hashedCredentialsMatcher;
    }
    // thymeleaf使用shiro标签
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
    @Bean
    public LoginRealm loginRealm(){
        LoginRealm loginRealm = new LoginRealm();
        loginRealm.setCachingEnabled(true);
        //启用身份验证缓存，即缓存AuthenticationInfo信息，默认false
        loginRealm.setAuthenticationCachingEnabled(false);
        //缓存AuthenticationInfo信息的缓存名称 在ehcache-shiro.xml中有对应缓存的配置
//        loginRealm.setAuthenticationCacheName("authenticationCache");
        //启用授权缓存，即缓存AuthorizationInfo信息，默认false
        loginRealm.setAuthorizationCachingEnabled(false);
        //缓存AuthorizationInfo信息的缓存名称  在ehcache-shiro.xml中有对应缓存的配置
//        loginRealm.setAuthorizationCacheName("authorizationCache");
        //配置自定义密码比较器
        loginRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return loginRealm;
    }
}
