package com.mhp.boot.camp.hateoasdemo.repo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Data
@Entity
@Table(name = "WIFE")
public class Wife {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "BREAST_SIZE")
    private String breastSize;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "NICK_NAME")
    private String nickName;


}
