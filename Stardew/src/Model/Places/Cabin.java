package Model.Places;

import Model.Ref;

import java.util.ArrayList;

public class Cabin extends Place {
    public Ref refrigerator = new Ref();
    public Cabin(int x , int y) {
        X_Coordinate = x;
        Y_Coordinate = y;
    }
}
