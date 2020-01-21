package com.mhp.beansdemo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AService implements InitializingBean {

    @Autowired
    private ABean aBean;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Ich bin auch da ");
        aBean.sayHello();
    }
}
