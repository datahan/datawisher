package com.datawisher.common.base.utils;

import com.datawisher.common.base.bean.Result;
import com.datawisher.common.base.code.SystemEnum;

public class ResultUtil {

    /**
     * 请求成功
     * @param sysRlt
     * @param result
     * @return
     */
    public static <T> Result<T> success(SystemEnum sysRlt, T result) {
        Result<T> success = new Result<T>();
        success.setSuccess(true);
        success.setMsg(sysRlt.getMessage());
        success.setReturnCode(sysRlt.getCode());
        success.setResult(result);
        return success;
    }

    /**
     * 请求成功
     * @param success
     * @param result
     */
    public static <T> void success(Result<T> success,T result) {
        success.setSuccess(true);
        success.setMsg(SystemEnum.SUCCESS.getMessage());
        success.setReturnCode(SystemEnum.SUCCESS.getCode());
        success.setResult(result);
    }

    /**
     * 请求成功
     * @param result
     * @return
     */
    public static <T> Result<T> success(T result) {
        Result<T> success = new Result<T>();
        success.setSuccess(true);
        success.setMsg(SystemEnum.SUCCESS.getMessage());
        success.setReturnCode(SystemEnum.SUCCESS.getCode());
        success.setResult(result);
        return success;
    }

    /**
     * 请求成功
     * @return
     */
    public static <T> Result<T> success() {
        Result<T> success = new Result<T>();
        success.setSuccess(true);
        success.setMsg(SystemEnum.SUCCESS.getMessage());
        success.setReturnCode(SystemEnum.SUCCESS.getCode());
        success.setResult(null);
        return success;
    }

    /**
     * 校验成功
     * @return
     */
    public static <T> Result<T> checkSuccess() {
        Result<T> success = new Result<T>();
        success.setSuccess(true);
        success.setMsg(SystemEnum.SUCCESS_FLAG.getMessage());
        success.setReturnCode(SystemEnum.SUCCESS_FLAG.getCode());
        return success;
    }

    /**
     * 请求失败
     * @param sysRlt
     * @return
     */
    public static <T> Result<T> error(SystemEnum sysRlt) {
        Result<T> error = new Result<T>();
        error.setSuccess(false);
        error.setMsg(sysRlt.getMessage());
        error.setReturnCode(sysRlt.getCode());
        return error;
    }

    /**
     * 请求失败
     * @param sysRlt
     * @return
     */
    public static <T> Result<T> error(SystemEnum sysRlt, String msg) {
        Result<T> error = new Result<T>();
        error.setSuccess(false);
        error.setMsg(msg);
        if(sysRlt != null) {
            error.setReturnCode(sysRlt.getCode());
        }
        return error;
    }

    /**
     * 请求失败
     * @return
     */
    public static <T> Result<T> error() {
        Result<T> error = new Result<T>();
        error.setSuccess(false);
        error.setMsg(SystemEnum.FAILURE.getMessage());
        error.setReturnCode(SystemEnum.FAILURE.getCode());
        return error;
    }

    /**
     * 校验失败
     * @return
     */
    public static <T> Result<T> checkError() {
        Result<T> error = new Result<T>();
        error.setSuccess(false);
        error.setMsg(SystemEnum.FAILURE_FLAG.getMessage());
        error.setReturnCode(SystemEnum.FAILURE_FLAG.getCode());
        return error;
    }
}
