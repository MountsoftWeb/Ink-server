package com.ink.controller;

import java.util.ArrayList;

import com.ink.entity.Project;
import com.ink.service.IProjectService;
import com.ink.utils.Json.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

@RestController
public class projectController {
    @Autowired
    IProjectService iProjectService;

    @GetMapping("/project/getProject")
    public Result getProject(){
        Result result = new Result();
        Project commodity = new Project();
        commodity.setId(12);
        commodity.setName("name");
        commodity.setPrice(21.0);
        Project commodity2 = new Project();
        commodity2.setId(13);
        commodity2.setName("ds");
        commodity2.setPrice(32.0);
        

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

    @PostMapping("/project/getProjecta")
    public Result getProjecta(ServletRequest request){
        Result result = new Result();
        String userName = (String) request.getAttribute("name");



        ArrayList list = iProjectService.getProjectByUsername("1");
//        System.out.println(list.size());
        if (list != null) {
            result.setCode("200");
            result.setMessage("OK");
            result.setData(list);
        }else {
            result.setCode("201");
            result.setMessage("no project");
            return result;
        }
        return  result;
    }
}