package leetcode;

import java.util.*;

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

public class WordBreakII {
    Map<String, List<String>> cache = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (cache.containsKey(s)) return cache.get(s);

        List<String> result = new ArrayList<>();
        if (wordDict.contains(s)) result.add(s);

        for (int i = 0; i < s.length(); i++) {
            String word = s.substring(0, i);
            if (wordDict.contains(word)) {
                List<String> tmp = wordBreak(s.substring(i, s.length()), wordDict);
                for (String str : tmp) {
                    result.add(word + " " + str);
                }
            }
        }
        cache.put(s, result);
        return result;
    }
}
