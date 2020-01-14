package com.mhp.boot.camp.datajpademo.repository;

import com.mhp.boot.camp.datajpademo.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {


    Optional<Company> findByCompanyName(String companyName);

}
