package com.ink.controller;

import java.util.ArrayList;

import com.ink.entity.Commodity;
import com.ink.utils.Json.Result;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class tradingController {

    @GetMapping("/trading/getCommodity")
    public Result getCommunity(){
        Result result = new Result();
        Commodity commodity = new Commodity();
        commodity.setId(12);
        commodity.setName("name");
        commodity.setPrice(21.0);
        Commodity commodity2 = new Commodity();
        commodity2.setId(13);
        commodity2.setName("ds");
        commodity2.setPrice(32.0);

        ArrayList list = new ArrayList();

        list.add(commodity);
        list.add(commodity2);
        list.add(commodity);
        result.setCode("200");

        result.setMessage("success");
        result.setData(list);
        return result;
    }
}