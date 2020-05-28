package com.ink.server.common.utils.response;

/**
 * @author Created by carlos
 */
public enum ApiResponseEnum {
    SUCCESS(200,"成功"),
    ERROR(400, "异常");


    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ApiResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
