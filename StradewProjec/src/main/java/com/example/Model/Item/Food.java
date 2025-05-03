package com.example.Model.Item;

import com.example.Model.Enums.Foods;

public class Food extends Item {
    private Foods food;
    public Food(int count, String quality) {
        super(count, quality);
    }

    public Foods getFood() {
        return food;
    }

    public void setFood(Foods food) {
        this.food = food;
        this.name = food.toString();
    }

    @Override
    public Food getCopy(){
        Food result = new Food(count, name);
        result.setFood(food);
        return result;
    }
}
