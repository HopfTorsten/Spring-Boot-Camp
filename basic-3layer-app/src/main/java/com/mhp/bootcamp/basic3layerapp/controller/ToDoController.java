package com.mhp.bootcamp.basic3layerapp.controller;

import com.mhp.bootcamp.basic3layerapp.service.SimpleTodo;
import com.mhp.bootcamp.basic3layerapp.service.TodoService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@RestController("/todo")
public class ToDoController {

    private final TodoService todoService;

    public ToDoController(@Autowired TodoService todoService) {
        this.todoService = todoService;
    }


    @PostMapping
    public ResponseEntity<SimpleTodo> createToDo(@RequestBody CreateToDoRequest request) {
        return ResponseEntity.status(201).body(todoService.createTodo(request.getAssignee(), request.getDescription()));
    }

    @GetMapping
    public ResponseEntity<List<SimpleTodo>> getToDosFor(@RequestParam("name") String name) {
        return ResponseEntity.ok(todoService.getToDosOf(name));
    }

    @PutMapping("/todo/{id}")
    public ResponseEntity<?> setToDoToDone(@PathVariable("id") Integer id) {
        todoService.setToDone(id);
        return ResponseEntity.ok(null);
    }

    @Data
    private static class CreateToDoRequest {
        @NotNull
        private String assignee;

        @NotNull
        @Size(min = 5, max = 255)
        private String description;
    }
}
// {\"assignee\":\"Torsten\",\"description:\":\"Bier trinken\"}