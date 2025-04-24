package com.example.Model.Tile;

import com.example.Model.Enums.Tree;

public class Trees extends Tile {
    private Tree tree;
    private int stage;
    private int HowOldAreYou;
    private boolean IsAttackingWithCrow = false;

    public Trees(String name, Tree tree, int stage, int howOldAreYou) {
        super(name);
        this.tree = tree;
        this.stage = stage;
        HowOldAreYou = howOldAreYou;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getHowOldAreYou() {
        return HowOldAreYou;
    }

    public void setHowOldAreYou(int howOldAreYou) {
        HowOldAreYou = howOldAreYou;
    }

    public boolean isAttackingWithCrow() {
        return IsAttackingWithCrow;
    }

    public void setAttackingWithCrow(boolean attackingWithCrow) {
        IsAttackingWithCrow = attackingWithCrow;
    }
}
