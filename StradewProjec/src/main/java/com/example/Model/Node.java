package com.example.Model;

public class Node {
    public int x;
    public int y;
    public boolean Check = false;
    public int[] CostInEachDirection = new int[8];
    public Node(int x , int y)
    {
        this.x = x;
        this.y = y;
    }
    public void SetCost(int index , int cost)
    {
        CostInEachDirection[index] = cost;
    }
    public int ReturnMinCost()
    {
        int minCost = Integer.MAX_VALUE;
        for(int i = 0; i < CostInEachDirection.length; i++)
        {
            if(CostInEachDirection[i] != -1) {
                minCost = Math.min(minCost, CostInEachDirection[i]);
            }
        }
        return minCost;
    }
}
