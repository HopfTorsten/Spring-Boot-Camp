package com.mhp.boot.camp.datajpademo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "E_MAIL", unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    @JsonIgnoreProperties("persons")
    private Team team;

    @ManyToMany
    @JoinTable(name = "PERSON_TRAINING",
               joinColumns = @JoinColumn(name = "PERSON_ID"),
               inverseJoinColumns = @JoinColumn(name = "TRAINING_ID"))
    @JsonIgnoreProperties("persons")
    private List<Training> trainings;

    @UpdateTimestamp
    @Column(name = "LAST_UPDATE")
    private LocalDateTime lastUpdate;

    @PrePersist
    @PreUpdate
    public void validateEmail() {
        if(email.length() == 0) {
            throw new RuntimeException("E-Mail must not be empty!");
        }
    }

    public Person(String firstName, String lastName, String email, Team team,
            List<Training> trainings) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.team = team;
        this.trainings = trainings;
    }

    public Person() {};

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }
}
