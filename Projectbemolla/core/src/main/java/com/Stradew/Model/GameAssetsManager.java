package com.Stradew.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class GameAssetsManager {
    private static GameAssetsManager instance;
    private final Skin skin;
    private final Texture DirtTexture = new Texture(Gdx.files.internal("FirstMap/Flooring_25.png"));
    private final Texture WaterTexture = new Texture(Gdx.files.internal("FirstMap/Flooring_26.png"));
    private final Texture Greenhouse = new Texture(Gdx.files.internal("FirstMap/greenhouse.png"));
    private final Texture Cabin = new Texture(Gdx.files.internal("FirstMap/Sheds.png"));
    private final Texture Clock = new Texture(Gdx.files.internal("Clock/ClockWithJournalwithoutnumber.png"));
    private final Texture HowedDirt = new Texture(Gdx.files.internal("FirstMap/Stone_Index34.png"));
    private final Texture TreeTest = new Texture(Gdx.files.internal("FirstMap/Apple_Stage_2.png"));
    private final Texture PlantTest = new Texture(Gdx.files.internal("FirstMap/Leek.png"));
    private final Texture InventoryBar = new Texture(Gdx.files.internal("Inventory/RealInventory.png"));
    private final Texture SkillPannel = new Texture(Gdx.files.internal("Inventory/RealSkills.png"));

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
