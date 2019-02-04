package com.mhp.boot.camp.aopdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopController {

    @PerformanceLogging
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

}
