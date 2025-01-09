package leetcode;

import java.util.*;

/*
* Time: O(2^n) with n being the number of words (due to backtracking)
* Space: O(2^n)
* */

public class WordBreakII {
    String s;
    Set<String> wordSet;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        wordSet = new HashSet<>(wordDict);
        List<String> results = new ArrayList<>();
        backtrack(0, new ArrayList<>(), results);
        return results;
    }

    private void backtrack(int startIndex, ArrayList<String> currentSentence, List<String> results) {
        // If we've reached the end of the string, add the current sentence to results
        if (startIndex == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<currentSentence.size(); i++) {
                String w = currentSentence.get(i);
                sb.append(w);
                if (i < currentSentence.size() - 1) sb.append(" ");
            }
            results.add(sb.toString());
            return;
        }

        // Iterate over possible end indices
        for (int endIndex = startIndex + 1; endIndex <= s.length(); endIndex++) {
            String word = s.substring(startIndex, endIndex);
            // If the word is in the set, proceed with backtracking
            if (wordSet.contains(word)) {
                // int currentLength = currentSentence.length();
                currentSentence.add(word);
                // Recursively call backtrack with the new end index
                backtrack(endIndex, currentSentence, results);
                // Reset currentSentence to its original length
                currentSentence.remove(currentSentence.size() - 1);
            }
        }
    }

    /*
     * s = catsdog
     * words: [cat, cats, dog, s]
     * res: [cat s dog], [cats, dog]
     *
     * we first look for the first word that matches:
     *   cat is a match
     *   we call wordBreak recursively, with s = sdog
     *       s is a match
     *       we call wordBreak recursively, with s = dog
     *           dog is a match
     *   we start to collect the results from tmp
     *   after unwinding, we will continue where we left
     *       for cat we continue with cats
     *
     * Time: O(n2)
     * Space: O(n2)
     * */
    Map<String, List<String>> cache = new HashMap<>();
    public List<String> wordBreakDp(String s, List<String> wordDict) {
        if (cache.containsKey(s)) return cache.get(s);

        List<String> result = new ArrayList<>();
        if (wordDict.contains(s)) result.add(s);

        for (int i = 0; i < s.length(); i++) {
            String word = s.substring(0, i);
            if (wordDict.contains(word)) {
                List<String> tmp = wordBreakDp(s.substring(i, s.length()), wordDict);
                for (String str : tmp) {
                    result.add(word + " " + str);
                }
            }
        }
        cache.put(s, result);
        return result;
    }
}
