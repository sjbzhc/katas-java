package leetcode;


import java.util.HashMap;
import java.util.Map;

/*
* Time: O(m) for normal words, up to O(n * 26^m) for .... words, with m = keySet.size()
* Space: O(1) for normal words, up to O(m) for ... words
* */

public class WordDictionary {

    static class TrieNode {
        public Map<Character, TrieNode> children = new HashMap<>();
        public boolean end = false;
    }

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.end = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, TrieNode root) {
        TrieNode node = root;

        for (int j=i; j<word.length();j++) {
            char c = word.charAt(j);
            if (c == '.') {
                for (TrieNode child : node.children.values()) {
                    // base case: dfs returns true when i >= word.length() and is the end of a word
                    if (dfs(word, j + 1, child)) return true;
                }
                return false;
            } else {
                if (!node.children.containsKey(c)) return false;
                node = node.children.get(c);
            }
        }
        return node.end;
    }
}
