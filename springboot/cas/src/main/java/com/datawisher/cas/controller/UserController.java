package com.datawisher.cas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JH
 */
@RestController
public class UserController {

    @GetMapping("/")
    public String index() {

        return "index";
    }
}
