package com.example.atlas.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.atlas.model.Meal;
import com.example.atlas.repository.MealRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/meal")
public class MealController {
    @Autowired
    private MealRepository repository;
    
    @GetMapping("/{userId}")
    public List<Meal> getMeals(@PathVariable int userId){
        return repository.getMealsByUserId(userId);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Meal> save(@RequestBody Meal meal,@PathVariable int userId,HttpServletRequest request, UriComponentsBuilder builder){
        meal.setIdUser(userId);
        repository.save(meal);
        return ResponseEntity.ok().build();
    }
}
