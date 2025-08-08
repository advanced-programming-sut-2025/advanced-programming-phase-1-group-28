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
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;


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

    public void Pet(String animalName)
    {
        Animal animal = App.ReturnCurrentPlayer().getFarm().getAnimalByName(animalName);
        if (animal == null){
            System.out.println("It seems your petting skills are so good, you're even making friends with nothing!");
            return;
        }
        mechanicController.ApplyPetAnimal(animal);
        System.out.println("Aww, so gentle!");
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
