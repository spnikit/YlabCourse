package com.spnikit.lesson3;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        var game = new Game();

        var createGameplay = new CreateGameplay(game);

        game.play();

        Gameplay gameplay = createGameplay.getGameplay();

        System.out.println(gameplay);

        // Write to JSON
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new FileWriter("./gameplay.json"), gameplay);


    }
}

class CreateGameplay implements PlayerMoved, PlayerRegistered, GameStarted, GameEnded {
    private final Gameplay gameplay = new Gameplay();

    public CreateGameplay(Game game) {
        game.addGameEndListener(this);
        game.addGameStartListener(this);
        game.addPlayerRegisteredListener(this);
        game.addPlayerMovedListener(this);
    }


    public Gameplay getGameplay() {
        return this.gameplay;
    }

    @Override
    public void onPlayerMoved(int xCoord, int yCoord, Player player, int moveNumber) {
        var playerNumber = player.getToken() == Token.X ? "1" : "2";
        gameplay.addStep(new Step(moveNumber, xCoord, yCoord, playerNumber));
    }

    @Override
    public void onPlayerRegister(Player player) {
        gameplay.setPlayer(player);
    }

    @Override
    public void onGameStart() {

    }

    @Override
    public void onGameEnd(String gameResult) {
        gameplay.setGameResult(gameResult);
    }
}

