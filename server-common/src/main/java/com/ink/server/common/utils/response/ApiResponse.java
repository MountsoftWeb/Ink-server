package com.ink.server.common.utils.response;

/**
 * @author Created by carlos
 */
public class ApiResponse<T> {

    private Integer code;
    private String msg;
    private T data;


    public ApiResponse(T data) {
        this.data = data;
    }

    public ApiResponse(){

    }

    public ApiResponse(ApiResponseEnum apiResponseEnum) {
        this.code = apiResponseEnum.getCode();
        this.msg = apiResponseEnum.getMsg();
//        this.data = null;
    }

    public ApiResponse(ApiResponseEnum apiResponseEnum, T data) {
        this.code = apiResponseEnum.getCode();
        this.msg = apiResponseEnum.getMsg();
        this.data = data;
    }


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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
