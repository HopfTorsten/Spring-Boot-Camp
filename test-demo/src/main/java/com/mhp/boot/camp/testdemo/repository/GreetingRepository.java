package com.mhp.boot.camp.testdemo.repository;

import com.mhp.boot.camp.testdemo.repository.dao.Greeting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GreetingRepository extends CrudRepository<Greeting, Long> {

    @Override
    List<Greeting> findAll();

}
