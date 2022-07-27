package leetcode;

import java.util.*;

/*
* Time: O(n2)
* Space: O(n)
* */

public class LongestStringChain {
    Map<String, Integer> memo = new HashMap<>();
    Set<String> wordsPresent = new HashSet<>();
    public int longestStrChain(String[] words) {
        Collections.addAll(wordsPresent, words);
        int ans = 0;
        for (String word : words) {
            ans = Math.max(ans, dfs(word));
        }
        return ans;
    }
    private int dfs(String currentWord) {
        if (memo.containsKey(currentWord)) return memo.get(currentWord);

        int maxLength = 1;
        StringBuilder sb = new StringBuilder(currentWord);

        for (int i = 0; i < currentWord.length(); i++) {
            sb.deleteCharAt(i);
            String newWord = sb.toString();
            // If the new word formed is present in the list, we do a dfs search with this newWord.
            if (wordsPresent.contains(newWord)) {
                int currentLength = 1 + dfs(newWord);
                maxLength = Math.max(maxLength, currentLength);
            }
            sb.insert(i, currentWord.charAt(i));
        }
        memo.put(currentWord, maxLength);

        return maxLength;
    }
}
