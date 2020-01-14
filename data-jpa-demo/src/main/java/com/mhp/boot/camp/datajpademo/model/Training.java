package com.mhp.boot.camp.datajpademo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "TRAINING")
public class Training {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "TRAINING_NAME")
    private String trainingName;

    @Column(name = "DAYS")
    private int days;

    @ManyToMany(mappedBy = "trainings")
    private List<Person> persons;

    public Training(String trainingName, int days) {
        this.trainingName = trainingName;
        this.days = days;
    }

    public Training() {};

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
