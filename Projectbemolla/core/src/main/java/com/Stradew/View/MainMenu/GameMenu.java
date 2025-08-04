package com.Stradew.View.MainMenu;
import com.Stradew.Controller.MainMenuController.GameMenuController;
import com.Stradew.Controller.MainMenuController.MapController;
import com.Stradew.Controller.MainMenuController.MechanicController.InventorypannelController;
import com.Stradew.Controller.MainMenuController.MechanicController.NotificationController;
import com.Stradew.Main;
import com.Stradew.Model.App;
import com.Stradew.Model.GameAssetsManager;
import com.Stradew.View.MainMenu.MechanicGame.NotificationDialog;
import com.Stradew.View.MainMenu.MechanicGame.NotificationMenu;
import com.badlogic.gdx.Gdx;
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
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.sun.tools.classfile.Opcode;

import javax.swing.plaf.IconUIResource;

public class GameMenu implements Screen {


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
    private TextButton QuitFromMiniGame;

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

    public GameMenu(GameMenuController controller) {
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
    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
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

        MainTable.setPosition(-800, 400);
        MainTable.add(Setting);
        //MainTable.setOrigin(900 , 400);
        MainTable.add(EnergyBar);
        MainTable.add(notifications);
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
