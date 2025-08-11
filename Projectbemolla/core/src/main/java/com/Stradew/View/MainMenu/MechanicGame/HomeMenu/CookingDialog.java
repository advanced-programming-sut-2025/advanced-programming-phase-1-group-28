package com.Stradew.View.MainMenu.MechanicGame.HomeMenu;

import com.Stradew.Controller.MainMenuController.HomeMenucontroller.PokhtOPazController;
import com.Stradew.Model.App;
import com.Stradew.Model.Enums.Foods;
import com.Stradew.Model.Item.Food;
import com.Stradew.Model.Item.Item;
import com.Stradew.Model.Ref;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.util.ArrayList;
import java.util.List;

public class CookingDialog extends Dialog {

    private final PokhtOPazController pokhtOPazController;
    private final Skin skin;
    private final Label feedbackLabel;
    private final TextField itemNameField;
    private final List<Image> refSlotImages = new ArrayList<>();
    private final List<Image> recipeSlotImages = new ArrayList<>();

    private boolean isInRef = true;

    Table mainContent;
    Table refrigeratorView;
    Table actionPanelView;

    public CookingDialog(PokhtOPazController pokhtOPazController, Skin skin) {
        super("Kitchen & Refrigerator", skin);
        this.pokhtOPazController = pokhtOPazController;
        this.skin = skin;

        setModal(true);
        setMovable(true);

        this.feedbackLabel = new Label("", skin);
        this.itemNameField = new TextField("", skin);
        itemNameField.setMessageText("Item name...");

        mainContent = new Table();
        refrigeratorView = buildRefrigeratorView();
        actionPanelView = buildActionPanelView();

        TextButton SwitchMenu = new TextButton("Switch Menu", skin);
        SwitchMenu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                isInRef = !isInRef;

                mainContent.clear();

                mainContent.add(SwitchMenu);

                if (isInRef) {
                    refrigeratorView = buildRefrigeratorView();
                    mainContent.add(refrigeratorView).pad(10);
                    mainContent.add(actionPanelView).pad(10).top();
                    actionPanelView.setVisible(true);
                    updateRefrigeratorView();
                } else {
                    Table recipeMenu = buildRecipeMenu();
                    mainContent.add(recipeMenu).pad(10);
                    mainContent.add(actionPanelView).pad(10).top();
                    actionPanelView.setVisible(false);
                }
            }
        });

        mainContent.add(SwitchMenu);
        mainContent.add(refrigeratorView).pad(10);
        mainContent.add(actionPanelView).pad(10).top();

        getContentTable().add(mainContent);
        button("Close");

        updateRefrigeratorView();
    }

    private Table buildRefrigeratorView() {
        Table table = new Table();

        Ref ref = App.ReturnCurrentPlayer().getFarm().getCabin().getRefrigerator();
        List<Item> items = ref.getItems();

        for (int i = 0; i < ref.getItems().size(); i++) {
            Image slotImage = new Image(skin.getDrawable("default-button-down")); // Placeholder empty slot
            refSlotImages.add(slotImage);

            final int index = i;
            slotImage.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (index < items.size()) {
                        itemNameField.setText(items.get(index).getName());
                    }
                }
            });

            table.add(slotImage).size(64, 64).pad(2);
            if ((i + 1) % 5 == 0) {
                table.row();
            }
        }
        return table;
    }

    private Table buildActionPanelView() {
        Table table = new Table();
        table.defaults().pad(5).fillX();

        TextButton pickButton = new TextButton("Pick From Fridge", skin);
        TextButton putButton = new TextButton("Put in Fridge", skin);
        TextButton cookButton = new TextButton("Cook Item", skin);
        TextButton eatButton = new TextButton("Eat Item", skin);

        table.add(new Label("Selected Item:", skin)).colspan(2).left().row();
        table.add(itemNameField).colspan(2).height(40).row();
        table.add(pickButton);
        table.add(putButton).row();
        table.add(cookButton);
        table.add(eatButton).row();
        table.add(feedbackLabel).colspan(2).height(60).growX();

        pickButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                pickFromRef(itemNameField.getText());
            }
        });
        putButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                putInRef(itemNameField.getText());
            }
        });
        cookButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                cookItem(itemNameField.getText());
            }
        });
        eatButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                eatItem(itemNameField.getText());
            }
        });

        return table;
    }

    private Table buildRecipeMenu(){
        Table table = new Table();

        List<Foods> knownRecipes = App.ReturnCurrentPlayer().getKnownRecipes();

        for (int i = 0; i < knownRecipes.size(); i++) {
            Image slotImage = new Image(knownRecipes.get(i).texture);
            recipeSlotImages.add(slotImage);

            int index = i;
            slotImage.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (index < knownRecipes.size()) {
                        itemNameField.setText(knownRecipes.get(index).name());
                    }
                }
            });

            table.add(slotImage).size(64, 64).pad(2);
            if ((i + 1) % 5 == 0) {
                table.row();
            }
        }
        return table;
    }

    private void updateRefrigeratorView() {
        Ref ref = App.ReturnCurrentPlayer().getFarm().getCabin().getRefrigerator();
        List<Item> items = ref.getItems();
        for (int i = 0; i < refSlotImages.size(); i++) {
            if (i < items.size()) {
                refSlotImages.get(i).setDrawable(new TextureRegionDrawable(items.get(i).getImage()));
            } else {
                refSlotImages.get(i).setDrawable(skin.getDrawable("default-button-down"));
            }
        }
    }

    private void pickFromRef(String itemName) {
        Ref ref = App.ReturnCurrentPlayer().getFarm().getCabin().getRefrigerator();
        if (!ref.isItemAvailable(itemName)) {
            feedbackLabel.setText("That item isn't in the fridge.");
            return;
        }
        pokhtOPazController.ApplyPickFromRef(itemName);
        feedbackLabel.setText("Took " + itemName + " from the fridge.");
        updateRefrigeratorView();
    }

    private void putInRef(String itemName) {
        Item item = App.ReturnCurrentPlayer().getInventory().getItemByName(itemName);
        if (item == null) {
            feedbackLabel.setText("You don't have that item in your inventory.");
            return;
        }
        if (!(item instanceof Food)) {
            feedbackLabel.setText("You can only put food in the refrigerator.");
            return;
        }
        pokhtOPazController.ApplyPut(itemName);
        feedbackLabel.setText("Put " + itemName + " in the fridge.");
        updateRefrigeratorView();
    }

    private void cookItem(String itemName) {
        if (!pokhtOPazController.EnoughSkill(itemName)) {
            feedbackLabel.setText("Your cooking skill is too low for that recipe.");
            return;
        }
        if (!pokhtOPazController.EnoughItemsFromInventory(itemName) &&
            !pokhtOPazController.EnoughItemsFromRef(itemName)) {
            feedbackLabel.setText("You're missing some ingredients.");
            return;
        }
        pokhtOPazController.ApplyPokhtingOPazing(itemName);
        feedbackLabel.setText("You successfully cooked " + itemName + "!");
        updateRefrigeratorView();
    }

    private void eatItem(String itemName) {
        Item item = App.ReturnCurrentPlayer().getInventory().getItemByName(itemName);
        if (item == null) {
            feedbackLabel.setText("You don't have that item to eat.");
            return;
        }
        if (!(item instanceof Food)) {
            feedbackLabel.setText("That doesn't look edible...");
            return;
        }
        pokhtOPazController.ApplyEatingFood(itemName);
        feedbackLabel.setText("You ate the " + itemName + ".");
        showEatAnimation();
        showBuffIcon();
    }

    private void showEatAnimation() {
        Image foodImage = new Image(new Texture(Gdx.files.internal("Recipe/Lobster_Bisque.png")));
        foodImage.setSize(64, 64);
        foodImage.setPosition(Gdx.graphics.getWidth() / 2f - 32, Gdx.graphics.getHeight() / 2f - 32);

        foodImage.addAction(Actions.sequence(
            Actions.parallel(
                Actions.scaleTo(1.5f, 1.5f, 0.5f),
                Actions.fadeOut(0.5f)
            ),
            Actions.run(() -> foodImage.remove())
        ));

        getStage().addActor(foodImage);
    }

    private void showBuffIcon() {
        Image buffImage = new Image(new Texture("Buff/Jinxed.png"));
        buffImage.setSize(64, 64);
        buffImage.setPosition(Gdx.graphics.getWidth() / 2f - 32, Gdx.graphics.getHeight() - 100);

        buffImage.addAction(Actions.sequence(
            Actions.parallel(
                Actions.fadeIn(0.3f),
                Actions.scaleTo(1.2f, 1.2f, 0.3f)
            ),
            Actions.delay(2f),
            Actions.parallel(
                Actions.fadeOut(0.5f),
                Actions.scaleTo(0.8f, 0.8f, 0.5f)
            ),
            Actions.run(buffImage::remove)
        ));

        getStage().addActor(buffImage);
    }


}
