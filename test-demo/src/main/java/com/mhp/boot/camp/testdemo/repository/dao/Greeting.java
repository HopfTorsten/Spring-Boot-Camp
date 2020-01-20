package com.mhp.boot.camp.testdemo.repository.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "GREETING")
@Entity
@Data
@NoArgsConstructor
public class Greeting {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "GREETING_VALUE")
    private String greetingValue;

    public Greeting(final String greetingValue) {
        this.greetingValue = greetingValue;
    }
}
