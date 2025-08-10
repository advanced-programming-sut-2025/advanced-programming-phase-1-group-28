package com.Stradew.Model;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ShopActor extends Image {

    public ShopActor(String textureAddress,float x, float y, final Runnable onClickAction) {
        super(new Texture(textureAddress));

        this.setPosition(x, y);
        this.setScale(3.5f);

        this.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (onClickAction != null) {
                    onClickAction.run();
                }
                event.stop();
            }
        });
    }
}
