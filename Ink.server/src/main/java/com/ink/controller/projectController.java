package com.ink.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.ink.model.entity.Project;
import com.ink.model.entity.appreciate;
import com.ink.model.entity.pageBean;
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
        return result;
    }

    /**
     * 按照用户名获取对应作品
     * @param request
     * @return
     */
    @GetMapping("/test/project/getProject")
    public Result getProject(ServletRequest request,
                            @RequestParam(value = "pageNum", required = false) String pageNum){
        Result result = new Result();
        String userName = (String) request.getAttribute("name");

        System.out.println(userName + " === project");
        Integer page = Integer.parseInt((pageNum.equals("undefined") ? "1" : pageNum));
        ArrayList<Project> list = iProjectService.getProjectByUsername(userName);
        if (list != null) {
            pageBean<Project> pb = new pageBean<>(page, 9, list.size());
            
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

    @GetMapping("/project/getAllProject")
    public Result getAllProject(@RequestParam("c") String category,
                                @RequestParam("l") String label,
                                @RequestParam(value = "pageNum", required = false) String pageNum){
        Result result = new Result();
        System.out.println(category + "_________" + label);

        Integer page = Integer.parseInt((pageNum.equals("undefined") ? "1" : pageNum));
        if (category.equals("undefined") || (category.equals("1") && label.equals("1"))){
            ArrayList<Project> list =  iProjectService.getAllProject();

            pageBean<Project> pb = new pageBean<>(page, 20, list.size());
            
            pb.setList(list);
            System.out.println(list.size());
            result.setCode("200");
            result.setData(pb);
            result.setMessage("OK");
            return result;
        }else{
            ArrayList<Project> list = iProjectService.getProject(category, label);
            pageBean<Project> pb = new pageBean<>(page, 10, list.size());
            pb.setList(list);
            result.setData(pb);
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
    
    @GetMapping("/project/pageNum/")
    public Result getPage(@RequestParam("pageNum") String page,
                            @RequestParam(value =  "c", required = false) String category,
                            @RequestParam(value = "l", required = false) String label){
        Result result = new Result();
        int pageNum = Integer.parseInt((page == null ? "1" : page));
        int pageSize = 10;
        pageBean<Project> pb = iProjectService.getPageNum(pageNum, pageSize);
        result.setData(pb);
        return result;
    }
}