package com.example.View.MainMenu.MechanicGame;

import com.example.Controller.MainMenuController.MechanicController.MechanicController;
import com.example.Model.App;
import com.example.Model.Item.Item;
import com.example.Model.Tile.Animal;

public class MechanicGame {
    MechanicController mechanicController = App.mechanicController;
    public void BuildGreenHouse() {
        if(!App.mechanicController.EnoughSourceForGreenhouse())
        {
            System.out.println("Akhe fahgir");
            return;
        }

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

    public void Pet(String animalName)
    {
        Animal animal = App.ReturnCurrentPlayer().getFarm().getAnimalByName(animalName);
        if (animal == null){
            System.out.println("It seems your petting skills are so good, you're even making friends with nothing!");
            return;
        }
        mechanicController.ApplyPetAnimal(animal);
        System.out.println("Aww, so gentle!");
    }

    public void getAnimalProducts(String animalName){
        Animal animal = App.ReturnCurrentPlayer().getFarm().getAnimalByName(animalName);
        if (animal == null){
            System.out.println("No animal with that name exists here.");
            return;
        }
        mechanicController.CollectAnimalProduce(animal);
        System.out.println("You collect " + animalName + " products successfully.");
    }

    public void shepherdAnimal(String animalName , int x , int y)
    {
        Animal animal = App.ReturnCurrentPlayer().getFarm().getAnimalByName(animalName);
        if (animal == null){
            System.out.println("No animal with that name exists here.");
            return;
        } else if (mechanicController.BFS(animal.getX(), animal.getY(), x, y) == -1) {
            System.out.println("You can't reach there.");
            return;
        }
        mechanicController.ApplyMovingAnimal(animal, x, y);
        System.out.println("You moved " + animalName + " successfully.");
    }

    public void FeedAnimal(String animalName)
    {
        Animal animal = App.ReturnCurrentPlayer().getFarm().getAnimalByName(animalName);
        if (animal == null){
            System.out.println("You are phychologically ravani.");
            System.out.println("No animal with that name exists here.");
            return;
        }
        mechanicController.ApplyFeedAnimal(animal);
        System.out.println("Animal fed successfully.");
    }

    public void SellAnimal(String animalName){
        Animal animal = App.ReturnCurrentPlayer().getFarm().getAnimalByName(animalName);
        if (animal == null){
            System.out.println("No animal with that name exists here.");
            return;
        }
        mechanicController.SellAnimal(animal);
        System.out.println("You've sold " + animalName + ". It's sad to see them go, but you received " + animal.getSellPrice() + ".");
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
