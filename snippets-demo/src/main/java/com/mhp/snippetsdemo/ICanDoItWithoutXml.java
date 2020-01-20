package com.mhp.snippetsdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ICanDoItWithoutXml {
    @Autowired
    private NoXmlNeeded noXmlNeeded;
}
