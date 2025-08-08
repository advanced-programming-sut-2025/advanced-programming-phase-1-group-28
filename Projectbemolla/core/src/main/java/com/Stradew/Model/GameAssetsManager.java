package com.Stradew.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class GameAssetsManager {
    private static GameAssetsManager instance;
    private final Skin skin;
    private final Texture DirtTexture = new Texture(Gdx.files.internal("FirstMap/Flooring_25.png"));
    private final Texture WaterTexture = new Texture(Gdx.files.internal("FirstMap/Flooring_26.png"));
    private final Texture Greenhouse = new Texture(Gdx.files.internal("FirstMap/greenhouse.png"));
    private final Texture Cabin = new Texture(Gdx.files.internal("FirstMap/Sheds.png"));
    private final Texture Clock = new Texture(Gdx.files.internal("Clock/ClockWithJournalwithoutnumber.png"));
    private final Texture HowedDirt = new Texture(Gdx.files.internal("FirstMap/Dirt Hoed - Copy.png"));
    private final Texture TreeTest = new Texture(Gdx.files.internal("FirstMap/Apple_Stage_2.png"));
    private final Texture PlantTest = new Texture(Gdx.files.internal("FirstMap/Leek.png"));
    private final Texture InventoryBar = new Texture(Gdx.files.internal("Inventory/RealInventory.png"));
    private final Texture SkillPannel = new Texture(Gdx.files.internal("Inventory/RealSkills.png"));
    public final String[] StringsReactionsText = {"HELLO" , "Yeah BOY" , "THANK YOU" , "GG" , "ARE YOU OK" , "GIVE ME A BO"};
    public final Texture[] ImagesREacions = {new Texture("Pants/Baggy_Pants.png") , new Texture("Pants/Baggy_Pants.png") , new Texture("Pants/Baggy_Pants.png") , new Texture("Pants/Baggy_Pants.png") , new Texture("Pants/Baggy_Pants.png") , new Texture("Pants/Baggy_Pants.png") , new Texture("Pants/Baggy_Pants.png")};

    private final Animation playerAnimation = new Animation<>(0.1f, new Texture("FirstMap/Lewis1animation.png"),
        new Texture("FirstMap/lewis2animation.png"),
        new Texture("FirstMap/lewis3animation.png"),
        new Texture("FirstMap/lewis4animation.png"));


    public TextButton[] Reactions() {
        TextButton[] Reactions = new TextButton[6];
        Reactions[0] = new TextButton("Hello", skin);
        Reactions[1] = new TextButton("Yeah Boy", skin);
        Reactions[2] = new TextButton("Thank you", skin);
        Reactions[3] = new TextButton("GG", skin);
        Reactions[4] = new TextButton("Are you ok", skin);
        Reactions[5] = new TextButton("Give me a Bo", skin);
        return Reactions;
    }

    public ImageButton[] ImageReactions()
    {
        ImageButton[] ImageReactions = new ImageButton[6];
        Texture Axe = new Texture("Pants/Baggy_Pants.png");
        TextureRegion region = new TextureRegion(Axe);
        TextureRegionDrawable drawable = new TextureRegionDrawable(region);
        ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle();
        style.up = drawable;
        style.down = drawable;
        for(int i = 0;i < 6  ;i++)
        {
            ImageReactions[i] = new ImageButton(style);
        }
        return ImageReactions;
    }

    public Animation getPlayerAnimation() {
        return playerAnimation;
    }

    public GameAssetsManager() {
        skin = new Skin(Gdx.files.internal("Skins/pixthulhu-ui.json"));
    }



    public Texture getSkillPannel()
    {
        return SkillPannel;
    }


    public Texture getPlantTest() {
        return PlantTest;
    }

    public Texture getInventoryBar() {
        return InventoryBar;
    }
    public Texture getTreeTest()
    {
        return TreeTest;
    }

    public Texture getHowedTexture()
    {
        return HowedDirt;
    }

    public Texture getCabin()
    {
        return Cabin;
    }


    public Texture getGreenhouse()
    {
        return Greenhouse;
    }

    public Texture GetWaterdTexture()
    {
        Texture shadeTexture;
        Color shadeColor;
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        shadeTexture = new Texture(pixmap);
        pixmap.dispose();
        shadeColor = new Color(0.0f, 0.0f, 0.2f, 0.4f);
        return shadeTexture;
    }


    public  Texture getClock()
    {
        return Clock;
    }

    public Texture WaterPicture()
    {
        return WaterTexture;
    }


    public Texture DirtPicture()
    {
        return DirtTexture;
    }



    public static GameAssetsManager getInstance() {
        if(instance == null) {
            instance = new GameAssetsManager();
        }
        return instance;
    }

    public Skin getSkin() {
        return skin;
    }
}
