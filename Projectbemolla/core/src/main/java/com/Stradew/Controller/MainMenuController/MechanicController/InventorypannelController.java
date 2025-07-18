package com.Stradew.Controller.MainMenuController.MechanicController;

import com.Stradew.Main;
import com.Stradew.Model.App;
import com.Stradew.Model.GameAssetsManager;
import com.Stradew.Model.InventorySlot;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import java.util.ArrayList;

public class InventorypannelController {
    private Texture BackGround = GameAssetsManager.getInstance().getInventoryBar();
    private Table Inventorytable;
    private ArrayList<InventorySlot> inventorySlots = new ArrayList<>();


    public Table getInventorytable() {
        return Inventorytable;
    }

    public void setInventorytable(Table inventorytable) {
        Inventorytable = inventorytable;
    }



    public void firstTouch() {
        Inventorytable.row().pad(40);
        for(int i = 0; i < 36 ;i++)
        {
            inventorySlots.add(new InventorySlot());
            Inventorytable.add(inventorySlots.get(i).getButton()).padRight(20);
            if(i % 6 == 0 && i != 0)
            {
                Inventorytable.row().pad(20);
            }

        }
    }

    public void Update()
    {
        //Main.getMain().getBatch().draw(BackGround , App.ReturnCurrentPlayer().getX() - 800 , App.ReturnCurrentPlayer().getY() - 400 , 1000 , 1000);
        for(int i = 0;i < App.ReturnCurrentPlayer().getInventory().getTools().size();i++)
        {
            boolean ok = false;
            for(int j = 0;j < 36;j++)
            {
                if(inventorySlots.get(j).getItem() != null) {
                    if (inventorySlots.get(j).getItem().equals(App.ReturnCurrentPlayer().getInventory().getTools().get(i))) {
                        ok = true;
                    }
                }
            }
            if(!ok)
            {
                for(int j = 0;j < 36;j++)
                {
                    if(inventorySlots.get(j).getItem() == null)
                    {
                        inventorySlots.get(j).SetImageButton(App.ReturnCurrentPlayer().getInventory().getTools().get(i));
                    }
                }
            }
        }
    }
}
