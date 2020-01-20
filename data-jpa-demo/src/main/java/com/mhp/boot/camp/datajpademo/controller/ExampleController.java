package com.mhp.boot.camp.datajpademo.controller;


import com.mhp.boot.camp.datajpademo.controller.dto.AddPersonRequest;
import com.mhp.boot.camp.datajpademo.model.Person;
import com.mhp.boot.camp.datajpademo.model.Team;
import com.mhp.boot.camp.datajpademo.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExampleController {

    @Autowired
    private ExampleService exampleService;

    @PostMapping(value = "/person")
    public String addEmployee(@RequestBody final AddPersonRequest request) {
        exampleService.addPerson(request);
        return "OK";
    }

    @GetMapping(value = "/persons")
    public List<Person> getPerson() {
        return exampleService.getAllPersons();
    }

    @GetMapping(value = "/teams")
    public List<Team> getTeams() {
        return exampleService.getAllTeams();
    }
}
