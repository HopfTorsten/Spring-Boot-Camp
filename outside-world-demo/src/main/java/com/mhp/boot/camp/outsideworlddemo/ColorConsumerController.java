package com.mhp.boot.camp.outsideworlddemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class ColorConsumerController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/color")
    public String getColor(Model model) {

        String color;
        try {
            color = restTemplate.getForObject("http://localhost:8088/color", String.class);
        } catch (Throwable ex) {
            color = "NOPE";
        }

        switch (color) {
            case "BLUE":
                model.addAttribute("color", "#4169E1");
                break;
            case "GREEN":
                model.addAttribute("color", "#7FFF00");
            default:
                model.addAttribute("color", "#DC143C");
        }
        return "color";

    }

}
