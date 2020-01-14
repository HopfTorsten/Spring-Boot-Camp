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
@Table(name = "COMPANY")
public class Company {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "COMPANY_NAME", unique = true)
    private String companyName;

    @OneToMany(mappedBy="company", orphanRemoval = true)
    @JsonIgnoreProperties("company")
    private List<Employee> employees;

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(final String companyName) {
        this.companyName = companyName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(final List<Employee> employees) {
        this.employees = employees;
    }
}
