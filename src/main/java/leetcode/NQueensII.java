package leetcode;

import java.util.HashSet;

/*
* Time: O(n!)
* Space: O(n)
* We need a base case. In this case, we return 1 because it means we reached the end of the rows, so we must have
* found one possible placement for all queens (we only reach a valid option, as otherwise we would run into the
* continue within the loop).
*
* To create the recursion tree, we iterate through all possible options. In this case it means increasing the column,
* since the row number is contained as an argument in the function.
*
* If we encounter a valid option, we:
*   update the state by adding constrains (cols, diags and antidiags).
*   recursively call that option, which will generate all possible paths for it.
*   after calling backtrack, we must go back to the previous state (this is the actual backtracking), by removing the
*   cols, diags and antidiags we just added. This leaves a clean state for the next round of the loop.
*
*
* Summarized:
* Follow a path until it branches.
* In the branch, follow each of the paths. Need to know how to come back, so keep track of the state, so you can reverse
* it to come back to where you started.
* */

public class NQueensII {
    int size;


    public int totalNQueens(int n) {
        size = n;
        return backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    private int backtrack(int row, HashSet<Object> diagonals, HashSet<Object> antidiagonals, HashSet<Object> cols) {
        // Base case
        if (row == size) return 1;

        int solutions = 0;
        for (int col = 0; col < size; col++) {
            int currentDiagonal = row - col;
            int currentAntidiagonal = row + col;
            // If queen cannot be placed, continue
            if (cols.contains(col) || diagonals.contains(currentDiagonal) || antidiagonals.contains(currentAntidiagonal)) continue;
            cols.add(col);
            diagonals.add(currentDiagonal);
            antidiagonals.add(currentAntidiagonal);

            solutions += backtrack(row + 1, diagonals, antidiagonals, cols);

            cols.remove(col);
            diagonals.remove(currentDiagonal);
            antidiagonals.remove(currentAntidiagonal);
        }

        return solutions;
    }
}
