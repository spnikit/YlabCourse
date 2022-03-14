package com.spnikit.lesson3;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;

class Game {
    private Player player1;
    private Player player2;
    private GameBoard board;
    private final IOManager manager = new IOManager();

    private Player getPlayer(PlayerNumber pn) {
        Optional<String> playerName;
        do {
            manager.printToConsole("Введите имя игрока " + pn + " :");
            playerName = manager.readStringFromConsole();

        } while (playerName.isEmpty());

        String name = playerName.get();
        return new Player(name, pn);
    }

    private int getCoordinate(Player playerToMove, String axis) {
        OptionalInt coordinate;
        do {
            manager.printToConsole(playerToMove.getName() + ", введите координату " + axis);

            coordinate = manager.readIntFromConsole();

        } while (coordinate.isEmpty());

        return coordinate.getAsInt();
    }

    private void playOneRound(XmlGameWriter xmlw) {
        board = new GameBoard();
        board.printBoard();

        boolean turn = true;

        int numberOfMoves = 1;
        do {
            Player playerToMove = turn ? player1 : player2;

            int x = getCoordinate(playerToMove, "X");
            int y = getCoordinate(playerToMove, "Y");

            try {
                board.acceptMove(x, y, playerToMove.getToken());
                xmlw.writeElementWithAttributes("Step",
                        Map.of("num", numberOfMoves + "",
                                "playerId", playerToMove.equals(player1) ? "1" : "2"),
                        "x: " + x, " y: " + y);
            } catch (IllegalArgumentException e) {
                manager.printToConsole(e.getMessage());
                continue;
            }

            board.printBoard();
            turn = !turn;

            if (board.isWinner()) break;
            numberOfMoves++;
        } while (!board.isDraw());

        xmlw.writeStartElement("GameResult");

        if (board.isWinner()) {
            Player winner = (turn) ? player2 : player1;
            manager.printToConsole("Победил : " + winner.getName());
            manager.writeMatchResults(LocalDate.now() + " - Победил " + winner.getName() + " за "
                    + winner.getNumberOfMoves() + " ходов!");
            xmlw.writeElementWithAttributes("Player", Map.of("name", winner.getName(),
                    "symbol", winner.getToken().toString(),
                    "id", winner.equals(player1) ? "1" : "2"));

        } else {
            manager.printToConsole("Ничья!");
            manager.writeMatchResults(LocalDate.now() + " Ничья ");
            xmlw.writeChars("DRAW");
        }

        xmlw.writeEndElement();
    }

    public void play(XmlGameWriter xmlw) {

        do {
            manager.printToConsole("Привет, сейчас начнется игра в крестики-нолики");

            xmlw.startDocument();
            xmlw.writeStartElement("Gameplay");

            player1 = getPlayer(PlayerNumber.ONE);
            var name1 = player1.getName();
            var symbol1 = player1.getToken().toString();

            xmlw.writeElementWithAttributes("Player", Map.of("name", name1,
                    "symbol", symbol1,
                    "id", player1.getToken() == Token.X ? "1" : "2"));

            player2 = getPlayer(PlayerNumber.TWO);
            var name2 = player2.getName();
            var symbol2 = player2.getToken().toString();

            xmlw.writeElementWithAttributes("Player", Map.of("name", name2,
                    "symbol", symbol2,
                    "id", player2.getToken() == Token.X ? "1" : "2"));

            playOneRound(xmlw);

            xmlw.writeEndElement();
            xmlw.endDocument();
            xmlw.flushAndClose();

        } while (doPlayAgain());


        finishGame();
        manager.printToConsole("Игра окончена!");
    }

    public void finishGame() {
        try {
            manager.finish();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean doPlayAgain() {

        Optional<String> yesOrNo;
        do {
            manager.printToConsole("Повторим? Да / Нет:");
            yesOrNo = manager.readStringFromConsole();

        } while (yesOrNo.isEmpty());

        String response = yesOrNo.get();

        return response.equalsIgnoreCase("да");
    }


    public void replay(Gameplay gameplay) {

        do {
            manager.printToConsole("Привет, сейчас начнется игра в крестики-нолики");

            player1 = gameplay.getPlayer1();
            manager.printToConsole("Имя первого игрока: " + player1.getName());

            sleep();

            player2 = gameplay.getPlayer2();
            manager.printToConsole("Имя второго игрока: " + player2.getName());

            sleep();

            replayOneRound(gameplay);

        } while (doPlayAgain());

        finishGame();
        manager.printToConsole("Игра окончена!");

    }


    public void replayOneRound(Gameplay gameplay) {
        var player1 = gameplay.getPlayer1();
        var player2 = gameplay.getPlayer2();
        var steps = gameplay.getSteps();

        board = new GameBoard();
        board.printBoard();

        boolean turn = true;

        for (var step : steps) {

            Player playerToMove = turn ? player1 : player2;

            int x = step.xCoord();
            int y = step.yCoord();

            try {
                board.acceptMove(x, y, playerToMove.getToken());

            } catch (IllegalArgumentException e) {
                manager.printToConsole(e.getMessage());
            }

            board.printBoard();
            turn = !turn;

            sleep();
        }

        if (board.isWinner()) {
            Player winner = (turn) ? player2 : player1;
            manager.printToConsole("Победил : " + winner.getName());

        } else {
            manager.printToConsole("Ничья!");
        }
    }


    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Problem with sleeping in thread");
            e.printStackTrace();
        }
    }
}
