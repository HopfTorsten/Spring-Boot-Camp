package com.mhp.boot.camp.datajpademo.service;

import com.mhp.boot.camp.datajpademo.controller.dto.AddPersonRequest;
import com.mhp.boot.camp.datajpademo.model.Person;
import com.mhp.boot.camp.datajpademo.model.Team;

import java.util.List;

public interface ExampleService {

    void addPerson(AddPersonRequest addPersonRequest);
    List<Person> getAllPersons();
    List<Team> getAllTeams();
}
