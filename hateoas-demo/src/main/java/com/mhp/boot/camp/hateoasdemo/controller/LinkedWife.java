package com.mhp.boot.camp.hateoasdemo.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkedWife extends ResourceSupport {

    private Integer objectId;

    private String name;

    private Integer age;

    private String breastSize;


}
