package leetcode;

import java.util.*;

/*
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
* The we encounter c, so we set:
* characterChecks = [1,0,1,1]
*
* We speed up the process of going through the different substrings by breaking in the case that charactersCheck[j] is
* false. This was, we move the i counter quicker (as we don't have to wait for j to increment all the way up to i).
*
* We return the value in the last position of the array
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
        boolean[] characterChecks = new boolean[word.length() + 1];
        characterChecks[0] = true;
        for (int right = 1; right <= word.length(); right++) {
            for (int left = 0; left < right; left++) {
                if (!characterChecks[left]) continue;
                if (subWords.contains(word.substring(left, right))) {
                    characterChecks[right] = true;
                    break;
                }
            }
        }
        return characterChecks[word.length()];
    }
}
