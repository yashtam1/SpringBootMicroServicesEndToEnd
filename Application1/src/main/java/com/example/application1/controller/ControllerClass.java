package com.example.application1.controller;

import com.example.application1.service.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/controller1")
public class ControllerClass {

    @Autowired
    private ServiceClass serviceClass;

    @RequestMapping("/cntMethod1")
    public String test(){
        return serviceClass.testService();
    }

}
