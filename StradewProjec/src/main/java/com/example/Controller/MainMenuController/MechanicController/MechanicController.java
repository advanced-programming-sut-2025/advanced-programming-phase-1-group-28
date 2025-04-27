package com.example.Controller.MainMenuController.MechanicController;

import com.example.Main;
import com.example.Model.Enums.Direction;
import com.example.Model.Item.Item;
import com.example.Model.Node;
import com.example.Model.Tile.Animal;

import java.util.PriorityQueue;

public class MechanicController {
    public boolean IsWalkable(int x , int y)
    {

        return true;
    }

    public int BFS(int StartX , int StartY , int EndX , int EndY) {
        StartX--;StartY--;EndX--;EndY--;
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
                    node.CostInEachDirection[k] = -1;
                }
                Check[i][j] = node;
            }
        }
        PriorityQueue<Node> BFSLayer = new PriorityQueue<>();
        BFSLayer.add(Check[StartX][StartY]);
        Check[StartX][StartY].Check = true;

        while (!BFSLayer.isEmpty()) {
            PriorityQueue<Node> newBFSLayer = new PriorityQueue<>();
            for(int i = 0 ;i < BFSLayer.size() ; i++)
            {
                Node currentNode = BFSLayer.poll();
                int count = 0;
                for(Direction direction : Direction.values())
                {
                    int NewX = currentNode.x + direction.x;
                    int NewY = currentNode.y + direction.y;
                    if(IsWalkable(NewX , NewY))
                    {
                        if(currentNode.CostInEachDirection[count] != -1) {
                            Check[NewX][NewY].SetCost(count, Math.min(currentNode.ReturnMinCost() + 11, currentNode.CostInEachDirection[count] + 1));
                        }
                        else
                        {
                            Check[NewX][NewY].SetCost(count , currentNode.ReturnMinCost());
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
        if(Check[EndX][EndY].ReturnMinCost() != Integer.MAX_VALUE)
        {
            return Check[EndX][EndY].ReturnMinCost();
        }
        else
        {
            return -1;
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

