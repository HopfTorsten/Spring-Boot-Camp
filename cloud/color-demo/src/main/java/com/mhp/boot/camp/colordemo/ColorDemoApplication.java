package com.mhp.boot.camp.colordemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ColorDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ColorDemoApplication.class, args);
    }

}

