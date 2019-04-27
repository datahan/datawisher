package com.datawisher.springboot.controller;

import com.datawisher.springboot.bean.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Dog dog;

    /**
     * 直接从配置文件中载入相应的值
     */
    @Value("${person.last-name}")
    private String name;

    @RequestMapping("/sayHello")
    public String sayHello() {
        // dog中的属性已经从配置文件中自动加载过了
        return "Hello " + name + " &&& " + dog.toString();
    }
}
