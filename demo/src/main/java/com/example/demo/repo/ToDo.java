package com.example.demo.repo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "todo")
public class ToDo {
    @Column(name = "id")
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "description")
    private String description;
    @Column(name = "assignee")
    private String assignee;
    @Column(name = "isActive")
    private Boolean isActive;
}
