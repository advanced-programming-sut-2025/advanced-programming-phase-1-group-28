package com.Stradew.Model;

import com.Stradew.Model.Enums.Seeds;
import com.Stradew.Model.GameAssetsManager;
import com.Stradew.Model.Item.Item;
import com.Stradew.Model.Tools.Pickaxe;
import com.Stradew.Model.Tools.Tools;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

public class InventorySlot {
    private ImageButton button;
    private Object item = null;


    public InventorySlot() {
        Texture Axe = new Texture("Pants/Baggy_Pants.png");
        TextureRegion region = new TextureRegion(Axe);
        TextureRegionDrawable drawable = new TextureRegionDrawable(region);
        ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle();
        style.up = drawable;
        style.down = drawable;
        button = new ImageButton(style);

        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (item instanceof Item){
                    App.ReturnCurrentPlayer().getInventory().setCurrentItem((Item) item);
                } else if (item instanceof Tools) {
                    App.ReturnCurrentPlayer().getInventory().setCurrentTool((Tools) item);
                }
            }
        });
    }

    public ImageButton getButton() {
        return button;
    }

    public Object getItem() {
        return item;
    }

    public void SetImageButton(Object item) {
        this.item = item;
        Texture buttonTexture = null;
        if(item instanceof Seeds){

        }
        if(item instanceof Tools)
        {
            Tools tool = (Tools)item;
            buttonTexture  = tool.getImage();
        }
        if(item instanceof Item)
        {
            buttonTexture = new Texture("Mineral/Aerinite.png");
        }
        TextureRegion region = new TextureRegion(buttonTexture);
        TextureRegionDrawable drawable = new TextureRegionDrawable(region);
        //ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle();
        //style.up = drawable;
        //style.down = drawable;
       // mageButton newbutton  = new ImageButton(style);
        //button = newbutton;
        button.getStyle().up = drawable;
        button.getStyle().down = drawable;

    }

}
