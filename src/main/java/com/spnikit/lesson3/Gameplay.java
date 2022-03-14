package com.spnikit.lesson3;

import java.util.ArrayList;
import java.util.List;

class Gameplay {
    private Player player1;
    private Player player2;
    private Player winner;

    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }

    private ArrayList<Step> steps = new ArrayList<>();


    public Player getPlayer1() {
        return player1;
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

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
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
                ", winner=" + winner +
                ", steps=" + steps +
                '}';
    }
}
