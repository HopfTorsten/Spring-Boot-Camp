package com.mhp.boot.camp.datajpademo.repository;

import com.mhp.boot.camp.datajpademo.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Override
    List<Person> findAll();


}
