package com.ink.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletRequest;

import com.ink.model.entity.Project;
import com.ink.model.entity.User;
import com.ink.service.IUserService;
import com.ink.utils.Json.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class userController{
    @Autowired
    IUserService iUserService;

    @PostMapping("/test/getDetail")
    public Result getDetail(ServletRequest request){
        Result result = new Result();

        String username = (String) request.getAttribute("name");
        User user = iUserService.getDetail(username);
        result.setCode("200");
        result.setData(user);
        System.err.println("getDetail");
        return result;
    }

    @PostMapping("/test/user/uploadFile")
    public Result uploadFile(@RequestParam(name = "image_data", required = false) MultipartFile file, ServletRequest request){
        Result result = new Result();
        String username = (String) request.getAttribute("name");

        // 获取时间为作品创建文件夹
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        StringBuffer time = new StringBuffer();
        time.append(year).append(month).append(day);
        String path = iUserService.creatProjectFile(username, time);

        Integer user_id = iUserService.selectByUsername(username);

        if (path.equals("no")){
            System.out.println("创建失败");
        }else{
            Project project = new Project();
            project.setName(username);
            project.setUpDate(String.valueOf(time));
            // project.setCategoryId(categoryId);
            project.setUserId(user_id);
            iUserService.uploadFile(file, username, project, path);
        }

        return result;
    }
    @PostMapping("/test/get")
    public Result test(){
        Result result = new Result();
        User user = iUserService.test();
        result.setData(user);
        return result;
    }
}