package com.hitenine.shiro;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Hitenine
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultSecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);

        /*
        anon：无需认证就可以访问
        authc：必须认证
        logout: 注销后直接跳转到setLoginUrl() 不常用
        user：必须拥有 记住我 功能才使用
        perms[]：用于对某个资源的权限才能访问  perms["user:add, user:del"]
        roles[]：拥有某个角色权限才能访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();

        filterMap.put("/", "anon");
        filterMap.put("/login", "anon");
        filterMap.put("/logout", "authc");

        filterMap.put("/admin/**","authc");

        bean.setFilterChainDefinitionMap(filterMap);

        bean.setLoginUrl("/login");

        bean.setUnauthorizedUrl("/noauth");


        return bean;
    }

    /**
     * jsessionid 存在 url 中的问题
     * @return
     */
    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }

    @Bean
    public DefaultWebSecurityManager defaultSecurityManager(UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setSessionManager(sessionManager());
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }


}
