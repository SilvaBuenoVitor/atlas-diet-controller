package com.example.atlas.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.atlas.model.Food;

import org.springframework.stereotype.Component;

@Component
public class FoodRepository {
    private List<Food> foods;
    private int nextId = 1;

    @PostConstruct
    public void init(){
        Food f1 = new Food();
        f1.setId(0);
        f1.setUserId(0);
        f1.setName("Banana");
        f1.setCalories(500);
        f1.setWeight(1.0);

        foods = new ArrayList<Food>();
        foods.add(f1);
    }

    public Food save(Food food, int userId){
        food.setUserId(userId);
        food.setId(nextId);
        nextId++;
        foods.add(food);
        return food;
    }

    public List<Food> getFoodByUserId(int userId){
        List<Food> foodByUserId = new ArrayList<Food>();
        for (Food food : foods) {
            if(food.getUserId() == userId){
                foodByUserId.add(food);
            }
        }
        return foodByUserId;
    }

}
