package com.ink.controller;

import java.util.ArrayList;
import java.util.List;

import com.ink.model.entity.Project;
import com.ink.service.IProjectService;
import com.ink.utils.Json.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        commodity.setId(12);
        commodity.setName("name");
        Project commodity2 = new Project();
        commodity2.setId(13);
        commodity2.setName("ds");


        ArrayList list = new ArrayList();

        list.add(commodity);
        list.add(commodity2);
        list.add(commodity);
        list.add(commodity);
        list.add(commodity);

        result.setCode("200");

        result.setMessage("success");
        result.setData(list);
        return result;
    }

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
        
 

        // return result;
    }
}