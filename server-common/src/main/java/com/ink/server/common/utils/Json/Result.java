package com.ink.server.common.utils.Json;


public class Result {
    private int code;
    private String message;
    private boolean success = true;
    private Object data;
    private String token;               // 返回 token 做登录验证


    public Result setCode(Res res){
        this.code = res.code();
        return this;
    }

    public Result setCode(String resultCode){
        this.code = Integer.valueOf(resultCode);
        return this;
    }

    public boolean isSuccess(){
        return success;
    }

    public Result setSuccess(boolean success){
        this.success = success;
        return this;
    }

    public int getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }

    public Result setMessage(String message){
        this.message = message;
        return this;
    }

    public Object getData(){
        return data;
    }

    public Result setData(Object data){
        this.data = data;
        return this;
    }
//    @Override
//    public String toString() {
//        return JSON.toJSONString(this);
//    }

    public String getToken() {
        return token;
    }

    public Result setToken(String token) {
        this.token = token;
        return this;
    }

}
