package com.example.View.MainMenu.MechanicGame.ShopMenu;

import com.example.Controller.MainMenuController.MechanicController.ShoppingController;
import com.example.Model.App;
import com.example.Model.Enums.*;
import com.example.Model.Tools.Pepolee;
import com.example.Model.Tools.ShippingBin;
import com.example.Model.Tools.Tools;

public class Shopping {
    ShoppingController shoppingController = new ShoppingController();

    public void Buy(String ProductName , String CountOrCoordinateOrName)
    {
        PlaceType CurrentPlaceType = App.getCurrentGame().getEntireMap()[App.ReturnCurrentPlayer().getX()][App.ReturnCurrentPlayer().getY()].getPlaceType();
        if(CurrentPlaceType.equals(PlaceType.BlackSmith))
        {
            shoppingController.ApplyBlackSmithPurchase(ProductName , Integer.parseInt(CountOrCoordinateOrName));
            return;
        }
        if(CurrentPlaceType.equals(PlaceType.MarineRanch))
        {
            shoppingController.ApplyMarineRanchPurchase(ProductName , CountOrCoordinateOrName);
            return;
        }
        if(CurrentPlaceType.equals(PlaceType.StarDropSaloon))
        {
            shoppingController.ApplyStarDropSaloon(ProductName , Integer.parseInt(CountOrCoordinateOrName));
            return;
        }
        if(CurrentPlaceType.equals(PlaceType.CarpenterShop))
        {
            shoppingController.ApplyCarpenterShop(ProductName , CountOrCoordinateOrName);
            return;
        }
        if(CurrentPlaceType.equals(PlaceType.JojaMart))
        {
            shoppingController.ApplyJojaMart(ProductName , Integer.parseInt(CountOrCoordinateOrName));
            return;
        }
        if(CurrentPlaceType.equals(PlaceType.PerrieGeneralStore))
        {
            shoppingController.ApplyPierreStore(ProductName , Integer.parseInt(CountOrCoordinateOrName));
            return;
        }
        if(CurrentPlaceType.equals(PlaceType.FishShop))
        {
            shoppingController.ApplyFishShop(ProductName , Integer.parseInt(CountOrCoordinateOrName));
            return;
        }
        System.out.println("Shopping is not possible here");
    }
    public void availableProducts()
    {
        PlaceType CurrentPlaceType = App.getCurrentGame().getEntireMap()[App.ReturnCurrentPlayer().getX()][App.ReturnCurrentPlayer().getY()].getPlaceType();
        if(CurrentPlaceType.equals(PlaceType.BlackSmith))
        {
            for(BlackSmithItems item : BlackSmithItems.values())
            {
                if(item.limitIndex < 0)
                {
                    System.out.println(item.name + " " + item.Price + " unlimited");
                }
                else
                {
                    System.out.println(item.name + " " + item.Price + " " + App.dailyLimits.getBlackSmithLimits()[item.limitIndex]);
                }
            }
            return;
        }
        if(CurrentPlaceType.equals(PlaceType.MarineRanch))
        {
            for(MarineRanchItems item : MarineRanchItems.values())
            {
                if(item.limitIndex < 0)
                {
                    System.out.println(item.name + " " + item.Price + " unlimited");
                }
                else
                {
                    System.out.println(item.name + " " + item.Price + " " + App.dailyLimits.getMarineRanch()[item.limitIndex]);
                }
            }
            return;
        }
        if(CurrentPlaceType.equals(PlaceType.StarDropSaloon))
        {
            for(StarDropSaloonItems item : StarDropSaloonItems.values())
            {
                if(item.limitIndex < 0)
                {
                    System.out.println(item.name + " " + item.Price + " unlimited");
                }
                else
                {
                    System.out.println(item.name + " " + item.Price + " " + App.dailyLimits.getStarDropSaloon()[item.limitIndex]);
                }
            }
            return;
        }
        if(CurrentPlaceType.equals(PlaceType.CarpenterShop))
        {
            for(CarpenterShopItems item : CarpenterShopItems.values())
            {
                if(item.limitIndex < 0)
                {
                    System.out.println(item.name + " " + item.Price + " unlimited");
                }
                else
                {
                    System.out.println(item.name + " " + item.Price + " " + App.dailyLimits.getCarpenterShop()[item.limitIndex]);
                }
            }
            return;
        }
        if(CurrentPlaceType.equals(PlaceType.JojaMart))
        {
            for(JojaMartItems item : JojaMartItems.values())
            {
                if(item.LimitIndex < 0)
                {
                    System.out.println(item.Name + " " + item.Price + " unlimited");
                }
                else
                {
                    System.out.println(item.name() + " " + item.Price + " " + App.dailyLimits.getJojaMart()[item.LimitIndex]);
                }
            }
            return;
        }
        if(CurrentPlaceType.equals(PlaceType.PerrieGeneralStore))
        {
            for(PierreStoreItems item : PierreStoreItems.values())
            {
                if(item.LimitIndex < 0)
                {
                    System.out.println(item.name() + " " + item.Price + " unlimited");
                }
                else
                {
                    System.out.println(item.name() + " " + item.Price + " " + App.dailyLimits.getPierreStore()[item.LimitIndex]);
                }
            }
            return;
        }
        if(CurrentPlaceType.equals(PlaceType.FishShop))
        {
            for(FishShopItems item : FishShopItems.values())
            {
                if(item.limitIndex < 0)
                {
                    System.out.println(item.name + " " + item.price + " unlimited");
                }
                else
                {
                    System.out.println(item.name + " " + item.price + " " + App.dailyLimits.getFishShop()[item.limitIndex]);
                }
            }
            return;
        }
        System.out.println("Not in store");
    }
    public void shippingBinSells(String ProductName , int count)
    {
        Pepolee CurrentPlayer = App.ReturnCurrentPlayer();
        boolean ShippingBinFound = false;
        for(Tools tools : App.ReturnCurrentPlayer().getInventory().getTools())
        {
            if(tools instanceof ShippingBin && Math.abs(((ShippingBin) tools).getX_Coordinate() - CurrentPlayer.getX()) < 2 && Math.abs(((ShippingBin) tools).getY_Coordinate() - CurrentPlayer.getY()) < 2)
            {
                ShippingBinFound = true;
                shoppingController.SellProduct((ShippingBin) tools, ProductName, count);
                break;
            }
        }
        if(!ShippingBinFound)
        {
            System.out.println("Not near shipping bin");
        }
    }
}
