package com.spnikit.lesson2;

class Player {
    private final String name;
    private int numberOfMoves = 0;
    private final Token token;


    Player(String name, PlayerNumber playerNumber) {
        this.name = name;
        this.token = playerNumber == PlayerNumber.ONE ? Token.X : Token.O;
    }

    public void setNumberOfMoves(int numberOfMoves) {
        this.numberOfMoves = numberOfMoves;
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    public Token getToken() {
        this.setNumberOfMoves(this.numberOfMoves + 1);
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
}
