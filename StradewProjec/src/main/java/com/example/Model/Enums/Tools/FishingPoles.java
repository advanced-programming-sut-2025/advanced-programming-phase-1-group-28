package com.example.Model.Enums.Tools;

public enum FishingPoles {
    Normal(8),
    Bamboo(8),
    FiberGlass(6),
    Iridium(4);
    public final int Energycost;

    FishingPoles(int energycost) {
        Energycost = energycost;
    }
}
