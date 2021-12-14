package leetcode.trie;

/*
* In Tries, the node value is encoded in its position in the array.
*
* The root array (of TrieNode) starts with 26 empty slots:
* [,,,,,,,], last = false
*
* With the first char, a new TrieNode is added in the right position. Other than its own array of TrieNode, it holds
* information whether its the last node, which is used to know if a prefix is an actual word, as we could have the
* word apple but not app in the Trie.
*
* For example, add app:
* Start with a
* [pointerTrieA,,,,,,,], false
* with trieA: [,,,,,,,,], false
*
* Then add p:
* [pointerTrieA,,,,,,,], false
* with trieA: [,,,,,,pointerTrieP,,], false
* with trieP: [,,,,,,,,,,,], false
*
* Add second p:
* [pointerTrieA,,,,,,,], false
* with trieA:  [,,,,,,pointerTrieP,,], false
* with trieP:  [,,,,,,pointerSecondTrieP,,,,,], false
* with trieP2: [,,,,,,,], true
*
* */

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i=0;i<word.length();i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}
