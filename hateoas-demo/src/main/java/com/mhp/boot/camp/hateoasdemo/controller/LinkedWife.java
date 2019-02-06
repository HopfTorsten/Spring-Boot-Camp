package com.mhp.boot.camp.hateoasdemo.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LinkedWife extends ResourceSupport {

    private Integer objectId;

    private String name;

    private Integer age;

    private String breastSize;


}
