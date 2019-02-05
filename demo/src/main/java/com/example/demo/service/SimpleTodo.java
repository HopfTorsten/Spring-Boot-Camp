package com.example.demo.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SimpleTodo {
    private final int id;
    private final String assignee;
    private final String description;
}
