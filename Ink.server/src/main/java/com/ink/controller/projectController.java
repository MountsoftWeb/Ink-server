package com.ink.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.ink.model.entity.Project;
import com.ink.model.entity.appreciate;
import com.ink.model.response.projectDetailResponse;
import com.ink.service.IProjectService;
import com.ink.utils.Json.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

@RestController
public class projectController {
    @Autowired
    IProjectService iProjectService;

    @GetMapping("/project/getProjecta")
    public Result getProjecta(){
        Result result = new Result();
        Project commodity = new Project();
        
        return result;
    }

    /**
     * 按照用户名获取对应作品
     * @param request
     * @return
     */
    @GetMapping("/test/project/getProject")
    public Result getProject(ServletRequest request){
        Result result = new Result();
        String userName = (String) request.getAttribute("name");

        System.out.println(userName + " === project");

        ArrayList list = iProjectService.getProjectByUsername(userName);
//        System.out.println(list.size());
        if (list != null) {
            result.setCode("200");
            result.setMessage("OK");
            result.setData(list);
            return  result;

        }else {
            result.setCode("201");
            result.setMessage("no project");
            return result;
        }
    }

    @GetMapping("/project/getAllProject")
    public Result getAllProject(@RequestParam("c") String category,
                                @RequestParam("l") String label){
        Result result = new Result();
        System.out.println(category + "_________" + label);
        if (category.equals("undefined") || (category.equals("1") && label.equals("1"))){
            ArrayList list =  iProjectService.getAllProject();
            System.out.println(list.size());
            result.setCode("200");
            result.setData(list);
            result.setMessage("OK");
            return result;
        }else{
            ArrayList list = iProjectService.getProject(category);
            result.setData(list);
            result.setCode("200");
            return result;
        }
    }
    @GetMapping("/test/project/updataAppreciate")
    public void updataAppreciate(@RequestBody appreciate appreciate,
                                ServletRequest request) {
        String username = (String) request.getAttribute("name");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//设置日期格式
        String testDate = df.format(new Date());//格式化当前日期
        
        System.out.println(appreciate.getProjectId());
        // appreciate.setAppreciateTime(testDate);
        // if(appreciate.getStatus().equals("1")){
        //     iProjectService.updataAppreciate(appreciate);
        // }else{
        //     iProjectService.insertAppreciate(appreciate);
        // }
    }
    /**
     * 按照 作品 id 返回相关信息
     */
    @GetMapping("/project/getProjectDetail")
    public Result getProjectDetail(@RequestParam("projectId") String projectId){
        Result result = new Result();
        projectDetailResponse projectDetailResponse = iProjectService.getProjectDetail(Integer.valueOf(projectId));
        result.setData(projectDetailResponse);
        return result;
    }
    
}