package com.example.Model.Enums;

public enum MapReading {
    Tree(null , null , Entitity.TREE,  'T'),
    Plant(null , null , Entitity.PLANTS , 'P'),
    Greenhouse(null , PlaceType.GREENHOUSE ,null ,  'G'),
    Cabin(null , PlaceType.CABIN ,null ,  'C'),
    Lake(null , PlaceType.LAKE ,null ,  'L'),
    Dirt(Terrain.DIRT , null , null , ' '),
    PEOPEELE(null , null , null , '@'),
    Animal(null , null , null , 'A'),
    Quarry(null , PlaceType.QUARRY , null , 'Q'),
    Mineral(null , PlaceType.QUARRY , Entitity.Minreal , 'M');



    public final Terrain terrain;
    public final PlaceType placeType;
    public final Entitity entitity;
    public final char Show;

    MapReading(Terrain terrain, PlaceType placeType, Entitity entitity , char Show) {
        this.terrain = terrain;
        this.placeType = placeType;
        this.entitity = entitity;
        this.Show = Show;
    }
}
