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
            color = restTemplate.getForObject("http://localhost:8080/color", String.class);
        } catch (Throwable ex) {
            color = "NOPE";
        }

        switch (color) {
            case "BLUE":
                model.addAttribute("color", "#4169E1");
                model.addAttribute("status", "OK");
                break;
            case "GREEN":
                model.addAttribute("color", "#7FFF00");
                model.addAttribute("status", "AUCH OK");
                break;
            case "YELLOW":
                model.addAttribute("color", "#FF8C00");
                model.addAttribute("status", "ZU LANGSAM");
                break;
            default:
                model.addAttribute("color", "#DC143C");
                model.addAttribute("status", "KAPUTT");
        }
        return "color";

    }

}
