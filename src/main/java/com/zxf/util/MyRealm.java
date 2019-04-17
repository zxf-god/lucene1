package com.zxf.util;

import com.zxf.dao.AdminDAO;
import com.zxf.entity.Admin;
import com.zxf.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.DomainPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;

public class MyRealm extends AuthorizingRealm {
  /*  @Resource
    private AdminService adminService;*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken)token;
        String username = upToken.getUsername();
      /*  Admin a=new Admin();
        a.setA_name(username);
        Admin admin = adminService.login(username,null);
        System.out.println(admin+"=================");*/
        AuthenticationInfo authenticationInfo = new SimpleAccount("admin","9898247bfac3a524680145b3b5e203d3", ByteSource.Util.bytes("abcd"),getName());
        return authenticationInfo;
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    //    String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
//        拿着username去获取角色   根据角色查权限
//        身份    角色      权限
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRole("super");
       authorizationInfo.addRoles(Arrays.asList("super","admin"));

//        authorizationInfo.addStringPermission("user:*");
        ArrayList<Permission> list = new ArrayList<>();
        list.add(new DomainPermission("user:update"));
        list.add(new DomainPermission("user:add"));
        authorizationInfo.addObjectPermissions(list);

        return authorizationInfo;
    }
}
