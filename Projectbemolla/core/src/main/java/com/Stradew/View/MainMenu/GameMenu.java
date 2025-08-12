package com.Stradew.View.MainMenu;
import com.Stradew.Controller.MainMenuController.GameMenuController;
import com.Stradew.Controller.MainMenuController.MapController;
import com.Stradew.Controller.MainMenuController.MechanicController.InventorypannelController;
import com.Stradew.Controller.MainMenuController.MechanicController.MechanicController;
import com.Stradew.Controller.MainMenuController.MechanicController.NotificationController;
import com.Stradew.Controller.MainMenuController.SwitchMenuController;
import com.Stradew.Main;
import com.Stradew.Model.App;
import com.Stradew.Model.Enums.PlaceType;
import com.Stradew.Model.Game;
import com.Stradew.Model.Enums.Animals;
import com.Stradew.Model.GameAssetsManager;
import com.Stradew.Model.Item.Item;
import com.Stradew.Model.Trade;
import com.Stradew.Model.Tile.Animal;
import com.Stradew.Server.Lobby;
import com.Stradew.Server.ServerMessageHandler;
import com.Stradew.Model.Tile.Tile;
import com.Stradew.View.MainMenu.MechanicGame.NotificationDialog;
import com.Stradew.View.MainMenu.MechanicGame.NotificationMenu;
import com.Stradew.View.MainMenu.MechanicGame.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.sun.tools.classfile.Opcode;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;

public class GameMenu implements Screen , ServerMessageHandler {

    @Override
    public void handleServerMessage(String message) {
        System.out.println(message);
        String[] parts = message.split(" ", 10);
        String command = parts[0].toUpperCase();
        if(command.equals("PLAYER_LIST"))
        {
            controller.getOnlinePlayersController().OnlinePlayers.clear();
            String Info = parts[1];
            String[] Data = Info.split("\\|", 10);
            for(int i = 0; i < Data.length; i++)
            {
                String[] parts2 = Data[i].split("\\.", 10);
                controller.getOnlinePlayersController().OnlinePlayers.add(parts2[0] +  "         "  + parts2[1]);
            }
        }
        if(command.equals("RECEIVE_REACTION"))
        {
            if(parts[2].equals("TEXT"))
            {
                ReactionTextSender = "1" + parts[1];
                ReactionTextForDisplay = GameAssetsManager.getInstance().StringsReactionsText[Integer.parseInt(parts[3])];

            }
            else
            {
                ReactionTextSender = "2" + parts[1];
                ReactionImageforDisplay = GameAssetsManager.getInstance().ImagesREacions[Integer.parseInt(parts[3])];
            }
            App.getCurrentGame().getTimeControlPannel().setReactionTime(0);
        }

        if(command.equals("SEND_TRADE_OFFER"))
        {
            if(parts[1].equals(App.getCurrentUser().getUsername()))
            {
                controller.getTradeController().setSenderName(parts[2]);
                controller.getTradeController().setGiverName(parts[1]);
                controller.getTradeController().setBuyer(true);
                MainTable.setVisible(false);
                TradeTable.setVisible(true);
            }
        }

        if(command.equals("USER_RANK_INFO"))
        {
            if(parts[1].equals(CurrntLobby.getId()))
            {
                for(int i = 0;i < CurrntLobby.getUsernames().size() ; i++)
                {
                    if(CurrntLobby.getUsernames().get(i).equals(parts[2]))
                    {
                        CurrntLobby.getCoins().set(i , Integer.parseInt(parts[3]));
                        CurrntLobby.getNumOfQuests().set(i , Integer.parseInt(parts[4]));
                        CurrntLobby.getSumLevelSkills().set(i , Integer.parseInt(parts[5]));
                    }
                }
            }
        }
        if(command.equals("TRADE_INFO"))
        {
            if(parts[1].equals(App.getCurrentUser().getUsername()))
            {
                Trade newtrade = new Trade(parts[3] , "mamad" , 1 ,new Item(1 , parts[2]) , 100 , "mamad" , 1);
                newtrade.setGiverName(App.getCurrentUser().getUsername());
                newtrade.setItemName(parts[2]);
                App.ReturnCurrentPlayer().getTradeHistory().add(newtrade);
                controller.getFriendShipController().GetTreade(parts[2] , 50);
            }
        }
        if(command.equals("ACCEPT_TRADE"))
        {
            if(parts[2].equals(App.getCurrentUser().getUsername()))
            {
                Trade newtrade = (new Trade(App.getCurrentUser().getUsername(), "mamad" , 1 , App.ReturnCurrentPlayer().getInventory().getCurrentItem() , 100 , "mamad" , 1));
                newtrade.setGiverName(parts[1]);
                System.out.println("ALi");
                newtrade.setItemName(App.ReturnCurrentPlayer().getInventory().getCurrentItem().getName());
                System.out.println("mamad");
                App.ReturnCurrentPlayer().addTradeToHistory(newtrade);
                System.out.println("Asghar");
                App.networkClient.sendMessage("TRADE_INFO " + parts[1] + " " + App.ReturnCurrentPlayer().getInventory().getCurrentItem().getName() + " " + App.getCurrentUser().getUsername());
                System.out.println("Akbar");
                controller.getFriendShipController().SellTrade(50, controller.getInventorypannelController());
                System.out.println("Sepehr");
                TradeTable.setVisible(false);
                MainTable.setVisible(true);
            }
        }
        if(command.equals("REJECT_TRADE"))
        {
            if(parts[2].equals(App.getCurrentUser().getUsername()))
            {
                TradeTable.setVisible(false);
                MainTable.setVisible(true);
            }
        }

        if(command.equals("NEW_CHAT_INFO"))
        {
            controller.getChatController().getMessages().add(parts[2] + "   :   "  + parts[1]);
        }
    }

    @Override
    public void handleDisconnection() {

    }

    public String getReactionTextSender() {
        return ReactionTextSender;
    }

    public String getReactionTextForDisplay() {
        return ReactionTextForDisplay;
    }

    public Texture getReactionImageforDisplay() {
        return ReactionImageforDisplay;
    }

    public ArrayList<CraftMenu> getCrafmenus() {
        return crafmenus;
    }

    public String getChatToShow() {
        return ChatToShow;
    }

    private TextButton Chat;
    private ArrayList<CraftMenu> crafmenus = new ArrayList<>();
    private InputMultiplexer inputMultiplexer;
    private Texture ReactionImageforDisplay;
    private String ReactionTextForDisplay;
    private String ReactionTextSender;
    private TextButton GoReact;
    private Lobby CurrntLobby;
    private Table OnlinePlayers;
    private Table Minigame;
    private ProgressBar MinigameProgress;
    private OrthographicCamera fboCamera;
    private FrameBuffer mapFrameBuffer;
    private Sprite mapSprite;
    private GameMenuController controller;
    private OrthographicCamera camera;
    private Stage stage;
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
    private Table NPCandShop;

    private ParticleEffect SnowEffect;
    private ParticleEffect Lightning;
    private SwitchMenuController switchMenuController;
    private TextButton QuitFromMiniGame;
    private TextButton SeeOnlilnePlayers;
    private TextButton BackFromOnlinePlayers;
    private TextButton Ranking;
    private Stage ConstantStage;
    private TextButton BackToInventory;
    private String ChatToShow;


    public TextButton getBackToInventory() {
        return BackToInventory;
    }

    public Table getTradeHistoryTable() {
        return TradeHistoryTable;
    }

    public SwitchMenuController getSwitchMenuController() {
        return switchMenuController;
    }

    public TextButton getSeeOnlilnePlayers() {
        return SeeOnlilnePlayers;
    }

    public Table getReactionTable() {
        return ReactionTable;
    }

    public Table getTradeTable() {
        return TradeTable;
    }

    public TextButton[] getTextReactions() {
        return TextReactions;
    }

    public ImageButton[] getImageReactions() {
        return ImageReactions;
    }

    public TextButton getGoreact() {
        return GoReact;
    }

    public Lobby getCurrntLobby() {
        return CurrntLobby;
    }

    public Table getOnlinePlayers() {
        return OnlinePlayers;
    }

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

    public Stage getConstantStage() {
        return ConstantStage;
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
    private Table ReactionTable;
    private Table TradeTable;
    private Table RankingTable;
    private Table RankingTable2;
    private Table TradeHistoryTable;
    private Table ChatTable;


    public TextButton getChat() {
        return Chat;
    }

    public Table getChatTable() {
        return ChatTable;
    }

    public Table getRankingTable() {
        return RankingTable;
    }

    public TextButton getRanking() {
        return Ranking;
    }

    private TextButton[] TextReactions;
    private ImageButton[] ImageReactions;
    private TextButton InventoryButton;
    private TextButton SkillButton;
    private TextButton SocialButton;
    private TextButton MapButton;
    private TextButton Backbutton;
    private MechanicGame mechanicGame;

    public TextButton getBackbutton() {
        return Backbutton;
    }

    public GameMenuController getController() {
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

    public TextButton getBackFromOnlinePlayers() {
        return BackFromOnlinePlayers;
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

    public Table getRankingTable2() {
        return RankingTable2;
    }

    public FrameBuffer getMapFrameBuffer() {
        return mapFrameBuffer;
    }

    public Sprite getMapSprite() {
        return mapSprite;
    }

    public GameMenu(GameMenuController controller , Lobby lobby) {
        if (App.networkClient != null) {
            App.networkClient.setMessageHandler(this);
        }
        CurrntLobby = lobby;
        switchMenuController = new SwitchMenuController();
        mechanicGame = new MechanicGame(new MechanicController());
        this.controller = controller;
        controller.setMenu(this);
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        stage = new Stage();
        Raineffect = new ParticleEffect();
        Raineffect.load(Gdx.files.internal("WetherEffects/CorrectRainWether.p"), Gdx.files.internal("WetherEffects"));
        Raineffect.start();
        SnowEffect = new ParticleEffect();
        SnowEffect.load(Gdx.files.internal("WetherEffects/Particle Park Snow Flakes.p"), Gdx.files.internal("WetherEffects"));
        SnowEffect.start();
        Lightning = new ParticleEffect();
        Lightning.load(Gdx.files.internal("WetherEffects/Particle Park Explosion.p"), Gdx.files.internal("WetherEffects"));
        Lightning.start();
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        shadeTexture = new Texture(pixmap);
        pixmap.dispose();
        shadeColor = new Color(0.0f, 0.0f, 0.2f, 0.4f);
        GreenhouseHoverButton = new TextButton("100 G Buy Greenhouse", GameAssetsManager.getInstance().getSkin());
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

        NPCandShop = new Table();
        SeeOnlilnePlayers = new TextButton("OnlinePlayers", GameAssetsManager.getInstance().getSkin());
        OnlinePlayers = new Table();

        ReactionTable = new Table();
        TextReactions = GameAssetsManager.getInstance().Reactions();
        ImageReactions = GameAssetsManager.getInstance().ImageReactions();
        GoReact = new TextButton("React", GameAssetsManager.getInstance().getSkin());

        TradeTable = new Table();
        BackFromOnlinePlayers = new TextButton("BackFromOnlinePlayers", GameAssetsManager.getInstance().getSkin());

        Ranking = new TextButton("Ranking", GameAssetsManager.getInstance().getSkin());
        RankingTable = new Table();
        RankingTable2 = new Table();
        ConstantStage = new Stage(new ScreenViewport(camera));

        TradeHistoryTable = new Table();
        BackToInventory = new TextButton("BackToInventory", GameAssetsManager.getInstance().getSkin());

        ChatTable = new Table();
        Chat = new TextButton("Chat", GameAssetsManager.getInstance().getSkin());
    }

    public Stage getStage() {
        return stage;
    }

    @Override
    public void show() {
        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(stage);
        inputMultiplexer.addProcessor(ConstantStage);
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
        NPCandShop.setVisible(false);
        //SwitchTable.setBackground(abbas);
        SwitchTable.center().top();
        SwitchTable.add(InventoryButton);
        SwitchTable.add(SkillButton);
        SwitchTable.add(SocialButton);
        SwitchTable.add(MapButton);
        SwitchTable.add(Backbutton);
        stage.addActor(SwitchTable);

        MainTable.setPosition(-300, 400);
        MainTable.add(Setting);
        //MainTable.setOrigin(900 , 400);
        MainTable.add(EnergyBar);
        MainTable.add(notifications);
        MainTable.add(SeeOnlilnePlayers);
        MainTable.add(GoReact);
        MainTable.add(Ranking);
        MainTable.add(Chat);
        stage.addActor(MainTable);

        Minigame.setFillParent(true);
        Minigame.setVisible(false);
        Minigame.right();
        Minigame.add(MinigameProgress);
        Minigame.add(QuitFromMiniGame);
        stage.addActor(Minigame);

        SettingTable.setPosition(800, 800);
        SettingTable.add(Exit);
        SettingTable.add(BackTogame);
        SettingTable.setVisible(false);
        stage.addActor(SettingTable);

        OnlinePlayers.setFillParent(true);
        OnlinePlayers.setVisible(false);
        OnlinePlayers.right();
        OnlinePlayers.add(BackFromOnlinePlayers);

        ReactionTable.setFillParent(true);
        ReactionTable.setVisible(false);
        ReactionTable.left();
        for(int i = 0;i < 6; i++)
        {
            ReactionTable.add(TextReactions[i]).width(200).padLeft(100);
            ReactionTable.add(ImageReactions[i]).row();
        }

        TradeTable.setFillParent(true);
        TradeTable.setVisible(false);
        TradeTable.center();

        RankingTable.setFillParent(true);
        RankingTable.setVisible(false);
        RankingTable.center();

        RankingTable2.setFillParent(true);
        RankingTable2.setVisible(false);
        RankingTable2.top().right();

        TradeHistoryTable.setFillParent(true);
        TradeHistoryTable.setVisible(false);
        TradeHistoryTable.top();
        TradeHistoryTable.add(BackToInventory);

        ChatTable.setFillParent(true);
        ChatTable.setVisible(false);
        ChatTable.top();


        stage.addActor(ChatTable);
        stage.addActor(TradeHistoryTable);
        stage.addActor(RankingTable2);
        stage.addActor(RankingTable);
        stage.addActor(TradeTable);
        stage.addActor(ReactionTable);
        stage.addActor(OnlinePlayers);
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
            controller.getMapController().PrintInitialMap(mapFrameBuffer, fboCamera);

        }
        //controller.getMapController().setGreenhouseHoverTextButton(GreenhouseHoverButton);
        //GreenhouseHoverButton.setPosition(500 , 500);
        controller.getMapController().setGreenhouseHoverTextButton();
        BuyGreenhouseTable.setFillParent(true);
        //BuyGreenhouseTable.setVisible(false);
        BuyGreenhouseTable.left();
        BuyGreenhouseTable.add(GreenhouseHoverButton);
        stage.addActor(BuyGreenhouseTable);
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
        ConstantStage.act();
        ConstantStage.draw();
        if (Gdx.input.isKeyJustPressed(Input.Keys.N)) {
            switchMenuController.openNpcVillage();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.O)){
            mechanicGame.playPettingAnimation(stage);
            mechanicGame.petAllAnimals();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.F)){
            mechanicGame.playFeedingAnimation(stage);
        }if (Gdx.input.isKeyJustPressed(Input.Keys.G)){
            mechanicGame.playShepherdingAnimation(stage);
        }if (Gdx.input.isKeyJustPressed(Input.Keys.B)){
            switchMenuController.openCraftMenu(stage);
        }
    }

    @Override
    public void resize(int i, int i1) {

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

    public Table getNPCandShop() {
        return NPCandShop;
    }
//    SignUpController signUpController = App.signUpController;
//    GameMenuController gameMenuController = App.gameMenuController;
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
//                App.gameMenu.NextTurn();
//            }
//        }
//        if((matcher = GameMenuRejex.StartGame.getMatcher(command)) != null) {
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
//        } else if ((matcher = GameMenuRejex.EnergyShow.getMatcher(command)) != null){
//            showFigures.ShowEnergy();
//        } else if ((matcher = GameMenuRejex.EnergySet.getMatcher(command)) != null) {
//            cheatCodes.SetEnergy(Integer.parseInt(matcher.group(1)));
//        } else if ((matcher = GameMenuRejex.EnergyUnlimited.getMatcher(command)) != null) {
//            cheatCodes.SetUnlimitedEnergy();
//        } else if ((matcher = GameMenuRejex.InventoryShow.getMatcher(command)) != null) {
//            showFigures.ShowInventory();
//        } else if ((matcher = GameMenuRejex.CheatWeatherSet.getMatcher(command)) != null) {
//            cheatCodes.SetWeather(matcher.group(1));
//        } else if ((matcher = GameMenuRejex.ShowWeather.getMatcher(command)) != null) {
//            showFigures.ShowWeather();
//        } else if ((matcher = GameMenuRejex.WeatherForecast.getMatcher(command)) != null) {
//            showFigures.PredictWeather();
//        } else if ((matcher = GameMenuRejex.CheatThor.getMatcher(command)) != null) {
//            cheatCodes.Thor(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));// This is incomplete
//        } else if ((matcher = GameMenuRejex.ShowSeason.getMatcher(command)) != null) {
//            showFigures.ShowSeason();
//        } else if ((matcher = GameMenuRejex.CheatAdvanceDate.getMatcher(command)) != null) {
//            cheatCodes.ChangeDay(Integer.parseInt(matcher.group(1)));
//        } else if ((matcher = GameMenuRejex.CheatAdvanceTime.getMatcher(command)) != null) {
//            cheatCodes.ChangeHour(Integer.parseInt(matcher.group(1)));
//        } else if ((matcher = GameMenuRejex.ShowDayOfWeek.getMatcher(command)) != null) {
//            showFigures.ShowDayOfWeek();
//        } else if ((matcher = GameMenuRejex.ShowDateTime.getMatcher(command)) != null) {
//            showFigures.ShowDateTime();
//        } else if ((matcher = GameMenuRejex.ShowDate.getMatcher(command)) != null) {
//            showFigures.ShowDate();
//        } else if ((matcher = GameMenuRejex.ShowTime.getMatcher(command)) != null) {
//            showFigures.ShowTime();
//        } else if((matcher = GameMenuRejex.ExitGame.getMatcher(command)) != null)
//        {
//            Appview.Situation = MenuName.LoginMenu;
//        } else if((matcher = GameMenuRejex.BuildGreenhouse.getMatcher(command)) != null)
//        {
//            App.mechanicGame.BuildGreenHouse();
//        } else if((matcher = GameMenuRejex.Walk.getMatcher(command)) != null)
//        {
//            App.mechanicGame.walk(App.ReturnCurrentPlayer().getX() , App.ReturnCurrentPlayer().getY() , Integer.parseInt(matcher.group(1)) , Integer.parseInt(matcher.group(2)));
//        } else if ((matcher = GameMenuRejex.TalkToSomeone.getMatcher(command)) != null) {
//            App.friendship.Talk(matcher.group(1), matcher.group(2));
//        } else if ((matcher = GameMenuRejex.TalkHistory.getMatcher(command)) != null) {
//            App.showFigures.ShowTalkHistory(matcher.group(1));
//        } else if ((matcher = GameMenuRejex.GiftSomeone.getMatcher(command)) != null) {
//            App.friendship.Gifting(matcher.group(1), matcher.group(2), Integer.parseInt(matcher.group(3)));
//        } else if ((matcher = GameMenuRejex.GiftList.getMatcher(command)) != null) {
//            App.showFigures.ShowUpcomingGifts();
//        } else if ((matcher = GameMenuRejex.GiftRate.getMatcher(command)) != null) {
//            App.friendship.rateGift(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
//        } else if ((matcher = GameMenuRejex.GiftHistory.getMatcher(command)) != null) {
//            App.showFigures.ShowGiftsFromDreamMan(matcher.group(1));
//        }else if ((matcher = GameMenuRejex.Hug.getMatcher(command)) != null){
//            App.friendship.Hug(matcher.group(1));
//        } else if ((matcher = GameMenuRejex.Flower.getMatcher(command)) != null) {
//            App.friendship.Flowering(matcher.group(1));
//        } else if ((matcher = GameMenuRejex.AskMarriage.getMatcher(command)) != null) {
//            App.friendship.marriageRequest(matcher.group(1), matcher.group(2));
//        } else if ((matcher = GameMenuRejex.TradeSomeone.getMatcher(command)) != null) {
//            App.friendship.tradeRequest(matcher.group(1), matcher.group(2), matcher.group(3), Integer.parseInt(matcher.group(4)),
//                    Integer.parseInt(matcher.group(5)), matcher.group(6), Integer.parseInt(matcher.group(7)));
//        } else if ((matcher = GameMenuRejex.TradeList.getMatcher(command)) != null) {
//            App.showFigures.showTradeList();
//        } else if ((matcher = GameMenuRejex.TradeResponse.getMatcher(command)) != null) {
//            App.friendship.tradeResponse(matcher.group(1).equals("-accept"), Integer.parseInt(matcher.group(2)));
//        } else if ((matcher = GameMenuRejex.TradeHistory.getMatcher(command)) != null) {
//            App.showFigures.showTradeHistory();
//        } else if((matcher = GameMenuRejex.PrintMap.getMatcher(command)) != null)
//        {
//            App.showFigures.PrintMap(Integer.parseInt(matcher.group(1)) , Integer.parseInt(matcher.group(2)) , Integer.parseInt(matcher.group(3)));
//        } else if((matcher = GameMenuRejex.HelpReadingMap.getMatcher(command)) != null)
//        {
//            App.showFigures.ShowHelpReadingMap();
//        } else if((matcher = GameMenuRejex.Equiptool.getMatcher(command)) != null)
//        {
//            App.UseTool.Equiptool(matcher.group(1).trim());
//        } else if ((matcher = GameMenuRejex.ToolsShowCurrent.getMatcher(command)) != null) {
//            App.showFigures.ShowTool();
//        } else if ((matcher = GameMenuRejex.ToolsShowAvailable.getMatcher(command)) != null) {
//            App.showFigures.ShowAvailableTools();
//        } else if((matcher = GameMenuRejex.ToolUse.getMatcher(command)) != null) {
//            App.UseTool.Usetool(Integer.parseInt(matcher.group(1)) , Integer.parseInt(matcher.group(2)));
//        } else if((matcher = GameMenuRejex.ShowCraft.getMatcher(command)) != null) {
//            App.showFigures.ShowCraft(matcher.group(1).trim());
//        } else if((matcher = GameMenuRejex.Planting.getMatcher(command)) != null) {
//            App.farming.Planting(matcher.group(1).trim() , Integer.parseInt(matcher.group(2).trim()) , Integer.parseInt(matcher.group(3).trim()));
//        } else if((matcher = GameMenuRejex.ShowPlant.getMatcher(command)) != null) {
//            App.showFigures.ShowPlant(Integer.parseInt(matcher.group(1).trim()) , Integer.parseInt(matcher.group(2).trim()));
//        } else if ((matcher = GameMenuRejex.Fertilizing.getMatcher(command)) != null) {
//            App.farming.Cood(matcher.group(1).trim() , Integer.parseInt(matcher.group(2).trim()) , Integer.parseInt(matcher.group(3).trim()));
//        } else if((matcher = GameMenuRejex.Crafting.getMatcher(command)) != null) {
//            App.Crafting.CraftItem(matcher.group(1).trim());
//        } else if((matcher = GameMenuRejex.AddCraftCheatcode.getMatcher(command)) != null) {
//            App.cheatCodes.AddItemCheatCode(matcher.group(1).trim() , Integer.parseInt(matcher.group(2).trim()));
//        } else if((matcher = GameMenuRejex.ShowCraft.getMatcher(command)) != null) {
//        } else if ((matcher = GameMenuRejex.CookingRefrigerator.getMatcher(command)) != null) {
//            if (matcher.group(1).equals("put")){
//                App.pokhtOPaz.putInRef(matcher.group(2));
//            }else {
//                App.pokhtOPaz.PickFromRef(matcher.group(2));
//            }
//        } else if ((matcher = GameMenuRejex.CookingShowRecipes.getMatcher(command)) != null) {
//            App.showFigures.ShowRecipe();
//        } else if ((matcher = GameMenuRejex.CookingPrepare.getMatcher(command)) != null) {
//            App.pokhtOPaz.PokhtingOPazing(matcher.group(1));
//        } else if ((matcher = GameMenuRejex.Eat.getMatcher(command)) != null) {
//            App.pokhtOPaz.Eating(matcher.group(1));
//        } else if ((matcher = GameMenuRejex.Build.getMatcher(command)) != null) {
//        } else if ((matcher = GameMenuRejex.BuyAnimal.getMatcher(command)) != null) {
//
//        } else if ((matcher = GameMenuRejex.PetAnimal.getMatcher(command)) != null) {
//            App.mechanicGame.Pet(matcher.group(1));
//        } else if ((matcher = GameMenuRejex.CheatSetFriendshipWithAnimal.getMatcher(command)) != null) {
//            App.cheatCodes.SetFriendShip(matcher.group(1), Integer.parseInt(matcher.group(2)));
//        } else if ((matcher = GameMenuRejex.AnimalShow.getMatcher(command)) != null) {
//            App.showFigures.ShowAnimals();
//        } else if ((matcher = GameMenuRejex.ShepherdAnimal.getMatcher(command)) != null) {
//            App.mechanicGame.shepherdAnimal(matcher.group(1), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
//        } else if ((matcher = GameMenuRejex.FeedHay.getMatcher(command)) != null) {
//            App.mechanicGame.FeedAnimal(matcher.group(1));
//        } else if ((matcher = GameMenuRejex.AnimalProduces.getMatcher(command)) != null) {
//            App.showFigures.ShowAllAvailableProducts();
//        } else if ((matcher = GameMenuRejex.CollectProduce.getMatcher(command)) != null) {
//            App.mechanicGame.getAnimalProducts(matcher.group(1));
//        } else if ((matcher = GameMenuRejex.SellAnimal.getMatcher(command)) != null) {
//            App.mechanicGame.SellAnimal(matcher.group(1));
//        } else if ((matcher = GameMenuRejex.MeetNpc.getMatcher(command)) != null) {
//            App.npcMenu.meetNPC(matcher.group(1));
//        } else if ((matcher = GameMenuRejex.GiftNpc.getMatcher(command)) != null) {
//            App.npcMenu.giftNPC(matcher.group(1), matcher.group(2));
//        } else if ((matcher = GameMenuRejex.FriendshipNpcList.getMatcher(command)) != null) {
//            App.showFigures.ShowNPCFriendShips();
//        } else if ((matcher = GameMenuRejex.QuestsList.getMatcher(command)) != null) {
//            App.showFigures.ShowQuestsList();
//        } else if ((matcher = GameMenuRejex.QuestsFinish.getMatcher(command)) != null) {
//            App.npcMenu.finishQuest(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
//        } else if ((matcher = GameMenuRejex.PlaceCraftOnFarm.getMatcher(command)) != null) {
//
//        }
//        else if((matcher = GameMenuRejex.Showallproducts.getMatcher(command)) != null) {
//            App.shopMenu.availableProducts();
//        }
//        else if((matcher = GameMenuRejex.purchase.getMatcher(command)) != null) {
//            App.shopMenu.Buy(matcher.group(1) , matcher.group(2));
//        }
//        else if((matcher = GameMenuRejex.ShippingBinSell.getMatcher(command)) != null) {
//            App.shopMenu.shippingBinSells(matcher.group(1) , Integer.parseInt(matcher.group(2)));
//        }
//    }

//
//    public void NextTurn()
//    {
//        App.gameMenuController.ApplyNextTurn();
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
