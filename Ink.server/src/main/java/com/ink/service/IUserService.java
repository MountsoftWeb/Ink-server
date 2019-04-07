package com.ink.service;


import com.ink.entity.User;
import com.ink.entity.User_login;
import com.ink.entity.login.UserEntity;

public interface IUserService {
    User_login longin(UserEntity userEntity);

    Boolean update(User_login user_login);
}
