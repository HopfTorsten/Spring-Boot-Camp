package com.mhp.boot.camp.datajpademo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "TEAM")
public class Team {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "TEAM_NAME")
    private String teamName;

    @OneToMany(mappedBy = "team")
    @JsonIgnoreProperties({"team", "trainings"})
    private List<Person> persons;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team() {};

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
