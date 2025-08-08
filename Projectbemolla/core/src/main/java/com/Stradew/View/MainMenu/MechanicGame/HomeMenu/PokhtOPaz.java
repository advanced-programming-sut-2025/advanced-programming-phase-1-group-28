package com.Stradew.View.MainMenu.MechanicGame.HomeMenu;

import com.Stradew.Controller.MainMenuController.HomeMenucontroller.PokhtOPazController;
import com.Stradew.Model.*;
import com.Stradew.Model.Item.Food;
import com.Stradew.Model.Item.Item;
import com.Stradew.Model.Tools.Pepolee;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.util.ArrayList;

public class PokhtOPaz implements Screen {
    PokhtOPazController pokhtOPazController;
    Stage stage;
    Table table;
    Skin skin;

    Label feedback;

    TextField itemName;

    TextButton pickFromRef;
    TextButton putInRef;
    TextButton pokhtingOPazing;
    TextButton eat;

    private Texture BackGround = GameAssetsManager.getInstance().getInventoryBar();
    private Table Reftable;
    private ArrayList<RefSlot> refSlots = new ArrayList<>();
    private ImageButton ChoosenItem;

    public Table getReftable() {
        return Reftable;
    }

    public void setReftable(Table Reftable) {
        this.Reftable = Reftable;
    }

    public PokhtOPaz(PokhtOPazController pokhtOPazController) {
        this.pokhtOPazController = pokhtOPazController;
        pokhtOPazController.setPokhtOPaz(this);
        stage = new Stage();
        skin = GameAssetsManager.getInstance().getSkin();

        table = new Table();
        table.setFillParent(true);
        this.setReftable(table);
        this.firstTouch();
        table = this.getReftable();

        feedback = new Label("", skin);

        itemName = new TextField("Item Name", skin);

        pickFromRef = new TextButton("Pick Item", skin);
        putInRef = new TextButton("Put Item",skin);
        pokhtingOPazing = new TextButton("Pokht O Paz", skin);
        eat = new TextButton("Eat", skin);

        table.add(itemName);
        table.add(pickFromRef);
        table.add(putInRef);
        table.add(pokhtingOPazing);
        table.add(eat).row();
        table.add(feedback);

        stage.addActor(table);

        pickFromRef.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                feedback.setText(PickFromRef(itemName.getText()));
            }
        });

        putInRef.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                feedback.setText(PutInRef(itemName.getText()));
            }
        });

        pokhtingOPazing.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                feedback.setText(PokhtingOPazing(itemName.getText()));
            }
        });

        eat.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                feedback.setText(Eating(itemName.getText()));
            }
        });

    }


    public void firstTouch() {
        Reftable.row().pad(40);
        for(int i = 0; i < 36 ;i++)
        {
            refSlots.add(new RefSlot());
            Reftable.add(refSlots.get(i).getButton()).padRight(20);
            if(i % 6 == 5)
            {
                Reftable.row().pad(20);
            }
        }
        Reftable.row().pad(40);
        Texture food = new Texture("Recipe/Pizza.png");
        TextureRegion region = new TextureRegion(food);
        TextureRegionDrawable drawable = new TextureRegionDrawable(region);
        ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle();
        style.up = drawable;
        style.down = drawable;
        ChoosenItem = new ImageButton(style);
        Reftable.add(ChoosenItem).row();
    }


    public String PickFromRef(String itemName)
    {
        Ref ref = App.ReturnCurrentPlayer().getFarm().getCabin().getRefrigerator();
        if (!ref.isItemAvailable(itemName)){
            return ("Looks likes that item isn't in the fridge anymore!");
        }
        pokhtOPazController.ApplyPickFromRef(itemName);
        return ("Item liberated from the cold, now in your inventory!");
    }

    public String PutInRef(String itemName)
    {
        Pepolee currentPlayer = App.ReturnCurrentPlayer();
        if (!currentPlayer.getInventory().isItemAvailable(itemName)){
            return ("Nope! That item seems to have vanished into thin air... or maybe it's just not in your inventory?");
        }if (!(currentPlayer.getInventory().getItemByName(itemName) instanceof Food)){
            return ("You can't put whatever you want in ref!");
        }
        pokhtOPazController.ApplyPut(itemName);
        return ("Item successfully transferred to refrigeration.");
    }

    public String PokhtingOPazing(String ItemName)
    {
        if (!pokhtOPazController.EnoughSkill(ItemName)){
            return ("Failed to cook: Requires higher Pokht O Paz proficiency.");
        }
        if (!pokhtOPazController.EnoughItemsFromInventory(ItemName) &&
                !pokhtOPazController.EnoughItemsFromRef(ItemName)){
            return ("Looks like you're missing some key ingredients for that recipe!");
        }
        pokhtOPazController.ApplyPokhtingOPazing(ItemName);
        return ("You Pokhted and Pazed " + ItemName + " successfully.");
    }
    public String Eating(String ItemName)
    {
        Item item = App.ReturnCurrentPlayer().getInventory().getItemByName(ItemName);
        if (item == null){
            return ("Unfortunately you don't have this one.");
        }
        if (!(item instanceof Food)){
            return ("Your stomach will thank if you skip that.");
        }
        pokhtOPazController.ApplyEatingFood(ItemName);
        return ("You ate some food.");
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
