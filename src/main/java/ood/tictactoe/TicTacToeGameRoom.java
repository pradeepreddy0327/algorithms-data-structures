package ood.tictactoe;

import java.util.Scanner;

public class TicTacToeGameRoom {

    private TicTacToe game;
    private Player player1;
    private Player player2;
    private GameStatus gameStatus;
    private Player currentPlayer;

    public TicTacToeGameRoom(Player player1, Player player2) {
        super();
        this.game = new TicTacToe();
        this.player1 = player1;
        this.player2 = player2;
        this.gameStatus = GameStatus.NOT_STARTED;
        this.currentPlayer = player1;
    }

    static TicTacToeGameRoom getOnePlayerGmae() {
        return new TicTacToeGameRoom(new Player("Player1", Value.X, false),
                new Player("Player2", Value.O, true));
    }

    static TicTacToeGameRoom getZeroPlayerGame() {
        return new TicTacToeGameRoom(new Player("Player1", Value.X, true),
                new Player("Player2", Value.O, true));
    }

    public void start() {
        gameStatus = GameStatus.RUNNING;
        while (gameStatus == GameStatus.RUNNING) {
            int[] position = getInput(currentPlayer);
            boolean isPlayerWon = game.setValue(position[0], position[1],
                    currentPlayer.getValue());
            if (isPlayerWon) {
                gameStatus = GameStatus.COMPLETED;
                printWinner();
            } else if (game.isFilled()) {
                gameStatus = GameStatus.COMPLETED;
                printDraw();
            } else {
                updateCurrentPlayer();
            }
        }
    }

    private void updateCurrentPlayer() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

    private void printDraw() {
        System.out.println("Game Draw");
    }

    private void printWinner() {
        System.out.println(currentPlayer.getName() + " Won the game");
    }

    @SuppressWarnings("resource")
    private int[] getInput(Player player) {
        if (player.isComputer()) {
            return game.getAvailablePosition();
        } else {
            System.out.println("Enter position for : " + player1.getName());
            Scanner scanner = new Scanner(System.in);
            return new int[] { scanner.nextInt(), scanner.nextInt() };
        }
    }

}

enum GameStatus {
    NOT_STARTED, RUNNING, COMPLETED;
}
