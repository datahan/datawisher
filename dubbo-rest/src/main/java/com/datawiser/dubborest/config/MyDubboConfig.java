package com.datawiser.dubborest.config;

import com.alibaba.dubbo.config.*;
import com.datawiser.dubborest.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyDubboConfig {

    /**
     * <dubbo:application name="dubbo-provider"/>
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-provider");
        return applicationConfig;
    }


    /**
     * <dubbo:registry id="zkregistry" address="zookeeper://127.0.0.1:2181"/>
     */
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setId("zkregistry");
        registryConfig.setAddress("127.0.0.1:2181");
        return registryConfig;
    }

    /**
     * <dubbo:protocol name="rest" prot="8080" server="netty" contextpath="services" />
     */
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("rest");
        protocolConfig.setPort(8080);
        protocolConfig.setServer("netty");
        return protocolConfig;
    }

    @Bean
    public ServiceConfig<UserService> userServiceConfig(UserService userService) {
        ServiceConfig<UserService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(userService);
        serviceConfig.setVersion("1.0.0");

        MethodConfig method1 = new MethodConfig();
        method1.setName("queryUserById");
        method1.setTimeout(1000);

        MethodConfig method2 = new MethodConfig();
        method2.setName("updateUser");
        method2.setTimeout(1000);

        MethodConfig method3 = new MethodConfig();
        method3.setName("deleteUserByIds");
        method3.setTimeout(1000);

        List<MethodConfig> methods = new ArrayList<>();
        methods.add(method1);
        methods.add(method2);
        methods.add(method3);
        serviceConfig.setMethods(methods);

        // ProviderConfig
        // MonitorConfig

        return serviceConfig;
    }
}
