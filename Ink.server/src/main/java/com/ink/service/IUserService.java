package com.ink.service;


import com.ink.entity.User;
import com.ink.entity.user_login;
import com.ink.entity.login.userEntity;
import com.ink.utils.Json.Result;

public interface IUserService {
    Result longin(userEntity userEntity, String ip);

    boolean update(user_login user_login);

    boolean updatePicture(User user);

    String selectPicture(String username);

    User getDetail(String username);
    // 检查用户名是否重复
    boolean checkUser(String username);
    // 注册用户
    boolean registerUser(userEntity userEntity);
}
