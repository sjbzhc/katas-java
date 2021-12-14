package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BacktrackingWithTrie {

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;
        public TrieNode() {}
    }

    char[][] board = null;
    List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = createTrie(words);

        this.board = board;

        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[row].length; ++col) {
                if (root.children.containsKey(board[row][col])) {
                    backtrack(row, col, root);
                }
            }
        }

        return result;
    }

    private void backtrack(int row, int col, TrieNode parent) {
        Character letter = board[row][col];
        TrieNode currNode = parent.children.get(letter);

        // If the word is null, it means we are in an intermediate node of the string, not at the end node, so its just a substring, not an actual word
        if (currNode.word != null) {
            result.add(currNode.word);
            currNode.word = null;
        }

        // mark the current letter before the EXPLORATION
        board[row][col] = '#';

        // explore neighbor cells in around-clock directions: up, right, down, left
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        for (int i = 0; i < 4; ++i) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0 || newRow >= board.length || newCol < 0
                    || newCol >= board[0].length) {
                continue;
            }
            if (currNode.children.containsKey(board[newRow][newCol])) {
                backtrack(newRow, newCol, currNode);
            }
        }

        // End of EXPLORATION, restore the original letter in the board.
        board[row][col] = letter;

        // Optimization: incrementally remove the leaf nodes
        if (currNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }

    private TrieNode createTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;

            for (Character letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }
        return root;
    }
}
