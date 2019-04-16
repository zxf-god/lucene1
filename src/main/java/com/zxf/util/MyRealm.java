package com.zxf.util;

import com.zxf.dao.AdminDAO;
import com.zxf.entity.Admin;
import com.zxf.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
public class MyRealm extends AuthorizingRealm {
    @Resource
    private AdminService adminService;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken)token;
        String username = upToken.getUsername();
        Admin a=new Admin();
        a.setA_name(username);
        Admin admin = adminService.login(username,null);
        System.out.println(admin+"=================");
        AuthenticationInfo authenticationInfo = new SimpleAccount(admin.getA_name(),admin.getA_password(),getName());
        return authenticationInfo;
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
//        根据主题查询角色  根据角色查权限
//        主题    角色      权限
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRole("admin");
        authorizationInfo.addStringPermission("admin:select");
        authorizationInfo.addStringPermission("admin:add");
        authorizationInfo.addStringPermission("admin:update");
        System.out.println("---------------------------");
        return authorizationInfo;
    }
}
