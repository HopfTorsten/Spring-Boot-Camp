package com.mhp.boot.camp.hateoasdemo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WifeRepo extends CrudRepository<Wife, Integer> {
}
