package com.Stradew.Controller.MainMenuController;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class TradeController {

    private Boolean Buyer = false;
    private TextButton Accept;
    private TextButton Reject;
    private String SenderName;
    private String GiverName;

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

    public void FirstTouch()
    {

    }


    public void Buy()
    {

    }

    public void Sell()
    {

    }

    public void Update()
    {}

}
