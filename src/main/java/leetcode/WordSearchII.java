package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* Time: O(mn * 4^mn)
* Space: O(mn * 4^mn)
* */
public class WordSearchII {

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean end = false;
    }

    TrieNode root = new TrieNode();

    public void addWord(String w) {
        TrieNode node = root;
        for (char c : w.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.end = true;
    }
    int ROWS;
    int COLS;
    char[][] board;
    boolean[][] visited;
    List<String> res = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        ROWS = board.length;
        COLS = board[0].length;
        visited = new boolean[ROWS][COLS];
        for (String w : words) addWord(w);

        for (int r=0; r<ROWS; r++) {
            for (int c=0; c<COLS; c++) {
                if (root.children.containsKey(board[r][c])) backtrack(r, c, "", root);
            }
        }
        return res;
    }

    private void backtrack(int r, int c, String word, TrieNode node) {
        if (!node.children.containsKey(board[r][c])) return;
        visited[r][c] = true;

        node = node.children.get(board[r][c]);
        word += board[r][c];
        if (node.end && !res.contains(word)) res.add(word);

        int[] rowOffsets = {-1, 0, 1, 0};
        int[] colOffsets = {0, -1, 0 ,1};

        for (int d=0; d<4; d++) {
            int newRow = r + rowOffsets[d];
            int newCol = c + colOffsets[d];
            if (newRow >= ROWS || newRow < 0 || newCol >= COLS || newCol < 0 || visited[newRow][newCol]) continue;
            backtrack(newRow, newCol, word, node);
        }

        visited[r][c] = false;
    }
}
