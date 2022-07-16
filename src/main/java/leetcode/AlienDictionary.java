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
    private Map<Character, Boolean> visited = new HashMap<>();
    private StringBuilder output = new StringBuilder();

    public String alienOrder(String[] words) {

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adjMap.putIfAbsent(c, new ArrayList<>());
            }
        }

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
                if (word1.charAt(j) != word2.charAt(j)) {
                    adjMap.get(word2.charAt(j)).add(word1.charAt(j));
                    break;
                }
            }
        }

        // Do DFS
        for (Character c : adjMap.keySet()) {
            dfs(c);
        }

        return output.toString();
    }

    private boolean dfs(Character c) {
        // if not in map it means it was never visited before
        if (visited.containsKey(c)) return visited.get(c);

        visited.put(c, true);
        for (Character next : adjMap.get(c)) {
            // if result is true, it means we have a cycle, so we can return immediately
            if (dfs(next)) return true;
        }
        visited.put(c, false);
        output.append(c);
        return false;
    }
}
