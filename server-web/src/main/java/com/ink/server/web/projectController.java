package com.ink.server.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.ink.server.common.utils.Json.Result;
import com.ink.server.dao.entity.Project;
import com.ink.server.dao.entity.appreciate;
import com.ink.server.dao.entity.pageBean;
import com.ink.server.service.IProjectService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

@RestController
public class projectController {
    @Autowired
    IProjectService iProjectService;

    private Logger log = LoggerFactory.getLogger(projectController.class);
    
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
        String phone = (String) request.getAttribute("name");

        log.info("用户名:" + phone + "查找所对应作品");
        Integer page = Integer.parseInt((pageNum.equals("undefined") ? "1" : pageNum));
        ArrayList<Project> list = iProjectService.getProjectByUsername(phone);
        if (list != null) {
//            pageBean<Project> pb = new pageBean<>(page, 9, list.size());
//            pb.setList(list);
//            result.setCode("200");
//            result.setMessage("OK");
//            result.setData(pb);
            return  result;
        }else {
            result.setCode("201");
            result.setMessage("no project");
            return result;
        }
    }

    @GetMapping("/project/getAllProject")
    public Result getAllProject(@RequestParam("c") String category,
                                @RequestParam(value = "pageNum", required = false) String pageNum){
        Result result = new Result();
        log.info("查询按照分类，分类 id = " + category);
        Integer page = Integer.parseInt((pageNum.equals("undefined") ? "1" : pageNum));
        if (category.equals("undefined") || (category.equals("1"))){
            ArrayList<Project> list =  iProjectService.getAllProject();

//            pageBean<Project> pb = new pageBean<>(page, 20, list.size());
//            pb.setList(list);
            result.setCode("200");
            result.setData(null);
            result.setMessage("OK");
            return result;
        }else{
            ArrayList<Project> list = iProjectService.getProject(category);
//            pageBean<Project> pb = new pageBean<>(page, 10, list.size());
//            pb.setList(list);
            result.setData(null);
            result.setCode("200");
            return result;
        }
    }

    /**
     * 点赞作品
     * @param projectId
     * @param status
     * @param request
     */
    @GetMapping("/test/project/updateAppreciate")
    public void updateAppreciate(@RequestParam(value = "projectId") String projectId,
                                @RequestParam(value = "status") String status,
                                ServletRequest request) {
        appreciate appreciate = new appreciate();
        String phone = (String) request.getAttribute("name");
        appreciate.setProjectId(Integer.valueOf(projectId));

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//设置日期格式
        String testDate = df.format(new Date());//格式化当前日期
        appreciate.setAppreciateTime(testDate);
        // System.out.println(appreciate.getProjectId());
        log.info("用户：" + phone + "为作品 id = " + projectId + "点赞");
        if(status.equals("1") || status.equals("0")){
            appreciate.setStatus(Integer.valueOf(status));
            iProjectService.updateAppreciate(appreciate, phone);
        }else{
            iProjectService.insertAppreciate(appreciate, phone);
        }
        iProjectService.countAppreciates(projectId);
    }
    
    /**
     * 按照 作品 id 返回相关信息
     */
    @GetMapping("/test/project/getProjectDetail")
    public Result getProjectDetail(@RequestParam("projectId") String projectId,
                                    ServletRequest request){
        Result result = new Result();
        String phone = (String) request.getAttribute("name");
        log.info("查找作品详细信息，作品 id = " + projectId);
//        projectDetailResponse projectDetailResponse = iProjectService.getProjectDetail(Integer.valueOf(projectId), phone);
//        if (projectDetailResponse.getStatus() == null){
//            projectDetailResponse.setStatus(2);
//        }
//        result.setData(projectDetailResponse);
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

    /**
     * 返回粉丝点赞最多的前九的作品
     * @return
     */
    @GetMapping("/project/getHotProject") 
    public Result getHotProject(){
        Result result = new Result();
        ArrayList list = iProjectService.getHotProject();
        result.setData(list);
        return result;
    }
}