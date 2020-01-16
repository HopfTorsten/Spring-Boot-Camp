package com.mhp.boot.camp.testdemo.service;

import com.mhp.boot.camp.testdemo.dto.Person;
import com.mhp.boot.camp.testdemo.repository.GreetingRepository;
import com.mhp.boot.camp.testdemo.repository.dao.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Autowired
    private RandomPersonService randomPersonService;

    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public List<String> greetMe() {
        final Person person = randomPersonService.getRandomPerson();

        final String greeting = String.format("Hello! I am %s %s (%s) from %s!",
                                              person.getName(),
                                              person.getSurname(),
                                              person.getGender(),
                                              person.getRegion());

        greetingRepository.save(new Greeting(greeting));

        return greetingRepository.findAll().stream().map(entity -> entity.getGreetingValue()).collect(Collectors.toList());
    }


}
