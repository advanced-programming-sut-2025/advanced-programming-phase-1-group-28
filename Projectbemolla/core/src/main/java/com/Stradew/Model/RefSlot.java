package com.Stradew.Model;

import com.Stradew.Model.Enums.Seeds;
import com.Stradew.Model.Item.Item;
import com.Stradew.Model.Tools.Tools;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class RefSlot {

    private ImageButton button;
    private Object item = null;


    public RefSlot() {
        Texture Axe = new Texture("Pants/Baggy_Pants.png");
        TextureRegion region = new TextureRegion(Axe);
        TextureRegionDrawable drawable = new TextureRegionDrawable(region);
        ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle();
        style.up = drawable;
        style.down = drawable;
        button = new ImageButton(style);

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
        if (item instanceof Item){
            buttonTexture = ((Item) item).getImage();
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
