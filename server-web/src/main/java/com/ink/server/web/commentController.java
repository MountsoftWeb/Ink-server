package com.ink.server.web;

import java.util.ArrayList;

import javax.servlet.ServletRequest;

import com.ink.server.common.utils.Json.Result;
import com.ink.server.service.ICommentService;

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
        String phone = (String) request.getAttribute("name");
       
        boolean bool = iCommentService.insertComment(projectId, phone, content);
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
        String phone = (String) request.getAttribute("name");
        
        ArrayList list = iCommentService.getCommentList(projectId);
        result.setData(list);
        return result;
    }
}