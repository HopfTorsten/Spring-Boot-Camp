package com.mhp.boot.camp.hateoasdemo.repo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASS")
    private String passWord;

    @Column(name = "ROLE")
    @Convert
    private List<String> roles;

}
