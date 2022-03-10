package com.spnikit.lesson3;

import java.io.IOException;
import java.time.LocalDate;
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

    private void playOneRound() {
        board = new GameBoard();
        board.printBoard();

        boolean turn = true;

        do {
            Player playerToMove = turn ? player1 : player2;

            int x = getCoordinate(playerToMove, "X");
            int y = getCoordinate(playerToMove, "Y");

            try {
                board.acceptMove(x, y, playerToMove.getToken());
            } catch (IllegalArgumentException e) {
                manager.printToConsole(e.getMessage());
                continue;
            }

            board.printBoard();
            turn = !turn;

            if (board.isWinner()) break;

        } while (!board.isDraw());

        if (board.isWinner()) {
            Player winner = (turn) ? player2 : player1;
            manager.printToConsole("Победил : " + winner.getName());
            manager.writeMatchResults(LocalDate.now() + " - Победил " + winner.getName() + " за "
                    + winner.getNumberOfMoves() + " ходов!");

        } else {
            manager.printToConsole("Ничья!");
            manager.writeMatchResults(LocalDate.now() + " Ничья ");
        }
    }

    public void play() {
        manager.printToConsole("Привет, сейчас начнется игра в крестики-нолики");


        do {
            player1 = getPlayer(PlayerNumber.ONE);
            player2 = getPlayer(PlayerNumber.TWO);
            playOneRound();
        } while (isPlayAgain());


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

    public boolean isPlayAgain() {

        Optional<String> yesOrNo;
        do {
            manager.printToConsole("Сыграть ещё раз? Да / Нет:");
            yesOrNo = manager.readStringFromConsole();

        } while (yesOrNo.isEmpty());

        String response = yesOrNo.get();

        return response.equalsIgnoreCase("да");
    }

}
