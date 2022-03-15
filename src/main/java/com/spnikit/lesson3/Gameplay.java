package com.spnikit.lesson3;

import java.util.ArrayList;
import java.util.List;

class Gameplay {
    private Player player1;
    private Player player2;
    private String gameResult;

    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }

    private ArrayList<Step> steps = new ArrayList<>();


    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer(Player player){
        if(player.getToken() == Token.X){
            setPlayer1(player);
        }else {
            setPlayer2(player);
        }
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public String getGameResult() {
        return gameResult;
    }

    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }

    public List<Step> getSteps(){
        return List.copyOf(steps);
    }

    public boolean addStep(Step step) {
        return steps.add(step);
    }


    @Override
    public String toString() {
        return "Gameplay{" +
                "player1=" + player1 +
                ", player2=" + player2 +
                ", winner=" + gameResult +
                ", steps=" + steps +
                '}';
    }
}
