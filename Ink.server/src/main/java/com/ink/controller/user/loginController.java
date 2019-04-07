package com.ink.controller.user;

import com.ink.entity.User;
import com.ink.entity.User_login;
import com.ink.entity.login.UserEntity;
import com.ink.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @author Created by carlos
 */

@RestController
public class loginController {
    @Autowired
    IUserService iUserService;


    @PostMapping("/test1")
    public String test(){

//        User s = iUserService.longin("123","123");
//        System.out.println("============" + s.toString());
        return "d";
    }
    @PostMapping(value= "/login")
    public String login(@RequestBody UserEntity userEntity, HttpServletRequest request){
        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        User_login user_login = new User_login();
        System.out.println(ip);
        user_login.setLoginip(ip);

        Date data = new Date();

//        user_login.setLogintime(String.valueOf(System.currentTimeMillis()));
        user_login.setLogintime(data.toString());
        System.out.println(user_login.getLogintime());

        System.out.println("username = " + userEntity.getUsername());
        System.out.println("password = " + userEntity.getPassword());
        System.out.println("user_login = " + userEntity.toString());


        // 登录判断
        User_login user = iUserService.longin(userEntity);
        System.out.println("user = " + user);
        if (user != null){
            user.setLoginip(ip);
            user.setLogintime(data.toString());
            iUserService.update(user);
        }else {

        }

        return "1";
    }

}
