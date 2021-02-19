package com.example.atlas.repository;

import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import com.example.atlas.model.Meal;

@Component
public class MealRepository {
    private List<Meal> meals;
    private int nextId = 1;
    
    @Autowired
    private FoodRepository foodRepository;

    @PostConstruct
    public void init(){
        Meal m1 = new Meal();
        m1.setName("Café");
        m1.setIdUser(0);
        m1.setFoods(foodRepository.getFoodByUserId(0));
        m1.setId(nextId);
        m1.setTime(LocalTime.now());

        meals = new ArrayList<Meal>();
        meals.add(m1);
    }

    public Meal save(Meal meal){
        meal.setId(nextId);
        meals.add(meal);
        nextId++;
        return meal;
    }

    public List<Meal> getMeals(){
        return meals;
    }

    public List<Meal> getMealsByUserId(int idUser){
        List<Meal> mealsByUserId = new ArrayList<Meal>();
        for (Meal meal : meals) {
            if(meal.getIdUser() == idUser){
                mealsByUserId.add(meal);
            }
        }
        return mealsByUserId;
    }
}
