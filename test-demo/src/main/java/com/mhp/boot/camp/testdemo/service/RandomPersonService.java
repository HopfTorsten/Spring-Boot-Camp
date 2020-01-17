package com.mhp.boot.camp.testdemo.service;

import com.mhp.boot.camp.testdemo.dto.Person;

import java.util.List;

public interface RandomPersonService {

    List<Person> getRandomPersons(int amount);
}
