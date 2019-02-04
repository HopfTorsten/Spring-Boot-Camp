package com.mhp.bootcamp.basic3layerapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

    List<ToDo> findToDoByAssigneeAndIsActive(String assignee, Boolean active);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update ToDo t set t.isActive=false where t.id = :id ")
    void setTodoToDone(@Param("id") Integer id);
}
