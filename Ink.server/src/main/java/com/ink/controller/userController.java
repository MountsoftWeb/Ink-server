package com.ink.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletRequest;

import com.ink.model.entity.Project;
import com.ink.model.entity.User;
import com.ink.model.entity.follow;
import com.ink.model.entity.pageBean;
import com.ink.service.IUserService;
import com.ink.utils.Json.Result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger log = LoggerFactory.getLogger(userController.class);
    /**
     * 获取用户基本信息
     * @param request
     * @return
     */
    @PostMapping("/test/getDetail")
    public Result getDetail(ServletRequest request){
        Result result = new Result();
        String username = (String) request.getAttribute("name");
        log.info("获取用户：" + username + "   基本信息");
        User user = iUserService.getDetail(username);
        result.setCode("200");
        result.setData(user);
        
        return result;
    }

    @GetMapping("/test/personal/getUserDetailByUserId")
    public Result get(@RequestParam(value = "userId") String userId,
                        @RequestParam(value = "pageNum", required = false) String pageNum) {
        Result result = new Result();
        Integer id = Integer.valueOf(userId);

        Integer page = Integer.parseInt((pageNum.equals("undefined") ? "1" : pageNum));
        ArrayList list = iUserService.getUserDeatilByUserId(id);

        if (list != null) {
            pageBean<Project> pb = new pageBean<>(page, 12, list.size());
            pb.setList(list);
            result.setCode("200");
            result.setMessage("OK");
            result.setData(pb);
            return  result;

        }else {
            result.setCode("201");
            result.setMessage("no project");
            return result;
        }



    }

    @GetMapping("/test/personal/getPersonalPageNum")
    public Result getPersonalPageNum(@RequestParam("userId") String userId,
                                    @RequestParam("pageNum") String page){
        Result result = new Result();
        int pageNum = Integer.parseInt((page.equals("undefined") ? "1" : page));
        int id = Integer.valueOf(userId);
        int pageSize = 12;
        pageBean<Project> pb = iUserService.getPageNum(id, pageNum, pageSize);
        result.setData(pb);
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
                            @RequestParam(name = "category", required = false) String category,
                            @RequestParam(name = "label", required = false) String label,
                            @RequestParam(name = "paintingwayId", required = false) Integer paintingwayId,
                            @RequestParam(name = "image_data", required = false) MultipartFile file, 
                            ServletRequest request
                            ){
        Result result = new Result();
        String username = (String) request.getAttribute("name");
        log.info("用户:" + username + "上传作品");
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
        Integer categoryId = Integer.valueOf(category);
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
            project.setCategoryId(categoryId);
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

    /**
     * 获取登录用户相关的关注与粉丝     0： 关注 
     *                             1： 粉丝
     * @param request
     * @param type
     * @param pageNum
     * @return
     */
    @GetMapping("/test/user/getFollows")
    public Result getFollowsFans(ServletRequest request,
                                @RequestParam(value = "type", required = false) String type,
                                @RequestParam(value = "pageNum", required = false) String pageNum){
        Result result = new Result();
        String id = (String) request.getAttribute("name");
        Integer page = Integer.parseInt((pageNum.equals("undefined") ? "1" : pageNum));
        ArrayList list = iUserService.getFollowsFans(id, type);
        pageBean<Project> pb = new pageBean<>(page, 12, list.size());
        pb.setList(list);
        result.setCode("200");
        
        result.setMessage(type);
        result.setData(pb);
        return  result;
        
    }

    @GetMapping("/test/user/updataFollow")
    public Result upFollow(@RequestParam(value = "userId") String userId,
                            @RequestParam(value = "userFollowStatus") String userFollowStatus,
                        ServletRequest request){
        Result result = new Result();

        // System.out.println(user);
        String username = (String) request.getAttribute("name");
        Integer myId = iUserService.selectByUsername(username);
        Integer user = Integer.valueOf(userId);
        Integer status = Integer.valueOf(userFollowStatus);
        follow follow = new follow();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//设置日期格式
        String testDate = df.format(new Date());//格式化当前日期
        follow.setTime(testDate);
        boolean bool;
        if(userFollowStatus.equals("1") || userFollowStatus.equals("0")){
            follow.setUserId(user);
            follow.setFollowId(myId);
            follow.setStatus(status);
            bool = iUserService.updataFollow(follow);
        }else{
            // iProjectService.insertAppreciate(appreciate, username);
            follow.setFollowId(myId);
            follow.setUserId(user);
            follow.setTime(testDate);
            bool = iUserService.insertFollow(follow);
        }
        if (bool){
            result.setCode("200");
            result.setMessage("更新成功");
        }else {
            result.setCode("200");
            result.setMessage("更新成功");
        }
        return result;
        
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
     * 返回粉丝最多的前九用户           待完善
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