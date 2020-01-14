package com.mhp.boot.camp.datajpademo.controller;

import com.mhp.boot.camp.datajpademo.controller.dto.AddEmployeeRequest;
import com.mhp.boot.camp.datajpademo.model.Employee;
import com.mhp.boot.camp.datajpademo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping(value = "/employee")
    public String addEmployee(@RequestBody final AddEmployeeRequest request) {
        companyService.addEmployee(request);
        return String.format("Added employee %s to company %s", request.getEmployeeName(), request.getCompanyName());
    }

    @GetMapping(value = "/employees")
    public List<Employee> getAllEmployees(@RequestParam final String companyName) {
        return companyService.getAllEmployees(companyName);
    }

    @PutMapping(value = "/employees/retire")
    public String retireEmployees(@RequestParam final String companyName) {
        companyService.retireEmployees(companyName);
        return String.format("Sending all employees of company %s into retirement", companyName);
    }

    @DeleteMapping(value = "/close")
    public String closeCompany(@RequestParam final String companyName) {
        companyService.closeCompany(companyName);
        return String.format("Closed company %s", companyName);
    }
}
