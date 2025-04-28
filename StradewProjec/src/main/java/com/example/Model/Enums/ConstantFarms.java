package com.example.Model.Enums;

import com.example.Model.Places.*;

public enum ConstantFarms {
    FirstFarm(new Farm(new GreenHouse(0 , 8 , 8) , new Cabin(10 , 25) , new Lake(25 , 15) , new Quarry(30 , 25))) ,
    SecondFarm(new Farm(new GreenHouse(0 , 25 , 8) , new Cabin(5 , 5) , new Lake(30 , 30) , new Quarry(25 , 8))) ,
    ThirdFarm(new Farm(new GreenHouse(0 , 30 , 30) , new Cabin(5 , 12) , new Lake(20 , 20) , new Quarry(30 , 5))) ;
    public final Farm farm;

    ConstantFarms(Farm farm) {
        this.farm = farm;
    }


}
