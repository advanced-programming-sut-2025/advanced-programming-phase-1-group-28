package com.Stradew.View.MainMenu;

import com.Stradew.Controller.MainMenuController.MapController;
import com.Stradew.Controller.MainMenuController.MechanicController.NPC_Controller;
import com.Stradew.Controller.MainMenuController.NPCVillageController;
import com.Stradew.Controller.MainMenuController.SwitchMenuController;
import com.Stradew.Main;
import com.Stradew.Model.*;
import com.Stradew.Model.Tools.Pepolee;
import com.Stradew.View.MainMenu.MechanicGame.NPCMenu;
import com.Stradew.View.MainMenu.MechanicGame.NotificationDialog;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class NPCVillage implements Screen {


    private InputMultiplexer inputMultiplexer;
    private SwitchMenuController switchMenuController;
    private NPCMenu npcMenu = new NPCMenu(new NPC_Controller(), null);
    private Table Minigame;
    private ProgressBar MinigameProgress;
    private OrthographicCamera fboCamera;
    private FrameBuffer mapFrameBuffer;
    private Sprite mapSprite;
    private NPCVillageController controller;
    private OrthographicCamera camera;
    private Stage stage;
    private Stage constantStage;
    private ParticleEffect Raineffect;
    private Texture shadeTexture;
    private Color shadeColor;
    private TextButton GreenhouseHoverButton;
    private Table BuyGreenhouseTable;
    private ProgressBar EnergyBar;
    private TextButton Setting;
    private Table SettingTable;
    private TextButton Exit;
    private TextButton BackTogame;
    private TextButton notifications;
    private ParticleEffect SnowEffect;
    private ParticleEffect Lightning;
    private TextButton QuitFromMiniGame;
    private TextField npcDialogs;

    public TextButton getQuitFromMiniGame() {
        return QuitFromMiniGame;
    }

    public ParticleEffect getSnowEffect() {
        return SnowEffect;
    }

    public ParticleEffect getLightning() {
        return Lightning;
    }

    public ParticleEffect getRaineffect() {
        return Raineffect;
    }

    public TextButton getNotifications() {
        return notifications;
    }

    public void setNotifications(TextButton notifications) {
        this.notifications = notifications;
    }

    public TextButton getExit() {
        return Exit;
    }

    public TextButton getBackTogame() {
        return BackTogame;
    }

    public Table getSettingTable() {
        return SettingTable;
    }

    public TextButton getSetting() {
        return Setting;
    }

    public Texture getShadeTexture() {
        return shadeTexture;
    }

    public Table getBuyGreenhouseTable() {
        return BuyGreenhouseTable;
    }

    public ProgressBar getEnergyBar() {
        return EnergyBar;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    private Table MainTable;
    private Table InventoryTable;
    private Table SkillTable;
    private Table SocialTable;
    private Table MapTable;
    private Table SwitchTable;

    private TextButton InventoryButton;
    private TextButton SkillButton;
    private TextButton SocialButton;
    private TextButton MapButton;
    private TextButton Backbutton;

    public TextButton getBackbutton() {
        return Backbutton;
    }

    public NPCVillageController getController() {
        return controller;
    }

    public TextButton getMapButton() {
        return MapButton;
    }

    public TextButton getSocialButton() {
        return SocialButton;
    }

    public OrthographicCamera getFboCamera() {
        return fboCamera;
    }

    public Table getMinigame() {
        return Minigame;
    }

    public ProgressBar getMinigameProgress() {
        return MinigameProgress;
    }

    public TextButton getSkillButton() {
        return SkillButton;
    }

    public TextButton getInventoryButton() {
        return InventoryButton;
    }

    public Table getSwitchTable() {
        return SwitchTable;
    }

    public Table getMapTable() {
        return MapTable;
    }

    public Table getSocialTable() {
        return SocialTable;
    }

    public Table getSkillTable() {
        return SkillTable;
    }

    public Table getInventoryTable() {
        return InventoryTable;
    }

    public Table getMainTable() {
        return MainTable;
    }

    public TextButton getGreenhouseHoverButton() {
        return GreenhouseHoverButton;
    }

    public Color getShadeColor() {
        return shadeColor;
    }

    public FrameBuffer getMapFrameBuffer() {
        return mapFrameBuffer;
    }

    public Sprite getMapSprite() {
        return mapSprite;
    }

    public NPCVillage(NPCVillageController controller) {
        switchMenuController = new SwitchMenuController();
        this.controller = controller;
        controller.setMenu(this);
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        stage = new Stage(new ScreenViewport());
        constantStage = new Stage(new ScreenViewport(camera));
        Raineffect = new ParticleEffect();
        Raineffect.load(Gdx.files.internal("WetherEffects/CorrectRainWether.p"), Gdx.files.internal("WetherEffects"));
        Raineffect.start();
        SnowEffect = new ParticleEffect();
        SnowEffect.load(Gdx.files.internal("WetherEffects/Particle Park Snow Flakes.p"), Gdx.files.internal("WetherEffects"));
        SnowEffect.start();
        Lightning = new ParticleEffect();
        Lightning.load(Gdx.files.internal("WetherEffects/Particle Park Laser.p"), Gdx.files.internal("WetherEffects"));
        Lightning.start();
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        shadeTexture = new Texture(pixmap);
        pixmap.dispose();
        shadeColor = new Color(0.0f, 0.0f, 0.2f, 0.4f);
        GreenhouseHoverButton = new TextButton("Buy", GameAssetsManager.getInstance().getSkin());
        InventoryTable = new Table();
        SkillTable = new Table();
        SocialTable = new Table();
        MapTable = new Table();
        SwitchTable = new Table();
        MainTable = new Table();
        BuyGreenhouseTable = new Table();
        InventoryButton = new TextButton("Inventory", GameAssetsManager.getInstance().getSkin());
        SkillButton = new TextButton("Skill", GameAssetsManager.getInstance().getSkin());
        SocialButton = new TextButton("Social", GameAssetsManager.getInstance().getSkin());
        MapButton = new TextButton("Map", GameAssetsManager.getInstance().getSkin());
        Backbutton = new TextButton("Back", GameAssetsManager.getInstance().getSkin());
        EnergyBar = new ProgressBar(0, 250, 1f, true, GameAssetsManager.getInstance().getSkin());

        Setting = new TextButton("Setting", GameAssetsManager.getInstance().getSkin());
        SettingTable = new Table();
        Exit = new TextButton("Exit", GameAssetsManager.getInstance().getSkin());
        BackTogame = new TextButton("BackTogame", GameAssetsManager.getInstance().getSkin());


        Minigame = new Table();
        MinigameProgress = new ProgressBar(0, 250, 1f, true, GameAssetsManager.getInstance().getSkin());
        QuitFromMiniGame = new TextButton("QuitFromMiniGame", GameAssetsManager.getInstance().getSkin());
        notifications = new TextButton(String.format("%d", App.ReturnCurrentPlayer().getNewMessages()), GameAssetsManager.getInstance().getSkin());
        notifications.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                App.ReturnCurrentPlayer().setNewMessages(0);
                new NotificationDialog(GameAssetsManager.getInstance().getSkin()).show(stage);
            }
        });

        npcDialogs = new TextField("", GameAssetsManager.getInstance().getSkin());
        npcDialogs.setDisabled(true);
    }

    public Stage getStage() {
        return stage;
    }

    public void initializeShopActors(){
        ShopActor blackSmith = new ShopActor("FirstMap/Cabins (8).png", 3250, 1500, new Runnable() {
            @Override
            public void run() {
                switchMenuController.openBlacksmith(stage);
            }
        });
        constantStage.addActor(blackSmith);

        ShopActor carpenterShop = new ShopActor("FirstMap/Cabins (9).png", 800, 2800, new Runnable() {
            @Override
            public void run() {
                switchMenuController.openCarpenterShop(stage);
            }
        });
        constantStage.addActor(carpenterShop);

        ShopActor jojaMart = new ShopActor("FirstMap/Cabins (10).png", 3500, 3400, new Runnable() {
            @Override
            public void run() {
                switchMenuController.openJojaMart();
            }
        });
        constantStage.addActor(jojaMart);

        ShopActor marineRanch = new ShopActor("FirstMap/Cabins (11).png", 500, 800, new Runnable() {
            @Override
            public void run() {
                switchMenuController.openMarineRanch(stage);
            }
        });
        constantStage.addActor(marineRanch);

        ShopActor perrieGeneralStore = new ShopActor("FirstMap/Cabins (12).png", 1800, 1900, new Runnable() {
            @Override
            public void run() {
                switchMenuController.openPerrieGeneralStore();
            }
        });
        constantStage.addActor(perrieGeneralStore);

        ShopActor fishShop = new ShopActor("FirstMap/Cabins (13).png", 2500, 500, new Runnable() {
            @Override
            public void run() {
                switchMenuController.openFishShop();
            }
        });
        constantStage.addActor(fishShop);

        ShopActor starDropSaloon = new ShopActor("FirstMap/Cabins (14).png", 2000, 2100, new Runnable() {
            @Override
            public void run() {
                switchMenuController.openStarDropSaloon(stage);
            }
        });
        constantStage.addActor(starDropSaloon);

    }


    @Override
    public void show() {
//        Gdx.input.setInputProcessor(stage);

        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(stage);
        inputMultiplexer.addProcessor(constantStage);
        Gdx.input.setInputProcessor(inputMultiplexer);
        InventoryTable.setFillParent(true);
        SkillTable.setFillParent(true);
        SocialTable.setFillParent(true);
        MapTable.setFillParent(true);
        SwitchTable.setFillParent(true);
        InventoryTable.setVisible(false);
        SkillTable.setVisible(false);
        SocialTable.setVisible(false);
        MapTable.setVisible(false);
        SwitchTable.setVisible(false);
        MainTable.setFillParent(true);
        //SwitchTable.setBackground(abbas);
        SwitchTable.center().top();
        SwitchTable.add(InventoryButton);
        SwitchTable.add(SkillButton);
        SwitchTable.add(SocialButton);
        SwitchTable.add(MapButton);
        SwitchTable.add(Backbutton);
        stage.addActor(SwitchTable);

        MainTable.setPosition(0, 400);
        MainTable.add(Setting);
        //MainTable.setOrigin(900 , 400);
        MainTable.add(EnergyBar);
        MainTable.add(notifications).row();
        MainTable.add(npcDialogs).colspan(3).width(600f);
        stage.addActor(MainTable);

        Minigame.setFillParent(true);
        Minigame.setVisible(false);
        Minigame.add(MinigameProgress);
        Minigame.add(QuitFromMiniGame);
        stage.addActor(Minigame);

        SettingTable.setPosition(800, 800);
        SettingTable.add(Exit);
        SettingTable.add(BackTogame);
        SettingTable.setVisible(false);
        stage.addActor(SettingTable);

        stage.addActor(InventoryTable);

        stage.addActor(SkillTable);
        stage.addActor(MapTable);
        stage.addActor(SocialTable);
        if (mapFrameBuffer == null) {
            int mapPixelWidth = MapController.MAP_COLS * MapController.TILE_SIZE;
            int mapPixelHeight = MapController.MAP_ROWS * MapController.TILE_SIZE;
            mapFrameBuffer = new FrameBuffer(Pixmap.Format.RGBA8888, mapPixelWidth, mapPixelHeight, false);
            mapSprite = new Sprite(mapFrameBuffer.getColorBufferTexture());
            mapSprite.flip(false, true);

            fboCamera = new OrthographicCamera(mapPixelWidth, mapPixelHeight);
            fboCamera.setToOrtho(false, mapPixelWidth, mapPixelHeight);
            fboCamera.update();
            controller.getMapController().PrintInitialVillage(mapFrameBuffer, fboCamera);

        }
        //controller.getMapController().setGreenhouseHoverTextButton(GreenhouseHoverButton);
        //GreenhouseHoverButton.setPosition(500 , 500);
        controller.getMapController().setGreenhouseHoverTextButton();
        BuyGreenhouseTable.setFillParent(true);
        //BuyGreenhouseTable.setVisible(false);
        BuyGreenhouseTable.left();
        BuyGreenhouseTable.add(GreenhouseHoverButton);
        stage.addActor(BuyGreenhouseTable);

        for (Npc npc : App.getCurrentGame().getGameNPCs()) {
            NPCActor npcActor = new NPCActor(npc, new Runnable() {
                @Override
                public void run() {
                    //switchMenuController.openNpcMenu(npc, stage);
                    switchMenuController.openNpcMenu(npc, stage);
                }
            });
            constantStage.addActor(npcActor);

            TextButton showMessage = new TextButton("...", GameAssetsManager.getInstance().getSkin());
            showMessage.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                     npcDialogs.setText(npcMenu.meetNPC(npc.getName()));
//                    System.out.println("Dialog for " + npc.getName());
                }
            });

            float npcX = npcActor.getX();
            float npcY = npcActor.getY();
            float npcWidth = npcActor.getWidth();
            float npcHeight = npcActor.getHeight();

            float buttonX = npcX + (npcWidth / 2) - (showMessage.getWidth() / 2);

            float buttonY = npcY + npcHeight + 10;

            showMessage.setPosition(buttonX, buttonY);

            constantStage.addActor(showMessage);
        }

        initializeShopActors();

        for (Pepolee pepolee: App.getCurrentGame().getCharactersInGame()){
            if (pepolee == App.ReturnCurrentPlayer()){
                continue;
            }
            PeepleeActor peepleeActor = new PeepleeActor(pepolee, new Runnable() {
                @Override
                public void run() {
                    switchMenuController.openFriendshipMenu(pepolee, stage);
                }
            });
            constantStage.addActor(peepleeActor);
        }
        //stage.addActor(GreenhouseHoverButton);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0, 0, 0, 1);
        Main.getMain().getBatch().begin();
        camera.position.set(App.ReturnCurrentPlayer().getX(), App.ReturnCurrentPlayer().getY(), 0);
        camera.update();
        Main.getMain().getBatch().setProjectionMatrix(camera.combined);
        controller.Update(v);
        Main.getMain().getBatch().end();
        stage.act();
        stage.draw();
        constantStage.act();
        constantStage.draw();
        if (Gdx.input.isKeyJustPressed(Input.Keys.N)){
            switchMenuController.openGameMenu();
        }
    }

    @Override
    public void resize(int i, int i1) {
        stage.getViewport().update(i, i1, true);

        constantStage.getViewport().update(i, i1);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
    //    SignUpController signUpController = App.signUpController;
    //    NPCVillageController npcVillageController = App.npcVillageController;
    //    ShowFigures showFigures = App.showFigures;
    //    CheatCodes cheatCodes = App.cheatCodes;
    //
    //    public void Input(String command){
    //        Matcher matcher;
    //        if(Appview.CurrentGameID != -1)
    //        {
    //            if(App.ReturnCurrentPlayer().getEnergy() <= 0)
    //            {
    //                App.ReturnCurrentPlayer().setISFainted(true);
    //                App.npcVillage.NextTurn();
    //            }
    //        }
    //        if((matcher = NPCVillageRejex.StartGame.getMatcher(command)) != null) {
    //            ArrayList<String> Usernames = new ArrayList<>();
    //            String PlayerRejex = "\\w+";
    //            Pattern Playerpattern = Pattern.compile(PlayerRejex);
    //            Matcher playerMatcher = Playerpattern.matcher(command.substring(12));
    //            while (playerMatcher.find()) {
    //                Usernames.add(playerMatcher.group().trim());
    //            }
    //            StartGame(Usernames);
    //        } else if(Appview.CurrentGameID == -1)
    //        {
    //            System.out.println("No game started yet");
    //        } else if ((matcher = NPCVillageRejex.EnergyShow.getMatcher(command)) != null){
    //            showFigures.ShowEnergy();
    //        } else if ((matcher = NPCVillageRejex.EnergySet.getMatcher(command)) != null) {
    //            cheatCodes.SetEnergy(Integer.parseInt(matcher.group(1)));
    //        } else if ((matcher = NPCVillageRejex.EnergyUnlimited.getMatcher(command)) != null) {
    //            cheatCodes.SetUnlimitedEnergy();
    //        } else if ((matcher = NPCVillageRejex.InventoryShow.getMatcher(command)) != null) {
    //            showFigures.ShowInventory();
    //        } else if ((matcher = NPCVillageRejex.CheatWeatherSet.getMatcher(command)) != null) {
    //            cheatCodes.SetWeather(matcher.group(1));
    //        } else if ((matcher = NPCVillageRejex.ShowWeather.getMatcher(command)) != null) {
    //            showFigures.ShowWeather();
    //        } else if ((matcher = NPCVillageRejex.WeatherForecast.getMatcher(command)) != null) {
    //            showFigures.PredictWeather();
    //        } else if ((matcher = NPCVillageRejex.CheatThor.getMatcher(command)) != null) {
    //            cheatCodes.Thor(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));// This is incomplete
    //        } else if ((matcher = NPCVillageRejex.ShowSeason.getMatcher(command)) != null) {
    //            showFigures.ShowSeason();
    //        } else if ((matcher = NPCVillageRejex.CheatAdvanceDate.getMatcher(command)) != null) {
    //            cheatCodes.ChangeDay(Integer.parseInt(matcher.group(1)));
    //        } else if ((matcher = NPCVillageRejex.CheatAdvanceTime.getMatcher(command)) != null) {
    //            cheatCodes.ChangeHour(Integer.parseInt(matcher.group(1)));
    //        } else if ((matcher = NPCVillageRejex.ShowDayOfWeek.getMatcher(command)) != null) {
    //            showFigures.ShowDayOfWeek();
    //        } else if ((matcher = NPCVillageRejex.ShowDateTime.getMatcher(command)) != null) {
    //            showFigures.ShowDateTime();
    //        } else if ((matcher = NPCVillageRejex.ShowDate.getMatcher(command)) != null) {
    //            showFigures.ShowDate();
    //        } else if ((matcher = NPCVillageRejex.ShowTime.getMatcher(command)) != null) {
    //            showFigures.ShowTime();
    //        } else if((matcher = NPCVillageRejex.ExitGame.getMatcher(command)) != null)
    //        {
    //            Appview.Situation = MenuName.LoginMenu;
    //        } else if((matcher = NPCVillageRejex.BuildGreenhouse.getMatcher(command)) != null)
    //        {
    //            App.mechanicGame.BuildGreenHouse();
    //        } else if((matcher = NPCVillageRejex.Walk.getMatcher(command)) != null)
    //        {
    //            App.mechanicGame.walk(App.ReturnCurrentPlayer().getX() , App.ReturnCurrentPlayer().getY() , Integer.parseInt(matcher.group(1)) , Integer.parseInt(matcher.group(2)));
    //        } else if ((matcher = NPCVillageRejex.TalkToSomeone.getMatcher(command)) != null) {
    //            App.friendship.Talk(matcher.group(1), matcher.group(2));
    //        } else if ((matcher = NPCVillageRejex.TalkHistory.getMatcher(command)) != null) {
    //            App.showFigures.ShowTalkHistory(matcher.group(1));
    //        } else if ((matcher = NPCVillageRejex.GiftSomeone.getMatcher(command)) != null) {
    //            App.friendship.Gifting(matcher.group(1), matcher.group(2), Integer.parseInt(matcher.group(3)));
    //        } else if ((matcher = NPCVillageRejex.GiftList.getMatcher(command)) != null) {
    //            App.showFigures.ShowUpcomingGifts();
    //        } else if ((matcher = NPCVillageRejex.GiftRate.getMatcher(command)) != null) {
    //            App.friendship.rateGift(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
    //        } else if ((matcher = NPCVillageRejex.GiftHistory.getMatcher(command)) != null) {
    //            App.showFigures.ShowGiftsFromDreamMan(matcher.group(1));
    //        }else if ((matcher = NPCVillageRejex.Hug.getMatcher(command)) != null){
    //            App.friendship.Hug(matcher.group(1));
    //        } else if ((matcher = NPCVillageRejex.Flower.getMatcher(command)) != null) {
    //            App.friendship.Flowering(matcher.group(1));
    //        } else if ((matcher = NPCVillageRejex.AskMarriage.getMatcher(command)) != null) {
    //            App.friendship.marriageRequest(matcher.group(1), matcher.group(2));
    //        } else if ((matcher = NPCVillageRejex.TradeSomeone.getMatcher(command)) != null) {
    //            App.friendship.tradeRequest(matcher.group(1), matcher.group(2), matcher.group(3), Integer.parseInt(matcher.group(4)),
    //                    Integer.parseInt(matcher.group(5)), matcher.group(6), Integer.parseInt(matcher.group(7)));
    //        } else if ((matcher = NPCVillageRejex.TradeList.getMatcher(command)) != null) {
    //            App.showFigures.showTradeList();
    //        } else if ((matcher = NPCVillageRejex.TradeResponse.getMatcher(command)) != null) {
    //            App.friendship.tradeResponse(matcher.group(1).equals("-accept"), Integer.parseInt(matcher.group(2)));
    //        } else if ((matcher = NPCVillageRejex.TradeHistory.getMatcher(command)) != null) {
    //            App.showFigures.showTradeHistory();
    //        } else if((matcher = NPCVillageRejex.PrintMap.getMatcher(command)) != null)
    //        {
    //            App.showFigures.PrintMap(Integer.parseInt(matcher.group(1)) , Integer.parseInt(matcher.group(2)) , Integer.parseInt(matcher.group(3)));
    //        } else if((matcher = NPCVillageRejex.HelpReadingMap.getMatcher(command)) != null)
    //        {
    //            App.showFigures.ShowHelpReadingMap();
    //        } else if((matcher = NPCVillageRejex.Equiptool.getMatcher(command)) != null)
    //        {
    //            App.UseTool.Equiptool(matcher.group(1).trim());
    //        } else if ((matcher = NPCVillageRejex.ToolsShowCurrent.getMatcher(command)) != null) {
    //            App.showFigures.ShowTool();
    //        } else if ((matcher = NPCVillageRejex.ToolsShowAvailable.getMatcher(command)) != null) {
    //            App.showFigures.ShowAvailableTools();
    //        } else if((matcher = NPCVillageRejex.ToolUse.getMatcher(command)) != null) {
    //            App.UseTool.Usetool(Integer.parseInt(matcher.group(1)) , Integer.parseInt(matcher.group(2)));
    //        } else if((matcher = NPCVillageRejex.ShowCraft.getMatcher(command)) != null) {
    //            App.showFigures.ShowCraft(matcher.group(1).trim());
    //        } else if((matcher = NPCVillageRejex.Planting.getMatcher(command)) != null) {
    //            App.farming.Planting(matcher.group(1).trim() , Integer.parseInt(matcher.group(2).trim()) , Integer.parseInt(matcher.group(3).trim()));
    //        } else if((matcher = NPCVillageRejex.ShowPlant.getMatcher(command)) != null) {
    //            App.showFigures.ShowPlant(Integer.parseInt(matcher.group(1).trim()) , Integer.parseInt(matcher.group(2).trim()));
    //        } else if ((matcher = NPCVillageRejex.Fertilizing.getMatcher(command)) != null) {
    //            App.farming.Cood(matcher.group(1).trim() , Integer.parseInt(matcher.group(2).trim()) , Integer.parseInt(matcher.group(3).trim()));
    //        } else if((matcher = NPCVillageRejex.Crafting.getMatcher(command)) != null) {
    //            App.Crafting.CraftItem(matcher.group(1).trim());
    //        } else if((matcher = NPCVillageRejex.AddCraftCheatcode.getMatcher(command)) != null) {
    //            App.cheatCodes.AddItemCheatCode(matcher.group(1).trim() , Integer.parseInt(matcher.group(2).trim()));
    //        } else if((matcher = NPCVillageRejex.ShowCraft.getMatcher(command)) != null) {
    //        } else if ((matcher = NPCVillageRejex.CookingRefrigerator.getMatcher(command)) != null) {
    //            if (matcher.group(1).equals("put")){
    //                App.pokhtOPaz.PutInRef(matcher.group(2));
    //            }else {
    //                App.pokhtOPaz.PickFromRef(matcher.group(2));
    //            }
    //        } else if ((matcher = NPCVillageRejex.CookingShowRecipes.getMatcher(command)) != null) {
    //            App.showFigures.ShowRecipe();
    //        } else if ((matcher = NPCVillageRejex.CookingPrepare.getMatcher(command)) != null) {
    //            App.pokhtOPaz.PokhtingOPazing(matcher.group(1));
    //        } else if ((matcher = NPCVillageRejex.Eat.getMatcher(command)) != null) {
    //            App.pokhtOPaz.Eating(matcher.group(1));
    //        } else if ((matcher = NPCVillageRejex.Build.getMatcher(command)) != null) {
    //        } else if ((matcher = NPCVillageRejex.BuyAnimal.getMatcher(command)) != null) {
    //
    //        } else if ((matcher = NPCVillageRejex.PetAnimal.getMatcher(command)) != null) {
    //            App.mechanicGame.Pet(matcher.group(1));
    //        } else if ((matcher = NPCVillageRejex.CheatSetFriendshipWithAnimal.getMatcher(command)) != null) {
    //            App.cheatCodes.SetFriendShip(matcher.group(1), Integer.parseInt(matcher.group(2)));
    //        } else if ((matcher = NPCVillageRejex.AnimalShow.getMatcher(command)) != null) {
    //            App.showFigures.ShowAnimals();
    //        } else if ((matcher = NPCVillageRejex.ShepherdAnimal.getMatcher(command)) != null) {
    //            App.mechanicGame.shepherdAnimal(matcher.group(1), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
    //        } else if ((matcher = NPCVillageRejex.FeedHay.getMatcher(command)) != null) {
    //            App.mechanicGame.FeedAnimal(matcher.group(1));
    //        } else if ((matcher = NPCVillageRejex.AnimalProduces.getMatcher(command)) != null) {
    //            App.showFigures.ShowAllAvailableProducts();
    //        } else if ((matcher = NPCVillageRejex.CollectProduce.getMatcher(command)) != null) {
    //            App.mechanicGame.getAnimalProducts(matcher.group(1));
    //        } else if ((matcher = NPCVillageRejex.SellAnimal.getMatcher(command)) != null) {
    //            App.mechanicGame.SellAnimal(matcher.group(1));
    //        } else if ((matcher = NPCVillageRejex.MeetNpc.getMatcher(command)) != null) {
    //            App.npcMenu.meetNPC(matcher.group(1));
    //        } else if ((matcher = NPCVillageRejex.GiftNpc.getMatcher(command)) != null) {
    //            App.npcMenu.giftNPC(matcher.group(1), matcher.group(2));
    //        } else if ((matcher = NPCVillageRejex.FriendshipNpcList.getMatcher(command)) != null) {
    //            App.showFigures.ShowNPCFriendShips();
    //        } else if ((matcher = NPCVillageRejex.QuestsList.getMatcher(command)) != null) {
    //            App.showFigures.ShowQuestsList();
    //        } else if ((matcher = NPCVillageRejex.QuestsFinish.getMatcher(command)) != null) {
    //            App.npcMenu.finishQuest(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
    //        } else if ((matcher = NPCVillageRejex.PlaceCraftOnFarm.getMatcher(command)) != null) {
    //
    //        }
    //        else if((matcher = NPCVillageRejex.Showallproducts.getMatcher(command)) != null) {
    //            App.shopMenu.availableProducts();
    //        }
    //        else if((matcher = NPCVillageRejex.purchase.getMatcher(command)) != null) {
    //            App.shopMenu.Buy(matcher.group(1) , matcher.group(2));
    //        }
    //        else if((matcher = NPCVillageRejex.ShippingBinSell.getMatcher(command)) != null) {
    //            App.shopMenu.shippingBinSells(matcher.group(1) , Integer.parseInt(matcher.group(2)));
    //        }
    //    }

    //
    //    public void NextTurn()
    //    {
    //        App.npcVillageController.ApplyNextTurn();
    //    }
    //
    //    /*public boolean InputMapValid(ArrayList<String> PlayersInGame)
    //    {
    //
    //    }*/
    //    public void LoadGame()
    //    {
    //        //TO DO
    //    }
    //    public void ExitGame()
    //    {
    //        //Update Files if we were Main
    //    }
    //    public void Voting()
    //    {
    //        //print Each turn
    //    }

}
