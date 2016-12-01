package com.example.austin.campuscalories;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DishClass implements Serializable{

    private String name;
    private String calories;
    private String caloriesFromFat;
    private String saturatedFat;
    private String transFat;
    private String cholesterol;
    private String sodium;
    private String dietaryFiber;
    private String sugars;
    private String protein;

    public DishClass(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCalories() {
        return this.calories;
    }

    public void setCalories(String cals) {
        this.calories = cals;
    }

    public String getCaloriesFromFat() {
        return this.caloriesFromFat;
    }

    public void setCaloriesFromFat(String calsFromFat) {
        this.caloriesFromFat = calsFromFat;
    }

    public String getSaturatedFat() {
        return this.saturatedFat;
    }

    public void setSaturatedFat(String satFat) {
        this.saturatedFat = satFat;
    }

    public String getTransfat() {
        return this.transFat;
    }

    public void setTransFat(String tranFat) {
        this.transFat = tranFat;
    }

    public String getCholesterol() {
        return this.cholesterol;
    }

    public void setCholesterol(String chol) {
        this.cholesterol = chol;
    }

    public String getSodium() {
        return this.sodium;
    }

    public void setSodium(String sod) {
        this.sodium = sod;
    }

    public String getDietaryFiber() {
        return this.dietaryFiber;
    }

    public void setDietaryFiber(String diet) {
        this.dietaryFiber = diet;
    }

    public String getSugars() {
        return this.sugars;
    }

    public void setSugars(String sug) {
        this.sugars = sug;
    }

    public String getProtein() {
        return this.protein;
    }

    public void setProtein(String prot) {
        this.protein = prot;
    }

}
