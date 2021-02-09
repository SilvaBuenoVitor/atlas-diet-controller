package com.example.atlas.repository;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.atlas.model.Meal;

@Component
public class MealRepository {
    private List<Meal> meals;
    private int nextId = 1;

    @PostConstruct
    public void init(){
        Meal m1 = new Meal();
        m1.setMealName("Café");
        List<String> itens = new ArrayList<String>();
        itens.add("Café");
        itens.add("Leite");
        m1.setItens(itens);
        m1.setId(nextId);

        meals = new ArrayList<Meal>();
        meals.add(m1);
        nextId = 2;
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
}
