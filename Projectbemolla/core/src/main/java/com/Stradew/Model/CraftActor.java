package com.Stradew.Model;

import com.Stradew.Controller.MainMenuController.MapController;
import com.Stradew.Model.Tile.PlantedCrafts;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.awt.*;

public class CraftActor extends Image {

    PlantedCrafts Craft;

    public  CraftActor(PlantedCrafts craft,int X , int Y ,  final Runnable onClickAction) {

        super(craft.getCraft().Craftimage);
        this.Craft = craft;

        this.setPosition(X , Y);
        this.setSize(MapController.TILE_SIZE, MapController.TILE_SIZE);
        this.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (onClickAction != null) {
                    onClickAction.run();
                }
                event.stop();
            }
        });
    }
}
