package com.example.easymenuplanner;

public class Ingredient {
    private String unit;
    private float quantity;


    public Ingredient(String unit, float quantity) {
        this.unit = unit;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        // Eventually, we will print the quantity as a fraction string
        return quantity + ' ' + unit;
    }
}
