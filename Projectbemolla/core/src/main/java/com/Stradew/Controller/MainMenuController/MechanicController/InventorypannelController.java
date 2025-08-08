package com.Stradew.Controller.MainMenuController.MechanicController;

import com.Stradew.Controller.MainMenuController.GameMenuController;
import com.Stradew.Controller.MainMenuController.NPCVillageController;
import com.Stradew.Main;
import com.Stradew.Model.App;
import com.Stradew.Model.GameAssetsManager;
import com.Stradew.Model.InventorySlot;
import com.Stradew.Model.Item.Item;
import com.Stradew.Model.Tools.Tools;
import com.Stradew.View.MainMenu.GameMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;
import java.util.Arrays;

public class InventorypannelController {
    private Texture BackGround = GameAssetsManager.getInstance().getInventoryBar();
    private Table Inventorytable;
    private ArrayList<InventorySlot> inventorySlots = new ArrayList<>();
    private ImageButton ChoosenItem;
    private TextButton Trade = new TextButton("Trade" , GameAssetsManager.getInstance().getSkin());
    private TextButton HistoryofTrades = new TextButton("History of Trades" , GameAssetsManager.getInstance().getSkin());
    private SelectBox Users = new SelectBox(GameAssetsManager.getInstance().getSkin());

    public Table getInventorytable() {
        return Inventorytable;
    }

    public void setInventorytable(Table inventorytable) {
        Inventorytable = inventorytable;
    }


    public void firstTouch(ArrayList<String> Usernames) {
        Inventorytable.row().pad(40);
        for(int i = 0; i < 36 ;i++)
        {
            inventorySlots.add(new InventorySlot());
            Inventorytable.add(inventorySlots.get(i).getButton()).padRight(20);
            if(i % 6 == 5)
            {
                Inventorytable.row().pad(20);
            }
        }
        Inventorytable.row().pad(40);
        Texture Axe = new Texture("Pants/Baggy_Pants.png");
        TextureRegion region = new TextureRegion(Axe);
        TextureRegionDrawable drawable = new TextureRegionDrawable(region);
        ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle();
        style.up = drawable;
        style.down = drawable;
        ChoosenItem = new ImageButton(style);
        Inventorytable.add(ChoosenItem).padRight(200);

        Array<String> Usernamesfortrade = new Array<String>();
        for(int i = 0; i < Usernames.size(); i++)
        {
            if(!Usernames.get(i).equals(App.getCurrentUser().getUsername())) {
                Usernamesfortrade.add(Usernames.get(i));
            }
        }
        Users.setItems(Usernamesfortrade);
        Inventorytable.add(Users).padRight(50);
        Inventorytable.add(Trade);
        Inventorytable.add(HistoryofTrades);
    }

    /*public void Remove(GameMenu menu)
    {
        if(menu.getBin().isChecked())
        {

            menu.getBin().setChecked(false);
        }
    }*/

    public void Trade(GameMenu menu)
    {
        if(Trade.isChecked())
        {
            //if(App.ReturnCurrentPlayer().getInventory().getCurrentItem() != null)
            {
                menu.getTradeTable().setVisible(true);
                menu.getMainTable().setVisible(false);
                menu.getSwitchTable().setVisible(false);
                menu.getController().getTradeController().setBuyer(false);
                menu.getController().getTradeController().setSenderName(App.getCurrentUser().getUsername());
                menu.getController().getTradeController().setGiverName((String) Users.getSelected());
                App.networkClient.sendMessage("TRADE_OFFER" + " " + (String) Users.getSelected());
                menu.getInventoryTable().setVisible(false);
            }
            Trade.setChecked(false);
        }
    }


    public void Equip(GameMenuController gamecontroller)
    {
        boolean ok = false;
        for(int i = 0;i < 36 ; i++)
        {
            if(!ok) {
                if (inventorySlots.get(i).getButton().isChecked()){
                    Texture ChoosenTexture = new Texture("Pants/Skirt.png");
                    Object item = inventorySlots.get(i).getItem();
                    if(item instanceof Tools)
                    {
                        Tools tool = (Tools)item;
                        ChoosenTexture = tool.getImage();
                        App.ReturnCurrentPlayer().getInventory().setCurrentTool((Tools)item);
                        gamecontroller.getPepoleeController().setToolTexture(ChoosenTexture);
                    }
                    if(item instanceof Item)
                    {
                        Item thing = (Item) item;
                        ChoosenTexture = thing.getImage();
                        App.ReturnCurrentPlayer().getInventory().setCurrentItem((Item)item);
                    }

                    TextureRegion region = new TextureRegion(ChoosenTexture);
                    TextureRegionDrawable drawable = new TextureRegionDrawable(region);
                    ChoosenItem.getStyle().up = drawable;
                    ChoosenItem.getStyle().down = drawable;
                    ok = true;
                }
            }
            inventorySlots.get(i).getButton().setChecked(false);
        }
    }

    public void EquipVillage(NPCVillageController gamecontroller)
    {
        boolean ok = false;
        for(int i = 0;i < 36 ; i++)
        {
            if(!ok) {
                if (inventorySlots.get(i).getButton().isChecked()){
                    Texture ChoosenTexture = new Texture("Pants/Skirt.png");
                    Object item = inventorySlots.get(i).getItem();
                    if(item instanceof Tools)
                    {
                        Tools tool = (Tools)item;
                        ChoosenTexture = tool.getImage();
                        App.ReturnCurrentPlayer().getInventory().setCurrentTool((Tools)item);
                        gamecontroller.getPepoleeController().setToolTexture(ChoosenTexture);
                    }
                    if(item instanceof Item)
                    {
                        Item thing = (Item) item;
                        ChoosenTexture = thing.getImage();
                        App.ReturnCurrentPlayer().getInventory().setCurrentItem((Item)item);
                    }

                    TextureRegion region = new TextureRegion(ChoosenTexture);
                    TextureRegionDrawable drawable = new TextureRegionDrawable(region);
                    ChoosenItem.getStyle().up = drawable;
                    ChoosenItem.getStyle().down = drawable;
                    ok = true;
                }
            }
            inventorySlots.get(i).getButton().setChecked(false);
        }
    }


    public void Update(GameMenuController gamecontroller)
    {
        Trade(gamecontroller.getMenu());
        Equip(gamecontroller);
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
                        break;
                    }
                }
            }
        }
        for(int i = 0;i < App.ReturnCurrentPlayer().getInventory().getItems().size();i++)
        {
            boolean ok = false;
            for(int j = 0;j < 36;j++)
            {
                if(inventorySlots.get(j).getItem() != null) {
                    if (inventorySlots.get(j).getItem().equals(App.ReturnCurrentPlayer().getInventory().getItems().get(i))) {
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
                        inventorySlots.get(j).SetImageButton(App.ReturnCurrentPlayer().getInventory().getItems().get(i));
                        break;
                    }
                }
            }
        }
    }

    public void UpdateVillage(NPCVillageController gamecontroller)
    {
        Main.getMain().getBatch().draw(BackGround , App.ReturnCurrentPlayer().getX() - 400 , App.ReturnCurrentPlayer().getY()  , 1000 , 1000);
        EquipVillage(gamecontroller);
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
                        break;
                    }
                }
            }
        }
        for(int i = 0;i < App.ReturnCurrentPlayer().getInventory().getItems().size();i++)
        {
            boolean ok = false;
            for(int j = 0;j < 36;j++)
            {
                if(inventorySlots.get(j).getItem() != null) {
                    if (inventorySlots.get(j).getItem().equals(App.ReturnCurrentPlayer().getInventory().getItems().get(i))) {
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
                        inventorySlots.get(j).SetImageButton(App.ReturnCurrentPlayer().getInventory().getItems().get(i));
                        break;
                    }
                }
            }
        }
    }
}
