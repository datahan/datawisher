package com.datawisher.plugin.security.realm;

import com.datawisher.plugin.security.SecurityConfig;
import com.datawisher.plugin.security.password.Md5CredentialsMatcher;
import com.datawisher.webframework.core.helper.DatabaseHelper;
import org.apache.shiro.realm.jdbc.JdbcRealm;


/**
 * 基于 Web 的 JDBC Realm（需要提供相关 web.plugin.security.jdbc.* 配置项）
 */
public class WebJdbcRealm extends JdbcRealm {

    public WebJdbcRealm() {
        super.setDataSource(DatabaseHelper.getDataSource());
        super.setAuthenticationQuery(SecurityConfig.getJdbcAuthcQuery());
        super.setUserRolesQuery(SecurityConfig.getJdbcRolesQuery());
        super.setPermissionsQuery(SecurityConfig.getJdbcPermissionsQuery());
        super.setPermissionsLookupEnabled(true);
        super.setCredentialsMatcher(new Md5CredentialsMatcher());
    }
}
