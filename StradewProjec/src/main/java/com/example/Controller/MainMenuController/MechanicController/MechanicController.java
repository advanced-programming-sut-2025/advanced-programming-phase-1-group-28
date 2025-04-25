package com.example.Controller.MainMenuController.MechanicController;

import com.example.Model.Enums.Direction;
import com.example.Model.Item.Item;
import com.example.Model.Tile.Animal;

public class MechanicController {
    public boolean IsWalkable(int x , int y)
    {
        return true;
    }

    public void BFS(int CurrentX , int CurrentY ,int[][] Checked , int[][][] MinimumCost) {
        for(Direction direction : Direction.values())
        {
            if(IsWalkable(CurrentX - direction.x, CurrentY - direction.y))
            {
                direction
            }
        }
    }

    public boolean CanBuild()
    {
        return true;
    }
    public void ApplyBuildingGreenHouse()
    {

    }
    public int BestWay(int x , int y , int DestenationX , int DestenationY)
    {
        //Attenation to the Energy needed for Emtiazi formula
        return -1;
    }
    public void ApplyWalking(int x , int y , int DestenationX , int DestenationY)
    {

    }
    public boolean CheckIsInAnAnotherFarm(int DestenationX , int DestenationY)
    {
        return false;
    }
    public boolean IsInKaveh()
    {
        //Ahangari
        return false;
    }
    public boolean EnoughResources()
    {
        return false;
    }
    public void ApplyUpgradeTool()
    {
        //decrease EnergyCost
    }
    public boolean CheckIfTileIsEmpty()
    {
        return false;
    }
    public boolean CheckIfSourcesEnough()
    {
        return false;
    }
    public void ApplyBuilding()
    {

    }
    public void ApplyMovingAnimal()
    {

    }
    public void SellAnimal(Animal animal)
    {

    }
    public void CollectAnimalProduce(Animal animal)
    {

    }
    public boolean IsSellable(Item item)
    {
        return false;
    }
    public boolean EnoughProductsInInventory(Item item)
    {
        return false;
    }


}

