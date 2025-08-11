package com.Stradew.View.MainMenu.MechanicGame;


import com.Stradew.Controller.MainMenuController.MechanicController.CraftMenuController;
import com.Stradew.Controller.MainMenuController.MechanicController.NPC_Controller;
import com.Stradew.Model.*;
import com.Stradew.Model.Tile.PlantedCrafts;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;


public class CraftMenu extends Dialog {

    private ProgressBar progressBar = new ProgressBar(0 , 200 , 1f , false , GameAssetsManager.getInstance().getSkin());

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    private CraftMenuController controller;
    private PlantedCrafts plantedCrafts;
    private Table MainTable;
    private Table container;
    private TextButton Back;
    private boolean IsStarted = false;
    private float TimePassed = 0;

    public void setTimePassed(float timePassed) {
        TimePassed = timePassed;
    }

    public CraftMenuController getController() {
        return controller;
    }

    public PlantedCrafts getPlantedCrafts() {
        return plantedCrafts;
    }

    public Table getMainTable() {
        return MainTable;
    }

    public Table getContainer() {
        return container;
    }

    public TextButton getBack() {
        return Back;
    }

    public boolean isStarted() {
        return IsStarted;
    }

    public float getTimePassed() {
        return TimePassed;
    }

    public CraftMenu(PlantedCrafts plantedCrafts , CraftMenuController craftMenuController) {
        super("Craft Menu" , GameAssetsManager.getInstance().getSkin());
        this.plantedCrafts = plantedCrafts;
        this.controller = craftMenuController;
        setModal(true);
        setMovable(true);

        MainTable = CreateMainTable();
        container = new Table();
        container.add(MainTable);

        getContentTable().add(container).pad(20);

        button("Close", true);
    }


    public Table CreateMainTable() {
        Table table  = new Table();
        TextButton Start = new TextButton("Start", GameAssetsManager.getInstance().getSkin());
        TextButton Finish = new TextButton("Finish", GameAssetsManager.getInstance().getSkin());
        TextButton Purchase = new TextButton("Purchase", GameAssetsManager.getInstance().getSkin());
        TextButton CheatCode = new TextButton("EndEarly" , GameAssetsManager.getInstance().getSkin());
        table.add(progressBar).colspan(2).pad(10);
        table.add(Finish).pad(10).row();
        table.add(Start).pad(10).row();
        table.add(Purchase).pad(10);
        table.add(CheatCode).pad(10);
        Start.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                IsStarted = true;
            }
        });


        CheatCode.addListener(new ClickListener() {
           @Override
           public void clicked(InputEvent event, float x, float y) {
               if(IsStarted)
               {
                   TimePassed = 200;
               }
           }
        });
        Finish.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                IsStarted = false;
                TimePassed = 0;
                progressBar.setValue(0);
            }
        });

        Purchase.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(TimePassed * 10 > 200)
                {
                    App.ReturnCurrentPlayer().getInventory().addItem(plantedCrafts.getCraft().item);
                    IsStarted = false;
                    TimePassed = 0;
                    progressBar.setValue(0);
                }
            }
        });

        return table;
    }
}
