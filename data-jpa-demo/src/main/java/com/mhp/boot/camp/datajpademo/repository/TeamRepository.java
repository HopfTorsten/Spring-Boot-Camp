package com.mhp.boot.camp.datajpademo.repository;

import com.mhp.boot.camp.datajpademo.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

    @Override
    List<Team> findAll();


    Optional<Team> findByTeamName(String teamName);

}
