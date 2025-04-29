package com.example.Model.Enums.Tools;

public enum FishingPole {
    Normal(8),
    Bamboo(8),
    FiberGlass(6),
    Iridium(4);
    public final int Energycost;

    FishingPole(int energycost) {
        Energycost = energycost;
    }
}
