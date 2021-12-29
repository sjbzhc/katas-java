package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
* Use a trie to quickly navigate to the nodes. When a sentences is finished, we update each character of the sentence
* with the information of the final node, to have to frequency and whole sentence in each of the nodes hot-list (this
* happens in the add function).
*
* We sort the hot lists in descending order. This happens automatically by using the compareTo function.
* */

public class AutocompleteSystem {
    class TrieNode implements Comparable<TrieNode> {
        TrieNode[] children;
        String s;
        int times;
        List<TrieNode> hot;

        public TrieNode() {
            children = new TrieNode[128];
            s = null;
            times = 0;
            hot = new ArrayList<>();
        }

        @Override
        public int compareTo(TrieNode o) {
            if (this.times == o.times) return s.compareTo(o.s);
            return o.times - this.times;
        }

        public void updateWithEndNode(TrieNode endNode) {
            if (!hot.contains(endNode)) {
                hot.add(endNode);
            }

            Collections.sort(hot);

            if (hot.size() > 3) {
                hot.remove(hot.size() - 1);
            }
        }
    }

    TrieNode root;
    TrieNode cur;
    StringBuilder sb;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        cur = root;
        sb = new StringBuilder();

        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }

    private void add(String sentence, int time) {
        TrieNode currentNode = root;

        List<TrieNode> visited = new ArrayList<>();
        for (char c : sentence.toCharArray()) {
            if (currentNode.children[c] == null) {
                currentNode.children[c] = new TrieNode();
            }
            currentNode = currentNode.children[c];
            visited.add(currentNode);
        }

        currentNode.s = sentence;
        currentNode.times += time;

        for (TrieNode node : visited) {
            node.updateWithEndNode(currentNode);
        }
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
            add(sb.toString(), 1);
            sb = new StringBuilder();
            cur = root;
            return res;
        }

        sb.append(c);
        if (cur != null) {
            cur = cur.children[c];
        }

        if (cur == null) return res;

        for (TrieNode node : cur.hot) {
            res.add(node.s);
        }

        return res;
    }
}
