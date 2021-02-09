package com.example.atlas.model;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private int id;
    private String mealName;
    private List<String> itens = new ArrayList<String>();

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public List<String> getItens() {
        return itens;
    }

    public void setItens(List<String> itens) {
        this.itens = itens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    
}
