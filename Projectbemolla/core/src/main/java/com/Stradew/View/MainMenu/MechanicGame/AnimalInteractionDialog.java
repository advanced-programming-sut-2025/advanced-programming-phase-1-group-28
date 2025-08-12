package com.Stradew.View.MainMenu.MechanicGame;

import com.Stradew.Controller.MainMenuController.MechanicController.MechanicController;
import com.Stradew.Model.App;
import com.Stradew.Model.GameAssetsManager;
import com.Stradew.Model.Item.Item;
import com.Stradew.Model.Tile.Animal;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

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
    private float stateTime = 0f;

    public AnimalInteractionDialog(Animal animal, MechanicController mechanicController, Skin skin) {
        super("Interacting with " + animal.getPetName(), skin);
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
                if (feedbackLabel.getText().toString().equals("Animal fed successfully.")){
                    playFeedingAnimation(table.getStage());
                }
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
                    playShepherdingAnimation(table.getStage());
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


    public void playFeedingAnimation(Stage stage) {
        final Texture animalTexture = new Texture(Gdx.files.internal("Animals/Ostrich.png"));
        final Texture hayTexture = new Texture(Gdx.files.internal("Recipe/Triple_Shot_Espresso.png"));

        Dialog dialog = new Dialog("", skin) {
            @Override
            public void hide() {
                super.hide();
                animalTexture.dispose();
                hayTexture.dispose();
            }
        };

        dialog.setModal(true);
        dialog.button("Close");

        Image animalImage = new Image(animalTexture);
        Image hayImage = new Image(hayTexture);
        hayImage.setOrigin(Align.center);

        Stack sceneStack = new Stack();
        sceneStack.add(animalImage);
        sceneStack.add(hayImage);

        dialog.getContentTable().add(sceneStack)
            .size(animalImage.getWidth() * 3, animalImage.getHeight() * 3)
            .pad(30);

        hayImage.addAction(Actions.forever(Actions.sequence(
            Actions.run(() -> {
                hayImage.setVisible(true);
                hayImage.setPosition(animalImage.getWidth(), animalImage.getHeight() * 2f);
                hayImage.setScale(0);
                hayImage.getColor().a = 1;
            }),
            Actions.scaleTo(0.7f, 0.7f, 0.4f),
            Actions.delay(0.2f),
            Actions.moveTo(
                animalImage.getWidth() * 1.5f - hayImage.getWidth() / 2,
                animalImage.getHeight() * 1.5f - hayImage.getHeight() / 2,
                1.0f
            ),
            Actions.fadeOut(0.3f),
            Actions.delay(0.8f)
        )));

        animalImage.addAction(Actions.forever(Actions.sequence(
            Actions.delay(1.9f),
            Actions.scaleTo(1.05f, 0.95f, 0.15f),
            Actions.scaleTo(1f, 1f, 0.15f),
            Actions.delay(0.5f)
        )));


        dialog.show(stage);
    }


    public void playShepherdingAnimation(Stage stage) {
        Animation<TextureRegion> playerAnimation = GameAssetsManager.getInstance().getPlayerAnimationRegion();
        if (playerAnimation == null) {
            Gdx.app.error("Animation", "Player animation is null.");
            return;
        }
        playerAnimation.setPlayMode(Animation.PlayMode.LOOP);
        stateTime = 0f;

        final Texture ostrichTexture = new Texture(Gdx.files.internal("Animals/Ostrich.png"));
        final Texture chickenTexture = new Texture(Gdx.files.internal("Animals/Cat_2.png"));
        final Texture catTexture = new Texture(Gdx.files.internal("Animals/Rabbit.png"));
        final Texture hayTexture = new Texture(Gdx.files.internal("Recipe/Ice_Cream.png"));
        final Texture cornTexture = new Texture(Gdx.files.internal("Recipe/Miner%27s_Treat.png"));
        final Texture seedsTexture = new Texture(Gdx.files.internal("Recipe/Triple_Shot_Espresso.png"));

        Dialog dialog = new Dialog("", skin) {
            @Override
            public void hide() {
                super.hide();
                ostrichTexture.dispose();
                chickenTexture.dispose();
                catTexture.dispose();
                hayTexture.dispose();
                cornTexture.dispose();
                seedsTexture.dispose();
            }
        };
        dialog.setModal(true);
        dialog.button("Close");

        Image playerImage = new Image(playerAnimation.getKeyFrame(0));
        Image ostrichImage = new Image(ostrichTexture);
        Image chickenImage = new Image(chickenTexture);
        Image catImage = new Image(catTexture);
        Image hayImage = new Image(hayTexture);
        Image cornImage = new Image(cornTexture);
        Image seedsImage = new Image(seedsTexture);

        Stack sceneStack = new Stack();
        dialog.getContentTable().add(sceneStack).width(Gdx.graphics.getWidth() * 0.7f).height(Gdx.graphics.getHeight() * 0.5f);

        Table foodTable = new Table();
        foodTable.add(hayImage).pad(10);
        foodTable.add(cornImage).pad(10);
        foodTable.add(seedsImage).pad(10);
        foodTable.align(Align.right | Align.bottom).padRight(50).padBottom(20);
        sceneStack.add(foodTable);

        Group characterGroup = new Group();
        characterGroup.addActor(playerImage);

        ostrichImage.setPosition(900 - 90, 80 - 20);
        chickenImage.setPosition(900 - 150, 80);
        catImage.setPosition(900 - 120, 80 + 30);
        characterGroup.addActor(ostrichImage);
        characterGroup.addActor(chickenImage);
        characterGroup.addActor(catImage);
        sceneStack.add(characterGroup);


        playerImage.addAction(Actions.forever(Actions.run(() -> {
            stateTime += Gdx.graphics.getDeltaTime();
            ((TextureRegionDrawable) playerImage.getDrawable()).setRegion(playerAnimation.getKeyFrame(stateTime, true));
        })));


        ostrichImage.addAction(Actions.forever(Actions.sequence(
            Actions.moveBy(0, 5, 0.4f),
            Actions.moveBy(0, -5, 0.4f)
        )));
        chickenImage.addAction(Actions.forever(Actions.sequence(
            Actions.delay(0.2f),
            Actions.moveBy(0, 7, 0.3f),
            Actions.moveBy(0, -7, 0.3f)
        )));
        catImage.addAction(Actions.forever(Actions.sequence(
            Actions.delay(0.1f),
            Actions.moveBy(0, 4, 0.35f),
            Actions.moveBy(0, -4, 0.35f)
        )));

        characterGroup.addAction(Actions.forever(Actions.sequence(
            Actions.run(() -> characterGroup.setPosition(-characterGroup.getWidth(), 20)),
            Actions.moveTo(sceneStack.getWidth(), 20, 7.0f)
        )));

        dialog.show(stage);
    }




}
