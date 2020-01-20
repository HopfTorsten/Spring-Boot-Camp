package com.mhp.boot.camp.datajpademo.repository;

import com.mhp.boot.camp.datajpademo.model.Company;
import com.mhp.boot.camp.datajpademo.model.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {


    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Query("UPDATE Employee e SET e.isRetired = true WHERE e.company = :company")
    void retireEmployees(@Param("company") Company company);
}
