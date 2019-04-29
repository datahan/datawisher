package com.datawisher.common.base.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SystemEnum {

    /** 基础模块及系统相关 **/
    /** 处理失败 */
    FAILURE(1001, "请求处理失败"),
    /** 成功处理 */
    SUCCESS(1002, "请求处理成功"),

    /** 参数校验通过 */
    SUCCESS_FLAG(1000, "ok"),
    FAILURE_FLAG(1001, "请求参数校验未通过");

    private Integer code;
    private String message;

    /**
     * 处理成功状态码
     * @return
     */
    public static Integer success(){
        return SUCCESS.getCode();
    }

    /**
     * 参数校验成功状态码
     * @return
     */
    public static Integer successFlag(){
        return SUCCESS_FLAG.getCode();
    }

    /**
     * 处理失败状态码
     * @return
     */
    public static Integer fail(){
        return FAILURE.getCode();
    }

    /**
     * 参数校验失败状态码
     * @return
     */
    public static Integer failFlag(){
        return FAILURE_FLAG.getCode();
    }
}
