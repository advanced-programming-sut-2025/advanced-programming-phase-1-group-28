package com.Stradew.View.MainMenu.MechanicGame;

import com.Stradew.Controller.MainMenuController.MechanicController.MechanicController;
import com.Stradew.Model.App;
import com.Stradew.Model.Item.Item;
import com.Stradew.Model.Tile.Animal;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class AnimalInteractionDialog extends Dialog {

    private final MechanicController mechanicController;
    private final Animal animal;
    private final Skin skin;

    private final Label feedbackLabel;
    private final Label infoLabel;
    private final Label productsLabel;

    private final Table container;
    private final Table mainView;
    private final Table productsView;

    public AnimalInteractionDialog(Animal animal, MechanicController mechanicController, Skin skin) {
        super("Interacting with " + animal.getPetName(), skin, "dialog");
        this.animal = animal;
        this.mechanicController = mechanicController;
        this.skin = skin;

        setModal(true);
        setMovable(true);

        this.feedbackLabel = new Label("", skin);
        this.infoLabel = new Label("", skin);
        this.productsLabel = new Label("", skin);

        this.mainView = buildMainView();
        this.productsView = buildProductsView();

        this.container = new Table();
        this.container.add(mainView);

        updateInfoLabel();

        Table content = getContentTable();
        content.add(container).row();
        content.add(feedbackLabel).width(350).padTop(10).row();

        button("Close");
    }

    private Table buildMainView() {
        Table table = new Table();
        table.defaults().pad(5);

        TextField xField = new TextField("", skin);
        TextField yField = new TextField("", skin);
        xField.setMessageText("X");
        yField.setMessageText("Y");

        TextButton feedButton = new TextButton("Feed", skin);
        TextButton getProductsButton = new TextButton("Get Products", skin);
        TextButton sellButton = new TextButton("Sell", skin);
        TextButton shepherdButton = new TextButton("Shepherd", skin);
        TextButton showProductsButton = new TextButton("Show Products", skin);

        table.add(infoLabel).colspan(3).left().row();

        table.add(feedButton).fillX();
        table.add(getProductsButton).fillX();
        table.add(sellButton).fillX().row();

        table.add(xField).width(60);
        table.add(yField).width(60);
        table.add(shepherdButton).fillX().row();

        table.add(showProductsButton).colspan(3).fillX().padTop(10);

        feedButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                feedAnimal();
                updateInfoLabel();
            }
        });

        getProductsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                getAnimalProducts();
            }
        });

        sellButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sellAnimal();
            }
        });

        shepherdButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                try {
                    int newX = Integer.parseInt(xField.getText());
                    int newY = Integer.parseInt(yField.getText());
                    shepherdAnimal(newX, newY);
                } catch (NumberFormatException e) {
                    feedbackLabel.setText("Please enter valid X and Y coordinates.");
                }
            }
        });

        showProductsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                updateProductsLabel();
                container.clear();
                container.add(productsView);
            }
        });

        return table;
    }

    private Table buildProductsView() {
        Table table = new Table();
        table.defaults().pad(5);

        TextButton backButton = new TextButton("Back to Info", skin);

        ScrollPane scrollPane = new ScrollPane(productsLabel, skin);
        productsLabel.setWrap(true);

        table.add(new Label("Available Products:", skin)).left().row();
        table.add(scrollPane).width(300).height(100).fill().row();
        table.add(backButton).fillX().padTop(10);

        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                updateInfoLabel();
                container.clear();
                container.add(mainView);
            }
        });

        return table;
    }

    private void updateInfoLabel() {
        String info = "Type: " + animal.getAnimalType() + "\n" +
            "Friendship: " + animal.getFriendShip() + "\n" +
            (animal.isPettedToday() ? "Petted today" : "Not petted today") + "\n" +
            (animal.isFed() ? "Fed today" : "Not fed today");
        infoLabel.setText(info);
    }

    private void updateProductsLabel() {
        StringBuilder productsText = new StringBuilder();
        if (animal.getProducts().isEmpty()) {
            productsText.append("None");
        } else {
            for (Item item : animal.getProducts()) {
                productsText.append(item.getName()).append("\n");
            }
        }
        productsLabel.setText(productsText.toString());
    }

    private void feedAnimal() {
        if (!App.friendShipController.isItemAvailable("Hay")) {
            feedbackLabel.setText("You have no hay.");
            return;
        }
        mechanicController.ApplyFeedAnimal(animal);
        feedbackLabel.setText("Animal fed successfully.");
    }

    private void getAnimalProducts() {
        mechanicController.CollectAnimalProduce(animal);
        feedbackLabel.setText("You collected products from " + animal.getPetName() + ".");
    }

    private void sellAnimal() {
        mechanicController.SellAnimal(animal);
        feedbackLabel.setText("You've sold " + animal.getPetName() + " for " + animal.getSellPrice() + "g.");
        this.hide();
    }

    private void shepherdAnimal(int x, int y) {
        if (mechanicController.BFS(animal.getX(), animal.getY(), x, y) == -1) {
            feedbackLabel.setText("The animal can't reach that location.");
            return;
        }
        mechanicController.ApplyMovingAnimal(animal, x, y);
        feedbackLabel.setText(animal.getPetName() + " has been moved.");
    }
}
