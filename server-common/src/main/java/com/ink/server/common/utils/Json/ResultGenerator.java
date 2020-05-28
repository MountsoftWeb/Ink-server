package com.ink.server.common.utils.Json;

/**
 * @author Created by carlos
 * 响应结果生成工具
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult(){
        return new Result().setCode(Res.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static Result genSUccessResult(Object data){
        return new Result()
                .setCode(Res.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static Result genFailResult(String message){
        return new Result()
                .setCode(Res.FAIL)
                .setMessage(message);
    }
}
