package com.Stradew.Model;

import com.Stradew.Controller.MainMenuController.MapController;
import com.Stradew.Main;
import com.Stradew.Model.Places.AnimalHouse;
import com.Stradew.Model.Tile.Animal;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

import java.awt.*;

public class AnimalActor extends Image {

    Animal animal;
    public AnimalActor(Animal animal, final Runnable onClickAction) {
        super(animal.getAnimalType().texture);
        this.animal = animal;

        this.setPosition(animal.getX() * MapController.TILE_SIZE, animal.getY() * MapController.TILE_SIZE);

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
