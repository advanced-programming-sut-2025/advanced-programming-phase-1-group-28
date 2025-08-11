package com.Stradew.View.MainMenu.MechanicGame.HomeMenu;

import com.Stradew.Controller.MainMenuController.HomeMenucontroller.CraftingController;
import com.Stradew.Model.App;
import com.Stradew.Model.Enums.Crafts;
import com.Stradew.Model.GameAssetsManager;
import com.Stradew.Model.Tools.Pepolee;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Crafting implements Screen {
    Stage stage;
    CraftingController craftingController;
    Skin skin;

    Label feedback;

    Table table;
    List<Image> knownRecipes = new ArrayList<>();

    public Crafting(CraftingController craftingController) {
        this.craftingController = craftingController;
        craftingController.setCrafting(this);
        skin = GameAssetsManager.getInstance().getSkin();



        int i = 0;
        for (Crafts craft: Crafts.values()) {
            Image slotImage = new Image(craft.Craftimage);
            knownRecipes.add(slotImage);

            int index = i;
            slotImage.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (!Objects.equals(App.craftingController.ShowCraft(craft), craft.toString() + ":" + "Locked" + "\n")) {
                        feedback.setText(craft.Name);
                    }
                }
            });
            if (!Objects.equals(App.craftingController.ShowCraft(craft), craft.toString() + ":" + "Locked" + "\n")) {
                table.add(slotImage).size(64, 64).pad(2);
            }
            if ((i + 1) % 5 == 0) {
                table.row();
            }
            i++;
        }
        table.setFillParent(true);
        stage.addActor(table);
    }

    public void ShowCraftHelp()
    {
        for(Crafts c : Crafts.values())
        {
            System.out.println(App.craftingController.ShowCraft(c));
        }
    }
    public void CraftItem(String ItemName) {
        if (App.craftingController.ReturnCraft(ItemName) == null) {
            System.out.println("There is no such Craft");
            return;
        }
        Crafts craft = App.craftingController.ReturnCraft(ItemName);
        if (Objects.equals(App.craftingController.ShowCraft(craft), craft.toString() + ":" + "Locked" + "\n")) {
            System.out.println("It is Locked my friend");
            return;
        }
        if (!App.craftingController.EnoughSource(craft)) {
            System.out.println("There is not enough source");
            return;
        }
        App.craftingController.ApplyCrafting(craft);
        System.out.println("Craft created successfully");
    }

    public void ShowRecipes()
    {
        Pepolee Currentpeople = App.ReturnCurrentPlayer();
        for(int i = 0;i < Currentpeople.getInventory().getItems().size();i++)
        {
            String Names = Currentpeople.getInventory().getItems().get(i).getName();
            if(Names.equals("DEHYDRATOR_RECIPE") || Names.equals("FISH_SMOKER_RECIPE") || Names.equals("GRASS_STARTER_RECIPE"))
            {
                System.out.println(Names);
            }
        }
    }

    public  void PlantingACraft(String ItemName ,int x , int y)
    {
        if(!App.craftingController.CanPlantCraft(x , y))
        {
            System.out.println("can't Plant here");
            return;
        }
        if(!App.craftingController.IsInInventory(ItemName))
        {
            System.out.println("There is no such craft in inventory");
            return;
        }
        //App.craftingController.ApplyPlantCraft(ItemName , x, y);
    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
