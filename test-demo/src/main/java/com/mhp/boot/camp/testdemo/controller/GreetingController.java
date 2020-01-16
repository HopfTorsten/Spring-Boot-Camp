package com.mhp.boot.camp.testdemo.controller;

import com.mhp.boot.camp.testdemo.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greetMe")
    public List<String> sayHello() {
        return greetingService.greetMe();
    }

}
