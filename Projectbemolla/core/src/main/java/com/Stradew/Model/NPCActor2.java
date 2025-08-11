package com.Stradew.Model;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.awt.*;

public class NPCActor2 extends Image {

    Npc npc;
    public NPCActor2(Npc npc, final Runnable onClickAction) {
        super(npc.getNpcTexture());
        this.npc = npc;

        this.setPosition(npc.getX_position(), npc.getY_position());

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
