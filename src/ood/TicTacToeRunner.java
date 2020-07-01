package ood;

public class TicTacToeRunner {

    public static void main(String[] args) {
        TicTacToeGameRoom ttt = TicTacToeGameRoom.getOnePlayerGmae();
        ttt.start();
        // TicTacToeGameRoom ttt2 = TicTacToeGameRoom.getZeroPlayerGmae();
        // ttt2.start();
    }

}
