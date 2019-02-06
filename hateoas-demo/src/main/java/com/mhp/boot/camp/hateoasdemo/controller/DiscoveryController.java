package com.mhp.boot.camp.hateoasdemo.controller;

import com.mhp.boot.camp.hateoasdemo.security.annotations.ReadRight;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping("/")
public class DiscoveryController {

    @ReadRight
    @GetMapping
    public List<Link> discover() {
        Link wife = linkTo(WifeController.class).withRel("wifes");
        return Arrays.asList(wife);
    }


}
