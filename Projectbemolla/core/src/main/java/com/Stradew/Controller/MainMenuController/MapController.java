package com.Stradew.Controller.MainMenuController;

import com.Stradew.Main;
import com.Stradew.Model.App;
import com.Stradew.Model.Enums.*;
import com.Stradew.Model.Game;
import com.Stradew.Model.GameAssetsManager;
import com.Stradew.Model.Tile.Tile;
import com.Stradew.View.MainMenu.GameMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MapController {



    public static final int TILE_SIZE = 30; // Ensure this matches your MapController
    public static final int MAP_COLS = 200; // Based on your MapController loop
    public static final int MAP_ROWS = 200;


    public void HandleBuyGreenhouseButton(GameMenu menu)
    {

        int XALi =(int) App.ReturnCurrentPlayer().getX() - (App.ReturnCurrentPlayer().getFarm().getGreenHouse().getX_Coordinate() * TILE_SIZE);
        int YAli = (int) App.ReturnCurrentPlayer().getY() - (App.ReturnCurrentPlayer().getFarm().getGreenHouse().getY_Coordinate() * TILE_SIZE);
        if(XALi < 600 && XALi > -600 && YAli < 600 && YAli > -600)
        {
            menu.getBuyGreenhouseTable().setVisible(true);
        }
        //else
        //{
          //  menu.getBuyGreenhouseTable().setVisible(false);
        //}

    }

    public void setGreenhouseHoverTextButton() {
        Tile[][] TempGround  = App.ReturnCurrentPlayer().getFarm().getGround();
        float X = 0 , Y  = 0;
        Boolean ok = false;
        for(int i = 2; i < MAP_ROWS; i++) {
            for(int j = MAP_COLS - 1; j >= 3; j--) {
                if(!ok && App.ReturnCurrentPlayer().getFarm().getGround()[i][j].getPlaceType() == PlaceType.GREENHOUSE && TempGround[i-1][j].getPlaceType() != PlaceType.GREENHOUSE && TempGround[i][j-1].getPlaceType() != PlaceType.GREENHOUSE)
                {
                    ok = true;
                    X = i * TILE_SIZE;
                    Y = j * TILE_SIZE;
                }
            }
        }
        float V = X / TILE_SIZE;
        float H = Y / TILE_SIZE;
        App.ReturnCurrentPlayer().getFarm().getGreenHouse().setX_Coordinate((int) V);
        App.ReturnCurrentPlayer().getFarm().getGreenHouse().setY_Coordinate((int) H);
    }

    public void PrintInitialMap(FrameBuffer mapFrameBuffer)
    {
        mapFrameBuffer.begin();
        Main.getMain().getBatch().begin();
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
        for(int i = 1; i <MAP_ROWS ; i++)
        {
            for(int j = 1; j < MAP_COLS ;j++)
            {
                Update(i , j);
            }
        }
        Main.getMain().getBatch().end();
        mapFrameBuffer.end();
    }

    public void RenderMap(Sprite mapSprite , FrameBuffer mapFrameBuffer , GameMenu menu)
    {
        Main.getMain().getBatch().end();
        mapFrameBuffer.begin();
        Main.getMain().getBatch().begin();
        //Gdx.gl.glClearColor(0, 0, 0, 0);
        //Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
        for(int i = App.ReturnCurrentPlayer().getFarm().getChanges().size() - 1 ; i >= 0 ; i--)
        {
            Update(App.ReturnCurrentPlayer().getFarm().getChanges().get(i).getX() , App.ReturnCurrentPlayer().getFarm().getChanges().get(i).getY());
            App.ReturnCurrentPlayer().getFarm().getChanges().remove(i);
        }
        Main.getMain().getBatch().end();
        mapFrameBuffer.end();
        Main.getMain().getBatch().begin();
        mapSprite.setPosition(0 , 0);
        mapSprite.draw(Main.getMain().getBatch());

        if(App.getCurrentGame().getTime().getHour() > 18)
        {
            menu.getShadeColor().set(0.0f , 0.0f , 0.2f , 0.4f);
        }
        else
        {
            if(App.getCurrentGame().getTime().getSeason() == Season.SUMMER)
            {
                menu.getShadeColor().set(1.0f , 0.9f , 0.5f,  0.15f);
            }
            else
            {
                menu.getShadeColor().set(0, 0, 0,  0);
            }
        }
    }

    public void Update(int i , int j)
    {
        Tile[][] TempGround = App.ReturnCurrentPlayer().getFarm().getGround();
                    boolean ok = false;
                    if(ok)
                    {

                    } else if(TempGround[i][j].getEntitity() == Entitity.Minreal) {

                    } else if(TempGround[i][j].getTerrain() == Terrain.DIRT) {
                        if(TempGround[i][j].isHow())
                        {
                            Texture HowedDirt = new Texture(Gdx.files.internal("HowedDirt.png"));
                            Main.getMain().getBatch().draw(HowedDirt , i * TILE_SIZE, j * TILE_SIZE , TILE_SIZE , TILE_SIZE);
                        }
                        else
                        {
                            Texture Dirt = GameAssetsManager.getInstance().DirtPicture();
                            Main.getMain().getBatch().draw(Dirt , i * TILE_SIZE, j * TILE_SIZE , TILE_SIZE , TILE_SIZE);
                        }
                    }
                    else
                    {
                        if(TempGround[i][j].getPlaceType() == PlaceType.CABIN)
                        {
                            if(i-1 > 0 && j - 1 > 0) {
                                if(TempGround[i-1][j].getPlaceType() != PlaceType.CABIN && TempGround[i][j-1].getPlaceType() != PlaceType.CABIN)
                                {
                                    Texture Cabin = GameAssetsManager.getInstance().getCabin();
                                    Main.getMain().getBatch().draw(Cabin , i * TILE_SIZE, j * TILE_SIZE , TILE_SIZE * PlaceType.CABIN.XLength , TILE_SIZE * PlaceType.CABIN.YLength);
                                }
                            }
                        }
                        else
                        {
                            if(TempGround[i][j].getPlaceType() == PlaceType.LAKE)
                            {
                                Texture Water = GameAssetsManager.getInstance().WaterPicture();
                                Main.getMain().getBatch().draw(Water , i * TILE_SIZE, j * TILE_SIZE , TILE_SIZE , TILE_SIZE);
                            }
                            else
                            {
                                if(TempGround[i][j].getPlaceType() == PlaceType.GREENHOUSE)
                                {
                                    if(i-1 > 0 && j - 1 > 0) {
                                    if(TempGround[i-1][j].getPlaceType() != PlaceType.GREENHOUSE && TempGround[i][j-1].getPlaceType() != PlaceType.GREENHOUSE && !App.ReturnCurrentPlayer().getFarm().getGreenHouse().getLocked())
                                    {
                                        Texture Greenhouse = GameAssetsManager.getInstance().getGreenhouse();
                                        Main.getMain().getBatch().draw(Greenhouse , i * TILE_SIZE, j * TILE_SIZE , TILE_SIZE * PlaceType.GREENHOUSE.XLength , TILE_SIZE * PlaceType.GREENHOUSE.YLength);
                                    }
                                    }
                                }
                                else
                                {
                                    if(TempGround[i][j].getEntitity() == Entitity.TREE)
                                    {
                                        //Texture Dirt = GameAssetsManager.getInstance().DirtPicture();
                                        //Main.getMain().getBatch().draw(Dirt , i * TILE_SIZE, j * TILE_SIZE , TILE_SIZE , TILE_SIZE);
                                        Texture Tree  = GameAssetsManager.getInstance().getTreeTest();
                                        Main.getMain().getBatch().draw(Tree , i * TILE_SIZE, j * TILE_SIZE , TILE_SIZE , TILE_SIZE);

                                    }
                                    else if(TempGround[i][j].getEntitity() == Entitity.PLANTS)
                                    {
                                        //Texture Dirt = GameAssetsManager.getInstance().DirtPicture();
                                        //Main.getMain().getBatch().draw(Dirt , i * TILE_SIZE, j * TILE_SIZE , TILE_SIZE , TILE_SIZE);
                                        Texture Plant = GameAssetsManager.getInstance().getPlantTest();
                                        Main.getMain().getBatch().draw(Plant , i * TILE_SIZE, j * TILE_SIZE , TILE_SIZE / 2 , TILE_SIZE / 2);
                                    } else if(TempGround[i][j].getPlaceType() == PlaceType.QUARRY)
                                    {
                                    } else if(TempGround[i][j].getPlaceType() == PlaceType.Craft) {

                                    }
                                }
                            }
                        }
                    }
            }
}
