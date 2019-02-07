package com.mhp.boot.camp.colordemo;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ColorRestController {

    int i = 0;
    @Value("${msgText:Hello World!}")
    private String msgText;

    @SneakyThrows
    @GetMapping("/color")
    public String getColor() {
        ++i;
        if (i % 3 == 0) {
            Thread.sleep(1200);
        }
        return "BLUE";
    }

    @GetMapping("/message")
    public String getMessage() {
        return msgText;
    }

}
