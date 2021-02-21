package com.example.atlas.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.atlas.model.Routine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoutineRepository {
    private List<Routine> routines;
    private int nextId = 1;

    @Autowired
    MealRepository meals = new MealRepository();

    @PostConstruct
    public void init(){
        Routine r1 = new Routine();
        r1.setId(0);
        r1.setUserId(0);
        r1.setMeals(meals.getMealsByUserId(0));
        routines = new ArrayList<Routine>();
        routines.add(r1);
    }

    public List<Routine> getRepositoriesByUserId(int userId){
        List<Routine> routinesByUserId = new ArrayList<Routine>();
        for (Routine routine : routines) {
            if(routine.getUserId() == userId){
                routinesByUserId.add(routine);
            }
        }
        return routinesByUserId;
    }
}
