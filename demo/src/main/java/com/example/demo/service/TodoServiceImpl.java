package com.example.demo.service;

import com.example.demo.repo.ToDo;
import com.example.demo.repo.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
        /*Package*/ class TodoServiceImpl implements TodoService {

    private final ToDoRepository todoRepo;

    public TodoServiceImpl(@Autowired ToDoRepository todoRepo) {
        this.todoRepo = todoRepo;
    }

    @Override
    public SimpleTodo createTodo(String assignee, String description) {
        ToDo todo = new ToDo();
        todo.setAssignee(assignee);
        todo.setDescription(description);
        todo.setIsActive(true);
        todo = todoRepo.save(todo);

        // map to return structure
        SimpleTodo simpleTodo = new SimpleTodo(todo.getId(), todo.getAssignee(), todo.getDescription());


        return simpleTodo;
    }

    @Override
    public void setToDone(int id) {
        todoRepo.setTodoToDone(id);
    }

    @Override
    public List<SimpleTodo> getToDosOf(String assignee) {

        List<ToDo> toDos = todoRepo.findToDoByAssigneeAndIsActive(assignee, Boolean.TRUE);

        List<SimpleTodo> simpleTodos = toDos.stream()//
                .map(todo -> new SimpleTodo(todo.getId(), todo.getAssignee(), todo.getDescription()))//
                .collect(Collectors.toList());//

        return simpleTodos;
    }

}
