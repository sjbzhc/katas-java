package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* Time: O(n!)
* Space: O(n2)
* */

public class NQueens {
    List<List<String>> res = new ArrayList<>();
    char[][] board;
    public Set<Integer> col = new HashSet<>();
    public Set<Integer> posDiag = new HashSet<>();
    public Set<Integer> negDiag = new HashSet<>();
    public int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.board = creteBoard(n);
        backtrack(0);
        return res;
    }

    private void backtrack(int r) {
        if (r == n) {
            res.add(stringify(board));
            return;
        }

        for (int c=0; c<n; c++) {
            if (col.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)) continue;

            col.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);
            board[r][c] = 'Q';

            backtrack(r + 1);

            col.remove(c);
            posDiag.remove(r + c);
            negDiag.remove(r - c);
            board[r][c] = '.';
        }
    }

    private List<String> stringify(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }

    public char[][] creteBoard(int n) {
        char [][] board = new char[n][n];
        for (int r=0; r<n; r++) {
            for (int c=0; c<n; c++) {
                board[r][c] = '.';
            }
        }
        return board;
    }
}
