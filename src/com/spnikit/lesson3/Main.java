package com.spnikit.lesson3;

public class Main {

    public static void main(String[] args) {

            new Game().play(new XmlGameWriter("./test.xml"));

//        new Game().replay(new XmlGameReader("./temp.xml").getGameplay());

    }
}



