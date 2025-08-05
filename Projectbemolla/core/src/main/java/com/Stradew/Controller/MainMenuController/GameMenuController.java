package com.Stradew.Controller.MainMenuController;

import com.Stradew.Controller.MainMenuController.HomeMenucontroller.PokhtOPazController;
import com.Stradew.Controller.MainMenuController.MechanicController.InventorypannelController;
import com.Stradew.Controller.MainMenuController.MechanicController.SocialPannelController;
import com.Stradew.Controller.PepoleeContoller;
import com.Stradew.Controller.SignUpController;
import com.Stradew.Main;
import com.Stradew.Model.*;
import com.Stradew.Model.Enums.*;
import com.Stradew.Model.Places.*;
import com.Stradew.Model.Tile.Animal;
import com.Stradew.Model.Tile.Plants;
import com.Stradew.Model.Tile.Tile;
import com.Stradew.Model.Tools.Pepolee;
import com.Stradew.Model.Tools.ShippingBin;
import com.Stradew.Model.Tools.Tools;
import com.Stradew.View.Appview;
import com.Stradew.View.MainMenu.GameMenu;
import com.Stradew.View.MainMenu.MechanicGame.HomeMenu.PokhtOPaz;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;

import java.util.ArrayList;

public class GameMenuController {


    public PepoleeContoller getPepoleeController() {
        return pepoleeController;
    }

    public static void StartGame(ArrayList<String> PlayersInGame)
    {
        PlayersInGame.add(0, App.getCurrentUser().getUsername());
        SignUpController Abbas = new SignUpController();
        for(int i = 0 ;i < PlayersInGame.size();i++) {
            if (!Abbas.IsUsernameTaken(PlayersInGame.get(i))) {
                System.out.println(PlayersInGame.get(i) + " is not a valid username");
                return;
            }
        }
        GameMenuController Abbas2 = new GameMenuController();
        if(!Abbas2.IsInAnotherGame(PlayersInGame)) {
            System.out.println("Your Friend are in the game");
            return;
        }

        Abbas2.ApplyPlayersToGame(PlayersInGame);
        for(int i = 0 ;i < PlayersInGame.size();i++) {

            Abbas2.SetFarm(i , 1);
        }
    }

    public InventorypannelController getInventorypannelController() {
        return inventorypannelController;
    }

    GameMenu menu;
    private MinigameController minigameController = new MinigameController();
    private PepoleeContoller pepoleeController = new PepoleeContoller();
    private MapController mapController = new MapController();
    private OptionsController optionsController = new OptionsController();
    private InventorypannelController inventorypannelController = new InventorypannelController();
    public MapController getMapController() {
        return mapController;
    }
    private SkillPannelController skillPannelController = new SkillPannelController();
    private SocialPannelController socialPannelController = new SocialPannelController();
    private SwitchMenuController switchMenuController = new SwitchMenuController();
    private boolean ok = false;

    public void setMenu(GameMenu menu) {
        this.menu = menu;
    }

    public void SetEnergyBar(GameMenu menu)
    {

    }

    public void CheckSetting()
    {
        if(menu.getSettingTable().isVisible())
        {
            if(menu.getExit().isChecked())
            {
                Gdx.app.exit();
            }
            if(menu.getBackTogame().isChecked())
            {
                menu.getSettingTable().setVisible(false);
                menu.getMainTable().setVisible(true);
                menu.getBackTogame().setChecked(false);
            }
        }
        else
        {
            if(menu.getSetting().isChecked())
            {
                menu.getMainTable().setVisible(false);
                menu.getSettingTable().setVisible(true);
                menu.getSetting().setChecked(false);
            }
        }
    }


    public void Update(float v)
    {
        menu.getNotifications().setText(String.format("%d", App.ReturnCurrentPlayer().getNewMessages()));
        if(App.ReturnCurrentPlayer().getEnergy() < 0)
        {
            App.ReturnCurrentPlayer().setEnergy(10);
            ApplyNextTurn();
        }
        CheckSetting();
        if (Gdx.input.isKeyJustPressed(Input.Keys.P)){
            switchMenuController.openPokhMenu();
        }
        if(!ok)
        {
            inventorypannelController.setInventorytable(menu.getInventoryTable());
            inventorypannelController.firstTouch();
            ok = true;
        }
        if(menu.getMainTable().isVisible()) {
            mapController.HandleBuyGreenhouseButton(menu);
            mapController.RenderMap(menu.getMapSprite(), menu.getMapFrameBuffer(), menu , menu.getFboCamera() , menu.getCamera());
            pepoleeController.Update(menu ,App.ReturnCurrentPlayer(), v);
            optionsController.Update(menu.getGreenhouseHoverButton() , menu);
            App.getCurrentGame().getTimeControlPannel().UpdateTimes(v);
            menu.getRaineffect().setPosition(App.ReturnCurrentPlayer().getX()  -Gdx.graphics.getWidth() / 2, App.ReturnCurrentPlayer().getY() - Gdx.graphics.getHeight() / 2);
            menu.getSnowEffect().setPosition(App.ReturnCurrentPlayer().getX() - Gdx.graphics.getWidth() / 2 , App.ReturnCurrentPlayer().getY() - Gdx.graphics.getHeight() /2 );
            menu.getLightning().setPosition(App.ReturnCurrentPlayer().getX() - Gdx.graphics.getWidth() / 2 , App.ReturnCurrentPlayer().getY() - Gdx.graphics.getHeight() / 2);
            menu.getRaineffect().update(v);
            menu.getSnowEffect().update(v);
            menu.getLightning().update(v);
            menu.getLightning().draw(Main.getMain().getBatch());
            if(App.getCurrentGame().getWeather() == Weathers.SNOW) {
                menu.getSnowEffect().draw(Main.getMain().getBatch());
            }
            if(App.getCurrentGame().getWeather() == Weathers.RAIN) {
                menu.getRaineffect().draw(Main.getMain().getBatch());
            }
            Main.getMain().getBatch().setColor(menu.getShadeColor());
            Main.getMain().getBatch().draw(menu.getShadeTexture() , App.ReturnCurrentPlayer().getX() - Gdx.graphics.getWidth()/2 , App.ReturnCurrentPlayer().getY() - Gdx.graphics.getHeight() / 2 , Gdx.graphics.getWidth() , Gdx.graphics.getHeight());
            Main.getMain().getBatch().setColor(Color.WHITE);
        }
        if(menu.getSwitchTable().isVisible()) {
            optionsController.SwitchBeetweenOptions(menu);
        }
        if(menu.getInventoryTable().isVisible()) {
            inventorypannelController.Update(this);
        }
        if(menu.getSkillTable().isVisible()) {
            skillPannelController.update();
        }
        if(menu.getMapTable().isVisible()) {

        }
        if(menu.getSocialTable().isVisible()) {
            socialPannelController.rebuild(menu.getSocialTable());
        }
        if(menu.getMinigame().isVisible())
        {
            minigameController.update(menu , v);
        }

    }


    public void ApplyNextTurn()
    {
        App.getCurrentGame().setWhoseTurn(((App.getCurrentGame().getWhoseTurn() + 1)) % App.getCurrentGame().getCharactersInGame().size());
        if(App.ReturnCurrentPlayer().isISFainted())
        {
            System.out.printf("%s is fainted next turn\n" , App.getCurrentGame().getPlayersInGame().get(App.getCurrentGame().getWhoseTurn()).getUsername());
        }
        if(App.getCurrentGame().getWhoseTurn() == 0)
        {
            App.getCurrentGame().getTime().jumpAheadOneHour();
        }
    }
    public void ApplyPlayersToGame(ArrayList<String> PlayersInGame)
    {
        Game newgame = new Game(App.Games.size());
        ArrayList<User> players = new ArrayList<User>();
        for(int i = 0; i < PlayersInGame.size() ; i++)
        {
            int Userindex = App.ReturnUserIndex(PlayersInGame.get(i));
            players.add(App.Users.get(Userindex));
        }
        newgame.setPlayersInGame(players);
        ArrayList<Pepolee> Characters = new ArrayList<>();
        for(int i = 0;i < PlayersInGame.size() ; i++)
        {
            Pepolee NewPeople = new Pepolee();
            NewPeople.setCharacterUser(players.get(i));
            NewPeople.setId(i);
            Skill[] S = new Skill[4];
            S[0] = new Skill(Skills.Foraging);
            S[1] = new Skill(Skills.Fishing);
            S[2] = new Skill(Skills.Farming);
            S[3] = new Skill(Skills.Mining);
            NewPeople.setSkills(S);
            Characters.add(NewPeople);
        }
        newgame.setCharactersInGame(Characters);
        for(int i = 0;i < PlayersInGame.size(); i++)
        {
            newgame.getScores().add(0);
        }
        for(int i = 0;i < players.size();i++)
        {
            players.get(i).setGameId(newgame.getID());
        }
        App.Games.add(newgame);
        Appview.CurrentGameID = newgame.getID();
        //first should Add Creator Id
        //define the Peoplee int the game
        //please Define dasti the Skills
    }

    public boolean IsInAnotherGame(ArrayList<String> PlayersInGame)
    {
        for(int i = 0; i<PlayersInGame.size(); i++)
        {
            int Userindex = App.ReturnUserIndex(PlayersInGame.get(i));
            if(App.Users.get(Userindex).getGameId() != -1)
            {
                return false;
            }
        }
        return true;
    }

    public boolean CheckMapIDValid(int MapID)
    {
        return MapID < 4;
    }

    public ConstantFarms ReturnFarm(int FarmID)
    {
        int count = 1;
        for(ConstantFarms farm : ConstantFarms.values())
        {
            if(count == FarmID)
            {
                return farm;
            }
            count++;
        }
        return null;
    }

    public void SetFarm(int Id , int FarmID) {
        if(FarmID == 1)
        {
            App.getCurrentGame().getCharactersInGame().get(Id).setFarm(new Farm(new GreenHouse( 8 , 8) , new Cabin(10 , 25) , new Lake(25 , 15) , new Quarry(30 , 25)));
        }
        if(FarmID == 2)
        {
            App.getCurrentGame().getCharactersInGame().get(Id).setFarm(new Farm(new GreenHouse( 25 , 8) , new Cabin(5 , 5) , new Lake(30 , 30) , new Quarry(25 , 8)));
        }
    }
    public void ApplyDeleteGame()
    {
        //Dont delete in ArrayList
    }
    public void RandomAttackCrow()
    {

    }
    public void RandomForagingOnGird()
    {

    }

    public static Weathers WeatherForeCasting()
    {
        Season season = App.getCurrentGame().getTime().getSeason();
        if(season == Season.SPRING)
        {
            int Rand = App.random.nextInt() % 5;
            if(Rand == 0 || Rand == 1)
            {
                return Weathers.RAIN;
            }
            if(Rand == 2 || Rand == 3)
            {
                return Weathers.SUNNY;
            }
            if(Rand == 4)
            {
                return Weathers.STORM;
            }
        }
        if(season == Season.SUMMER)
        {
            return Weathers.SUNNY;
        }
        if(season == Season.FALL)
        {
            int Rand = App.random.nextInt() % 5;
            if(Rand == 0 || Rand == 1)
            {
                return Weathers.RAIN;
            }
            if(Rand == 2)
            {
                return Weathers.SNOW;
            }
            if(Rand == 4 || Rand == 3)
            {
                return Weathers.STORM;
            }
        }
        if(season == Season.WINTER)
        {
            int Rand = App.random.nextInt() % 5;
            if(Rand == 0 || Rand == 1)
            {
                return Weathers.STORM;
            }
            if(Rand == 2 || Rand == 3)
            {
                return Weathers.SNOW;
            }
            if(Rand == 4)
            {
                return Weathers.RAIN;
            }
        }
        return Weathers.SUNNY;
    }


    public static void ApplyChangeDay()
    {
        Time gameTime = App.getCurrentGame().getTime();
        //USer random Foraging
        //set weather
        App.getCurrentGame().setWeather(WeatherForeCasting());
        if(App.getCurrentGame().getWeather() == Weathers.STORM) {
            for (Pepolee pepolee : App.getCurrentGame().getCharactersInGame()) {
                for (int i = 0; i < PlaceType.FARM.XLength; i++) {
                    for (int j = 0; j < PlaceType.FARM.YLength; j++) {
                        App.farmingController.RandomLightning(pepolee, i, j, false);
                    }
                }
            }
        }
        if(App.getCurrentGame().getWeather() == Weathers.RAIN) {
            for(Pepolee pepolee : App.getCurrentGame().getCharactersInGame()) {
                for(int i = 0; i < PlaceType.FARM.XLength; i++) {
                    for(int j = 0; j < PlaceType.FARM.YLength; j++) {
                        if(pepolee.getFarm().getGround()[i][j].getEntitity() == Entitity.PLANTS && pepolee.getFarm().getGround()[i][j].getPlaceType() != PlaceType.GREENHOUSE)
                        {
                            Plants ourplant = (Plants) pepolee.getFarm().getGround()[i][j];
                            ourplant.setLastTimeWatering(App.getCurrentGame().getTime());
                        }
                    }
                }
            }
        }

        // plants stage
        for (Pepolee pepolee: App.getCurrentGame().getCharactersInGame()){
            for (Tile[] tiles: pepolee.getFarm().getGround()){
                for (Tile tile: tiles){
                    if (tile instanceof Plants){
                        if (((Plants) tile).getCurrentStage() == -1){
                            continue;
                        }
                        int daysLeft = gameTime.getDay() - ((Plants) tile).getBornTime().getDay();
                        if (daysLeft > ((Plants) tile).getCurrentStage()){
                            ((Plants) tile).setStage(((Plants) tile).getStage()+1);
                        }
                    }
                }
            }
            App.farmingController.ApplyRandomForagingInFarm(pepolee);
            pepolee.RefreshDay();
        }
        //use above function
        //USer random Foraging
        // animals friendship effects
        for (Pepolee pepolee: App.getCurrentGame().getCharactersInGame()){

            for (Animal animal: pepolee.getFarm().getAnimals()){
                if (!animal.isFed()){
                    animal.addFriendship(-20);
                }if (!animal.isPettedToday()){
                    animal.addFriendship(animal.getFriendShip()/200 - 10);
                }if (!animal.isInside()){
                    animal.addFriendship(-20);
                }
            }
        }

        // random gift
        FriendShip[][] allFriendships = App.getCurrentGame().getFriendShips();
        for (Pepolee pepolee:App.getCurrentGame().getCharactersInGame()){
            for (int i = 4; i<9; i++){
                if (allFriendships[pepolee.getId()][i].getLevel() >= 3){
                    int random = App.random.nextInt() % 2;
                    if (random == 1){
                        pepolee.addCoin(50 + (App.random.nextInt() % 25));
                    }
                }
            }
        }

        // unlock quest
        for (Pepolee pepolee: App.getCurrentGame().getCharactersInGame()){
            for (Npc npc: App.getCurrentGame().getGameNPCs()){
                if (npc.getHowManyDaysToUnlockQuest() > gameTime.getDay() + gameTime.getMonth() * 28){
                    if (npc.getQuests().get(2).getQuestLockedForever()[pepolee.getId()]){
                        continue;
                    }
                    npc.getQuests().get(2).getQuestLocked()[pepolee.getId()] = false;
                }
            }
        }

        // animals produce
        for (Pepolee pepolee: App.getCurrentGame().getCharactersInGame()){
            for (Animal animal: pepolee.getFarm().getAnimals()){
                animal.makeProduct();
            }
        }

        // apply daily limist
        App.dailyLimits.setBlackSmithLimits(new int[]{1 , 1 , 1 , 1 , 1 , 1 , 1 , 1});
        App.dailyLimits.setMarineRanch(new int[]{1 , 1 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2});
        App.dailyLimits.setStarDropSaloon(new int[]{1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1});
        App.dailyLimits.setCarpenterShop(new int[]{1 , 1 , 1 , 1 , 1 , 1 , 1});
        App.dailyLimits.setJojaMart(new int[]
                {5 , 10 , 5 , 1 , 5 ,
                        5 , 5 , 5 , 5 , 5 ,
                        5 , 5 , 5 , 5 , 5 ,
                        5 , 5 , 5 , 5 , 5 ,
                        5 , 5 , 10 , 5 , 5 ,
                        10 , 5 , 5 , 5 , 5 ,
                        5 , 5 , 5 , 5 , 5 ,
                        5 , 1 , 10 , 1 , 5});
        App.dailyLimits.setPierreStore(new int[]
                {
                        2 , 2 , 1 , 1 , 1 ,
                        1 , 5 , 5 , 5 , 5 ,
                        5 , 5 , 5 , 5 , 5 ,
                        5 , 5 , 5 , 5 , 5 ,
                        5 , 5 , 5 , 5 , 5 ,
                        5 , 5 , 5 , 5 , 5 ,
                        5 , 5 , 5 , 5 , 5 ,
                        5 , 5 , 5 , 5
                });
        App.dailyLimits.setFishShop(new int[]
                {
                        1 , 1 , 1 , 1 , 1 , 1
                });

        // empty shipping bin
        for(Tools tools : App.ReturnCurrentPlayer().getInventory().getTools())
        {
            if(tools instanceof ShippingBin)
            {
                for(int i = ((ShippingBin) tools).getShippingBinItem().size() - 1 ; i >= 0 ; i--)
                {
                    App.ReturnCurrentPlayer().setCoin((int) (App.ReturnCurrentPlayer().getCoin() + ((ShippingBin) tools).getShippingBinItem().get(i).getCount() * ((ShippingBin) tools).getItemPrice().get(i) * ((ShippingBin) tools).ShippingBinType.coefficient));
                    ((ShippingBin) tools).RemoveLast();
                }
            }
        }
    }
    public static void ApplyChangeHour(){
        Game game = App.getCurrentGame();
        game.getTime().jumpAheadOneHour();
        if (game.getTime().isDayChanged()){
            ApplyChangeDay();
        }


        //buff effect
        for (Pepolee pepolee: game.getCharactersInGame()){
            Buff buff = pepolee.getBuff();
            int[] hoursLeft = buff.getHoursLeft();
            for (int hour: hoursLeft){
                if (hour > 0){
                    hour --;
                }
            }
            if (hoursLeft[0] <= 0){
                buff.setMaxEnergy(0);
            }
            if (hoursLeft[1] <= 0){
                buff.setFarming(false);
            }
            if (hoursLeft[2] <= 0){
                buff.setForaging(false);
            }
            if (hoursLeft[3] <= 0){
                buff.setFishing(false);
            }
            if (hoursLeft[4] <= 0){
                buff.setMining(false);
            }
        }
    }
}
