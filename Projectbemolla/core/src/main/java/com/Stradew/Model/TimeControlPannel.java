package com.Stradew.Model;

public class TimeControlPannel {
    private float CheatCodeUse = 0;
    private float TimeWalkForENetgy = 0;
    private float UsingTool = 0;
    private float AnimationPlayer = 0;
    private float ReactionTime = 1000;
    private float RankingTime = 0;

    public float getRankingTime() {
        return RankingTime;
    }

    public void setRankingTime(float rankingTime) {
        RankingTime = rankingTime;
    }

    public float getReactionTime() {
        return ReactionTime;
    }

    public void setReactionTime(float reactionTime) {
        ReactionTime = reactionTime;
    }

    public float getAnimationPlayer() {
        return AnimationPlayer;
    }

    public void setAnimationPlayer(float animationPlayer) {
        AnimationPlayer = animationPlayer;
    }

    public float getUsingTool() {
        return UsingTool;
    }

    public void setUsingTool(float usingTool) {
        UsingTool = usingTool;
    }

    public float getTimeWalkForENetgy() {
        return TimeWalkForENetgy;
    }

    public void setTimeWalkForENetgy(float timeWalkForENetgy) {
        TimeWalkForENetgy = timeWalkForENetgy;
    }

    public void UpdateTimes(float Delta)
    {
        CheatCodeUse = CheatCodeUse + Delta;
        UsingTool = UsingTool + Delta;
        ReactionTime = ReactionTime + Delta;
    }

    public void setCheatCodeUse(float cheatCodeUse) {
        CheatCodeUse = cheatCodeUse;
    }

    public float getCheatCodeUse() {
        return CheatCodeUse;
    }
}
