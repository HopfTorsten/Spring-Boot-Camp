package com.mhp.boot.camp.datajpademo.service;

import com.mhp.boot.camp.datajpademo.controller.dto.AddEmployeeRequest;
import com.mhp.boot.camp.datajpademo.model.Company;
import com.mhp.boot.camp.datajpademo.model.Employee;
import com.mhp.boot.camp.datajpademo.repository.CompanyRepository;
import com.mhp.boot.camp.datajpademo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void addEmployee(final AddEmployeeRequest addEmployeeRequest) {

        final Optional<Company> opt = companyRepository.findByCompanyName(addEmployeeRequest.getCompanyName());

        if(!opt.isPresent()) {
            final Company company = new Company();
            company.setCompanyName(addEmployeeRequest.getCompanyName());

            companyRepository.save(company);
        }

        final Company company = companyRepository.findByCompanyName(addEmployeeRequest.getCompanyName()).get();

        final Employee employee = new Employee();
        employee.setName(addEmployeeRequest.getEmployeeName());
        employee.setCompany(company);

        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees(final String companyName) {
        final Optional<Company> opt = companyRepository.findByCompanyName(companyName);

        if(!opt.isPresent()) {
            throw new RuntimeException(String.format("Company %s does not exist", companyName));
        }

        final Company company = opt.get();
        return company.getEmployees();
    }

    @Override
    public void retireEmployees(final String companyName) {
        final Optional<Company> opt = companyRepository.findByCompanyName(companyName);

        if(!opt.isPresent()) {
            throw new RuntimeException(String.format("Company %s does not exist", companyName));
        }

        employeeRepository.retireEmployees(opt.get());
    }

    @Override
    public void closeCompany(final String companyName) {
        final Optional<Company> opt = companyRepository.findByCompanyName(companyName);

        if(!opt.isPresent()) {
            throw new RuntimeException(String.format("Company %s does not exist", companyName));
        }

        companyRepository.delete(opt.get());
    }
}
