package com.example.austin.campuscalories;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class LocationClass implements Serializable{

    private String name;
    private ArrayList<DishClass> breakfast;
    private ArrayList<DishClass> lunch;
    private ArrayList<DishClass> dinner;


    public LocationClass(String name) {
        this.name = name;
        this.breakfast = new ArrayList<DishClass>();
        this.lunch = new ArrayList<DishClass>();
        this.dinner = new ArrayList<DishClass>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DishClass getBreakfast(Integer index) {
        return this.breakfast.get(index);
    }

    public void addDishToBreakfast(DishClass dish) {
        this.breakfast.add(dish);
    }

    public DishClass getLunch(Integer index) {
        return this.lunch.get(index);
    }

    public void addDishToLunch(DishClass dish) {
        this.lunch.add(dish);
    }

    public DishClass getDinner(Integer index) {
        return this.dinner.get(index);
    }

    public void addDishToDinner(DishClass dish) {
        this.dinner.add(dish);
    }


}
