package com.Stradew.Model.Item;

import com.Stradew.Model.Enums.Foods;

public class Food extends Item {
    private Foods food;
    public Food(int count, Foods food) {
        super(count, food.Name);
        this.food = food;
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
        return new Food(count, food);
    }
}
