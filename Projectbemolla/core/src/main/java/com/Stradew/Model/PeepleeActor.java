package com.Stradew.Model;

import com.Stradew.Model.Tools.Pepolee;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class PeepleeActor extends Image {
    Pepolee pepolee;
    public PeepleeActor(Pepolee pepolee,final Runnable onClickAction) {
        super(pepolee.getPlayerTexture());
        this.pepolee = pepolee;

        this.setPosition(pepolee.getX(), pepolee.getY());

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
