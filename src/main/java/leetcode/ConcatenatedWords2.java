package leetcode;

import java.util.*;

public class ConcatenatedWords2 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> subwords = new HashSet<>();
        List<String> result = new ArrayList<>();
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        for (String word: words) {
            if (canAdd(word, subwords)) {
                result.add(word);
            }
            subwords.add(word);
        }
        return result;
    }

    private boolean canAdd(String word, Set<String> subwords) {
        if (subwords.isEmpty()) return false;
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;

        for (int end = 1; end <= word.length(); end++) {
            for (int start = 0; start < end; start++) {
                if (!dp[start]) continue;
                if (subwords.contains(word.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }
            return dp[word.length()];
    }
}
