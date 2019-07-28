package com.ink.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletRequest;

import com.ink.service.ICommentService;
import com.ink.utils.Json.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class commentController {
    @Autowired
    ICommentService iCommentService;

    /**
     * 为作品添加评论
     * @param content
     * @param projectId
     * @param request
     * @return
     */
    @PostMapping("/test/comment/insertComment")
    public Result insertComment(@RequestParam(value = "content") String content,
                                @RequestParam(value = "projectId") String projectId,
                                ServletRequest request){

        Result result = new Result();
        String username = (String) request.getAttribute("name");
       
        boolean bool = iCommentService.insertComment(projectId, username, content);
        if (bool){
            result.setCode("200");
            result.setMessage("评论成功");
            return result;
        }else {
            result.setCode("404");
            result.setMessage("评论失败");
            return result;
        }
    }

    @GetMapping("/test/comment/getCommentList")
    public Result getCommentList(@RequestParam(value = "projectId") String projectId,
                                ServletRequest request){
        Result result = new Result();
        String username = (String) request.getAttribute("name");
        
        ArrayList list = iCommentService.getCommentList(projectId);
        result.setData(list);
        return result;
    }
}