package com.datawisher.plugin.security.realm;

import com.datawisher.plugin.security.SecurityConstant;
import com.datawisher.plugin.security.WebSecurity;
import com.datawisher.plugin.security.password.Md5CredentialsMatcher;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * 基于 Web 的自定义 Realm（需要实现 WebSecurity 接口）
 */
public class WebCustomRealm extends AuthorizingRealm {

    private final WebSecurity webSecurity;

    public WebCustomRealm(WebSecurity webSecurity) {
        this.webSecurity = webSecurity;
        super.setName(SecurityConstant.REALMS_CUSTOM);
        super.setCredentialsMatcher(new Md5CredentialsMatcher());
    }

    @Override
    public AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if (token == null) {
            throw new AuthenticationException("parameter token is null");
        }

        // 通过 AuthenticationToken 对象获取从表单中提交过来的用户名
        String username = ((UsernamePasswordToken) token).getUsername();

        // 通过 WebSecurity 接口并根据用户名获取数据库中存放的密码
        String password = webSecurity.getPassword(username);

        // 将用户名与密码放入 AuthenticationInfo 对象中，便于后续的认证操作
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo();
        authenticationInfo.setPrincipals(new SimplePrincipalCollection(username, super.getName()));
        authenticationInfo.setCredentials(password);
        return authenticationInfo;
    }

    @Override
    public AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null) {
            throw new AuthorizationException("parameter principals is null");
        }

        // 获取已认证用户的用户名
        String username = (String) super.getAvailablePrincipal(principals);

        // 通过 WebSecurity 接口并根据用户名获取角色名集合
        Set<String> roleNameSet = webSecurity.getRoleNameSet(username);

        // 通过 WebSecurity 接口并根据角色名获取与其对应的权限名集合
        Set<String> permissionNameSet = new HashSet<String>();
        if (roleNameSet != null && roleNameSet.size() > 0) {
            for (String roleName : roleNameSet) {
                Set<String> currentPermissionNameSet = webSecurity.getPermissionNameSet(roleName);
                permissionNameSet.addAll(currentPermissionNameSet);
            }
        }

        // 将角色名集合与权限名集合放入 AuthenticationInfo 对象中，便于后续的授权操作
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roleNameSet);
        authorizationInfo.setStringPermissions(permissionNameSet);
        return authorizationInfo;
    }
}
