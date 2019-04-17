package com.ink.service;


import com.ink.entity.User;
import com.ink.entity.User_login;
import com.ink.entity.login.userEntity;
import com.ink.utils.Json.Result;

public interface IUserService {
    Result longin(userEntity userEntity, String ip);

    boolean update(User_login user_login);

    boolean updateAvator(User user);
}
