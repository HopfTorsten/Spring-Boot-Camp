package com.mhp.bootcamp.basic3layerapp.service;

import java.util.List;

public interface TodoService {
    public SimpleTodo createTodo(String assignee, String description);

    public void setToDone(int id);

    public List<SimpleTodo> getToDosOf(String assignee);

}
