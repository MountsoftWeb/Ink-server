package com.ink.server.service;

import org.springframework.stereotype.Service;

/**
 * @author Created by carlos
 */
@Service
public class DemoServiceImpl implements DemoService {

    public String test() {
        return "hello world";
    }
}
