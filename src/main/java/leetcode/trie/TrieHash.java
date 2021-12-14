package leetcode.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieHash {
    class TrieNode {
        public Map<Character, TrieNode> children = new HashMap<>();
        public boolean end = false;
    }

    private TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
           if (!node.children.containsKey(c)) {
               TrieNode newNode = new TrieNode();
               node.children.put(c, newNode);
           }
           node = node.children.get(c);
        }
        node.end = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        if (node.end) return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c: prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        if (node != null) return true;
        return false;
    }
}
