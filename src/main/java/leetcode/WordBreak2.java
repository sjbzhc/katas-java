package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordBreak2 {
    List<String> dict;
    public boolean wordBreakRecur(String word, List<String> dict) {
        this.dict = dict;
        return solve(word, 0);
    }

    private boolean solve(String word, int start) {
        if (start == word.length()) return true;

        for (int end= start + 1; end<=word.length(); end++) {
            if (dict.contains(word.substring(start, end)) && solve(word, end)) return true;
        }

        return false;
    }

    public boolean wordBreakMemo(String word, List<String> dict) {
        this.dict = dict;
        boolean[] memo = new boolean[word.length()];
        return solveMemo(word, 0, memo);
    }

    private boolean solveMemo(String word, int start, boolean[] memo) {
        if (start == word.length()) return true;

        if (memo[start]) {
            return memo[start];
        }

        for (int end= start + 1; end <= word.length(); end ++) {
            if (dict.contains(word.substring(start, end)) && solveMemo(word, end, memo)) {
                memo[start] = true;
                return memo[start];
            }
        }

        memo[start] = false;
        return memo[start];
    }

    public boolean wordBreakBfs(String word, List<String> dict) {
        this.dict = dict;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[word.length()];

        queue.add(0);

        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (visited[start]) continue;

            for (int end = start + 1; end <= word.length(); end++) {
                if (dict.contains(word.substring(start, end))) {
                    queue.add(end);
                    if (end == word.length()) return true;
                }
            }
            visited[start] = true;
        }

        return false;
    }

    public boolean wordBreakDp(String word, List<String> dict) {
        this.dict = dict;
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;

        for (int end=1; end <= word.length(); end++) {
            for (int start=0; start < end; start++) {
                if (!dp[start]) continue;
                if (dict.contains(word.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}
