package com.example.Controller.MainMenuController.MechanicController;

import com.example.Main;
import com.example.Model.App;
import com.example.Model.Enums.Direction;
import com.example.Model.Enums.PlaceType;
import com.example.Model.Inventory;
import com.example.Model.Item.Ingredient;
import com.example.Model.Item.Item;
import com.example.Model.Node;
import com.example.Model.Places.Farm;
import com.example.Model.Tile.Animal;
import com.example.Model.Tools.Pepolee;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MechanicController {
    public boolean IsWalkable(int x , int y)
    {
        if(x > 0 && y > 0 && x < 200 && y < 200) {
            return true;
        }
        return false;
    }

    public boolean EnoughSourceForGreenhouse()
    {
        Pepolee currentpeople = App.ReturnCurrentPlayer();
        if(currentpeople.getCoin() < 1000)
        {
            return false;
        }
        boolean ok = false;
        for(Item item : currentpeople.getInventory().getItems())
        {
            if(item.getName().equals("Wood"))
            {
                if(item.getCount() >= 500)
                {
                    ok = true;
                }
            }
        }
        return ok;
    }

    public void ApplyBuildGreenhouse()
    {
        Pepolee currentpeople = App.ReturnCurrentPlayer();
        currentpeople.setCoin(currentpeople.getCoin() - 1000);
        for(Item item : currentpeople.getInventory().getItems())
        {
            if(item.getName().equals("Wood"))
            {
                item.setCount(item.getCount() - 500);
            }
        }
        currentpeople.getFarm().getGreenHouse().setLocked(false);
    }

    public int BFS(int StartX , int StartY , int EndX , int EndY) {
        Node [][] Check = new Node [200][200];
        for(int i = 0;i < 200 ; i++)
        {
            for(int j = 0 ;j < 200 ; j++)
            {
                Node node = new Node(i , j);
                for(int k = 0 ;k <8 ; k++)
                {
                    if(i == StartX && j == StartY)
                    {
                        node.CostInEachDirection[k] = 0;
                    }
                    else {
                        node.CostInEachDirection[k] = -1;
                    }
                }
                Check[i][j] = node;
            }
        }
        ArrayList<Node> BFSLayer = new ArrayList<>();
        BFSLayer.add(Check[StartX][StartY]);
        Check[StartX][StartY].Check = true;

        while (!BFSLayer.isEmpty()) {
            ArrayList<Node> newBFSLayer = new ArrayList<>();
            for(int i = BFSLayer.size() - 1; i >= 0 ; i--)
            {
                Node currentNode = BFSLayer.get(i);
                int count = 0;
                for(Direction direction : Direction.values())
                {
                    int NewX = currentNode.x + direction.x;
                    int NewY = currentNode.y + direction.y;
                    if(IsWalkable(NewX , NewY))
                    {
                        if(currentNode.CostInEachDirection[count] != -1) {
                            int Minimum = Math.min(currentNode.ReturnMinCost() + 11, currentNode.CostInEachDirection[count] + 1);
                            if(Check[NewX][NewY].CostInEachDirection[count] != -1) {
                                Check[NewX][NewY].SetCost(count, Math.min(Check[NewX][NewY].CostInEachDirection[count], Minimum));
                            }
                            else
                            {
                                Check[NewX][NewY].SetCost(count, Minimum);
                            }
                        }
                        else
                        {
                            int Minimum = currentNode.ReturnMinCost() + 11;
                            if(Check[NewX][NewY].CostInEachDirection[count] != -1) {
                                Check[NewX][NewY].SetCost(count, Math.min(currentNode.ReturnMinCost(), Minimum));
                            }
                            else
                            {
                                Check[NewX][NewY].SetCost(count, Minimum);
                            }
                        }
                        if(!Check[NewX][NewY].Check) {
                            newBFSLayer.add(Check[NewX][NewY]);
                            Check[NewX][NewY].Check = true;
                        }
                    }
                    count++;
                }
            }
            BFSLayer = newBFSLayer;
        }
        if(Check[EndX][EndY].Check) {
            System.out.println(Check[EndX][EndY].ReturnMinCost());
            if (Check[EndX][EndY].ReturnMinCost() != 1000000) {
                /*if (Check[EndX][EndY].ReturnMinCost() / 20 > App.ReturnCurrentPlayer().getEnergy()) {
                    return -1;
                }*/
                return Check[EndX][EndY].ReturnMinCost();
            }
            else
            {
                return -1;
            }
        }
        else
        {
            return -1;
        }
    }

    public void ApplyWalk(int StartX , int StartY , int EndX , int EndY)
    {
        App.ReturnCurrentPlayer().setX(EndX);
        App.ReturnCurrentPlayer().setY(EndY);
        App.ReturnCurrentPlayer().setEnergy(App.ReturnCurrentPlayer().getEnergy() - BFS(StartX , StartY , EndX , EndY) / 20);
    }

    public boolean CanBuild()
    {
        return true;
    }

    public void ApplyBuildingGreenHouse()
    {

    }

    public void ApplyWalkToFaint(int StartX , int StartY , int EndX , int EndY)
    {
        while(App.ReturnCurrentPlayer().getEnergy() > 0)
        {
            int RandomDirection = App.random.nextInt() % 8;
            int count = 0;
            for(Direction direction : Direction.values())
            {
                if(count == RandomDirection)
                {
                    App.ReturnCurrentPlayer().setX(StartX + direction.x);
                    App.ReturnCurrentPlayer().setY(StartY + direction.y);
                }
                count++;
            }
            App.ReturnCurrentPlayer().setEnergy(App.ReturnCurrentPlayer().getEnergy() - 10);
        }
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
    public void ApplyRemoveItem(String ItemName , int number)
    {
        Inventory TempInventory = App.ReturnCurrentPlayer().getInventory();
        for(int i = 0 ;i < TempInventory.getItems().size(); i++)
        {
            if(TempInventory.getItems().get(i).getName().equals(ItemName))
            {
                if(number == -1)
                {
                    TempInventory.getItems().remove(i);
                }
                else
                {
                    TempInventory.getItems().get(i).setCount(TempInventory.getItems().get(i).getCount() - number);
                }
            }
        }
        for(int i = 0 ;i < TempInventory.getTools().size(); i++)
        {
            if(TempInventory.getTools().get(i).getName().equals(ItemName))
            {
                if(number == -1)
                {
                    TempInventory.getTools().remove(i);
                }
                else
                {
                    TempInventory.getTools().get(i).setCount(TempInventory.getTools().get(i).getCount() - number);
                }
            }
        }
    }

    public void ApplySetTool(String ItemName)
    {
        Inventory TempInventory = App.ReturnCurrentPlayer().getInventory();
        for(int i = 0 ;i < TempInventory.getItems().size(); i++)
        {
            if(TempInventory.getItems().get(i).getName().equals(ItemName))
            {
                TempInventory.setCurrentItem(TempInventory.getItems().get(i));
                TempInventory.setCurrentTool(null);
            }
        }
        for(int i = 0 ;i < TempInventory.getTools().size(); i++)
        {
            if(TempInventory.getTools().get(i).getName().equals(ItemName))
            {
                TempInventory.setCurrentTool(TempInventory.getTools().get(i));
                TempInventory.setCurrentItem(null);
            }
        }
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

    public void ApplyPetAnimal(Animal animal){
        animal.addFriendship(15);
        animal.setPettedToday(true);
    }

    public void ApplyFeedAnimal(Animal animal){
        Item item = App.ReturnCurrentPlayer().getInventory().getItemByName("Hay");
        item.addCount(-1);
        if (item.getCount() == 0){
            App.ReturnCurrentPlayer().getInventory().removeItem(item);
        }
        animal.setFed(true);
    }

    public void ApplyMovingAnimal(Animal animal,int x,int y)
    {
        animal.setX(x);
        animal.setY(y);
        Farm farm = App.ReturnCurrentPlayer().getFarm();
        if (farm.getGround()[x][y].getPlaceType() == PlaceType.BARN || farm.getGround()[x][y].getPlaceType() == PlaceType.COOP){
            animal.setInside(true);
        }else {
            animal.setInside(false);
            animal.addFriendship(8);
        }
    }

    public void SellAnimal(Animal animal)
    {
        Pepolee currentPlayer = App.ReturnCurrentPlayer();
        currentPlayer.addCoin(animal.getSellPrice());
        currentPlayer.getFarm().removeAnimal(animal);
    }

    public void CollectAnimalProduce(Animal animal)
    {
        Inventory inventory = App.ReturnCurrentPlayer().getInventory();
        ArrayList<Ingredient> ingredients = animal.getProducts();
        for (Ingredient ingredient: ingredients){
            inventory.addItem(ingredient);
        }
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

