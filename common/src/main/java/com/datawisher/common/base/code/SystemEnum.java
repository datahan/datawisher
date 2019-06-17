package com.datawisher.common.base.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SystemEnum {

    /** 基础模块及系统相关 **/
    SUCCESS_FLAG(1, "成功"),
    FAILURE_FLAG(2, "失败"),

    /** 请求参数校验通过 */
    REQUEST_PARAM_SUCCESS(1000, "请求参数校验通过"),
    /** 成功处理 */
    SUCCESS(1001, "处理成功"),

    /** 请求参数校验失败 */
    REQUEST_PARAM_FAILURE(2000, "请求参数校验未通过"),
    /** 处理失败 */
    FAILURE(2001, "处理失败");


    private Integer code;
    private String message;

}
