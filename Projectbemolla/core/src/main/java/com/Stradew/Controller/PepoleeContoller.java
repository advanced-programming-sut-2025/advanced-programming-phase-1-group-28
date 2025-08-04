package com.Stradew.Controller;

import com.Stradew.Controller.MainMenuController.MapController;
import com.Stradew.Controller.MainMenuController.MechanicController.UseToolController;
import com.Stradew.Main;
import com.Stradew.Model.App;
import com.Stradew.Model.Enums.Entitity;
import com.Stradew.Model.GameAssetsManager;
import com.Stradew.Model.PairChanges;
import com.Stradew.Model.Tile.Plants;
import com.Stradew.Model.Tile.Tile;
import com.Stradew.Model.Tools.Pepolee;
import com.Stradew.View.MainMenu.CheatCodes;
import com.Stradew.View.MainMenu.GameMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PepoleeContoller {
    CheatCodes cheatCodes = new CheatCodes();
    Texture ToolTexture = null;

    private UseToolController useToolController = new UseToolController();

    public void setToolTexture(Texture toolTexture) {
        ToolTexture = toolTexture;
    }



    public void PrintTool()
    {
        if(App.ReturnCurrentPlayer().getInventory().getCurrentTool() != null)
        {
            ToolTexture = App.ReturnCurrentPlayer().getInventory().getCurrentTool().getImage();
        }
        if(ToolTexture != null)
        {

            Main.getMain().getBatch().draw(ToolTexture, App.ReturnCurrentPlayer().getX() + 10, App.ReturnCurrentPlayer().getY() + 10 , 50 , 50);
        }
    }

    public void HandleWalk(Pepolee player , float v)
    {
        boolean ok = false;
        if(Gdx.input.isKeyPressed(Input.Keys.W))
        {
            player.setY(player.getY() + (v * 500f));
            App.getCurrentGame().getTimeControlPannel().setTimeWalkForENetgy(App.getCurrentGame().getTimeControlPannel().getTimeWalkForENetgy() + v);
            ok = true;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S))
        {
            player.setY(player.getY() - (v * 500f));
            App.getCurrentGame().getTimeControlPannel().setTimeWalkForENetgy(App.getCurrentGame().getTimeControlPannel().getTimeWalkForENetgy() + v);
            ok = true;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D))
        {
            player.setX(player.getX() + (v * 500f));
            App.getCurrentGame().getTimeControlPannel().setTimeWalkForENetgy(App.getCurrentGame().getTimeControlPannel().getTimeWalkForENetgy() + v);
            ok = true;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A))
        {
            player.setX(player.getX() - (v * 500f));
            App.getCurrentGame().getTimeControlPannel().setTimeWalkForENetgy(App.getCurrentGame().getTimeControlPannel().getTimeWalkForENetgy() + v);
            ok = true;
        }
        if(ok)
        {
            Animation animation = GameAssetsManager.getInstance().getPlayerAnimation();
            if (!animation.isAnimationFinished(App.getCurrentGame().getTimeControlPannel().getAnimationPlayer())) {
            App.getCurrentGame().getTimeControlPannel().setAnimationPlayer(App.getCurrentGame().getTimeControlPannel().getAnimationPlayer() +v);
            }
            else {
                App.getCurrentGame().getTimeControlPannel().setAnimationPlayer(0);
            }
        }
        if(App.getCurrentGame().getTimeControlPannel().getTimeWalkForENetgy() > 1)
        {
            App.ReturnCurrentPlayer().setEnergy(App.ReturnCurrentPlayer().getEnergy() - 5);
            App.getCurrentGame().getTimeControlPannel().setTimeWalkForENetgy(0);
        }
    }

    public void UsingTool(GameMenu gameMenu)
    {
        if(App.getCurrentGame().getTimeControlPannel().getUsingTool() > 1)
        {
            if(Gdx.input.isKeyPressed(Input.Keys.C))
            {
                int X =(int) (Math.floor(App.ReturnCurrentPlayer().getX() / MapController.TILE_SIZE));
                int Y = (int) (Math.floor(App.ReturnCurrentPlayer().getY() / MapController.TILE_SIZE));
                System.out.println(X + " " + Y);
                if(X > 1 && X < 400 && Y > 1 && Y < 400)
                 {
                    App.getCurrentGame().getTimeControlPannel().setUsingTool(0);
                    String S  = useToolController.ApplyUsing(X,Y);
                    if(S != null) {
                        if (S.equals("Fish Added To your inventory")) {
                            gameMenu.getMainTable().setVisible(false);
                            gameMenu.getMinigame().setVisible(true);
                        }
                    }
                }
                /*Tile[][] TempGround = App.ReturnCurrentPlayer().getFarm().getGround();
                Plants newplant = new Plants(com.Stradew.Model.Enums.Plants.BLUE_JAZZ);
                newplant.setBornTime(App.getCurrentGame().getTime());
                TempGround[40][40] = newplant;
                TempGround[40][40].setHow(false);
                TempGround[40][40].setTerrain(null);;
                TempGround[40][40].setEntitity(Entitity.PLANTS);
                App.ReturnCurrentPlayer().getFarm().getChanges().add(new PairChanges(40 , 40));
                App.ReturnCurrentPlayer().getFarm().setGround(TempGround);
                App.getCurrentGame().getTimeControlPannel().setUsingTool(0);

                 */
            }
        }
    }

    public void CheatCodes()
    {
        if(App.getCurrentGame().getTimeControlPannel().getCheatCodeUse() > 1) {
            if (Gdx.input.isKeyPressed(Input.Keys.NUM_1)) {
                cheatCodes.ChangeHour(7);
                App.getCurrentGame().getTimeControlPannel().setCheatCodeUse(0);
            }
            if(Gdx.input.isKeyPressed(Input.Keys.NUM_2)) {
                cheatCodes.ChangeDay(10);
                App.getCurrentGame().getTimeControlPannel().setCheatCodeUse(0);
            }
            if(Gdx.input.isKeyPressed(Input.Keys.NUM_3)) {
                cheatCodes.SetEnergy(App.ReturnCurrentPlayer().getEnergy() + 50);
                App.getCurrentGame().getTimeControlPannel().setCheatCodeUse(0);
            }
        }
    }

    public void Update(GameMenu menu , Pepolee player , float v)
    {
        HandleWalk(player , v);
        CheatCodes();
        UsingTool(menu);
        idleAnimation(v);
        player.getPlayerSprite().setPosition(player.getX() , player.getY() - 500);
        player.getPlayerSprite().draw(Main.getMain().getBatch());
        player.getPlayerSprite().setSize(700 , 700);
        PrintTool();
    }

    public void idleAnimation(float Delta){
        Animation<Texture> animation = GameAssetsManager.getInstance().getPlayerAnimation();

        App.ReturnCurrentPlayer().getPlayerSprite().setRegion(animation.getKeyFrame(App.getCurrentGame().getTimeControlPannel().getAnimationPlayer()));

//        if (!animation.isAnimationFinished(App.getCurrentGame().getTimeControlPannel().getAnimationPlayer())) {
//            App.getCurrentGame().getTimeControlPannel().setAnimationPlayer(App.getCurrentGame().getTimeControlPannel().getAnimationPlayer() + Delta);
//        }
//        else {
//            App.getCurrentGame().getTimeControlPannel().setAnimationPlayer(0);
//        }
        animation.setPlayMode(Animation.PlayMode.LOOP);
    }
}
