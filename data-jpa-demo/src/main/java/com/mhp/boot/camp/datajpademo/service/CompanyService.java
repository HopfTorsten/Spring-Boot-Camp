package com.mhp.boot.camp.datajpademo.service;

import com.mhp.boot.camp.datajpademo.controller.dto.AddEmployeeRequest;
import com.mhp.boot.camp.datajpademo.model.Employee;

import java.util.List;

public interface CompanyService {

    void addEmployee(AddEmployeeRequest employee);

    List<Employee> getAllEmployees(String companyName);

    void retireEmployees(String companyName);

    void closeCompany(String companyName);
}
