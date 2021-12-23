package leetcode;

import java.util.*;

public class WordBreak {
    /*
    * O(2^n)
    * Recursion works by divide and conquer. It separates the problem in 2 substrings, with the right side possibly
    * being further segmented.
    *
    * If returns true if the left substring is in the wordDict and the right substring can be solved by recursion.
    *
    * The base case is when start == s.length, since we can only reach this value for start if we were able to find
    * entries in the wordDict for all substrings leading up to the whole string.
    * */
    public boolean wordBreakRecur(String s, List<String> wordDict) {
        return wordBreakRecursion(s, new HashSet<>(wordDict), 0);
    }

    private boolean wordBreakRecursion(String s, HashSet<String> wordDict, int start) {
        if (start == s.length()) return true;

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakRecursion(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }

    /*
    * Keeps track of the previously calculated values in the memo array and returns the value if queried, instead of
    * calculating it again.
    *
    * We cannot return directly true or false, but need to set it in the memo first, as those values might be used
    * in further calculations (except for base case).
    * */
    public boolean wordBreakMemo(String s, List<String> wordDict) {
        return wordBreakMemoization(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    private boolean wordBreakMemoization(String s, HashSet<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) return true;

        if (memo[start] != null) return memo[start];

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakMemoization(s, wordDict, end, memo)) {
                memo[start] = true;
                return memo[start];
            }
        }
        memo[start] = false;
        return memo[start];
    }

    /*
    * Focuses on the index of the string. We put the index of the end of the substring currently being examined
    * in the queue.
    *
    * We start with 0 in the queue.
    *
    * We only add a new end-index to the queue if it is the end-index of a substring that is present in the dict.
    * We use the end-index + 1 as the next start, chaining the different substrings in the word.
    *
    * If the end-index is the same as the length of the string, we return true, as there it means we found all necessary
    * words to fill all the substrings of the word.
    * */
    public boolean wordBreakBfs(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.add(0);

        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (visited[start]) continue;

            for (int end = start + 1; end <= s.length(); end++) {
                if (wordDictSet.contains(s.substring(start, end))) {
                    queue.add(end);
                    if (end  == s.length()) {
                        return true;
                    }
                }
            }
            visited[start] = true;
        }
        return false;
    }

    /*
    * Works by saving the progress state in the dp array.
    *
    * Right iterates from 1 to s.length.
    * With left, we create all substrings of s up to right.
    *
    * If dp[left] is false, we don't bother to check further this substring and we continue.
    * Only when dp[left] is true and the substring is valid we set dp[right] to true.
    *
    * We will only set the last dp[s.length] to true if we found all necessary words for the substrings.
    *
    *
    *   0 1 2 3 4 5 6 7  <- index
    *   l e e t c o d e
    * 0 1 2 3 4 5 6 7 8  <- dp indexes
    * t f f f f f f f f  <- dp
    *
    * first time we set a true value in dp will be when we find leet, which has left = 0 & right = 4 (as substring is
    * exclusive for the right index).
    *
    * dp changes to:
    * 0 1 2 3 4 5 6 7 8  <- dp indexes
    * t f f f t f f f f  <- dp
    *
    * Then, we enter the second if thanks to the conditions of dp[4] = true, which says that we found leet and with the
    * right index = 8, with the substring(4,8) = code
    * dp changes to:
    *
    * 0 1 2 3 4 5 6 7 8  <- dp indexes
    * t f f f t f f f t  <- dp
    *
    * We reach the end of the word and return dp[8]
    *
    * We need to have dp longer by 1 than the size of the string, since that way there is an offset between the string
    * and the dp array. The offset comes due to substring being exclusive for the right index. Therefore, when we store
    * right in the index, it would refer to the position + 1 in the string if there was no offset.
    * Additionally, it helps with the check for dp[0].
    * */
    public boolean wordBreakDp(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int right = 1; right <= s.length(); right++) {
            for (int left = 0; left<right; left++) {
                if (!dp[left]) continue;
                if (dp[left] && wordDictSet.contains(s.substring(left, right))) {
                    dp[right] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
