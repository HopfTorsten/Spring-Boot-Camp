package com.mhp.beansdemo;

import org.springframework.beans.factory.annotation.Value;

public class ABean {

    @Value("${message.greeting}")
    private String myVal;

    public ABean() {
        System.out.println("Hello World");
    }

    public void sayHello() {
        System.out.println(myVal);
    }

}
