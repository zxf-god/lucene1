package com.zxf.service;

import com.zxf.dao.AdminDAO;
import com.zxf.entity.Admin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
    @Resource
    private AdminDAO adminDAO;
    @Override
    public Admin login(String name, String password) {
        //获取安全管理器工厂
        IniSecurityManagerFactory iniSecurityManagerFactory=new
                IniSecurityManagerFactory("classpath:shiro.ini");
        //获取安全管理器
        SecurityManager securityManager=iniSecurityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        //token就是用户的令牌 包含用户的身份信息和凭证信息
        AuthenticationToken token=new UsernamePasswordToken(name,password);
        try {
            subject.login(token);
            System.out.println("认证成功！");
        } catch (AuthenticationException e) {
            System.out.println("认证失败！");
            e.printStackTrace();
        }
        boolean authenticated = subject.isAuthenticated();
        System.out.println(authenticated);
            return adminDAO.selectOne(new Admin(null,name,password));

    }
}
