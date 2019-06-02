package com.ink.controller.user;

import com.ink.entity.user_login;
import com.ink.entity.login.userEntity;
import com.ink.service.IUserService;
import com.ink.utils.Json.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;

/**
 * @author Created by carlos
 */

@RestController
public class loginController {
    @Autowired
    IUserService iUserService;


//    @PostMapping("/test1")
//    public String test(){
//
////        User s = iUserService.longin("123","123");
////        System.out.println("============" + s.toString());
//        return "d";
//    }
    @PostMapping(value= "/login")
    public Result login(@RequestBody userEntity userEntity, HttpServletRequest request){
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
        user_login user_login = new user_login();
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
        Result result = iUserService.longin(userEntity, ip);

        return result;
    }

   

     @PostMapping("/test/life")
     public String test(ServletRequest request){
         String id = (String) request.getAttribute("name");
         System.out.println(id);
        return "123";
     }

}
