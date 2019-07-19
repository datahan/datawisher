package com.datahan.webapp.controller;

import com.datahan.webapp.service.HomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @RequestMapping("/index")
    public String index() {

        log.info("the classic spring project.");
        homeService.print("access");
        return "index";
    }

}
