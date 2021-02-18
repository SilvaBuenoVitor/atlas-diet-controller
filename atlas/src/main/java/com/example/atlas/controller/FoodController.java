package com.example.atlas.controller;

import java.util.List;

import com.example.atlas.model.Food;
import com.example.atlas.repository.FoodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/{userId}")
    public List<Food> getFoodByUserId(@PathVariable int userId){
        return foodRepository.getFoodByUserId(userId);
    }
    
    @PostMapping("/{userId}")
    public ResponseEntity<Food> save(@RequestBody Food food, @PathVariable int userId){
        foodRepository.save(food, userId);
        return ResponseEntity.ok().build();
    }
}
