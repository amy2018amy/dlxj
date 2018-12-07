package com.az.dlxj.system.shiro.realm;

import com.az.dlxj.common.util.ShiroUtils;
import com.az.dlxj.common.util.ToolUtils;
import com.az.dlxj.system.domain.User;
import com.az.dlxj.system.service.MenuDOService;
import com.az.dlxj.system.service.RoleDOService;
import com.az.dlxj.system.service.UserService;
import com.az.dlxj.system.shiro.config.ByteSourceUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.Set;

/**
 * @Author : az
 * @Create : 2018-12-05 17:27
 * @Desc :
 */
//@Component
public class LoginRealm extends AuthorizingRealm {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Lazy
    @Autowired
    private UserService userService;

    @Lazy
    @Autowired
    private MenuDOService menuDOService;

    @Lazy
    @Autowired
    private RoleDOService roleDOService;



    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        logger.info("---------------开始认证-----------------");
        //获取用户名 密码 第二种方式 
        // 1.可以把AuthenticationToken强转为UsernamePasswordToken
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();

        // 2.调用数据库的方法，从数据库中查询对应的记录
        User user = userService.getUserByUserName(username);

        // 3.根据用户的情况抛出AuthenticationException或其子类
        // 账号不存在
        if (user == null) { throw new UnknownAccountException("账号不存在"); }
        // 账号锁定
        if (2 == user.getState()) { throw new LockedAccountException("账号已被锁定,请联系管理员！"); }

//        // 4.根据用户情况，构建AuthenticationInfo并返回
//        Object principal = user;// 认证的实体信息，可以是username，也可是user（用户名）
//        Object credentials = user.getPassword();// 凭证（密码）
//        String realmName = getName();// 当前realm对象的name ， 调用父类的getName即可
        ByteSource credentialsSalt =  ByteSourceUtils.bytes(user.getSalt());// 盐值
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), credentialsSalt,getName());
        logger.debug(info.getCredentials().toString());
        logger.debug(info.getCredentialsSalt().toString());
        logger.info("---------------结束认证-----------------");
        return info;
    }

    /**
     * 授权用户权限
     * 授权的方法是在碰到<shiro:hasPermission name=''></shiro:hasPermission>标签的时候调用的
     * 它会去检测shiro框架中的权限(这里的permissions)是否包含有该标签的name值,如果有,里面的内容显示
     * 如果没有,里面的内容不予显示(这就完成了对于权限的认证.)
     *
     * shiro的权限授权是通过继承AuthorizingRealm抽象类，重载doGetAuthorizationInfo();
     * 当访问到页面的时候，链接配置了相应的权限或者shiro标签才会执行此方法否则不会执行
     * 所以如果只是简单的身份认证没有权限的控制的话，那么这个方法可以不进行实现，直接返回null即可。
     *
     * 在这个方法中主要是使用类：SimpleAuthorizationInfo 进行角色的添加和权限的添加。
     * authorizationInfo.addRole(role.getRole()); authorizationInfo.addStringPermission(p.getPermission());
     *
     * 当然也可以添加set集合：roles是从数据库查询的当前用户的角色，stringPermissions是从数据库查询的当前用户对应的权限
     * authorizationInfo.setRoles(roles); authorizationInfo.setStringPermissions(stringPermissions);
     *
     * 就是说如果在shiro配置文件中添加了filterChainDefinitionMap.put("/add", "perms[权限添加]");
     * 就说明访问/add这个链接必须要有“权限添加”这个权限才可以访问
     *
     * 如果在shiro配置文件中添加了filterChainDefinitionMap.put("/add", "roles[100002]，perms[权限添加]");
     * 就说明访问/add这个链接必须要有 "权限添加" 这个权限和具有 "100002" 这个角色才可以访问
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("---------------开始授权-----------------");
        // 获取登录用户  --  在其他地方也可通过SecurityUtils.getSubject().getPrincipals()获取用户信息
        String username = ((User) principals.getPrimaryPrincipal()).getUsername();
        // 查询用户名称
        User user = userService.getUserByUserName(username);
        // 角色字符串
        Set<String> roles = roleDOService.getRoleStrByUserId(Integer.valueOf(ShiroUtils.getUserId()+""));
        // 权限字符串
        Set<String> permissions = menuDOService.getPermsByUserId(Integer.valueOf(ShiroUtils.getUserId()+""));

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);
        info.addRoles(roles);
        logger.info(user.getUsername()+" 拥有的角色："+roles+",权限："+permissions);
        logger.info("---------------结束授权-----------------");
        return info;
    }
    public static void main(String[] args) {
        String s = ToolUtils.entryptPassword("xianlu", "a");
        System.out.println("s = " + s);
//        String hashAlgorithmName = "MD5";
//        Object credentials = "xiaoque";
//        Object salt = ByteSource.Util.bytes("a");;
//        int hashIterations = 1024;
//
//        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
//        System.out.println(result);
    }



}
