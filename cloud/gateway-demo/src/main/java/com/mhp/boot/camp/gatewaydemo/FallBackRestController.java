package com.mhp.boot.camp.gatewaydemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackRestController {
    @GetMapping("/fallback")
    public String fallback() {
        return "YELLOW";
    }

}
