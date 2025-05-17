package com.example.Model.Enums.Rejex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum GameMenuRejex {
    ShippingBinSell("sell\\s+(.+)\\s+-n\\s+(\\d+)"),
    Showallproducts("^show\\s+all\\s+products$"),
    purchase("^purchase\\s+(.+)\\s+-n\\s+(.+)$"),
    AddCraftCheatcode("cheat\\s+add\\s+item\\s+-n\\s+(.+)\\s+-c\\s+(\\d+)"),
    Crafting("crafting\\s+craft\\s+(.+)"),
    ShowRecipes("crafting\\s+show\\s+recipes"),
    Fertilizing("fertilize\\s+-f\\s+(.+)\\s+-d\\s+(\\d+),(\\d+)"),
    ShowPlant("showplant\\s+-l\\s+(\\d+),(\\d+)"),
    Planting("plant\\s+-s\\s+(.+)\\s+-d\\s+(\\d+),(\\d+)"),
    ShowCraft("craftinfo\\s+-n\\s+(.+)"),
    ToolUse("tools\\s+use\\s+-d\\s+(\\d+)\\s+(\\d+)"),
    ToolsShowAvailable("^tools\\s+show\\s+available$"),
    ToolsShowCurrent("^tools\\s+show\\s+current$"),
    Equiptool("^tools\\s+equip\\s+(.+)$"),
    Printmap("print\\s+map\\s+-l\\s+(\\d+),(\\d+)\\s+-s\\s+(\\d+)"),
    BuildGreenhouse("^greenhouse\\s+build$"),
    ExitGame("^exit\\s+game$"),
    StartGame("^game new -u(?:\\s+(\\w+)){1,3}$"),
    ShowTime("^time$"),
    ShowDate("^date$"),
    ShowDateTime("^datetime$"),
    ShowDayOfWeek("^day\\s+of\\s+the\\s+week"),
    CheatAdvanceTime("^cheat\\s+advance\\s+time\\s+(\\d+)h"),
    CheatAdvanceDate("^cheat\\s+advance\\s+date\\s+(\\d+)d"),
    ShowSeason("^season$"),
    CheatThor("^cheat\\s+Thor\\s+-l\\s+(\\d),(\\d)"),
    ShowWeather("^weather$"),
    WeatherForecast("^weather\\s+forecast"),
    CheatWeatherSet("^cheat\\s+weather\\s+set\\s+(.+)"),
    Walk("^walk\\s+-l\\s+(\\d+),(\\d+)"),
    PrintMap("^print\\s+map\\s+-l\\s+(\\d+),(\\d+)\\s+-s\\s+(\\d+)"),
    HelpReadingMap("^help\\s+reading\\s+map"),
    EnergyShow("^energy\\s+show"),
    EnergySet("^energy\\s+set\\s+-v\\s+(\\d+)"),
    EnergyUnlimited("^energy\\s+unlimited"),
    InventoryShow("^inventory\\s+show"),
    InventoryTrash("^inventory\\s+trash\\s+-i\\s+(.+)\\s+-n\\s+(\\d+)"),
    TalkToSomeone("^talk\\s+-u\\s+(.+)\\s+-m\\s+(.+)"),
    TalkHistory("^talk\\s+history\\s+-u\\s+(.+)"),
    GiftSomeone("^gift\\s+-u\\s+(.+)\\s+-i\\s+(.+)\\s+-a\\s+(\\d+)"),
    GiftList("^gift\\s+list"),
    GiftRate("^gift\\s+rate\\s+-i\\s+(.+)\\s+-r\\s+(.+)"),
    GiftHistory("^gift\\s+history\\s+-u\\s+(.+)"),
    Flower("^flower\\s+-u\\s+(.+)"),
    Hug("^hug\\s+-u\\s+(.+)"),
    AskMarriage("^ask\\s+marriage\\s+-u\\s+(.+)\\s+-r\\s+(.+)"),
    RespondMarriage("^respond\\s+(-accept|-reject)\\s+-u\\s+(.+)"),
    StartTrade("^start\\s+trade"),
    TradeSomeone(
            "^trade\\s+-u\\s+(\\S+)" +
                    "\\s+-t\\s+(\\S+)" +
                    "\\s+-i\\s+(\\S+)" +
                    "\\s+-a\\s+(\\d+)" +
                    "\\s+(?:-p\\s+(\\d+)" +
                    "|-ti\\s+(\\S+)\\s+-ta\\s+(\\d+))"
    ),
    TradeList("^trade\\s+list"),
    TradeResponse("^trade\\s+response\\s+(-accept|-reject)\\s+-i\\s+(\\d)"),
    TradeHistory("^trade\\s+history"),
    CookingRefrigerator("^cooking\\s+refrigerator\\s+(pick|put)\\s+(.+)$"),
    CookingShowRecipes("^cooking\\s+show\\s+recipes$"),
    CookingPrepare("^cooking\\s+prepare\\s+(.+)$"),
    Eat("^eat\\s+(.+)$"),
    Build("^build\\s+-a\\s+(.+)\\s+-l\\s+(\\d+),(\\d+)$"),
    BuyAnimal("^buy\\s+animal\\s+-a\\s+(.+)\\s+-n\\s+(.+)$"),
    PetAnimal("^pet\\s+-n\\s+(.+)$"),
    CheatSetFriendshipWithAnimal("^cheat\\s+set\\s+friendship\\s+-n\\s+(.+)\\s+-c\\s+(\\d+)$"),
    AnimalShow("^animals$"),
    ShepherdAnimal("^shepherd\\s+animals\\s+-n\\s+(.+)\\s+-l(\\d+),(\\d+)$"),
    FeedHay("^feed\\s+hay\\s+-n\\s+(.+)$"),
    AnimalProduces("^produces$"),
    CollectProduce("^collect\\s+produce\\s+-n\\s+(.+)$"),
    SellAnimal("^sell\\s+animal\\s+-n\\s+(.+)$"),
    MeetNpc("^meet\\s+NPC\\s+(.+)$"),
    GiftNpc("^gift\\s+NPC\\s+(.+)\\s+-i\\s+(.+)$"),
    FriendshipNpcList("^friendship\\s+NPC\\s+list$"),
    QuestsList("^quests\\s+list$"),
    QuestsFinish("^quests\\s+finish\\s+-i\\s+(\\d+)\\s+-n\\s+(\\d+)$");// something different from doc
    public String command;
    GameMenuRejex(String command) {
        this.command = command;
    }

    public Matcher getMatcher(String line) {
        Matcher matcher = Pattern.compile(command).matcher(line);
        if(matcher.matches())
        {
            return matcher;
        }
        return null;
    }
}
