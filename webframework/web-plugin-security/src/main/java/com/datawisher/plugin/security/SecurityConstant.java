package com.datawisher.plugin.security;

/**
 * 常量接口
 */
public interface SecurityConstant {

    String REALMS = "web.plugin.security.realms";
    String REALMS_JDBC = "jdbc";
    String REALMS_CUSTOM = "custom";

    String SMART_SECURITY = "web.plugin.security.custom.class";

    String JDBC_AUTHC_QUERY = "web.plugin.security.jdbc.authc_query";
    String JDBC_ROLES_QUERY = "web.plugin.security.jdbc.roles_query";
    String JDBC_PERMISSIONS_QUERY = "web.plugin.security.jdbc.permissions_query";

    String CACHE = "web.plugin.security.cache";
}
