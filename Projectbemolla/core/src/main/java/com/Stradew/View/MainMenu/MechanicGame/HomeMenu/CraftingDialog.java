package com.Stradew.View.MainMenu.MechanicGame.HomeMenu;

import com.Stradew.Controller.MainMenuController.HomeMenucontroller.CraftingController;
import com.Stradew.Model.App;
import com.Stradew.Model.Enums.Crafts;
import com.Stradew.Model.GameAssetsManager;
import com.Stradew.Model.Tools.Pepolee;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.math.Interpolation;


import java.util.Objects;

public class CraftingDialog extends Dialog {

    private final CraftingController craftingController;
    private final Skin skin;
    private Label feedbackLabel;

    private TextField craftName;

    private TextButton doCraft;
    private TextButton plantingCraft;

    int currentX;
    int currentY;


    public CraftingDialog(CraftingController craftingController, Skin skin) {
        super("Crafting", skin);
        this.craftingController = craftingController;
        this.skin = skin;


        initializeUI();
    }

    private void initializeUI() {
        feedbackLabel = new Label("", skin);
        currentX = (int) App.ReturnCurrentPlayer().getX();
        currentY = (int) App.ReturnCurrentPlayer().getY();

        Table mainTable = new Table();
        craftName = new TextField("Craft Name", skin);
        doCraft = new TextButton("Craft", skin);
        plantingCraft = new TextButton("Plant Craft", skin);
        doCraft.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                feedbackLabel.setText(CraftItem(craftName.getText()));
            }
        });

        plantingCraft.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                feedbackLabel.setText(PlantingACraft(craftName.getText(), currentX, currentY));
            }
        });

        mainTable.add(craftName).fillX();
        mainTable.add(doCraft).fillX();
        mainTable.add(plantingCraft).fillX().row();


        Table recipesTable = populateRecipes();

        mainTable.add(recipesTable);
        mainTable.row();
        mainTable.add(feedbackLabel);

        getContentTable().add(mainTable);

        button("Close", false);

        setModal(true);
        setMovable(true);
        setResizable(false);
    }

    private Table populateRecipes() {
        Table table = new Table();
        int i = 0;
        final int columns = 5;

        for (final Crafts craft : Crafts.values()) {
            if (!isCraftLocked(craft)) {
                if (craft.Craftimage == null){
                    continue;
                }
                Image craftImage = new Image(craft.Craftimage);
                craftImage.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        craftName.setText(craft.Name);
                    }
                });
                table.add(craftImage).size(64, 64).pad(5);

                if ((i + 1) % columns == 0) {
                    table.row();
                }
                i++;
            }
        }
        return table;
    }

    private boolean isCraftLocked(Crafts craft) {
        String status = App.craftingController.ShowCraft(craft);
        return Objects.equals(status, craft.toString() + ":" + "Locked" + "\n");
    }



    public void ShowCraftHelp() {
        System.out.println("--- Available Crafting Recipes ---");
        for (Crafts c : Crafts.values()) {
            System.out.println(App.craftingController.ShowCraft(c));
        }
    }

    public String CraftItem(String itemName) {
        Crafts craft = App.craftingController.ReturnCraft(itemName);
        if (craft == null) {
            return ("There is no such Craft");
        }
        if (isCraftLocked(craft)) {
            return ("It is Locked my friend");
        }
        if (!App.craftingController.EnoughSource(craft)) {
            return ("There is not enough source");
        }
        App.craftingController.ApplyCrafting(craft);
        return ("Craft created successfully");
    }

    public void ShowRecipes() {
        Pepolee currentPlayer = App.ReturnCurrentPlayer();
        System.out.println("--- Known Recipes in Inventory ---");
        for (int i = 0; i < currentPlayer.getInventory().getItems().size(); i++) {
            String name = currentPlayer.getInventory().getItems().get(i).getName();
            if (name.equals("DEHYDRATOR_RECIPE") || name.equals("FISH_SMOKER_RECIPE") || name.equals("GRASS_STARTER_RECIPE")) {
                System.out.println(name);
            }
        }
    }

    public String PlantingACraft(String itemName, int x, int y) {
        if (!App.craftingController.CanPlantCraft(x, y)) {
            return ("Can't plant here");
        }
        if (!App.craftingController.IsInInventory(itemName)) {
            return ("There is no such craft in inventory");
        }
        // App.craftingController.ApplyPlantCraft(itemName, x, y);
        return ("Craft planted successfully (logic not implemented).");
    }

}
