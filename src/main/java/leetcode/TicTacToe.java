package leetcode;

import java.util.Arrays;

public class TicTacToe {
    int size;
    char[][] board;
    int winner = 0;

    public TicTacToe(int n) {
        size = n;
        board = new char[n][n];

    }

    public int move(int row, int col, int player) {

        char playersMark = player == 1 ? 'X' : 'O';
        board[row][col] = playersMark;
        checkWinner(row, col);
        if (winner != 0) {
            return winner;
        }
        return 0;
    }

    private void checkWinner(int row, int col) {
        boolean rowEqual = true;
        boolean colEqual = true;
        boolean diagonalLeft = true;
        boolean diagonalRight = true;

        char placed = board[row][col];
        for (int i=0; i<size;i++) {
            if (board[row][i] != placed) {
                rowEqual = false;
                break;
            }
        }

        for (int i=0; i<size;i++) {
            if (board[i][col] != placed) {
                colEqual = false;
                break;
            }
        }

        for (int i=0; i<size;i++) {
            if (board[i][i] != placed) {
                diagonalLeft = false;
                break;
            }
        }

        for (int i=0; i<size;i++) {
            if (board[i][size - i - 1] != placed) {
                diagonalRight = false;
                break;
            }
        }

        if (rowEqual || colEqual || diagonalLeft || diagonalRight) {
            if (placed == 'X') {
                winner = 1;
            } else {
                winner = 2;
            }
        }
    }

}
