package com.example.Application2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller2")
public class ControllerClass {

    @RequestMapping("/cntMethod2")
    public String cntMethod(){
        return "Controller2 Method changed";
    }
}
