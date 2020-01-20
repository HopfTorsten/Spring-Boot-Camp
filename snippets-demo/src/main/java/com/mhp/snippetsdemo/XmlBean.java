package com.mhp.snippetsdemo;

import org.springframework.beans.factory.config.PropertiesFactoryBean;

public class XmlBean {

    private PropertiesFactoryBean propertiesFactoryBean;


    public void setPropertiesFactoryBean(PropertiesFactoryBean propertiesFactoryBean) {
        this.propertiesFactoryBean = propertiesFactoryBean;
    }
}
