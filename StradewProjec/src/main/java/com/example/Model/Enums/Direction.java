package com.example.Model.Enums;

public enum Direction {
    Up( 0 ,0 , -1) ,
    Down(1, 0 , 1) ,
    Left(2 , -1  , 0) ,
    Right (3 , 1 , 0),
    UpLeft(4 , -1 , -1) ,
    UpRight(5 , 1 , -1) ,
    DownLeft(6, -1 , 1) ,
    DownRight(7 , 1 , 1) ;
    public final int Id;
    public final int x;
    public final int y;
    Direction(int Id , int x, int y) {
        this.Id = Id;
        this.x = x;
        this.y = y;
    }
}
