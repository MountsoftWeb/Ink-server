package com.ink.server.common.utils.response;

/**
 * @author Created by carlos
 */
public class RetResponse {

    public static  <T> ApiResponse<T> ofData(T data) {
        return new ApiResponse<T>(ApiResponseEnum.SUCCESS, data);
    }

    public static ApiResponse ofMessage(ApiResponseEnum apiResponseEnum) {
        return new ApiResponse(apiResponseEnum, null);
    }
}
