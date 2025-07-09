package com.Stradew;

import com.Stradew.Controller.StartmenuController;
import com.Stradew.View.StartMenu;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    private static Main main;
    private SpriteBatch batch;
    private Texture image;

    @Override
    public void create() {
        main = this;
        batch = new SpriteBatch();
        //image = new Texture("libgdx.png");
        getMain().setScreen(new StartMenu(new StartmenuController()));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }

    public static Main getMain() {
        return main;
    }

    public SpriteBatch getBatch() {
        return batch;
    }
}
