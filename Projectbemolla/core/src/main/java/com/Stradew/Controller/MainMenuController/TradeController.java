package com.Stradew.Controller.MainMenuController;

import com.Stradew.Main;
import com.Stradew.Model.App;
import com.Stradew.Model.GameAssetsManager;
import com.Stradew.View.MainMenu.GameMenu;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class TradeController {

    private Boolean Buyer = false;
    private TextButton Accept = new TextButton("Accept" , GameAssetsManager.getInstance().getSkin());
    private TextButton Reject = new TextButton("Reject " , GameAssetsManager.getInstance().getSkin());
    private String SenderName;
    private String GiverName;
    private BitmapFont font = new BitmapFont();


    public Boolean getBuyer() {
        return Buyer;
    }

    public TextButton getAccept() {
        return Accept;
    }

    public TextButton getReject() {
        return Reject;
    }

    public String getSenderName() {
        return SenderName;
    }

    public String getGiverName() {
        return GiverName;
    }

    public void setBuyer(Boolean buyer) {
        Buyer = buyer;
    }

    public void setAccept(TextButton accept) {
        Accept = accept;
    }

    public void setReject(TextButton reject) {
        Reject = reject;
    }

    public void setSenderName(String senderName) {
        SenderName = senderName;
    }

    public void setGiverName(String giverName) {
        GiverName = giverName;
    }

    public void FirstTouch(GameMenu menu)
    {
        menu.getTradeTable().add(Accept);
        menu.getTradeTable().add(Reject);
    }


    public void Buy(GameMenu menu)
    {
        Accept.setVisible(true);
        Accept.setVisible(true);
        font.draw(Main.getMain().getBatch(), "You are Buying the Item From" + SenderName , App.ReturnCurrentPlayer().getX() , App.ReturnCurrentPlayer().getY() + 400);

        if(Accept.isChecked())
        {
            App.networkClient.sendMessage("TRADE_RESULT " + "AC" + " " +  SenderName);
            menu.getMainTable().setVisible(true);
            menu.getTradeTable().setVisible(false);
            Accept.setChecked(false);
        }
        if(Reject.isChecked())
        {
            menu.getMainTable().setVisible(true);
            menu.getTradeTable().setVisible(false);
            App.networkClient.sendMessage("TRADE_RESULT " + "RE" + " " + SenderName);
            Reject.setChecked(false);
        }
    }

    public void Sell(GameMenu menu)
    {
        Accept.setVisible(false);
        Reject.setVisible(false);
        font.draw(Main.getMain().getBatch(),"You are Selling the item To " + GiverName ,  App.ReturnCurrentPlayer().getX(), App.ReturnCurrentPlayer().getY() + 400);
    }

    public void Update(GameMenu menu , float v)
    {
        if(Buyer)
        {
            Buy(menu);
        }
        else
        {
            Sell(menu);
        }
    }

}
