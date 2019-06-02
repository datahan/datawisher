package com.datawisher.common.base.bean;

import java.io.Serializable;

public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 请求结果 true:成功 false:失败
     */
    private Boolean success=true;
    /**
     * 响应状态 1000:成功 其他:失败
     */
    private Integer returnCode=1000;
    /**
     * 响应结果
     */
    private T result;
    /**
     * 异常信息
     */
    private String exception;
    /**
     * 提示信息
     */
    private String msg="执行成功";

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", returnCode=" + returnCode +
                ", result=" + result +
                ", exception='" + exception + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
