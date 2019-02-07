package com.mhp.boot.camp.colordemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ColorRestController {

    @Value("${msgText:Hello World!}")
    private String msgText;

    @GetMapping("/color")
    public String getColor() {
        return "BLUE";
    }

    @GetMapping("/message")
    public String getMessage() {
        return msgText;
    }

}
