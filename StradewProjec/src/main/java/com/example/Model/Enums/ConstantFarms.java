package com.example.Model.Enums;

import com.example.Model.Places.Farm;

public enum ConstantFarms {
    FirstFarm(new Farm()) ,
    SecondFarm(new Farm()) ,
    ThirdFarm(new Farm()) ,;
    public final Farm farm;

    ConstantFarms(Farm farm) {
        this.farm = farm;
    }
}
