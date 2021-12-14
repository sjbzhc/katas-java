package leetcode;

import java.util.HashSet;

public class NQueens2 {
    int n;
    public int totalNQueens(int n) {
        this.n = n;
        return backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    private int backtrack(int row, HashSet<Object> diagonals, HashSet<Object> antidiagonals, HashSet<Object> columns) {
        if (row == n) return 1;

        int solutions = 0;
        for (int col=0; col<n; col++) {
            int currentDiagonal = row - col;
            int currentAntidiagonal = row + col;

            if (diagonals.contains(currentDiagonal) || antidiagonals.contains(currentAntidiagonal) || columns.contains(col)) continue;

            diagonals.add(currentDiagonal);
            antidiagonals.add(currentAntidiagonal);
            columns.add(col);

            solutions += backtrack(row + 1, diagonals, antidiagonals, columns);

            diagonals.remove(currentDiagonal);
            antidiagonals.remove(currentAntidiagonal);
            columns.remove(col);

        }
        return solutions;
    }
}
