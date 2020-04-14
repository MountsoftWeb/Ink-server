package com.ink.server.web;

import com.ink.server.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by carlos
 */
@RestController
public class DemoController {

    @Autowired
    DemoService demoService;
    @GetMapping("test")
    public String test() {
        System.out.println(demoService.test());
        return "Hello World!";
    }
}
