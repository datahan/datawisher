package com.datawisher.common.service;

public class MyService {

    public String foo() {
        String var = "one";
        if ("one".equals(var)) {
            return "foo one";
        } else {
            return "foo null";
        }
    }
}
