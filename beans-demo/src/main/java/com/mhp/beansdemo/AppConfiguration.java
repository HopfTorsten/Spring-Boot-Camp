package com.mhp.beansdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public Logger logger() {
        return LoggerFactory.getLogger("MyLogger");
    }

    @Bean
    public ABean aBean() {
        return new ABean();
    }


}
