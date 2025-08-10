package com.Stradew.View.MainMenu.MechanicGame;

import com.Stradew.Controller.MainMenuController.MechanicController.MechanicController;
import com.Stradew.Model.App;
import com.Stradew.Model.GameAssetsManager;
import com.Stradew.Model.Item.Item;
import com.Stradew.Model.Tile.Animal;
import com.Stradew.Model.Tools.Pepolee;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
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


public class MechanicGame implements Screen {
    MechanicController mechanicController = App.mechanicController;
    Stage stage;
    Skin skin;
    Animal myAnimal;

    Label feedback;
    Label info;
    Label allProducts;

    TextButton feedAnimal;
    TextButton getProducts;
    TextButton sell;
    TextButton shepherd;
    TextButton seeProducts;
    TextButton seeMainTable;

    TextField X;
    TextField Y;

    Table mainTable;
    Table products;
    Table switchButtons;
    private float stateTime = 0f;
    private boolean isPettingAnimationPlaying = false;
    private float pettingAnimationTimer = 0f;
    private Dialog pettingAnimationDialog = null;
    private Image pettingCharacterImage = null;
    private Animation<TextureRegion> playerPettingAnimation = null;


    public MechanicGame(MechanicController mechanicController) {
        this.mechanicController = mechanicController;
        mechanicController.setMechanicGame(this);
        skin = GameAssetsManager.getInstance().getSkin();

        feedback = new Label("", skin);
        if (myAnimal != null){
            info = new Label(this.ShowAnimal(myAnimal), skin);
            allProducts = new Label(this.ShowAllAvailableProducts(myAnimal), skin);
        }else {
            info = new Label("", skin);
            allProducts = new Label("", skin);
        }

        X = new TextField("X", skin);
        Y = new TextField("Y", skin);

        feedAnimal = new TextButton("Feed", skin);
        getProducts = new TextButton("Get Products", skin);
        sell = new TextButton("Sell", skin);
        shepherd = new TextButton("Shepherd", skin);
        seeProducts = new TextButton("Show Products", skin);
        seeMainTable = new TextButton("Animal Menu", skin);

        mainTable = new Table();
        mainTable.setFillParent(true);
        products = new Table();
        products.setFillParent(true);
        products.setVisible(false);
        switchButtons = new Table();

        mainTable.add(info).row();
        mainTable.add(feedAnimal);
        mainTable.add(getProducts);
        mainTable.add(sell).row();
        mainTable.add(X);
        mainTable.add(Y);
        mainTable.add(shepherd);

        switchButtons.add(seeMainTable);
        switchButtons.add(seeProducts);

        products.add(allProducts);

        feedAnimal.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                feedback.setText(FeedAnimal(myAnimal.getPetName()));
            }
        });

        getProducts.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                feedback.setText(getAnimalProducts(myAnimal.getPetName()));
            }
        });

        sell.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                feedback.setText(SellAnimal(myAnimal.getPetName()));
            }
        });

        shepherd.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                try {
                    feedback.setText(shepherdAnimal(myAnimal.getPetName(), Integer.parseInt(X.getText()), Integer.parseInt(Y.getText())));
                }catch (Exception e){

                }
            }
        });

        seeProducts.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                mainTable.setVisible(false);
                products.setVisible(true);
                allProducts.setText(ShowAllAvailableProducts(myAnimal));
            }
        });

        seeMainTable.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                products.setVisible(false);
                mainTable.setVisible(true);
            }
        });


    }

    public void BuildGreenHouse() {
        if(!App.mechanicController.EnoughSourceForGreenhouse())
        {
            System.out.println("Akhe fahgir");
            return;
        }

    }

    public void walk(int StartX, int StartY, int EndX, int EndY)
    {
        int Cost = App.mechanicController.BFS(StartX, StartY, EndX, EndY);
        if(Cost == -1)
        {
            System.out.println("You Cant reach The point . \n Do you want Go And Faint?");
            String ISOK = App.scanner.nextLine();
            if(ISOK.equals("Yes"))
            {
                App.mechanicController.ApplyWalkToFaint(StartX, StartY, EndX, EndY);
            }
        }
        else
        {
            System.out.println("You can go there in Energy cost : " + Cost / 20 + "Do you wanna Go there");
            String ISOK = App.scanner.nextLine();
            if(ISOK.equals("Yes"))
            {
                App.mechanicController.ApplyWalk(StartX, StartY, EndX, EndY);
            }
        }
    }

    public boolean IsEnergyOver()
    {
        return false;
    }

    public void DeleteFromInventory(String ItemName , int Number)
    {
        if(!mechanicController.EnoughItemInInventory(ItemName, Number))
        {
            System.out.println("there is not enough number of item in Inventory");
            return;
        }
        App.mechanicController.ApplyRemoveItem(ItemName, Number);
    }
    public void SetTool()
    {

    }
    public void UpgradeTool()
    {

    }
    public void PutOnEarth(int x , int y , String ItemName)
    {

    }
    public void BuildBuilding(String BuildingName , int x , int y)
    {

    }

    public String Pet(String animalName)
    {
        Animal animal = App.ReturnCurrentPlayer().getFarm().getAnimalByName(animalName);
        if (animal == null){
            return ("It seems your petting skills are so good, you're even making friends with nothing!");
        }
        mechanicController.ApplyPetAnimal(animal);
        return ("Aww, so gentle!");
    }

    public void petAllAnimals(){
        for (Animal animal: App.ReturnCurrentPlayer().getFarm().getAnimals()){
            Pet(animal.getPetName());
        }
    }

    public String getAnimalProducts(String animalName){
        Animal animal = App.ReturnCurrentPlayer().getFarm().getAnimalByName(animalName);
        if (animal == null){
            return ("No animal with that name exists here.");
        }
        mechanicController.CollectAnimalProduce(animal);
        return ("You collect " + animalName + " products successfully.");
    }

    public String shepherdAnimal(String animalName , int x , int y)
    {
        Animal animal = App.ReturnCurrentPlayer().getFarm().getAnimalByName(animalName);
        if (animal == null){
            return ("No animal with that name exists here.");
        } else if (mechanicController.BFS(animal.getX(), animal.getY(), x, y) == -1 ||
        (x - animal.getX()) * (x - animal.getX()) + (y - animal.getY()) * (y - animal.getY()) > 300) {
            return ("You can't reach there.");
        }
        mechanicController.ApplyMovingAnimal(animal, x, y);
        return ("You moved " + animalName + " successfully.");
    }

    public String FeedAnimal(String animalName)
    {
        Animal animal = App.ReturnCurrentPlayer().getFarm().getAnimalByName(animalName);
        if (animal == null){
            return ("You are phychologically ravani." + "\nNo animal with that name exists here.");
        }
        if (!App.friendShipController.isItemAvailable("Hay")){
            return ("You have no hay.");
        }
        mechanicController.ApplyFeedAnimal(animal);
        return ("Animal fed successfully.");
    }

    public String SellAnimal(String animalName){
        Animal animal = App.ReturnCurrentPlayer().getFarm().getAnimalByName(animalName);
        if (animal == null){
            return ("No animal with that name exists here.");
        }
        mechanicController.SellAnimal(animal);
        return ("You've sold " + animalName + ". It's sad to see them go, but you received " + animal.getSellPrice() + ".");
    }

    public String ShowAnimal(Animal animal)
    {
        String result = "";
        result += ("Name: " + animal.getPetName() + "\n");
        result += ("Type: " + animal.getAnimalType().toString() + "\n");
        result += ("Friendship: " + animal.getFriendShip() + "\n");
        if (animal.isPettedToday()){
            result += ("Has been petted today.");
        }else {
            result += ("Hasn't been petted today.");
        }if (animal.isFed()){
        result += ("Has been fed today.");
    }else {
        result += ("Hasn't been fed today.");
    }
        return result;
    }

    public String ShowAllAvailableProducts(Animal animal)
    {
        Pepolee currentPlayer = App.ReturnCurrentPlayer();
        String result = "";
        result += ("Animal products:\n");
        for (Item item: animal.getProducts()){
            result += (item.getName() + "\n");
        }
        return result;
    }

    public void Fishing(int x , int y)
    {
        //we have USe Tool
    }
    public void MakeArtisan(String ArtisanName)
    {
        //it maybe have Tow Inputs
    }
    public void HarvestArtisanProduce()
    {

    }
    public void Purchase()
    {

    }
    public void SellProduct(Item item)
    {

    }

    public Animal getMyAnimal() {
        return myAnimal;
    }

    public void setMyAnimal(Animal myAnimal) {
        this.myAnimal = myAnimal;
        info.setText(this.ShowAnimal(myAnimal));
        allProducts.setText(this.ShowAllAvailableProducts(myAnimal));
    }

    public void playPettingAnimation(Stage stage) {


        Animation<TextureRegion> playerAnimation = GameAssetsManager.getInstance().getPlayerAnimationRegion();
        if (playerAnimation == null) {
            Gdx.app.error("Animation", "Player animation is null.");
            return;
        }
        playerAnimation.setPlayMode(Animation.PlayMode.LOOP);
        stateTime = 0f;

        final Texture animalTexture = new Texture(Gdx.files.internal("Animals/Ostrich.png"));
        final Texture heartTexture = new Texture(Gdx.files.internal("Heart/HeartIconLarge.png"));

        Dialog dialog = new Dialog("", skin){
            @Override
            public void hide() {
                super.hide();
                animalTexture.dispose();
                heartTexture.dispose();
            }
        };
        dialog.setModal(true);

        dialog.button("Close");

        Table layoutTable = new Table();
        Image characterImage = new Image(playerAnimation.getKeyFrame(0));
        Image animalImage = new Image(animalTexture);
        Image heartImage = new Image(heartTexture);

        Stack animalStack = new Stack();
        animalStack.add(animalImage);
        heartImage.setPosition(animalImage.getWidth() / 4f, animalImage.getHeight() * 1.8f);
        animalStack.add(heartImage);

        layoutTable.add(characterImage).size(characterImage.getWidth() * 2, characterImage.getHeight() * 2).padRight(20).bottom();
        layoutTable.add(animalStack).size(animalImage.getWidth() * 2, animalImage.getHeight() * 2);

        dialog.getContentTable().add(layoutTable).pad(30);


        characterImage.addAction(Actions.forever(Actions.run(() -> {
            stateTime += Gdx.graphics.getDeltaTime();
            ((TextureRegionDrawable) characterImage.getDrawable()).setRegion(playerAnimation.getKeyFrame(stateTime, true));
        })));

        characterImage.addAction(Actions.forever(Actions.sequence(
            Actions.moveBy(-10, 15, 0.5f),
            Actions.delay(1.5f),
            Actions.moveBy(10, -15, 0.5f)
        )));

        animalImage.addAction(Actions.forever(Actions.sequence(
            Actions.delay(0.5f),
            Actions.moveBy(0, 10, 0.2f),
            Actions.moveBy(0, -10, 0.2f),
            Actions.delay(1.6f)
        )));

        heartImage.addAction(Actions.forever(Actions.sequence(
            Actions.delay(0.7f),
            Actions.run(() -> heartImage.setVisible(true)),
            Actions.alpha(1),
            Actions.moveTo(heartImage.getX(), animalImage.getHeight() * 1.8f), // ریست کردن موقعیت
            Actions.parallel(
                Actions.moveBy(0, 40, 1.5f),
                Actions.fadeOut(1.5f)
            ),
            Actions.run(() -> heartImage.setVisible(false)),
            Actions.delay(0.3f)
        )));


        dialog.show(stage);
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




//Tow above Functions maybe Move To Another Places

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
