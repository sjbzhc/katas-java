package leetcode;

import java.util.*;

/*
* Time: O(n * L^3): L has 2 nested loops of length of longest word, + substring
* Space: O(n + L)
*
* The main part is in canForm.
*
* A boolean array is created with the size of the word + 1. For example, for abc, with the first element as true:
*
* With subWords: {ab, c}
* characterChecks = [1,0,0,0]
* Then we have nested loop, to check all substrings of the word in the subWords set.
* If a portion of the word is encountered, we set the end of the substring in the word to true. In this case, we find
* ab, so we set:
* characterChecks = [1,0,1,0]
* Then we encounter c, so we set:
* characterChecks = [1,0,1,1]
*
* We speed up the process of going through the different substrings by breaking in the case that charactersCheck[end] is
* false. This was, we move the start counter quicker (as we don't have to wait for start to increment all the way up to end).
*
* We return the value in the last position of the array.
*
* Time: O(n l3)
* Space: O(n + l)
* */

public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> subWords = new HashSet<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for (int i = 0; i < words.length; i++) {
            if (canForm(words[i], subWords)) {
                result.add(words[i]);
            }
            subWords.add(words[i]);
        }

        return result;
    }

    private boolean canForm(String word, Set<String> subWords) {
        if (subWords.isEmpty()) return false;
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int end = 1; end <= word.length(); end++) {
            for (int start = 0; start < end; start++) {
                if (!dp[start]) continue;
                if (subWords.contains(word.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}
