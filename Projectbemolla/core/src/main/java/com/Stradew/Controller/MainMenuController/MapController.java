package com.Stradew.Controller.MainMenuController;

import com.Stradew.Main;
import com.Stradew.Model.App;
import com.Stradew.Model.Enums.*;
import com.Stradew.Model.Game;
import com.Stradew.Model.GameAssetsManager;
import com.Stradew.Model.PairChanges;
import com.Stradew.Model.Tile.*;
import com.Stradew.Model.Tile.Plants;
import com.Stradew.View.MainMenu.GameMenu;
import com.Stradew.View.MainMenu.NPCVillage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MapController {


    BitmapFont font = new BitmapFont();
    public static final int TILE_SIZE = 100; // Ensure this matches your MapController
    public static final int MAP_COLS = 100; // Based on your MapController loop
    public static final int MAP_ROWS = 100;
    public Texture Map1 = new Texture(Gdx.files.internal("FirstMap/FirstFarm.png"));
    public Texture Map2 = new Texture(Gdx.files.internal("FirstMap/secondfarm.png"));
    public Texture Character = new Texture(Gdx.files.internal("Villagers/Lewis.png"));



    public void PrintEasyMap(GameMenu menu)
    {
        if(App.getCurrentUser().getFarmId() == 1)
        {
            Main.getMain().getBatch().draw(Map1 , App.ReturnCurrentPlayer().getX() - 400, App.ReturnCurrentPlayer().getY() - 400 , 1000 , 600);
            Main.getMain().getBatch().draw(Character , App.ReturnCurrentPlayer().getX() - 400 + (App.ReturnCurrentPlayer().getX() / MapController.TILE_SIZE * 10)  , App.ReturnCurrentPlayer().getY() - 400 + (App.ReturnCurrentPlayer().getY() / MapController.TILE_SIZE * 5) , 50 , 50);
        }
        else
        {
            Main.getMain().getBatch().draw(Map2 , App.ReturnCurrentPlayer().getX() - 400, App.ReturnCurrentPlayer().getY() - 400 , 1000 , 600);
            Main.getMain().getBatch().draw(Character , App.ReturnCurrentPlayer().getX() - 400 + (App.ReturnCurrentPlayer().getX() / MapController.TILE_SIZE * 10)  , App.ReturnCurrentPlayer().getY() - 400 + (App.ReturnCurrentPlayer().getY() / MapController.TILE_SIZE * 5) , 50 , 50);
        }
    }


    public void HandleBuyGreenhouseButton(GameMenu menu)
    {

        int XALi =(int) App.ReturnCurrentPlayer().getX() - (App.ReturnCurrentPlayer().getFarm().getGreenHouse().getX_Coordinate() * TILE_SIZE);
        int YAli = (int) App.ReturnCurrentPlayer().getY() - (App.ReturnCurrentPlayer().getFarm().getGreenHouse().getY_Coordinate() * TILE_SIZE);
        if(XALi < 600 && XALi > -600 && YAli < 600 && YAli > -600)
        {
            menu.getBuyGreenhouseTable().setVisible(true);
        }
        else
        {
            menu.getBuyGreenhouseTable().setVisible(false);
        }

    }

    public void setGreenhouseHoverTextButton() {
        Tile[][] TempGround = App.getCurrentGame().isInVillage()
            ? App.getCurrentGame().getVillage().getGround()
            : App.ReturnCurrentPlayer().getFarm().getGround();
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

    public void PrintInitialMap(FrameBuffer mapFrameBuffer  , OrthographicCamera camera)
    {
        Tile[][] TempGround = App.getCurrentGame().isInVillage()
            ? App.getCurrentGame().getVillage().getGround()
            : App.ReturnCurrentPlayer().getFarm().getGround();
        TempGround[1][10].setPlaceType(PlaceType.Portal);
        mapFrameBuffer.begin();
        Main.getMain().getBatch().begin();
        Main.getMain().getBatch().setProjectionMatrix(camera.combined);
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

    public void PrintInitialVillage(FrameBuffer mapFrameBuffer  , OrthographicCamera camera)
    {
        mapFrameBuffer.begin();
        Main.getMain().getBatch().begin();
        Main.getMain().getBatch().setProjectionMatrix(camera.combined);
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
        for(int i = 1; i <MAP_ROWS ; i++)
        {
            for(int j = 1; j < MAP_COLS ;j++)
            {
                UpdateVillage(i , j);
            }
        }
        Main.getMain().getBatch().end();
        mapFrameBuffer.end();
    }

    public void RenderMap(Sprite mapSprite , FrameBuffer mapFrameBuffer , GameMenu menu , OrthographicCamera camera , OrthographicCamera cam2)
    {
        Main.getMain().getBatch().flush();
        mapFrameBuffer.begin();
        camera.update();
        Main.getMain().getBatch().setProjectionMatrix(camera.combined);
        //Gdx.gl.glClearColor(0, 0, 0, 0);
        //Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
        for(int i = App.ReturnCurrentPlayer().getFarm().getChanges().size() - 1 ; i >= 0 ; i--)
        {
            Update(App.ReturnCurrentPlayer().getFarm().getChanges().get(i).getX() , App.ReturnCurrentPlayer().getFarm().getChanges().get(i).getY());
            App.ReturnCurrentPlayer().getFarm().getChanges().remove(i);
            //System.out.println("Dash Chi be gam behet");
        }

        Main.getMain().getBatch().flush();
        mapFrameBuffer.end();
        Main.getMain().getBatch().setProjectionMatrix(cam2.combined);
        cam2.update();
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

    public void RenderVillageMap(Sprite mapSprite , FrameBuffer mapFrameBuffer , NPCVillage menu , OrthographicCamera camera , OrthographicCamera cam2)
    {
        Main.getMain().getBatch().flush();
        mapFrameBuffer.begin();
        camera.update();
        Main.getMain().getBatch().setProjectionMatrix(camera.combined);
        //Gdx.gl.glClearColor(0, 0, 0, 0);
        //Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
        for(int i = App.getCurrentGame().getNpcVillage().getChanges().size() - 1 ; i >= 0 ; i--)
        {
            UpdateVillage(App.getCurrentGame().getNpcVillage().getChanges().get(i).getX() , App.getCurrentGame().getNpcVillage().getChanges().get(i).getY());
            App.getCurrentGame().getNpcVillage().getChanges().remove(i);
        }

        Main.getMain().getBatch().flush();
        mapFrameBuffer.end();
        Main.getMain().getBatch().setProjectionMatrix(cam2.combined);
        cam2.update();
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
        Tile[][] TempGround = App.getCurrentGame().isInVillage()
            ? App.getCurrentGame().getVillage().getGround()
            : App.ReturnCurrentPlayer().getFarm().getGround();
        if (TempGround[i][j].getPlaceType() == PlaceType.StarDropSaloon) {
            boolean isTopLeft = true;
            for (int x = 1; x <= PlaceType.StarDropSaloon.XLength; x++) {
                if (i - x >= 0 && TempGround[i - x][j].getPlaceType() == PlaceType.StarDropSaloon) {
                    isTopLeft = false;
                    break;
                }
            }
            for (int y = 1; y <= PlaceType.StarDropSaloon.YLength; y++) {
                if (j - y >= 0 && TempGround[i][j - y].getPlaceType() == PlaceType.StarDropSaloon) {
                    isTopLeft = false;
                    break;
                }
            }
            if (isTopLeft) {
                Texture saloon = GameAssetsManager.getInstance().getStarDropSaloon();
                Main.getMain().getBatch().draw(saloon,
                    i * TILE_SIZE, j * TILE_SIZE,
                    TILE_SIZE * PlaceType.StarDropSaloon.XLength,
                    TILE_SIZE * PlaceType.StarDropSaloon.YLength);
            }
        }
        if (TempGround[i][j].getPlaceType() == PlaceType.COOP) {
            boolean isTopLeft = true;
            for (int x = 1; x <= PlaceType.COOP.XLength; x++) {
                if (i - x >= 0 && TempGround[i - x][j].getPlaceType() == PlaceType.COOP) { isTopLeft = false; break; }
            }
            for (int y = 1; y <= PlaceType.COOP.YLength; y++) {
                if (j - y >= 0 && TempGround[i][j - y].getPlaceType() == PlaceType.COOP) { isTopLeft = false; break; }
            }
            if (isTopLeft) {
                Texture coop = GameAssetsManager.getInstance().getCoop(); // add this getter (see below)
                Main.getMain().getBatch().draw(
                    coop,
                    i * TILE_SIZE, j * TILE_SIZE,
                    TILE_SIZE * PlaceType.COOP.XLength,
                    TILE_SIZE * PlaceType.COOP.YLength
                );
            }
        }
                    boolean ok = false;
                    if(ok)
                    {

                    } else if (TempGround[i][j].getTerrain() == Terrain.DIRT) {
                        if(TempGround[i][j].isHow())
                        {
                            Texture HowedDirt = GameAssetsManager.getInstance().getHowedTexture();
                            Main.getMain().getBatch().draw(HowedDirt , i * TILE_SIZE, j * TILE_SIZE , 100 , 100);
                            //Gdx.app.exit();
                        }
                        else
                        {
                            Texture Dirt = GameAssetsManager.getInstance().DirtPicture();
                            Main.getMain().getBatch().draw(Dirt , i * TILE_SIZE, j * TILE_SIZE , TILE_SIZE , TILE_SIZE);
                            font.draw(Main.getMain().getBatch(), String.valueOf(i) + "," + String.valueOf(j), i * TILE_SIZE, j * TILE_SIZE);
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
                                    if(TempGround[i][j].getPlaceType() == PlaceType.Craft)
                                    {
                                        PlantedCrafts plantedCraft = (PlantedCrafts) TempGround[i][j];
                                        Texture PlantedCraft = plantedCraft.getCraft().Craftimage;
                                        Main.getMain().getBatch().draw(PlantedCraft, i * TILE_SIZE , j * TILE_SIZE , TILE_SIZE , TILE_SIZE);
                                        System.out.println("MozBaghali");
                                    }
                                    else {
                                        if (TempGround[i][j].getEntitity() == Entitity.TREE) {
                                            //Texture Dirt = GameAssetsManager.getInstance().DirtPicture();
                                            //Main.getMain().getBatch().draw(Dirt , i * TILE_SIZE, j * TILE_SIZE , TILE_SIZE , TILE_SIZE);
                                            Texture Tree = ((Trees) TempGround[i][j]).getTree().TreeTexture;
                                            Main.getMain().getBatch().draw(Tree, i * TILE_SIZE, j * TILE_SIZE, 70, 70);


                                        } else if (TempGround[i][j].getEntitity() == Entitity.PLANTS) {
                                            //Texture Dirt = GameAssetsManager.getInstance().DirtPicture();
                                            //Main.getMain().getBatch().draw(Dirt , i * TILE_SIZE, j * TILE_SIZE , TILE_SIZE , TILE_SIZE);
                                            Texture Plant = ((Plants) TempGround[i][j]).getPlant().PlantTexture;
                                            Main.getMain().getBatch().draw(Plant, i * TILE_SIZE, j * TILE_SIZE, 30, 30);
                                            Plants plants = (Plants) TempGround[i][j];
                                        /*if(plants.getLastTimeWatering() != null) {
                                            if (plants.getLastTimeWatering().getDay() - App.getCurrentGame().getTime().getDay() > -1) {
                                                Color Abas = new Color(0.0f, 0.3f, 0.7f, 0.2f);
                                                Main.getMain().getBatch().setColor(Abas);
                                                Main.getMain().getBatch().draw(GameAssetsManager.getInstance().GetWaterdTexture(), i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                                                Main.getMain().getBatch().setColor(Color.WHITE);
                                            }
                                        }*/
                                        } else if (TempGround[i][j].getPlaceType() == PlaceType.QUARRY) {
                                            if(TempGround[i][j].getEntitity() == Entitity.Minreal)
                                            {
                                                Minreal mineral = (Minreal) TempGround[i][j];
                                                Texture MineralTexture = mineral.getMineral().image;
                                                Main.getMain().getBatch().draw(MineralTexture, i * TILE_SIZE, j * TILE_SIZE, 70, 70);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if(TempGround[i][j].getTerrain() == Terrain.DIRT && TempGround[i][j].isHow())
                    {
                        Texture Dirt = GameAssetsManager.getInstance().getHowedTexture();
                        Main.getMain().getBatch().draw(Dirt, i * TILE_SIZE , j * TILE_SIZE , TILE_SIZE , TILE_SIZE);
                    }
    }

    public void UpdateVillage(int i , int j)
    {
        Tile[][] TempGround = App.getCurrentGame().getNpcVillage().getGround();
        boolean ok = false;
        if(ok)
        {

        } else if(TempGround[i][j].getEntitity() == Entitity.Minreal) {

        } else if (TempGround[i][j].getTerrain() == Terrain.DIRT) {
            if(TempGround[i][j].isHow())
            {
                Texture HowedDirt = GameAssetsManager.getInstance().getHowedTexture();
                Main.getMain().getBatch().draw(HowedDirt , i * TILE_SIZE, j * TILE_SIZE , 100 , 100);
                //Gdx.app.exit();
            }
            else
            {
                Texture Dirt = GameAssetsManager.getInstance().DirtPicture();
                Main.getMain().getBatch().draw(Dirt , i * TILE_SIZE, j * TILE_SIZE , TILE_SIZE , TILE_SIZE);
                font.draw(Main.getMain().getBatch(), String.valueOf(i) + "," + String.valueOf(j), i * TILE_SIZE, j * TILE_SIZE);
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
                        if(TempGround[i][j].getPlaceType() == PlaceType.Craft)
                        {
                            PlantedCrafts plantedCraft = (PlantedCrafts) TempGround[i][j];
                            Texture PlantedCraft = plantedCraft.getCraft().Craftimage;
                            Main.getMain().getBatch().draw(PlantedCraft, i * TILE_SIZE , j * TILE_SIZE , TILE_SIZE , TILE_SIZE);
                            System.out.println("MozBaghali");
                        }
                        else {
                            if (TempGround[i][j].getEntitity() == Entitity.TREE) {
                                //Texture Dirt = GameAssetsManager.getInstance().DirtPicture();
                                //Main.getMain().getBatch().draw(Dirt , i * TILE_SIZE, j * TILE_SIZE , TILE_SIZE , TILE_SIZE);
                                Texture Tree = ((Trees) TempGround[i][j]).getTree().TreeTexture;
                                Main.getMain().getBatch().draw(Tree, i * TILE_SIZE, j * TILE_SIZE, 30, 30);


                            } else if (TempGround[i][j].getEntitity() == Entitity.PLANTS) {
                                //Texture Dirt = GameAssetsManager.getInstance().DirtPicture();
                                //Main.getMain().getBatch().draw(Dirt , i * TILE_SIZE, j * TILE_SIZE , TILE_SIZE , TILE_SIZE);
                                Texture Plant = ((Plants) TempGround[i][j]).getPlant().PlantTexture;
                                Main.getMain().getBatch().draw(Plant, i * TILE_SIZE, j * TILE_SIZE, 30, 30);
                                Plants plants = (Plants) TempGround[i][j];
                                if (plants.getLastTimeWatering() != null) {
                                    if (plants.getLastTimeWatering().getDay() - App.getCurrentGame().getTime().getDay() > -1) {
                                        Color Abas = new Color(0.0f, 0.3f, 0.7f, 0.2f);
                                        Main.getMain().getBatch().setColor(Abas);
                                        Main.getMain().getBatch().draw(GameAssetsManager.getInstance().GetWaterdTexture(), i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                                        Main.getMain().getBatch().setColor(Color.WHITE);
                                    }
                                }
                            } else if (TempGround[i][j].getPlaceType() == PlaceType.QUARRY) {
                            } else if (TempGround[i][j].getPlaceType() == PlaceType.Craft) {

                            }
                        }
                    }
                }
            }
        }
        if(TempGround[i][j].getTerrain() == Terrain.DIRT && TempGround[i][j].isHow())
        {
            Texture Dirt = GameAssetsManager.getInstance().getHowedTexture();
            Main.getMain().getBatch().draw(Dirt, i * TILE_SIZE , j * TILE_SIZE , TILE_SIZE , TILE_SIZE);
        }

    }
}
