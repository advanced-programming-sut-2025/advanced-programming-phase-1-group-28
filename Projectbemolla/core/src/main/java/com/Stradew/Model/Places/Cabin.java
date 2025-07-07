package com.Stradew.Model.Places;

import com.Stradew.Model.Ref;

public class Cabin extends Place {
    private Ref refrigerator = new Ref();

    public Ref getRefrigerator() {
        return refrigerator;
    }

    public void setRefrigerator(Ref refrigerator) {
        this.refrigerator = refrigerator;
    }

    public Cabin(int x , int y) {
        X_Coordinate = x;
        Y_Coordinate = y;
    }
}
