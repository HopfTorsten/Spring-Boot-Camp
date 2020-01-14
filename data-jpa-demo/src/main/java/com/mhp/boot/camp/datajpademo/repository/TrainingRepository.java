package com.mhp.boot.camp.datajpademo.repository;

import com.mhp.boot.camp.datajpademo.model.Training;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainingRepository extends CrudRepository<Training, Long> {

    Optional<List<Training>> findByTrainingNameIn(List<String> trainingNames);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Query("UPDATE Training t SET t.trainingName = :newTrainingName WHERE t.trainingName = :currentTrainingName")
    void renameTraining(String newTrainingName, String currentTrainingName);
}
