package com.Stradew.View.MainMenu;
import com.Stradew.Controller.MainMenuController.GameMenuController;
import com.Stradew.Controller.MainMenuController.MapController;
import com.Stradew.Controller.MainMenuController.MechanicController.InventorypannelController;
import com.Stradew.Controller.MainMenuController.MechanicController.MechanicController;
import com.Stradew.Controller.MainMenuController.MechanicController.NotificationController;
import com.Stradew.Controller.MainMenuController.SwitchMenuController;
import com.Stradew.Main;
import com.Stradew.Model.App;
import com.Stradew.Model.Enums.Animals;
import com.Stradew.Model.GameAssetsManager;
import com.Stradew.Model.Tile.Animal;
import com.Stradew.Server.Lobby;
import com.Stradew.Server.ServerMessageHandler;
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
                controller.getFriendShipController().GetTreade(parts[2] , 50);
            }
        }
        if(command.equals("ACCEPT_TRADE"))
        {
            if(parts[2].equals(App.getCurrentUser().getUsername()))
            {
                App.networkClient.sendMessage("TRADE_INFO " + parts[1] + " " + App.ReturnCurrentPlayer().getInventory().getCurrentItem().getName());
                controller.getFriendShipController().SellTrade(50, controller.getInventorypannelController());
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
    private ParticleEffect SnowEffect;
    private ParticleEffect Lightning;
    private SwitchMenuController switchMenuController;
    private TextButton QuitFromMiniGame;
    private TextButton SeeOnlilnePlayers;
    private TextButton BackFromOnlinePlayers;
    private TextButton Ranking;
    private Stage ConstantStage;

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
        //SwitchTable.setBackground(abbas);
        SwitchTable.center().top();
        SwitchTable.add(InventoryButton);
        SwitchTable.add(SkillButton);
        SwitchTable.add(SocialButton);
        SwitchTable.add(MapButton);
        SwitchTable.add(Backbutton);
        stage.addActor(SwitchTable);

        MainTable.setPosition(-400, 400);
        MainTable.add(Setting);
        //MainTable.setOrigin(900 , 400);
        MainTable.add(EnergyBar);
        MainTable.add(notifications);
        MainTable.add(SeeOnlilnePlayers);
        MainTable.add(GoReact);
        MainTable.add(Ranking);
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
        }if (Gdx.input.isKeyJustPressed(Input.Keys.H)){
            switchMenuController.openAnimalMenu(new Animal("mamad", Animals.Chicken), stage);
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
}
