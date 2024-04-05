package com.example.application1.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceClass {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @CircuitBreaker(name="LearnCB",fallbackMethod = "testServiceFallback")
    @Retry(name = "LearnCB")
    @RateLimiter(name = "LearnCB")
    public String testService(){
        System.out.println("Inside testService");
        String response =  restTemplate.getForObject("http://APPLICATION2/controller2/cntMethod2",String.class);

        //Return that Communication done.
        kafkaTemplate.send("app1_to_app2","Communication done from app1 to app2");
        System.out.println("Kafka sent message");
        return response;
    }

    public String testServiceFallback(Exception ex){
        System.out.println("Inside fallback");
        return "Microservice Down";
    }
}
