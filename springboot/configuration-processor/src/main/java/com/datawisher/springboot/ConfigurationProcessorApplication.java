package com.datawisher.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * @PropertySourcem默认application.properties会覆盖自定义properties文件中的配置
 *
 */
@SpringBootApplication
@PropertySource({"classpath:person.properties", "classpath:dog.properties"})
public class ConfigurationProcessorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationProcessorApplication.class, args);
    }

}
