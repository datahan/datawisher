package com.datawiser.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginVo {

    @NotBlank(message = "电话号码不能为空")
    private String phone;

    @NotBlank(message = "电话号码不能为空")
    private String password;
}
