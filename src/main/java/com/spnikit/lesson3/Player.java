package com.spnikit.lesson3;

import java.util.Objects;

class Player {
    private String name;
    private int numberOfMoves = 0;
    private Token token;


    public Player() {
    }

    public Player(String name, PlayerNumber playerNumber) {
        this.name = name;
        this.token = playerNumber == PlayerNumber.ONE ? Token.X : Token.O;
    }

    public void setNumberOfMoves(int numberOfMoves) {
        this.numberOfMoves = numberOfMoves;
    }

    public void makeMove() {
        this.numberOfMoves += 1;
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    public Token getToken() {
        return token;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", numberOfMoves=" + numberOfMoves +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return name.equals(player.name) && token == player.token;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, token);
    }
}
