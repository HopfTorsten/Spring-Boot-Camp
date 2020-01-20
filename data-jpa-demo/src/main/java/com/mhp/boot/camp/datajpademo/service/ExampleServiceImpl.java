package com.mhp.boot.camp.datajpademo.service;


import com.mhp.boot.camp.datajpademo.controller.dto.AddPersonRequest;
import com.mhp.boot.camp.datajpademo.model.Person;
import com.mhp.boot.camp.datajpademo.model.Team;
import com.mhp.boot.camp.datajpademo.model.Training;
import com.mhp.boot.camp.datajpademo.repository.PersonRepository;
import com.mhp.boot.camp.datajpademo.repository.TeamRepository;
import com.mhp.boot.camp.datajpademo.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TrainingRepository trainingRepository;

    @PostConstruct
    public void setUp() {
        Training training1 = new Training("Spring Framework", 2);
        trainingRepository.save(training1);

        Training training2 = new Training("Learning Kotlin", 3);
        trainingRepository.save(training2);
    }

    @Override
    public void addPerson(final AddPersonRequest addPersonRequest) {
        Optional<Team> optTeam = teamRepository.findByTeamName(addPersonRequest.getTeamName());
        Team team;

        if(!optTeam.isPresent()) {
            team = new Team(addPersonRequest.getTeamName());
            teamRepository.save(team);
        } else {
            team = optTeam.get();
        }

        Optional<List<Training>> optionalTrainings = trainingRepository.findByTrainingNameIn(addPersonRequest.getTrainings());
        List<Training> trainings = optionalTrainings.orElse(Collections.emptyList());

        final Person person = new Person(addPersonRequest.getFirstName(), addPersonRequest.getLastName(), addPersonRequest.getEmail(), team, trainings);

        personRepository.save(person);
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
}
