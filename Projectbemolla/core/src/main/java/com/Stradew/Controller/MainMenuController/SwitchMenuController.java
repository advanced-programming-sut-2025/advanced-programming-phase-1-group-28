package com.Stradew.Controller.MainMenuController;

import com.Stradew.Controller.MainMenuController.HomeMenucontroller.CraftingController;
import com.Stradew.Controller.MainMenuController.HomeMenucontroller.PokhtOPazController;
import com.Stradew.Controller.MainMenuController.MechanicController.FriendShipController;
import com.Stradew.Controller.MainMenuController.MechanicController.MechanicController;
import com.Stradew.Controller.MainMenuController.MechanicController.NPC_Controller;
import com.Stradew.Controller.MainMenuController.MechanicController.ShoppingController;
import com.Stradew.Main;
import com.Stradew.Model.App;
import com.Stradew.Model.Enums.*;
import com.Stradew.Model.GameAssetsManager;
import com.Stradew.Model.Npc;
import com.Stradew.Model.Tile.Animal;
import com.Stradew.Model.Tools.Pepolee;
import com.Stradew.Server.Lobby;
import com.Stradew.View.MainMenu.GameMenu;
import com.Stradew.View.MainMenu.MechanicGame.AnimalInteractionDialog;
import com.Stradew.View.MainMenu.MechanicGame.FriendshipDialog;
import com.Stradew.View.MainMenu.MechanicGame.HomeMenu.CookingDialog;
import com.Stradew.View.MainMenu.MechanicGame.HomeMenu.CraftingDialog;
import com.Stradew.View.MainMenu.MechanicGame.HomeMenu.PokhtOPaz;
import com.Stradew.View.MainMenu.MechanicGame.NpcDialog;
import com.Stradew.View.MainMenu.NPCVillage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.Stradew.Controller.MainMenuController.HomeMenucontroller.CraftingController;
import com.Stradew.Controller.MainMenuController.HomeMenucontroller.PokhtOPazController;
import com.Stradew.Controller.MainMenuController.MechanicController.FriendShipController;
import com.Stradew.Controller.MainMenuController.MechanicController.MechanicController;
import com.Stradew.Controller.MainMenuController.MechanicController.NPC_Controller;
import com.Stradew.Controller.MainMenuController.MechanicController.ShoppingController;
import com.Stradew.Main;
import com.Stradew.Model.App;
import com.Stradew.Model.Enums.CarpenterShopItems;
import com.Stradew.Model.Enums.MarineRanchItems;
import com.Stradew.Model.Enums.StarDropSaloonItems;
import com.Stradew.Model.Enums.JojaMartItems;
import com.Stradew.Model.GameAssetsManager;
import com.Stradew.Model.Npc;
import com.Stradew.Model.Tile.Animal;
import com.Stradew.Model.Tools.Pepolee;
import com.Stradew.Server.Lobby;
import com.Stradew.View.MainMenu.GameMenu;
import com.Stradew.View.MainMenu.MechanicGame.AnimalInteractionDialog;
import com.Stradew.View.MainMenu.MechanicGame.FriendshipDialog;
import com.Stradew.View.MainMenu.MechanicGame.HomeMenu.CookingDialog;
import com.Stradew.View.MainMenu.MechanicGame.HomeMenu.CraftingDialog;
import com.Stradew.View.MainMenu.MechanicGame.HomeMenu.PokhtOPaz;
import com.Stradew.View.MainMenu.MechanicGame.NpcDialog;
import com.Stradew.View.MainMenu.NPCVillage;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Scaling;


import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import com.Stradew.Model.Enums.PierreStoreItems;

public class SwitchMenuController {
    private final Map<StarDropSaloonItems, TextureRegionDrawable> saloonIconCache = new HashMap<>();
    private final java.util.Map<BlackSmithItems, TextureRegionDrawable> blacksmithIconCache = new java.util.HashMap<>();
    private final java.util.Map<MarineRanchItems, TextureRegionDrawable> ranchIconCache = new java.util.HashMap<>();
    private final java.util.List<MRRow> mrRows = new ArrayList<>();
    private final java.util.Map<CarpenterShopItems, TextureRegionDrawable> carpenterIconCache = new java.util.HashMap<>();
    private final java.util.List<CRow> cRows = new java.util.ArrayList<>();
    private final java.util.Map<FishShopItems, TextureRegionDrawable> fishIconCache = new java.util.HashMap<>();
    private final java.util.List<FRow> fRows = new java.util.ArrayList<>();
    private final java.util.Map<JojaMartItems, TextureRegionDrawable> jojaIconCache = new java.util.HashMap<>();
    private final java.util.List<JRow> jRows = new java.util.ArrayList<>();
    private final java.util.Map<PierreStoreItems, TextureRegionDrawable> pierreIconCache = new java.util.HashMap<>();
    private final java.util.List<PRow> pRows = new java.util.ArrayList<>();
    private static class PRow {
        final PierreStoreItems item;
        final CheckBox pick;
        final TextField qty;
        PRow(PierreStoreItems item, CheckBox pick, TextField qty) {
            this.item = item; this.pick = pick; this.qty = qty;
        }
    }

    private static class JRow {
        final JojaMartItems item;
        final com.badlogic.gdx.scenes.scene2d.ui.CheckBox pick;
        final com.badlogic.gdx.scenes.scene2d.ui.TextField qty;
        JRow(JojaMartItems item, com.badlogic.gdx.scenes.scene2d.ui.CheckBox pick, com.badlogic.gdx.scenes.scene2d.ui.TextField qty) {
            this.item = item; this.pick = pick; this.qty = qty;
        }
    }

    private static class FRow {
        final FishShopItems item;
        final CheckBox pick;
        final TextField qty;
        FRow(FishShopItems item, CheckBox pick, TextField qty) {
            this.item = item; this.pick = pick; this.qty = qty;
        }
    }

    // Simple validators
    private static final TextField.TextFieldFilter DIGITS_ONLY = new TextField.TextFieldFilter.DigitsOnlyFilter();
    private static final TextField.TextFieldFilter COORD_FILTER = (tf, c) -> (c==' ' || c=='-' || Character.isDigit(c));
    public void openPokhMenu(Stage stage) {
        CookingDialog cookingDialog = new CookingDialog(new PokhtOPazController(), GameAssetsManager.getInstance().getSkin());
        cookingDialog.show(stage);
    }
    ShoppingController shoppingController = new ShoppingController();

    private static class CRow {
        final CarpenterShopItems item;
        final CheckBox pick;
        final TextField qtyField;    // used for Wood/Stone
        final TextField coordField;  // used for buildings (x y)
        CRow(CarpenterShopItems item, CheckBox pick, TextField qtyField, TextField coordField) {
            this.item = item; this.pick = pick; this.qtyField = qtyField; this.coordField = coordField;
        }
    }

    public void openPokhMenu(){
        PokhtOPaz pokhtOPaz = new PokhtOPaz(new PokhtOPazController());
        Main.getMain().setScreen(pokhtOPaz);
    }

    public void openNpcVillage(){
        App.ReturnCurrentPlayer().setInNpcVillage(true);
        if (Main.getMain().getBatch().isDrawing()){
            Main.getMain().getBatch().end();
        }
        Main.getMain().setScreen(new NPCVillage(new NPCVillageController()));
    }

    public void openGameMenu(){
        App.ReturnCurrentPlayer().setInNpcVillage(false);
        if (Main.getMain().getBatch().isDrawing()){
            Main.getMain().getBatch().end();
        }
        GameMenu newGameMenu = new GameMenu(new GameMenuController() , new Lobby(null ,null ,null , null));
        App.setCurrentGameMenu(newGameMenu);
        Main.getMain().setScreen(newGameMenu);
    }

    public void openNpcMenu(Npc npc, Stage stage){
        NpcDialog npcDialog = new NpcDialog(npc, new NPC_Controller(), GameAssetsManager.getInstance().getSkin());
        npcDialog.show(stage);
    }

    public void openFriendshipMenu(Pepolee otherPlayer, Stage stage){
        FriendshipDialog friendshipDialog = new FriendshipDialog(otherPlayer, new FriendShipController(), GameAssetsManager.getInstance().getSkin());
        friendshipDialog.show(stage);
    }

    public void openAnimalMenu(Animal animal, Stage stage){
        AnimalInteractionDialog dialog = new AnimalInteractionDialog(animal, new MechanicController(), GameAssetsManager.getInstance().getSkin());
        dialog.show(stage);
    }

    public void openCraftMenu(Stage stage){
        CraftingDialog craftingDialog = new CraftingDialog(new CraftingController(), GameAssetsManager.getInstance().getSkin());
        craftingDialog.show(stage);
    }



        private static class BRow {
            final BlackSmithItems item;
            final CheckBox pick;
            final TextField qty;

            BRow(BlackSmithItems item, CheckBox pick, TextField qty) {
                this.item = item;
                this.pick = pick;
                this.qty = qty;
            }
        }
        private final java.util.List<BRow> bRows = new java.util.ArrayList<>();


    public void openBlacksmith(Stage stage) {
        final Skin skin = GameAssetsManager.getInstance().getSkin();

        // --- console area (graphical System.out) ---
        final StringBuilder consoleBuf = new StringBuilder();
        final Label consoleLabel = new Label("", skin);
        consoleLabel.setWrap(true);
        final ScrollPane consoleScroll = new ScrollPane(consoleLabel, skin);
        consoleScroll.setFadeScrollBars(false);
        consoleScroll.setScrollingDisabled(true, false);
        consoleScroll.setOverscroll(false, false);
        final Runnable scrollToBottom = () -> Gdx.app.postRunnable(() -> consoleScroll.setScrollPercentY(1f));
        final Consumer<String> consoleAppend = (s) -> { consoleBuf.append(s); consoleLabel.setText(consoleBuf.toString()); scrollToBottom.run(); };

        final Dialog dialog = new Dialog("Blacksmith", skin);

        // --- product list (scrollable) ---
        Table list = new Table(skin);
        list.defaults().pad(6).left();

        // Header
        list.add(new Label("Item", skin)).left().padLeft(4);
        list.add().growX();
        list.add(new Label("Qty", skin)).width(110).center();   // wider qty
        list.add(new Label("Pick", skin)).width(70).center();
        list.row();

        bRows.clear();

        // Single selection group
        ButtonGroup<CheckBox> group = new ButtonGroup<>();
        group.setMinCheckCount(0); // set to 1 if one must always be selected
        group.setMaxCheckCount(1);

        for (BlackSmithItems it : BlackSmithItems.values()) {
            Image icon = new Image(getBlacksmithIcon(it));
            icon.setScaling(Scaling.fit);
            list.add(icon).size(48, 48).padRight(8).left();

            Label name = new Label(it.name, skin); // assumes your enum has a display name field `name`
            name.setAlignment(Align.left);
            list.add(name).growX().left();

            TextField qty = new TextField("0", skin);
            qty.setMessageText("0");
            qty.setTextFieldFilter(new TextField.TextFieldFilter.DigitsOnlyFilter());
            list.add(qty).width(110).center();

            CheckBox pick;
            if (skin.has("radio", CheckBox.CheckBoxStyle.class)) {
                pick = new CheckBox("", skin, "radio");
            } else {
                pick = new CheckBox("", skin);
            }
            list.add(pick).width(70).center();
            list.row();

            bRows.add(new BRow(it, pick, qty));
            group.add(pick);
        }

        ScrollPane scroll = new ScrollPane(list, skin);
        scroll.setFadeScrollBars(false);
        scroll.setScrollingDisabled(true, false);
        scroll.setOverscroll(false, false);

        // Layout content
        dialog.getContentTable()
            .add(scroll)
            .width(Math.min(720, Gdx.graphics.getWidth() * 0.9f))
            .height(Math.min(420, Gdx.graphics.getHeight() * 0.7f))
            .pad(8);
        dialog.getContentTable().row();

        dialog.getContentTable()
            .add(new Label("Activity:", skin))
            .left().padTop(6).padBottom(2).padLeft(8).growX();
        dialog.getContentTable().row();

        dialog.getContentTable()
            .add(consoleScroll)
            .width(Math.min(720, Gdx.graphics.getWidth() * 0.9f))
            .height(110)
            .pad(8)
            .growX();
        dialog.getContentTable().row();

        // --- Buttons ---
        // Cancel closes dialog
        dialog.button("Cancel", false);

        // Custom Buy (does NOT close)
        TextButton buyBtn = new TextButton("Buy", skin);
        dialog.getButtonTable().add(buyBtn).pad(6);

        buyBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // single selection
                BRow selected = null;
                for (BRow r : bRows) { if (r.pick.isChecked()) { selected = r; break; } }
                if (selected == null) { consoleAppend.accept("No item selected.\n"); return; }

                int q = parseQty(selected.qty.getText());
                if (q <= 0) { consoleAppend.accept("Please enter a quantity > 0.\n"); return; }

                // Capture System.out while shopping logic runs
                PrintStream oldOut = System.out;
                PrintStream capturing = new PrintStream(new java.io.OutputStream() {
                    @Override public void write(int b) { consoleAppend.accept(String.valueOf((char)b)); }
                }, true);
                System.setOut(capturing);
                try {
                    // IMPORTANT: match what ShoppingController.ApplyBlacksmith expects (usually display name)
                    shoppingController.ApplyBlackSmithPurchase(selected.item.name, q);
                } catch (Throwable t) {
                    consoleAppend.accept("\n[Error] " + t.getMessage() + "\n");
                } finally {
                    System.setOut(oldOut);
                }

                // Optional QoL:
                // selected.qty.setText("0");
                // selected.pick.setChecked(false);
            }
        });

        // ENTER triggers Buy without closing
        dialog.addListener(new InputListener() {
            @Override public boolean keyDown(InputEvent event, int keycode) {
                if (keycode == Input.Keys.ENTER) {
                    buyBtn.setProgrammaticChangeEvents(true);
                    buyBtn.toggle();
                    buyBtn.setProgrammaticChangeEvents(false);
                    buyBtn.fire(new ChangeListener.ChangeEvent());
                    return true;
                }
                return false;
            }
        });

        // ESC => Cancel
        dialog.key(Input.Keys.ESCAPE, false);

        dialog.show(stage);
        dialog.setMovable(true);
        dialog.setResizable(true);
    }

    public void openCarpenterShop(Stage stage) {
        final Skin skin = GameAssetsManager.getInstance().getSkin();

        // --- Activity console (graphical System.out) ---
        final StringBuilder consoleBuf = new StringBuilder();
        final Label consoleLabel = new Label("", skin);
        consoleLabel.setWrap(true);
        final ScrollPane consoleScroll = new ScrollPane(consoleLabel, skin);
        consoleScroll.setFadeScrollBars(false);
        consoleScroll.setScrollingDisabled(true, false);
        consoleScroll.setOverscroll(false, false);
        final Runnable scrollToBottom = () -> com.badlogic.gdx.Gdx.app.postRunnable(() -> consoleScroll.setScrollPercentY(1f));
        final Consumer<String> consoleAppend = s -> { consoleBuf.append(s); consoleLabel.setText(consoleBuf.toString()); scrollToBottom.run(); };

        final Dialog dialog = new Dialog("Carpenter Shop", skin);

        // --- List header ---
        Table list = new Table(skin);
        list.defaults().pad(6).left();
        list.add(new Label("Item", skin)).left().padLeft(4);
        list.add().growX();
        list.add(new Label("Input", skin)).width(180).center();  // Qty for wood/stone OR "x y" for buildings
        list.add(new Label("Pick", skin)).width(70).center();
        list.row();

        cRows.clear();

        // Single-selection
        ButtonGroup<CheckBox> group = new ButtonGroup<>();
        group.setMinCheckCount(0);
        group.setMaxCheckCount(1);

        for (CarpenterShopItems it : CarpenterShopItems.values()) {
            // icon
            Image icon = new Image(getCarpenterIcon(it));
            icon.setScaling(Scaling.fit);
            list.add(icon).size(48, 48).padRight(8).left();

            // display name (assuming your enum exposes a `name` field like other shops)
            Label nameLbl = new Label(it.name, skin);
            nameLbl.setAlignment(Align.left);
            list.add(nameLbl).growX().left();

            // input cell: qty OR coordinates
            TextField qty = new TextField("", skin);
            qty.setMessageText("Qty");
            qty.setTextFieldFilter(DIGITS_ONLY);

            TextField coords = new TextField("", skin);
            coords.setMessageText("x y");
            coords.setTextFieldFilter(COORD_FILTER);

            // show only the relevant field
            boolean resource = isResourceItem(it);
            Actor inputActor = resource ? qty : coords;
            list.add(inputActor).width(resource ? 110 : 180).center();

            // radio-style pick
            CheckBox pick = skin.has("radio", CheckBox.CheckBoxStyle.class)
                ? new CheckBox("", skin, "radio")
                : new CheckBox("", skin);
            list.add(pick).width(70).center();

            list.row();

            cRows.add(new CRow(it, pick, qty, coords));
            group.add(pick);
        }

        ScrollPane scroll = new ScrollPane(list, skin);
        scroll.setFadeScrollBars(false);
        scroll.setScrollingDisabled(true, false);
        scroll.setOverscroll(false, false);

        // Layout content
        dialog.getContentTable()
            .add(scroll)
            .width(Math.min(720, com.badlogic.gdx.Gdx.graphics.getWidth() * 0.9f))
            .height(Math.min(420, com.badlogic.gdx.Gdx.graphics.getHeight() * 0.7f))
            .pad(8);
        dialog.getContentTable().row();

        dialog.getContentTable()
            .add(new Label("Activity:", skin))
            .left().padTop(6).padBottom(2).padLeft(8).growX();
        dialog.getContentTable().row();

        dialog.getContentTable()
            .add(consoleScroll)
            .width(Math.min(720, com.badlogic.gdx.Gdx.graphics.getWidth() * 0.9f))
            .height(110)
            .pad(8)
            .growX();
        dialog.getContentTable().row();

        // Buttons: Cancel closes; Buy is custom (stays open)
        dialog.button("Cancel", false);

        TextButton buyBtn = new TextButton("Buy", skin);
        dialog.getButtonTable().add(buyBtn).pad(6);

        buyBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // find selected
                CRow selected = null;
                for (CRow r : cRows) { if (r.pick.isChecked()) { selected = r; break; } }
                if (selected == null) { consoleAppend.accept("No item selected.\n"); return; }

                boolean isRes = isResourceItem(selected.item);
                String userArg;

                if (isRes) {
                    String txt = selected.qtyField.getText().trim();
                    if (txt.isEmpty()) { consoleAppend.accept("Enter a quantity for " + selected.item.name + ".\n"); return; }
                    try {
                        int q = Integer.parseInt(txt);
                        if (q <= 0) { consoleAppend.accept("Quantity must be > 0.\n"); return; }
                    } catch (NumberFormatException nfe) {
                        consoleAppend.accept("Invalid quantity.\n"); return;
                    }
                    userArg = txt; // pass as plain number string
                } else {
                    String txt = selected.coordField.getText().trim();
                    if (txt.isEmpty()) { consoleAppend.accept("Enter coordinates as: x y\n"); return; }
                    String[] parts = txt.split("\\s+");
                    if (parts.length != 2) { consoleAppend.accept("Coordinates must be two numbers: x y\n"); return; }
                    try {
                        Integer.parseInt(parts[0]);
                        Integer.parseInt(parts[1]);
                    } catch (NumberFormatException nfe) {
                        consoleAppend.accept("Coordinates must be numbers: x y\n"); return;
                    }
                    userArg = txt; // pass as "x y"
                }

                // Capture System.out while ShoppingController runs
                PrintStream oldOut = System.out;
                PrintStream capturing = new PrintStream(new java.io.OutputStream() {
                    @Override public void write(int b) { consoleAppend.accept(String.valueOf((char)b)); }
                }, true);
                System.setOut(capturing);
                try {
                    // IMPORTANT: adjust to your actual controller signature if different.
                    // Here we pass either "qty" (e.g., "25") or "x y" (e.g., "12 7") as a single arg.
                    shoppingController.ApplyCarpenterShop(selected.item.name, userArg);
                } catch (Throwable t) {
                    consoleAppend.accept("\n[Error] " + t.getMessage() + "\n");
                } finally {
                    System.setOut(oldOut);
                }

                // Optional QoL reset:
                // selected.qtyField.setText("");
                // selected.coordField.setText("");
                // selected.pick.setChecked(false);
            }
        });

        // ENTER triggers Buy without closing
        dialog.addListener(new InputListener() {
            @Override public boolean keyDown(InputEvent event, int keycode) {
                if (keycode == Input.Keys.ENTER) {
                    buyBtn.setProgrammaticChangeEvents(true);
                    buyBtn.toggle();
                    buyBtn.setProgrammaticChangeEvents(false);
                    buyBtn.fire(new ChangeListener.ChangeEvent());
                    return true;
                }
                return false;
            }
        });

        // ESC => Cancel
        dialog.key(Input.Keys.ESCAPE, false);

        dialog.show(stage);
        dialog.setMovable(true);
        dialog.setResizable(true);
    }

    public void openFishShop(Stage stage) {
        final Skin skin = GameAssetsManager.getInstance().getSkin();

        // --- Activity console (graphical System.out) ---
        final StringBuilder consoleBuf = new StringBuilder();
        final Label consoleLabel = new Label("", skin);
        consoleLabel.setWrap(true);
        final ScrollPane consoleScroll = new ScrollPane(consoleLabel, skin);
        consoleScroll.setFadeScrollBars(false);
        consoleScroll.setScrollingDisabled(true, false);
        consoleScroll.setOverscroll(false, false);
        final Runnable scrollToBottom = () -> Gdx.app.postRunnable(() -> consoleScroll.setScrollPercentY(1f));
        final Consumer<String> consoleAppend = s -> { consoleBuf.append(s); consoleLabel.setText(consoleBuf.toString()); scrollToBottom.run(); };

        final Dialog dialog = new Dialog("Fish Shop", skin);

        // --- List header ---
        Table list = new Table(skin);
        list.defaults().pad(6).left();
        list.add(new Label("Item", skin)).left().padLeft(4);
        list.add().growX();
        list.add(new Label("Qty", skin)).width(110).center();
        list.add(new Label("Pick", skin)).width(70).center();
        list.row();

        fRows.clear();

        // Single-selection group
        ButtonGroup<CheckBox> group = new ButtonGroup<>();
        group.setMinCheckCount(0);   // set to 1 if you want one always selected
        group.setMaxCheckCount(1);

        for (FishShopItems it : FishShopItems.values()) {
            // icon
            Image icon = new Image(getFishIcon(it));
            icon.setScaling(Scaling.fit);
            list.add(icon).size(48, 48).padRight(8).left();

            // display name (assuming your enum exposes a field called `name` like others)
            Label nameLbl = new Label(it.name, skin);
            nameLbl.setAlignment(Align.left);
            list.add(nameLbl).growX().left();

            // qty input
            TextField qty = new TextField("0", skin);
            qty.setMessageText("0");
            qty.setTextFieldFilter(new TextField.TextFieldFilter.DigitsOnlyFilter());
            list.add(qty).width(110).center();

            // radio-style pick
            CheckBox pick = skin.has("radio", CheckBox.CheckBoxStyle.class)
                ? new CheckBox("", skin, "radio")
                : new CheckBox("", skin);
            list.add(pick).width(70).center();

            list.row();

            fRows.add(new FRow(it, pick, qty));
            group.add(pick);
        }

        ScrollPane scroll = new ScrollPane(list, skin);
        scroll.setFadeScrollBars(false);
        scroll.setScrollingDisabled(true, false);
        scroll.setOverscroll(false, false);

        // Layout content
        dialog.getContentTable()
            .add(scroll)
            .width(Math.min(720, Gdx.graphics.getWidth() * 0.9f))
            .height(Math.min(420, Gdx.graphics.getHeight() * 0.7f))
            .pad(8);
        dialog.getContentTable().row();

        dialog.getContentTable()
            .add(new Label("Activity:", skin))
            .left().padTop(6).padBottom(2).padLeft(8).growX();
        dialog.getContentTable().row();

        dialog.getContentTable()
            .add(consoleScroll)
            .width(Math.min(720, Gdx.graphics.getWidth() * 0.9f))
            .height(110)
            .pad(8)
            .growX();
        dialog.getContentTable().row();

        // Buttons: Cancel closes; Buy is custom (stays open)
        dialog.button("Cancel", false);

        TextButton buyBtn = new TextButton("Buy", skin);
        dialog.getButtonTable().add(buyBtn).pad(6);

        buyBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // find selected
                FRow selected = null;
                for (FRow r : fRows) { if (r.pick.isChecked()) { selected = r; break; } }
                if (selected == null) { consoleAppend.accept("No item selected.\n"); return; }

                int q;
                try {
                    q = Integer.parseInt(selected.qty.getText().trim());
                } catch (NumberFormatException ex) {
                    consoleAppend.accept("Please enter a valid quantity.\n");
                    return;
                }
                if (q <= 0) { consoleAppend.accept("Quantity must be > 0.\n"); return; }

                // Capture System.out while ShoppingController runs (so its prints show in Activity)
                PrintStream oldOut = System.out;
                PrintStream capturing = new PrintStream(new java.io.OutputStream() {
                    @Override public void write(int b) { consoleAppend.accept(String.valueOf((char)b)); }
                }, true);
                System.setOut(capturing);
                try {
                    // IMPORTANT: match your controller signature
                    shoppingController.ApplyFishShop(selected.item.name, q);
                } catch (Throwable t) {
                    consoleAppend.accept("\n[Error] " + t.getMessage() + "\n");
                } finally {
                    System.setOut(oldOut);
                }

                // Optional QoL:
                // selected.qty.setText("0");
                // selected.pick.setChecked(false);
            }
        });

        // ENTER triggers Buy without closing
        dialog.addListener(new InputListener() {
            @Override public boolean keyDown(InputEvent event, int keycode) {
                if (keycode == Input.Keys.ENTER) {
                    buyBtn.setProgrammaticChangeEvents(true);
                    buyBtn.toggle();
                    buyBtn.setProgrammaticChangeEvents(false);
                    buyBtn.fire(new ChangeListener.ChangeEvent());
                    return true;
                }
                return false;
            }
        });

        // ESC => Cancel
        dialog.key(Input.Keys.ESCAPE, false);

        dialog.show(stage);
        dialog.setMovable(true);
        dialog.setResizable(true);
    }

    public void openJojaMart(Stage stage) {
        final Skin skin = GameAssetsManager.getInstance().getSkin();

        // Activity console
        final StringBuilder consoleBuf = new StringBuilder();
        final Label consoleLabel = new Label("", skin);
        consoleLabel.setWrap(true);
        final ScrollPane consoleScroll = new ScrollPane(consoleLabel, skin);
        consoleScroll.setFadeScrollBars(false);
        consoleScroll.setScrollingDisabled(true, false);
        consoleScroll.setOverscroll(false, false);
        final Runnable scrollToBottom = () -> Gdx.app.postRunnable(() -> consoleScroll.setScrollPercentY(1f));
        final Consumer<String> consoleAppend = s -> { consoleBuf.append(s); consoleLabel.setText(consoleBuf.toString()); scrollToBottom.run(); };

        final Dialog dialog = new Dialog("JojaMart", skin);

        // List header
        Table list = new Table(skin);
        list.defaults().pad(6).left();
        list.add(new Label("Item", skin)).left().padLeft(4);
        list.add().growX();
        list.add(new Label("Qty", skin)).width(110).center();
        list.add(new Label("Pick", skin)).width(70).center();
        list.row();

        jRows.clear();

        // Single-select
        ButtonGroup<CheckBox> group = new ButtonGroup<>();
        group.setMinCheckCount(0);
        group.setMaxCheckCount(1);

        for (JojaMartItems it : JojaMartItems.values()) {
            Image icon = new Image(getJojaIcon(it));
            icon.setScaling(Scaling.fit);
            list.add(icon).size(48, 48).padRight(8).left();

            Label nameLbl = new Label(it.name(), skin); // adjust if your enum uses a different display field
            nameLbl.setAlignment(Align.left);
            list.add(nameLbl).growX().left();

            TextField qty = new TextField("0", skin);
            qty.setMessageText("0");
            qty.setTextFieldFilter(new TextField.TextFieldFilter.DigitsOnlyFilter());
            list.add(qty).width(110).center();

            CheckBox pick = skin.has("radio", CheckBox.CheckBoxStyle.class)
                ? new CheckBox("", skin, "radio")
                : new CheckBox("", skin);
            list.add(pick).width(70).center();

            list.row();

            jRows.add(new JRow(it, pick, qty));
            group.add(pick);
        }

        ScrollPane scroll = new ScrollPane(list, skin);
        scroll.setFadeScrollBars(false);
        scroll.setScrollingDisabled(true, false);
        scroll.setOverscroll(false, false);

        // Layout content
        dialog.getContentTable()
            .add(scroll)
            .width(Math.min(720, Gdx.graphics.getWidth() * 0.9f))
            .height(Math.min(420, Gdx.graphics.getHeight() * 0.7f))
            .pad(8);
        dialog.getContentTable().row();

        dialog.getContentTable()
            .add(new Label("Activity:", skin))
            .left().padTop(6).padBottom(2).padLeft(8).growX();
        dialog.getContentTable().row();

        dialog.getContentTable()
            .add(consoleScroll)
            .width(Math.min(720, Gdx.graphics.getWidth() * 0.9f))
            .height(110)
            .pad(8)
            .growX();
        dialog.getContentTable().row();

        // Buttons
        dialog.button("Cancel", false); // closes
        TextButton buyBtn = new TextButton("Buy", skin);
        dialog.getButtonTable().add(buyBtn).pad(6);

        buyBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // selected row
                JRow selected = null;
                for (JRow r : jRows) { if (r.pick.isChecked()) { selected = r; break; } }
                if (selected == null) { consoleAppend.accept("No item selected.\n"); return; }

                int q;
                try { q = Integer.parseInt(selected.qty.getText().trim()); }
                catch (NumberFormatException ex) { consoleAppend.accept("Please enter a valid quantity.\n"); return; }
                if (q <= 0) { consoleAppend.accept("Quantity must be > 0.\n"); return; }

                // Capture System.out while controller runs
                PrintStream oldOut = System.out;
                PrintStream capturing = new PrintStream(new java.io.OutputStream() {
                    @Override public void write(int b) { consoleAppend.accept(String.valueOf((char)b)); }
                }, true);
                System.setOut(capturing);
                try {
                    shoppingController.ApplyJojaMart((selected.item.Name != null) ? selected.item.Name : selected.item.name(), q);



                } catch (Throwable t) {
                    consoleAppend.accept("\n[Error] " + t.getMessage() + "\n");
                } finally {
                    System.setOut(oldOut);
                }

                // Optional reset
                // selected.qty.setText("0");
                // selected.pick.setChecked(false);
            }
        });

        // ENTER triggers Buy without closing
        dialog.addListener(new InputListener() {
            @Override public boolean keyDown(InputEvent event, int keycode) {
                if (keycode == Input.Keys.ENTER) {
                    buyBtn.setProgrammaticChangeEvents(true);
                    buyBtn.toggle();
                    buyBtn.setProgrammaticChangeEvents(false);
                    buyBtn.fire(new ChangeListener.ChangeEvent());
                    return true;
                }
                return false;
            }
        });

        // ESC => Cancel
        dialog.key(Input.Keys.ESCAPE, false);

        dialog.show(stage);
        dialog.setMovable(true);
        dialog.setResizable(true);
    }

    private static class MRRow {
        final MarineRanchItems item;
        final CheckBox pick;
        final TextField nameField;
        MRRow(MarineRanchItems item, CheckBox pick, TextField nameField) {
            this.item = item; this.pick = pick; this.nameField = nameField;
        }
    }

    public void openMarineRanch(Stage stage) {
        final Skin skin = GameAssetsManager.getInstance().getSkin();

        // --- Activity console (graphical System.out) ---
        final StringBuilder consoleBuf = new StringBuilder();
        final Label consoleLabel = new Label("", skin);
        consoleLabel.setWrap(true);
        final ScrollPane consoleScroll = new ScrollPane(consoleLabel, skin);
        consoleScroll.setFadeScrollBars(false);
        consoleScroll.setScrollingDisabled(true, false);
        consoleScroll.setOverscroll(false, false);
        final Runnable scrollToBottom = () -> Gdx.app.postRunnable(() -> consoleScroll.setScrollPercentY(1f));
        final Consumer<String> consoleAppend = s -> { consoleBuf.append(s); consoleLabel.setText(consoleBuf.toString()); scrollToBottom.run(); };

        final Dialog dialog = new Dialog("Marine Ranch", skin);

        // --- Product list (scrollable) ---
        Table list = new Table(skin);
        list.defaults().pad(6).left();

        // Header
        list.add(new Label("Item", skin)).left().padLeft(4);
        list.add().growX();
        list.add(new Label("Name/Count", skin)).width(180).center();
        list.add(new Label("Pick", skin)).width(70).center();
        list.row();

        mrRows.clear();

        // Enforce single selection
        ButtonGroup<CheckBox> group = new ButtonGroup<>();
        group.setMinCheckCount(0); // set to 1 if one must always be selected
        group.setMaxCheckCount(1);

        for (MarineRanchItems it : MarineRanchItems.values()) {
            // icon
            Image icon = new Image(getRanchIcon(it));
            icon.setScaling(Scaling.fit);
            list.add(icon).size(48, 48).padRight(8).left();

            // item display name (assuming your enum exposes a field called `name` as in your other enums)
            Label nameLbl = new Label(it.name, skin);
            nameLbl.setAlignment(Align.left);
            list.add(nameLbl).growX().left();

            // animal name input
            TextField nameField = new TextField("", skin);
            nameField.setMessageText("Name");
            nameField.setTextFieldFilter(NAME_FILTER);
            list.add(nameField).width(180).center();

            // single-select radio (fallback to default if "radio" style missing)
            CheckBox pick = skin.has("radio", CheckBox.CheckBoxStyle.class)
                ? new CheckBox("", skin, "radio")
                : new CheckBox("", skin);
            list.add(pick).width(70).center();

            list.row();

            mrRows.add(new MRRow(it, pick, nameField));
            group.add(pick);
        }

        ScrollPane scroll = new ScrollPane(list, skin);
        scroll.setFadeScrollBars(false);
        scroll.setScrollingDisabled(true, false);
        scroll.setOverscroll(false, false);

        // Layout content
        dialog.getContentTable()
            .add(scroll)
            .width(Math.min(720, Gdx.graphics.getWidth() * 0.9f))
            .height(Math.min(420, Gdx.graphics.getHeight() * 0.7f))
            .pad(8);
        dialog.getContentTable().row();

        dialog.getContentTable()
            .add(new Label("Activity:", skin))
            .left().padTop(6).padBottom(2).padLeft(8).growX();
        dialog.getContentTable().row();

        dialog.getContentTable()
            .add(consoleScroll)
            .width(Math.min(720, Gdx.graphics.getWidth() * 0.9f))
            .height(110)
            .pad(8)
            .growX();
        dialog.getContentTable().row();

        // --- Buttons ---
        // Cancel closes dialog
        dialog.button("Cancel", false);

        // Custom Buy (does NOT close)
        TextButton buyBtn = new TextButton("Buy", skin);
        dialog.getButtonTable().add(buyBtn).pad(6);

        buyBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // single selected row
                MRRow selected = null;
                for (MRRow r : mrRows) { if (r.pick.isChecked()) { selected = r; break; } }
                if (selected == null) { consoleAppend.accept("No item selected.\n"); return; }

                String petName = selected.nameField.getText() == null ? "" : selected.nameField.getText().trim();
                if (petName.isEmpty()) { consoleAppend.accept("Please enter an animal name.\n"); return; }
                if (petName.length() > 24) { consoleAppend.accept("Animal name too long (max 24 chars).\n"); return; }

                // Capture System.out while purchase runs so ShoppingController prints show here
                PrintStream oldOut = System.out;
                PrintStream capturing = new PrintStream(new java.io.OutputStream() {
                    @Override public void write(int b) { consoleAppend.accept(String.valueOf((char)b)); }
                }, true);
                System.setOut(capturing);
                try {
                    // IMPORTANT: match your controller’s method signature
                    // Assuming: ApplyMarineRanchPurchase(String itemDisplayName, String animalName)
                    shoppingController.ApplyMarineRanchPurchase(selected.item.name, petName);
                } catch (Throwable t) {
                    consoleAppend.accept("\n[Error] " + t.getMessage() + "\n");
                } finally {
                    System.setOut(oldOut);
                }

                // Optional QoL: reset the name field / selection for next purchase
                // selected.nameField.setText("");
                // selected.pick.setChecked(false);
            }
        });

        // ENTER triggers Buy without closing
        dialog.addListener(new InputListener() {
            @Override public boolean keyDown(InputEvent event, int keycode) {
                if (keycode == Input.Keys.ENTER) {
                    buyBtn.setProgrammaticChangeEvents(true);
                    buyBtn.toggle();
                    buyBtn.setProgrammaticChangeEvents(false);
                    buyBtn.fire(new ChangeListener.ChangeEvent());
                    return true;
                }
                return false;
            }
        });

        // ESC => Cancel
        dialog.key(Input.Keys.ESCAPE, false);

        dialog.show(stage);
        dialog.setMovable(true);
        dialog.setResizable(true);
    }

    public void openPierreGeneralStore(Stage stage) {
        final Skin skin = GameAssetsManager.getInstance().getSkin();

        // Activity console (shows System.out from controller)
        final StringBuilder consoleBuf = new StringBuilder();
        final Label consoleLabel = new Label("", skin);
        consoleLabel.setWrap(true);
        final ScrollPane consoleScroll = new ScrollPane(consoleLabel, skin);
        consoleScroll.setFadeScrollBars(false);
        consoleScroll.setScrollingDisabled(true, false);
        consoleScroll.setOverscroll(false, false);
        final Runnable scrollToBottom = () -> Gdx.app.postRunnable(() -> consoleScroll.setScrollPercentY(1f));
        final Consumer<String> consoleAppend = s -> { consoleBuf.append(s); consoleLabel.setText(consoleBuf.toString()); scrollToBottom.run(); };

        final Dialog dialog = new Dialog("Pierre's General Store", skin);

        // List header
        Table list = new Table(skin);
        list.defaults().pad(6).left();
        list.add(new Label("Item", skin)).left().padLeft(4);
        list.add().growX();
        list.add(new Label("Qty", skin)).width(110).center();
        list.add(new Label("Pick", skin)).width(70).center();
        list.row();

        pRows.clear();

        // single-select
        ButtonGroup<CheckBox> group = new ButtonGroup<>();
        group.setMinCheckCount(0);
        group.setMaxCheckCount(1);

        for (PierreStoreItems it : PierreStoreItems.values()) {
            Image icon = new Image(getPierreIcon(it));
            icon.setScaling(Scaling.fit);
            list.add(icon).size(48, 48).padRight(8).left();

            // assumes your enum has a display field `name` like others
            Label nameLbl = new Label(it.name(), skin);
            nameLbl.setAlignment(Align.left);
            list.add(nameLbl).growX().left();

            TextField qty = new TextField("0", skin);
            qty.setMessageText("0");
            qty.setTextFieldFilter(new TextField.TextFieldFilter.DigitsOnlyFilter());
            list.add(qty).width(110).center();

            CheckBox pick = skin.has("radio", CheckBox.CheckBoxStyle.class)
                ? new CheckBox("", skin, "radio")
                : new CheckBox("", skin);
            list.add(pick).width(70).center();

            list.row();

            pRows.add(new PRow(it, pick, qty));
            group.add(pick);
        }

        ScrollPane scroll = new ScrollPane(list, skin);
        scroll.setFadeScrollBars(false);
        scroll.setScrollingDisabled(true, false);
        scroll.setOverscroll(false, false);

        // Layout
        dialog.getContentTable()
            .add(scroll)
            .width(Math.min(720, Gdx.graphics.getWidth() * 0.9f))
            .height(Math.min(420, Gdx.graphics.getHeight() * 0.7f))
            .pad(8);
        dialog.getContentTable().row();

        dialog.getContentTable().add(new Label("Activity:", skin))
            .left().padTop(6).padBottom(2).padLeft(8).growX();
        dialog.getContentTable().row();

        dialog.getContentTable()
            .add(consoleScroll)
            .width(Math.min(720, Gdx.graphics.getWidth() * 0.9f))
            .height(110)
            .pad(8)
            .growX();
        dialog.getContentTable().row();

        // Buttons
        dialog.button("Cancel", false); // closes

        TextButton buyBtn = new TextButton("Buy", skin); // stays open
        dialog.getButtonTable().add(buyBtn).pad(6);

        buyBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                PRow selected = null;
                for (PRow r : pRows) { if (r.pick.isChecked()) { selected = r; break; } }
                if (selected == null) { consoleAppend.accept("No item selected.\n"); return; }

                int q;
                try { q = Integer.parseInt(selected.qty.getText().trim()); }
                catch (NumberFormatException ex) { consoleAppend.accept("Please enter a valid quantity.\n"); return; }
                if (q <= 0) { consoleAppend.accept("Quantity must be > 0.\n"); return; }

                // capture System.out while applying purchase
                PrintStream oldOut = System.out;
                PrintStream capturing = new PrintStream(new java.io.OutputStream() {
                    @Override public void write(int b) { consoleAppend.accept(String.valueOf((char)b)); }
                }, true);
                System.setOut(capturing);
                try {
                    shoppingController.ApplyPierreStore(selected.item.name(), q);
                } catch (Throwable t) {
                    consoleAppend.accept("\n[Error] " + t.getMessage() + "\n");
                } finally {
                    System.setOut(oldOut);
                }

                // Optional QoL:
                // selected.qty.setText("0");
                // selected.pick.setChecked(false);
            }
        });

        // ENTER triggers Buy
        dialog.addListener(new InputListener() {
            @Override public boolean keyDown(InputEvent event, int keycode) {
                if (keycode == Input.Keys.ENTER) {
                    buyBtn.setProgrammaticChangeEvents(true);
                    buyBtn.toggle();
                    buyBtn.setProgrammaticChangeEvents(false);
                    buyBtn.fire(new ChangeListener.ChangeEvent());
                    return true;
                }
                return false;
            }
        });

        // ESC => Cancel
        dialog.key(Input.Keys.ESCAPE, false);

        dialog.show(stage);
        dialog.setMovable(true);
        dialog.setResizable(true);
    }

    private static class Row {
        final StarDropSaloonItems item;
        final CheckBox pick;
        final TextField qty;
        Row(StarDropSaloonItems item, CheckBox pick, TextField qty) {
            this.item = item; this.pick = pick; this.qty = qty;
        }
    }

    public void openStarDropSaloon(Stage stage) {
        final Skin skin = GameAssetsManager.getInstance().getSkin();

        // --- console area (graphical System.out) ---
        final StringBuilder consoleBuf = new StringBuilder();
        final Label consoleLabel = new Label("", skin);
        consoleLabel.setWrap(true);
        final ScrollPane consoleScroll = new ScrollPane(consoleLabel, skin);
        consoleScroll.setFadeScrollBars(false);
        consoleScroll.setScrollingDisabled(true, false);
        consoleScroll.setOverscroll(false, false);
        final Runnable scrollToBottom = () -> Gdx.app.postRunnable(() -> consoleScroll.setScrollPercentY(1f));
        final Consumer<String> consoleAppend = (s) -> { consoleBuf.append(s); consoleLabel.setText(consoleBuf.toString()); scrollToBottom.run(); };

        final Dialog dialog = new Dialog("StarDrop Saloon", skin);

        // --- product list (scrollable) ---
        Table list = new Table(skin);
        list.defaults().pad(6).left();

        // Header
        list.add(new Label("Item", skin)).left().padLeft(4);
        list.add().growX();
        list.add(new Label("Qty", skin)).width(110).center();   // wider qty
        list.add(new Label("Pick", skin)).width(70).center();
        list.row();

        rows.clear();

        // Single selection (radio-style)
        ButtonGroup<CheckBox> group = new ButtonGroup<>();
        group.setMinCheckCount(0); // set to 1 if one must always be selected
        group.setMaxCheckCount(1);

        for (StarDropSaloonItems it : StarDropSaloonItems.values()) {
            Image icon = new Image(getIcon(it));
            icon.setScaling(Scaling.fit);
            list.add(icon).size(48, 48).padRight(8).left();

            Label name = new Label(it.name, skin);
            name.setAlignment(Align.left);
            list.add(name).growX().left();

            TextField qty = new TextField("0", skin);
            qty.setMessageText("0");
            qty.setTextFieldFilter(new TextField.TextFieldFilter.DigitsOnlyFilter());
            list.add(qty).width(110).center();                   // wider qty

            // radio style if available; fallback to default if your skin lacks "radio"
            CheckBox pick;
            if (skin.has("radio", CheckBox.CheckBoxStyle.class)) {
                pick = new CheckBox("", skin);
            } else {
                pick = new CheckBox("", skin);
            }
            list.add(pick).width(70).center();
            list.row();

            rows.add(new Row(it, pick, qty));
            group.add(pick);
        }

        ScrollPane scroll = new ScrollPane(list, skin);
        scroll.setFadeScrollBars(false);
        scroll.setScrollingDisabled(true, false);
        scroll.setOverscroll(false, false);

        // Layout content
        dialog.getContentTable()
            .add(scroll)
            .width(Math.min(720, Gdx.graphics.getWidth() * 0.9f))
            .height(Math.min(420, Gdx.graphics.getHeight() * 0.7f))
            .pad(8);
        dialog.getContentTable().row();

        dialog.getContentTable()
            .add(new Label("Activity:", skin))
            .left().padTop(6).padBottom(2).padLeft(8).growX();
        dialog.getContentTable().row();

        dialog.getContentTable()
            .add(consoleScroll)
            .width(Math.min(720, Gdx.graphics.getWidth() * 0.9f))
            .height(110)
            .pad(8)
            .growX();
        dialog.getContentTable().row();

        // --- Buttons ---
        // 1) Cancel: standard result button -> closes dialog
        dialog.button("Cancel", false);

        // 2) Buy: custom button -> DOES NOT close dialog
        TextButton buyBtn = new TextButton("Buy", skin);
        dialog.getButtonTable().add(buyBtn).pad(6);

        buyBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // find single selected row
                Row selected = null;
                for (Row r : rows) { if (r.pick.isChecked()) { selected = r; break; } }
                if (selected == null) { consoleAppend.accept("No item selected.\n"); return; }

                int q = parseQty(selected.qty.getText());
                if (q <= 0) { consoleAppend.accept("Please enter a quantity > 0.\n"); return; }

                // Capture System.out while shopping logic runs
                PrintStream oldOut = System.out;
                PrintStream capturing = new PrintStream(new java.io.OutputStream() {
                    @Override public void write(int b) { consoleAppend.accept(String.valueOf((char)b)); }
                }, true);
                System.setOut(capturing);
                try {
                    shoppingController.ApplyStarDropSaloon(selected.item.name, q);
                } catch (Throwable t) {
                    consoleAppend.accept("\n[Error] " + t.getMessage() + "\n");
                } finally {
                    System.setOut(oldOut);
                }

                // Optional: clear for next purchase
                // selected.qty.setText("0");
                // selected.pick.setChecked(false);
            }
        });

        // ENTER triggers Buy (without closing)
        dialog.addListener(new InputListener() {
            @Override public boolean keyDown(InputEvent event, int keycode) {
                if (keycode == Input.Keys.ENTER) {
                    buyBtn.setProgrammaticChangeEvents(true);
                    buyBtn.toggle(); // quick visual feedback
                    buyBtn.setProgrammaticChangeEvents(false);
                    buyBtn.fire(new ChangeListener.ChangeEvent());
                    return true;
                }
                return false;
            }
        });

        // Cancel on ESC
        dialog.key(Input.Keys.ESCAPE, false);

        dialog.show(stage);
        dialog.setMovable(true);
        dialog.setResizable(true);
    }

    // --- helpers ---

    private final ArrayList<Row> rows = new ArrayList<>();

    private int parseQty(String txt) {
        try {
            int v = Integer.parseInt(txt.trim());
            return Math.max(0, v);
        } catch (Exception e) {
            return 0;
        }
    }

    private TextureRegionDrawable getIcon(StarDropSaloonItems item) {
        TextureRegionDrawable dr = saloonIconCache.get(item);
        if (dr != null) return dr;

        String path = resolveIconPath(item);
        Texture tex;
        try {
            tex = new Texture(Gdx.files.internal(path));
        } catch (Exception e) {
            // fallback tiny placeholder if missing
            tex = new Texture(Gdx.files.internal("Artisan_good/Beer.png"));
        }
        dr = new TextureRegionDrawable(new TextureRegion(tex));
        saloonIconCache.put(item, dr);
        return dr;
    }
    private String resolveIconPath(StarDropSaloonItems item) {
        switch (item) {
            case Beer: return "Artisan_good/Beer.png";
            case Salad: return "Recipe/Salad.png";
            case Bread: return "Recipe/Bread.png";
            case Spaghetti: return "Recipe/Spaghetti.png";
            case Pizza: return "Recipe/Pizza.png";
            case Coffee: return "Artisan_good/Coffee.png";
            case Hashbrowns_Recipe: return "Recipe/Hashbrowns.png";
            case Omlete_Recipe: return "Recipe/Omelet.png";
            case Pancake_Recipe: return "items/recipes/pancakes_48.png";
            case Bread_Recipe: return "Recipe/Pancakes.png";
            case Tortilla_Recipe: return "Recipe/Tortilla.png";
            case Pizza_Recipe: return "Recipe/Pizza.png";
            case Maki_Roll_Recipe: return "Recipe/Maki_Roll.png";
            case Triple_Shot_Espresso_Recipe: return "Recipe/Triple_Shot_Espresso.png";
            case Cookie_Recipe: return "items/recipes/cookie_48.png";
            default: return "Recipe/Cookie.png";
        }
    }

    private TextureRegionDrawable getBlacksmithIcon(BlackSmithItems item) {
        TextureRegionDrawable dr = blacksmithIconCache.get(item);
        if (dr != null) return dr;

        String path = resolveBlacksmithIconPath(item);
        Texture tex;
        try {
            tex = new Texture(Gdx.files.internal(path));
        } catch (Exception e) {
            tex = new Texture(Gdx.files.internal("ui/placeholder_32.png")); // make sure this exists
        }
        dr = new TextureRegionDrawable(new TextureRegion(tex));
        blacksmithIconCache.put(item, dr);
        return dr;
    }

    // TODO: adjust these paths to your actual asset tree
    private String resolveBlacksmithIconPath(BlackSmithItems item) {
        switch (item) {
            case Copper_Ore:            return "Resource/Copper_Ore.png";
            case Iron_Ore:              return "Resource/Iron_Ore.png";
            case Gold_Ore:              return "Resource/Gold_Ore.png";
            case Coal:                  return "Resource/Coal.png";

            case Copper_Axe:            return "Tools/Axe/Copper_Axe.png";
            case Steel_Axe:             return "Tools/Axe/Steel_Axe.png";
            case Gold_Axe:              return "Tools/Axe/Gold_Axe.png";

            case Copper_Hoe:            return "Hoe/Copper_Hoe.png";
            case Steel_Hoe:             return "Hoe/Steel_Hoe.png";
            case Gold_Hoe:              return "Hoe/Gold_Hoe.png";

            case Copper_MilkPail:       return "Tools/Milk_Pail.png";
            case Steel_MilkPail:        return "Tools/Milk_Pail.png";
            case Gold_MilkPail:         return "Tools/Milk_Pail.png";

            case Copper_WaterCan:       return "Watering_Can/Copper_Watering_Can.png";
            case Steel_WaterCan:        return "Watering_Can/Steel_Watering_Can.png";
            case Gold_WaterCan:         return "Watering_Can/Gold_Watering_Can.png";

            case Copper_Shear:          return "Tools/Shears.png";
            case Steel_Shear:           return "Tools/Shears.png";
            case Gold_Shear:            return "Tools/Shears.png";

            case Copper_Pickaxe:        return "Tools/Pickaxe/Copper_Pickaxe.png";
            case Steel_Pickaxe:         return "Tools/Pickaxe/Steel_Pickaxe.png";
            case Gold_Pickaxe:          return "Tools/Pickaxe/Gold_Pickaxe.png";

            case Copper_Seythe:         return "Tools/Scythe.png";  // matches your enum spelling
            case Steel_Seythe:          return "Weapon/Iridium_Scythe.png";
            case Gold_Seythe:           return "Weapon/Golden_Scythe.png";

            case Copper_Trash_Can:      return "Tools/Trash_Can_Copper.png";
            case Steel_Trash_Can:       return "Tools/Trash_Can_Steel.png";
            case Gold_Trash_Can:        return "Tools/Trash_Can_Gold.png";

            default:                    return "ui/placeholder_32.png";
        }
    }

    private TextureRegionDrawable getRanchIcon(MarineRanchItems item) {
        TextureRegionDrawable dr = ranchIconCache.get(item);
        if (dr != null) return dr;

        String path = resolveMarineRanchIconPath(item);
        Texture tex;
        try {
            tex = new Texture(Gdx.files.internal(path));
        } catch (Exception e) {
            tex = new Texture(Gdx.files.internal("ui/placeholder_32.png")); // ensure this exists
        }
        dr = new TextureRegionDrawable(new TextureRegion(tex));
        ranchIconCache.put(item, dr);
        return dr;
    }

    private String resolveMarineRanchIconPath(MarineRanchItems item) {
        switch (item){
            case Hay: return "Tools/Hay_Hopper.png";
            case Milk_Pail: return "Tools/Milk_Pail.png";
            case Shears: return "Tools/Shears.png";
            case Chicken: return "Animals/White_Chicken.png";
            case Duck: return "Animals/Duck.png";
            case Cow: return "Animals/White_Cow.png";
            case Rabbit: return "Animals/Rabbit.png";
            case Dinosaur: return  "Animals/Dinosaur.png";
            case Pig: return "Animals/Pig.png";
            case Sheep: return "Animals/Sheep.png";
            case Goat: return "Animals/Goat.png";
            default: return "";
        }
    }

    private static final TextField.TextFieldFilter NAME_FILTER = (textField, c) -> {
        return Character.isLetterOrDigit(c) || c==' ' || c=='-' || c=='\'';
    };

    private TextureRegionDrawable getCarpenterIcon(CarpenterShopItems item) {
        TextureRegionDrawable dr = carpenterIconCache.get(item);
        if (dr != null) return dr;
        String path = resolveCarpenterIconPath(item);
        Texture tex;
        try { tex = new Texture(Gdx.files.internal(path)); }
        catch (Exception e) { tex = new Texture(Gdx.files.internal("ui/placeholder_32.png")); }
        dr = new TextureRegionDrawable(new TextureRegion(tex));
        carpenterIconCache.put(item, dr);
        return dr;
    }

    // If your files follow the pattern, this keeps things simple.
// Example: COOP -> items/carpenter/coop_48.png
    private String resolveCarpenterIconPath(CarpenterShopItems item) {
        switch (item)
        {
            case Wood: return "Trees/Wood.png";
            case Stone: return "Crafting/Stone.png";
            case Shipping_Bin: return "Crafting/Worm_Bin.png";
            default: return "sprites/Coop.png";
        }
    }

    // Identify “resource” items that take a single quantity input.
// Update this list to exactly match your enum names for wood & stone.
    private boolean isResourceItem(CarpenterShopItems item) {
        switch (item) {
            case Wood:
            case Stone:
                return true;
            default:
                return false;
        }
    }

    private TextureRegionDrawable getFishIcon(FishShopItems item) {
        TextureRegionDrawable dr = fishIconCache.get(item);
        if (dr != null) return dr;

        String path = resolveFishIconPath(item);
        Texture tex;
        try {
            tex = new Texture(Gdx.files.internal(path));
        } catch (Exception e) {
            tex = new Texture(Gdx.files.internal("Fishing_Pole/Iridium_Rod.png")); // ensure exists
        }
        dr = new TextureRegionDrawable(new TextureRegion(tex));
        fishIconCache.put(item, dr);
        return dr;
    }

    // If your files follow a pattern like "items/fishshop/<enum>_48.png"
    private String resolveFishIconPath(FishShopItems item) {
        switch (item)
        {
            case FISH_SMOKER_RECIPE : return "Crafting/Fish_Smoker.png";
            case TROUT_SOUP : return "Recipe/Trout_Soup.png";
            case TRAINING_ROD: return "Fishing_Pole/Training_Rod.png";
            case BAMBOO_POLE: return "Fishing_Pole/Bamboo_Pole.png";
            case FIBERGLASS_ROD: return "Fishing_Pole/Fiberglass_Rod.png";
            default: return "Fishing_Pole/Iridium_Rod.png";
        }
    }
    private TextureRegionDrawable getJojaIcon(JojaMartItems item) {
        TextureRegionDrawable dr = jojaIconCache.get(item);
        if (dr != null) return dr;
        String path = resolveJojaIconPath(item);
        Texture tex;
        try { tex = new Texture(Gdx.files.internal(path)); }
        catch (Exception e) { tex = new Texture(Gdx.files.internal("Crops/Wheat_Seeds.png")); }
        dr = new TextureRegionDrawable(new TextureRegion(tex));
        jojaIconCache.put(item, dr);
        return dr;
    }

    // If your filenames follow a pattern like items/jojmart/<enum>_48.png:
    private String resolveJojaIconPath(JojaMartItems item) {
        switch (item)
        {
            case JojaCola: return "Concessions/Joja_Cola_%28large%29.png";
            case Sugar: return "Ingredient/Sugar.png";
            case WheatFlour: return "Ingredient/Wheat_Flour.png";
            case Rice: return "Ingredient/Rice.png";
            case GrassStarter: return "Crafting/Grass_Starter.png";
            case JazzSeeds:            return "Crops/Jazz_Seeds.png";
            case CarrotSeeds:          return "Crops/Carrot_Seeds.png";
            case CauliflowerSeeds:     return "Crops/Cauliflower_Seeds.png";
            case CoffeeBean:           return "Crops/Coffee_Bean.png";
            case GarlicSeeds:          return "Crops/Garlic_Seeds.png";
            case BeanStarter:          return "Crops/Bean_Starter.png";
            case KaleSeeds:            return "Crops/Kale_Seeds.png";
            case ParsnipSeeds:         return "Crops/Parsnip_Seeds.png";
            case PotatoSeeds:          return "Crops/Potato_Seeds.png";
            case RhubarbSeeds:         return "Crops/Rhubarb_Seeds.png";
            case StrawberrySeeds:      return "Crops/Strawberry_Seeds.png";
            case TulipBulb:            return "Crops/Tulip_Bulb.png";
            case RiceShoot:            return "Crops/Rice_Shoot.png";
            case BlueberrySeeds:       return "Crops/Blueberry_Seeds.png";
            case CornSeeds:            return "Crops/Corn_Seeds.png";
            case HopsStarter:          return "Crops/Hops_Starter.png";
            case PepperSeeds:          return "Crops/Pepper_Seeds.png";
            case MelonSeeds:           return "Crops/Melon_Seeds.png";
            case PoppySeeds:           return "Crops/Poppy_Seeds.png";
            case RadishSeeds:          return "Crops/Radish_Seeds.png";
            case RedCabbageSeeds:      return "Crops/Red_Cabbage_Seeds.png";
            case StarfruitSeeds:       return "Crops/Starfruit_Seeds.png";
            case SpangleSeeds:         return "Crops/Spangle_Seeds.png";
            case SummerSquashSeeds:    return "Crops/Summer_Squash_Seeds.png";
            case SunflowerSeeds:       return "Crops/Sunflower_Seeds.png";
            case TomatoSeeds:          return "Crops/Tomato_Seeds.png";
            case WheatSeeds:           return "Crops/Wheat_Seeds.png";
            case AmaranthSeeds:        return "Crops/Amaranth_Seeds.png";
            case ArtichokeSeeds:       return "Crops/Artichoke_Seeds.png";
            case BeetSeeds:            return "Crops/Beet_Seeds.png";
            case BokChoySeeds:         return "Crops/Bok_Choy_Seeds.png";
            case BroccoliSeeds:        return "Crops/Broccoli_Seeds.png";
            case CranberrySeeds:       return "Crops/Cranberry_Seeds.png";
            case EggplantSeeds:        return "Crops/Eggplant_Seeds.png";
            case FairySeeds:           return "Crops/Fairy_Seeds.png";
            case GrapeStarter:         return "Crops/Grape_Starter.png";
            case PumpkinSeeds:         return "Crops/Pumpkin_Seeds.png";
            case YamSeeds:             return "Crops/Yam_Seeds.png";
            case RareSeed:             return "Crops/Rare_Seed.png";
            case PowdermelonSeeds:     return "Crops/Powdermelon_Seeds.png";
            case AncientSeeds:         return "Crops/Ancient_Seeds.png";
            default: return "Crops/Wheat_Seeds.png";
        }
    }

    private TextureRegionDrawable getPierreIcon(PierreStoreItems item) {
        TextureRegionDrawable dr = pierreIconCache.get(item);
        if (dr != null) return dr;
        String path = resolvePierreIconPath(item);
        Texture tex;
        try { tex = new Texture(Gdx.files.internal(path)); }
        catch (Exception e) { tex = new Texture(Gdx.files.internal("ui/placeholder_32.png")); }
        dr = new TextureRegionDrawable(new TextureRegion(tex));
        pierreIconCache.put(item, dr);
        return dr;
    }

    // If your files follow a pattern like "items/pierre/<enum>_48.png":
    private String resolvePierreIconPath(PierreStoreItems item) {
        switch (item) {
            // مواد اولیه و اینگریدینت‌ها
            case RICE:                    return "Ingredient/Rice.png";
            case WHEAT_FLOUR:            return "Ingredient/Wheat_Flour.png";
            case SUGAR:                  return "Ingredient/Sugar.png";
            case OIL:                    return "Ingredient/Oil.png";
            case VINEGAR:                return "Ingredient/Vinegar.png";

            // Retaining soil ها (اصلاح‌شده: پوشه‌ی Fertilizer)
            case BASIC_RETAINING_SOIL:   return "Fertilizer/Basic_Retaining_Soil.png";
            case QUALITY_RETAINING_SOIL: return "Fertilizer/Quality_Retaining_Soil.png";
            case DELUXE_RETAINING_SOIL:  return "Fertilizer/Deluxe_Retaining_Soil.png";

            // سایر آیتم‌های فروشگاهی
            case GRASS_STARTER:          return "Crafting/Grass_Starter.png";
            case SPEED_GRO:              return "Fertilizer/Speed-Gro.png";

            // نهال‌ها (saplings)
            case APPLE_SAPLING:          return "Trees/Apple_Sapling.png";
            case APRICOT_SAPLING:        return "Trees/Apricot_Sapling.png";
            case CHERRY_SAPLING:         return "Trees/Cherry_Sapling.png";
            case ORANGE_SAPLING:         return "Trees/Orange_Sapling.png";
            case PEACH_SAPLING:          return "Trees/Peach_Sapling.png";
            case POMEGRANATE_SAPLING:    return "Trees/Pomegranate_Sapling.png";

            // آیتم‌های خاص/آیتم‌های متفرقه
            case BOUQUET:                return "Special_item/Bouquet.png";
            case WEDDING_RING:           return "Crafting/Wedding_Ring.png";
            case DEHYDRATOR_RECIPE:      return "Crafting/Dehydrator.png";        // نزدیک‌ترین آیکن موجود
            case GRASS_STARTER_RECIPE:   return "Crafting/Grass_Starter.png";     // نزدیک‌ترین آیکن موجود
            case LARGE_PACK:             return "Tools/Backpack.png";
            case DELUXE_PACK:            return "Tools/36_Backpack.png";

            // بذرها (seeds)
            case PARSNIP_SEEDS:          return "Crops/Parsnip_Seeds.png";
            case BEAN_STARTER:           return "Crops/Bean_Starter.png";
            case CAULIFLOWER_SEEDS:      return "Crops/Cauliflower_Seeds.png";
            case POTATO_SEEDS:           return "Crops/Potato_Seeds.png";
            case TULIP_BULB:             return "Crops/Tulip_Bulb.png";
            case KALE_SEEDS:             return "Crops/Kale_Seeds.png";
            case JAZZ_SEEDS:             return "Crops/Jazz_Seeds.png";
            case GARLIC_SEEDS:           return "Crops/Garlic_Seeds.png";
            case RICE_SHOOT:             return "Crops/Rice_Shoot.png";

            case MELON_SEEDS:            return "Crops/Melon_Seeds.png";
            case TOMATO_SEEDS:           return "Crops/Tomato_Seeds.png";
            case BLUEBERRY_SEEDS:        return "Crops/Blueberry_Seeds.png";
            case PEPPER_SEEDS:           return "Crops/Pepper_Seeds.png";
            case WHEAT_SEEDS_SUMMER:     return "Crops/Wheat_Seeds.png";
            case RADISH_SEEDS:           return "Crops/Radish_Seeds.png";
            case POPPY_SEEDS:            return "Crops/Poppy_Seeds.png";
            case SPANGLE_SEEDS:          return "Crops/Spangle_Seeds.png";
            case HOPS_STARTER:           return "Crops/Hops_Starter.png";
            case CORN_SEEDS_SUMMER:      return "Crops/Corn_Seeds.png";
            case SUNFLOWER_SEEDS_SUMMER: return "Crops/Sunflower_Seeds.png";
            case RED_CABBAGE_SEEDS:      return "Crops/Red_Cabbage_Seeds.png";

            case EGGPLANT_SEEDS:         return "Crops/Eggplant_Seeds.png";
            case CORN_SEEDS_FALL:        return "Crops/Corn_Seeds.png";
            case PUMPKIN_SEEDS:          return "Crops/Pumpkin_Seeds.png";
            case BOK_CHOY_SEEDS:         return "Crops/Bok_Choy_Seeds.png";
            case YAM_SEEDS:              return "Crops/Yam_Seeds.png";
            case CRANBERRY_SEEDS:        return "Crops/Cranberry_Seeds.png";
            case SUNFLOWER_SEEDS_FALL:   return "Crops/Sunflower_Seeds.png";
            case FAIRY_SEEDS:            return "Crops/Fairy_Seeds.png";
            case AMARANTH_SEEDS:         return "Crops/Amaranth_Seeds.png";
            case GRAPE_STARTER:          return "Crops/Grape_Starter.png";
            case WHEAT_SEEDS_FALL:       return "Crops/Wheat_Seeds.png";
            case ARTICHOKE_SEEDS:        return "Crops/Artichoke_Seeds.png";

            default: return "Crops/Eggplant_Seeds.png";
        }
    }
}
