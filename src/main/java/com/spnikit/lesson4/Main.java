package com.spnikit.lesson4;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

////         Create new game
//        var game = new Game();
//
//        //  Subscribe to the game listeners to construct gameplay object
//        var createGameplay = new GameplayConstructor(game);
//
//        // play the game
//        game.play();
//
//        // get constructed gameplay object
//        Gameplay gameplay = createGameplay.getGameplay();
//
////         Write gameplay object to JSON
//
//        new GameplayToJsonMapper().writeToFile("./gameplay.json", gameplay);


//         Game replay from JSON

        // Create gameplay object from JSON
        Optional<Gameplay> gameplay = new GameplayToJsonMapper().readFromFile("./gameplay.json");

        // replay the game with gameplay object
        gameplay.ifPresentOrElse(game -> new Game().replay(game),
                () -> System.out.println("Gameplay object is not valid or not present"));


    }
}

