package com.Stradew.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class GameAssetsManager {
    private static GameAssetsManager instance;
    private final Skin skin;

    public GameAssetsManager() {
        skin = new Skin(Gdx.files.internal("Skins/pixthulhu-ui.json"));
    }

    public  Texture getClock()
    {
        return new Texture(Gdx.files.internal("Clock/ClockWithJournalwithoutnumber.png"));
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
