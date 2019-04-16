package com.zxf.cof;

import com.zxf.util.MyRealm;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroFilterConf {
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> map = new HashMap<>();
        // AnonymousFilter 匿名过滤器 anon
        // FormAuthenticationFilter 认证过滤器 authc
        map.put("/**","anon");
        map.put("/index.jsp","anon");
        map.put("/admin/login","anon");
        // shiroFilterFactoryBean.setLoginUrl("/main/login.jsp");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }
    @Bean
    public SecurityManager getSecurityManager(MyRealm myRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        return securityManager;
    }
    @Bean
    public MyRealm getMyRealm(CredentialsMatcher credentialsMatcher, CacheManager cacheManager){
        MyRealm myRealm = new MyRealm();
        myRealm.setCredentialsMatcher(credentialsMatcher);
        myRealm.setCacheManager(cacheManager);
        return myRealm;
    }
    @Bean
    public CredentialsMatcher getCredentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(1024);
        return credentialsMatcher;
    }

    @Bean
    public CacheManager getCacheManager(){
        CacheManager cacheManager = new EhCacheManager();
        return cacheManager;
    }

}
