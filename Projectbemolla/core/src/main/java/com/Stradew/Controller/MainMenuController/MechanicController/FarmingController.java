package com.Stradew.Controller.MainMenuController.MechanicController;

import com.Stradew.Model.App;
import com.Stradew.Model.Enums.*;
import com.Stradew.Model.Item.Ingredient;
import com.Stradew.Model.PairChanges;
import com.Stradew.Model.Tile.Minreal;
import com.Stradew.Model.Tile.Plants;
import com.Stradew.Model.Tile.Tile;
import com.Stradew.Model.Tile.Trees;
import com.Stradew.Model.Tools.Pepolee;
import com.badlogic.gdx.Gdx;

public class FarmingController {

    public void RandomLightning(Pepolee currentpepolee , int x  , int y , Boolean cheat)
    {
        Tile[][] Tempground = currentpepolee.getFarm().getGround();
                int Randomnumber = App.random.nextInt() % 10;
                if(cheat)
                {
                    Randomnumber = 0;
                }
                if(Randomnumber == 0)
                {
                    //Gdx.app.exit();
                    App.ReturnCurrentPlayer().setLightend(true);
                    App.getCurrentGame().getTimeControlPannel().setIsLightend(0);
                    if(Tempground[x][y].getEntitity() == Entitity.PLANTS && Tempground[x][y].getPlaceType() != PlaceType.GREENHOUSE)
                    {
                        Tempground[x][y] = new Tile(Terrain.DIRT , null , null);
                    }
                    if(Tempground[x][y].getEntitity() == Entitity.TREE)
                    {
                        Trees temptree = (Trees) Tempground[x][y];
                        temptree.setISLightend(true);
                    }
                }
                currentpepolee.getFarm().setGround(Tempground);
    }

    public void ApplyRandomForagingInFarm(Pepolee pepolee)
    {
        Tile[][] TempGround = pepolee.getFarm().getGround();
        Plants newplant1 = new Plants(com.Stradew.Model.Enums.Plants.BLUE_JAZZ);
        newplant1.setBornTime(App.getCurrentGame().getTime());
        TempGround[40][40] = newplant1;
        TempGround[40][40].setHow(false);
        TempGround[40][40].setTerrain(null);;
        TempGround[40][40].setEntitity(Entitity.PLANTS);

        App.ReturnCurrentPlayer().getFarm().getChanges().add(new PairChanges(40, 40));
        Pepolee CurrentPepolee = pepolee;
        for(int x = 0 ; x < PlaceType.FARM.XLength ; x++)
        {
            for(int y = 0; y < PlaceType.FARM.YLength ; y++)
            {
                int RandomProb = App.random.nextInt() % 50;
                if(RandomProb == 0)
                {
                    int SeedOrCrop = App.random.nextInt() % 2;
                    if(SeedOrCrop == 0) {
                        if (TempGround[x][y].getTerrain() == Terrain.DIRT && TempGround[x][y].isHow()) {
                            int RandomSeed = App.random.nextInt() % (Seeds.values().length - 1);
                            int count = 0;
                            for(Seeds seed : Seeds.values()) {
                                if(count == RandomSeed) {
                                    Plants newplant = new Plants(seed.Plant);
                                    newplant.setBornTime(App.getCurrentGame().getTime());
                                    TempGround[x][y] = newplant;
                                    TempGround[x][y].setHow(false);
                                    TempGround[x][y].setTerrain(null);;
                                    TempGround[x][y].setEntitity(Entitity.PLANTS);
                                    App.ReturnCurrentPlayer().getFarm().getChanges().add(new PairChanges(x , y));
                                }
                                count++;
                            }
                        }
                    }
                    else
                    {
                        if(TempGround[x][y].getTerrain() == Terrain.DIRT)
                        {
                            int RandomForgagingFruit = App.random.nextInt() % 22;
                            int count = 0;
                            for(com.Stradew.Model.Enums.Plants plant : com.Stradew.Model.Enums.Plants.values())
                            {
                                if(count == RandomForgagingFruit) {
                                    Plants newplant = new Plants(plant);
                                    newplant.setBornTime(App.getCurrentGame().getTime());
                                    TempGround[x][y] = newplant;
                                    TempGround[x][y].setHow(false);
                                    TempGround[x][y].setTerrain(null);;
                                    TempGround[x][y].setEntitity(Entitity.PLANTS);
                                    App.ReturnCurrentPlayer().getFarm().getChanges().add(new PairChanges(x , y));
                                }
                                if(plant.Source == null)
                                {
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
        }
        for(int x = 0; x < PlaceType.FARM.XLength ; x++)
        {
            for(int y = 0; y < PlaceType.FARM.YLength ; y++)
            {
                int RandomProb = App.random.nextInt() % 50;
                if(RandomProb == 0 && TempGround[x][y].getPlaceType() == null && TempGround[x][y].getTerrain() == Terrain.DIRT && TempGround[x][y].getPlaceType() != PlaceType.LAKE)
                {
                    int RnadomTree = App.random.nextInt() % 14;
                    int count = 0;
                    for(Tree tree : Tree.values())
                    {
                        if(count == RnadomTree) {
                            TempGround[x][y] = new Trees(tree);
                            TempGround[x][y].setTerrain(null);
                            TempGround[x][y].setPlaceType(null);
                            TempGround[x][y].setEntitity(Entitity.TREE);
                            App.ReturnCurrentPlayer().getFarm().getChanges().add(new PairChanges(x , y));
                        }
                        count++;
                    }
                }
            }
        }
        for(int x = 0 ; x < PlaceType.FARM.XLength ; x++)
        {
            for(int y = 0; y < PlaceType.FARM.YLength ; y++)
            {
                if(TempGround[x][y].getPlaceType() == PlaceType.QUARRY)
                {
                    int RandomNumber = App.random.nextInt() % 5;
                    if(RandomNumber == 0)
                    {
                        if(TempGround[x][y].getEntitity() != Entitity.Minreal)
                        {
                            Minreal newminreal = new Minreal(null , null , Entitity.Minreal);
                            int RandomMineral = App.random.nextInt() % 10;
                            if(RandomMineral < 0)
                            {
                                RandomMineral += 10;
                            }
                            int Count = 0;
                            for(Minerals m : Minerals.values())
                            {
                                if(Count == RandomMineral)
                                {
                                    newminreal.setMineral(m);
                                }
                                Count++;
                            }
                            TempGround[x][y] = newminreal;
                            TempGround[x][y].setPlaceType(PlaceType.QUARRY);
                            TempGround[x][y].setEntitity(Entitity.Minreal);
                            TempGround[x][y].setTerrain(null);
                            App.ReturnCurrentPlayer().getFarm().getChanges().add(new PairChanges(x , y));
                        }
                    }
                }
            }
        }
        CurrentPepolee.getFarm().setGround(TempGround);
    }

    public boolean CanPlant(int x , int y)
    {
//        Pepolee CurrentPepolee = App.ReturnCurrentPlayer();
//        int NewX = CurrentPepolee.getX() + x;
//         int NewY = CurrentPepolee.getY() + y;
//        if(CurrentPepolee.getFarm().getGround()[NewX][NewY].isHow() && CurrentPepolee.getFarm().getGround()[NewX][NewY].getTerrain() == Terrain.DIRT)
//        {
//            return true;
//        }
       return false;
    }

    public void ApplyGianting()
    {

    }

    public boolean BeinsidetheGreenhouse(String Seedname , int x , int y)
    {
//        Pepolee CurrentPepolee = App.ReturnCurrentPlayer();
//        Tile[][] TempGround = CurrentPepolee.getFarm().getGround();
//        if(TempGround[CurrentPepolee.getX()][CurrentPepolee.getY()].getPlaceType() == PlaceType.GREENHOUSE)
//        {
//            int NewX = CurrentPepolee.getX() + x;
//            int NewY = CurrentPepolee.getY() + y;
//            if(TempGround[NewX][NewY].getEntitity() != Entitity.PLANTS)
//            {
//                Plants newplant = new Plants(returnseed(Seedname).Plant);
//                newplant.setBornTime(App.getCurrentGame().getTime());
//                System.out.println("plant Planted Succsesfully");
//                TempGround[NewX][NewY] = newplant;
//            }
//            CurrentPepolee.getFarm().setGround(TempGround);
//            return true;
//        }
        return false;
    }


    public Seeds returnseed(String Seedname)
    {
        for(Seeds Seed : Seeds.values()) {
            if(Seed.name().equalsIgnoreCase(Seedname))
            {
                return Seed;
            }
        }
        return null;
    }

    public boolean IsSeedininventory(String Seedname)
    {
        Seeds Goalseed = returnseed(Seedname);
        Pepolee CurrentPepolee = App.ReturnCurrentPlayer();
        Tile[][] TempGround = CurrentPepolee.getFarm().getGround();
        for(int i = 0;i < CurrentPepolee.getInventory().getSeeds().size(); i++)
        {
            if(CurrentPepolee.getInventory().getSeeds().get(i) == Goalseed)
            {
                return true;
            }
        }
        return false;
    }


    public void ApplyPlanting(Seeds seedali , int x , int y)
    {
        Seeds Goalseed = seedali;
        Pepolee CurrentPepolee = App.ReturnCurrentPlayer();
        Tile[][] TempGround = CurrentPepolee.getFarm().getGround();
        for(int i = 0;i < CurrentPepolee.getInventory().getSeeds().size(); i++)
        {
            if(CurrentPepolee.getInventory().getSeeds().get(i) == Goalseed)
            {
                CurrentPepolee.getInventory().getSeeds().remove(i);
                break;
            }
        }
        if(Goalseed == Seeds.MixedSeeds) {
            Season OurSeason = App.getCurrentGame().getTime().getSeason();
            for(MixedSeeds seed : MixedSeeds.values()) {
                if(seed.season == OurSeason) {
                    int Randomplant = App.random.nextInt() % seed.Plants.size();
                    Plants newplant = new Plants(seed.Plants.get(Randomplant));
                    newplant.setBornTime(App.getCurrentGame().getTime());
                    int NewX =  x;
                    int NewY = y;
                    TempGround[NewX][NewY] = newplant;
                    TempGround[NewX][NewY].setHow(false);
                    TempGround[NewX][NewY].setEntitity(Entitity.PLANTS);
                    TempGround[NewX][NewY].setTerrain(null);
                }
            }
        }
        else {
            Plants newplant = new Plants(Goalseed.Plant);
            newplant.setBornTime(App.getCurrentGame().getTime());
            int NewX = x;
            int NewY = y;
            TempGround[NewX][NewY] = newplant;
            TempGround[NewX][NewY].setHow(false);
            TempGround[NewX][NewY].setEntitity(Entitity.PLANTS);
            TempGround[NewX][NewY].setTerrain(null);
        }
        CurrentPepolee.getFarm().setGround(TempGround);
    }

    public boolean CanCood(int x , int y)
    {
//        Pepolee CurrentPepolee = App.ReturnCurrentPlayer();
//        int NewX = CurrentPepolee.getX() + x;
//        int NewY = CurrentPepolee.getY() + y;
//        Tile[][] TempGround = CurrentPepolee.getFarm().getGround();
//        if(TempGround[NewX][NewY].getEntitity() == Entitity.PLANTS || TempGround[NewX][NewY].getEntitity() == Entitity.TREE)
//        {
//            return true;
//        }
        return false;
    }

    public boolean ISIninventory(String coodname)
    {
        Pepolee CurrentPepolee = App.ReturnCurrentPlayer();
        for(int i = 0;i < CurrentPepolee.getInventory().getItems().size(); i++)
        {
            if(CurrentPepolee.getInventory().getItems().get(i) instanceof Ingredient)
            {
                if(CurrentPepolee.getInventory().getItems().get(i).getName().equals(coodname))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void ApplyCooding(String coodname , int x , int y)
    {
//        Pepolee CurrentPepolee = App.ReturnCurrentPlayer();
//        Tile[][] TempGround = CurrentPepolee.getFarm().getGround();
//        int NewX = CurrentPepolee.getX() + x;
//        int NewY = CurrentPepolee.getY() + y;
//        for(int i = 0;i < CurrentPepolee.getInventory().getItems().size(); i++)
//        {
//            if(CurrentPepolee.getInventory().getItems().get(i) instanceof Ingredient)
//            {
//                if(CurrentPepolee.getInventory().getItems().get(i).getName().equals(coodname))
//                {
//                    CurrentPepolee.getInventory().getItems().remove(i);
//                }
//            }
//        }
//        if(TempGround[NewX][NewY].getEntitity() == Entitity.PLANTS)
//        {
//            Plants ourPlant = (Plants)TempGround[NewX][NewY];
//            ourPlant.setISCooded(true);
//        }
//        if(TempGround[NewX][NewY].getEntitity() == Entitity.TREE)
//        {
//            Trees ourTrees = (Trees)TempGround[NewX][NewY];
//            ourTrees.setIscooded(true);
//        }
    }

    public void CrowAttack()
    {
        for(int i = 0 ;i < App.getCurrentGame().getCharactersInGame().size();i++)
        {
            Pepolee nowpeolee = App.getCurrentGame().getCharactersInGame().get(i);
            Tile[][] Tempground = nowpeolee.getFarm().getGround();
            for(int x = 0 ;x < PlaceType.FARM.XLength ; x++)
            {
                for(int y = 0;y < PlaceType.FARM.YLength ;y++)
                {
                    if(Tempground[x][y].getEntitity() == Entitity.PLANTS)
                    {
                        int Randx = App.random.nextInt() % 24;
                        if(Randx == 0)
                        {
                            Plants ourplant = (Plants)Tempground[x][y];
                            if(ourplant.getPlant().OnTime)
                            {
                                Tempground[x][y].setTerrain(Terrain.DIRT);
                                Tempground[x][y].setEntitity(null);
                                Tempground[x][y].setPlaceType(null);
                                Tempground[x][y].setHow(false);
                            }
                            else
                            {
                                Tempground[x][y].setISAttackedByCrow(true);
                            }
                        }
                    }
                }
            }
            nowpeolee.getFarm().setGround(Tempground);
        }

    }

}
