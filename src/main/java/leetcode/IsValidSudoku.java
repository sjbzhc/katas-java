package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
* Time: O(n * m)
* Space: O(n * m)
* */

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        int blockSize = 3;
        Map<Integer, Set> rows = new HashMap<>();
        Map<Integer, Set> cols = new HashMap<>();
        Map<String, Set> blocks = new HashMap<>();

        for (int i=0; i<n;i++) {
            rows.put(i, new HashSet());
            cols.put(i, new HashSet());
        }

        for (int r=0; r<blockSize; r++) {
            for (int c=0; c<blockSize; c++) {
                String key = r + String.valueOf(c);
                blocks.put(key, new HashSet());
            }
        }

        for (int r=0; r<n;r++) {
            for (int c=0; c<n;c++) {
                char current = board[r][c];

                if (current == '.') continue;

                if (rows.get(r).contains(current)) return false;
                rows.get(r).add(current);
                if (cols.get(c).contains(current)) return false;
                cols.get(c).add(current);
                String key = r/3 + String.valueOf(c/3);
                if (blocks.get(key).contains(current)) return false;
                blocks.get(key).add(current);
            }
        }

        return true;
    }
}
