package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* Time: O(length of all words)
* Space: O(1)
* */

public class AlienDictionary {
    private Map<Character, List<Character>> adjMap = new HashMap<>();
    private Map<Character, Integer> color = new HashMap<>();
    private StringBuilder output = new StringBuilder();
    boolean isPossible = true;

    public String alienOrder(String[] words) {

        // For each pair of words, find the first character that doesn't match.
        // Since the list is sorted, the character of word1 comes before the char in word2
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            // If word2 is a prefix of word1 error that is an error, as it would need to come before
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            // The adjancency is inverted, as we are building the inverted topological sort
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    adjMap.putIfAbsent(c2, new ArrayList<>());
                    adjMap.get(c2).add(c2);
                    break;
                }
            }
        }

        for (Character c : adjMap.keySet()) {
            color.put(c, 0);
        }

        // Do DFS
        for (Character c : adjMap.keySet()) {
            if (color.get(c) == 0) dfs(c);
        }

        if (!isPossible) return "";

        return output.toString();
    }

    private boolean dfs(Character c) {
        // there is a cycle
        if (!isPossible) return false;

        color.put(c, 1);
        for (Character next : adjMap.get(c)) {
            if (color.get(next) == 1) {
                isPossible = false;
            }
            if (color.get(next) == 0) dfs(next);
        }
        color.put(c, 2);
        output.append(c);
        return true;
    }
}
