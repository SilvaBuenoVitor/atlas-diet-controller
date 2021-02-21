package com.example.atlas.controller;

import java.util.List;

import com.example.atlas.model.Routine;
import com.example.atlas.repository.RoutineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/routine")
public class RoutineController {
    @Autowired
    private RoutineRepository repository;

    @GetMapping("/{userId}")
    public List<Routine> getRoutineByUserId(@PathVariable int userId) {
        return repository.getRepositoriesByUserId(userId);
    }
    
}
