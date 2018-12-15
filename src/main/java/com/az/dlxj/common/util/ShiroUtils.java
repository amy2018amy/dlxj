package com.az.dlxj.common.util;

import com.az.dlxj.system.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

public class ShiroUtils {
    @Autowired
    private static SessionDAO sessionDAO;

    public static Subject getSubjct() {
        Subject subject = SecurityUtils.getSubject();
        return subject;
    }
    public static User getUser() {
        Object obj = getSubjct().getPrincipal();
        return (User)obj;
    }
    public static Long getUserId() {
        return Long.valueOf(getUser().getId());
    }
    public static void logout() {
        getSubjct().logout();
    }

    public static List<Principal> getPrinciples() {
        List<Principal> principals = null;
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        return principals;
    }
}
