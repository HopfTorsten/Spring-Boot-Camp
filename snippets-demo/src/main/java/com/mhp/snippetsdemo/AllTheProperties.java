package com.mhp.snippetsdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AllTheProperties {

    @Autowired
    private Environment env;

    public String greetUser() {
        return env.getProperty("message.hello");
    }

}
