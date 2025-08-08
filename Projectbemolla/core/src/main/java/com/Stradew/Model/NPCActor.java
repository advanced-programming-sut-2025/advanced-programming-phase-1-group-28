package com.Stradew.Model;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class NPCActor extends Image {

    Npc npc;
    public NPCActor(Npc npc, final Runnable onClickAction) {
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
