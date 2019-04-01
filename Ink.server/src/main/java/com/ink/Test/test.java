package com.ink.Test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by carlos
 */
@RestController
public class test {




        @GetMapping(value = "/test")
        public String Test(String tt){
            System.out.println("======");
            return tt;
        }



}
