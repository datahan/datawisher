package com.datawiser.controller;

import com.datawiser.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author Jim Han
 */
@RestController
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger("LoginController");

    @RequestMapping("/do_login")
    public String doLogin(HttpServletResponse response, @Valid LoginVo loginVo) {
        log.info(loginVo.toString());

        return loginVo.getPhone() + loginVo.getPassword();
    }
}
