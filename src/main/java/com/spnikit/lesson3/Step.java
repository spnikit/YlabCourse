package com.spnikit.lesson3;

//public record Step(int number, int xCoord, int yCoord, String playerNumber) {
//}

public class Step{

    private int number;
    private int xCoord;
    private int yCoord;
    String playerNumber;

    public Step(){}

    public Step(int number, int xCoord, int yCoord, String playerNumber) {
        this.number = number;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.playerNumber = playerNumber;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(String playerNumber) {
        this.playerNumber = playerNumber;
    }


    @Override
    public String toString() {
        return "Step{" +
                "number=" + number +
                ", xCoord=" + xCoord +
                ", yCoord=" + yCoord +
                ", playerNumber='" + playerNumber + '\'' +
                '}';
    }
}
