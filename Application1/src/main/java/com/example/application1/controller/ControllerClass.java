package com.example.application1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/controller1")
public class ControllerClass {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/cntMethod1")
    public String test(){
        ResponseEntity<String> response =  restTemplate.getForEntity("http://APPLICATION2/controller2/cntMethod2",String.class);
        return response.getBody();
    }

}
