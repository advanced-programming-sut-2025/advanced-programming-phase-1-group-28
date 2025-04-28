package com.example.View.MainMenu.MechanicGame;

import com.example.Model.App;
import com.example.Model.Item.Item;
import com.example.Model.Tile.Animal;

public class MechanicGame {
    public void BuildGreenHouse() {

    }

    public void walk(int StartX, int StartY, int EndX, int EndY)
    {
        int Cost = App.mechanicController.BFS(StartX, StartY, EndX, EndY);
        if(Cost == -1)
        {
            System.out.println("You Cant reach The point . \n Do you want Go And Faint?");
            String ISOK = App.scanner.nextLine();
            if(ISOK.equals("Yes"))
            {
                App.mechanicController.ApplyWalkToFaint(StartX, StartY, EndX, EndY);
            }
        }
        else
        {
            System.out.println("You can go there in Energy cost : " + Cost / 20 + "Do you wanna Go there");
            String ISOK = App.scanner.nextLine();
            if(ISOK.equals("Yes"))
            {
                App.mechanicController.ApplyWalk(StartX, StartY, EndX, EndY);
            }
        }
    }

    public boolean IsEnergyOver()
    {
        return false;
    }

    public void DeleteFromInventory(String ItemName , int Number)
    {
        App.mechanicController.ApplyRemoveItem(ItemName, Number);
    }
    public void SetTool()
    {

    }
    public void UpgradeTool()
    {

    }
    public void PutOnEarth(int x , int y , String ItemName)
    {

    }
    public void BuildBuilding(String BuildingName , int x , int y)
    {

    }
    public void Pet(Animal animal)
    {

    }
    public void Milking(Animal animal)
    {

    }
    public void furCutting()
    {

    }
    public void shepherdAnimal(Animal animal , int x , int y)
    {

    }
    public void FeedAnimal()
    {

    }
    public void Fishing(int x , int y)
    {
        //we have USe Tool
    }
    public void MakeArtisan(String ArtisanName)
    {
        //it maybe have Tow Inputs
    }
    public void HarvestArtisanProduce()
    {

    }
    public void Purchase()
    {

    }
    public void SellProduct(Item item)
    {

    }
    //Tow above Functions maybe Move To Another Places
}
