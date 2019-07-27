package com.ink.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletRequest;

import com.ink.model.entity.Project;
import com.ink.model.entity.User;
import com.ink.service.IUserService;
import com.ink.utils.Json.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    /**
     * 上传作品
     * @param name
     * @param patitingway
     * @param file
     * @param request
     * @return
     */
    @PostMapping("/test/user/uploadFile")
    public Result uploadFile(
                            @RequestParam(name = "name", required = false) String name,
                            @RequestParam(name = "state", required = false) String state,
                            @RequestParam(name = "label", required = false) String label,
                            @RequestParam(name = "paintingwayId", required = false) Integer paintingwayId,
                            @RequestParam(name = "image_data", required = false) MultipartFile file, 
                            ServletRequest request
                            ){
        Result result = new Result();
        String username = (String) request.getAttribute("name");
        System.out.println("------------ 上传文件 ------------");
        // 获取时间为作品创建文件夹
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        // 用于创建文件夹所用时间格式
        StringBuffer time = new StringBuffer();
        time.append(year).append(month).append(day);
        String path = iUserService.creatProjectFile(username, time);
        Integer labelId = iUserService.insertLabel(label);
        Integer user_id = iUserService.selectByUsername(username);

        if (path.equals("no")){
            System.out.println("创建失败");
        }else{
            StringBuffer upDate = new StringBuffer();
            Project project = new Project();
            upDate.append(year).append("/").append(month);
            project.setName(name);
            project.setPaintingwayId(paintingwayId);
            project.setUpDate(String.valueOf(upDate));
            project.setState(state);
            project.setLabelId(labelId);
            // project.setCategoryId(categoryId);
            project.setUserId(user_id);
            iUserService.uploadFile(file, username, project, path, String.valueOf(time));
        }

        return result;
    }
    
    @GetMapping("/user/getFollowsFans")
    public Result getFollows(@RequestParam(value = "userId", required = false) String userId) {
        Result result = new Result();


        return result;
    }

    public void upFollow(@RequestParam(value = "userId") String userId,
                        ServletRequest request){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//设置日期格式
        String testDate = df.format(new Date());//格式化当前日期
        String username = (String) request.getAttribute("name");
        Integer my_id = iUserService.selectByUsername(username);

    }
    
    /**
     * 按照 project ID 删除文件，先找到相应文件删除，然后删除数据库中信息
     * @param projectId
     * @return
     */
    @GetMapping("/test/user/deleteProject")
    public Result deleteProject(@RequestParam(value = "projectId") String projectId){
        Result result = new Result();
        Integer id = Integer.valueOf(projectId);
        boolean bool = iUserService.deleteFileByProjectId(id);
        if (bool){
            iUserService.deleteProjectId(id);
            result.setMessage("成功删除");
            return result;

        } else{
            result.setCode("201");
            result.setMessage("删除失败");
            return result;
        }

    }

    @PostMapping("/test/get")
    public Result test(){
        Result result = new Result();
        // User user = iUserService.test();
        // result.setData(user);
        Date upDate = new Date("yyyy/MM/dd");
        // System.out.println(upDate.f);
        return result;
    }

    /**
     * 返回粉丝最多的前九用户
     * @return
     */
    @GetMapping("/user/getHotUser")
    public Result getHotUser(){
        Result result = new Result();
        ArrayList list = iUserService.getHotUser();
        result.setData(list);
        return result;
    }
}