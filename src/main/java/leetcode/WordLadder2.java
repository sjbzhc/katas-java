package leetcode;

import java.util.*;

public class WordLadder2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> wildcardToWords = new HashMap<>();
        int count = 1;

        for (String word: wordList) {
            for (int i=0; i< word.length(); i++) {
                String wildcardString = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> wordsOfWildcard = wildcardToWords.getOrDefault(wildcardString, new ArrayList<>());
                if (!wordsOfWildcard.contains(word)) {
                    wordsOfWildcard.add(word);
                }
                wildcardToWords.put(wildcardString, wordsOfWildcard);
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String word = queue.poll();
                for (int i=0;i<word.length();i++) {
                    String wildcardString = word.substring(0, i) + "*" + word.substring(i + 1);
                    for (String w : wildcardToWords.getOrDefault(wildcardString, new ArrayList<>())) {
                        if (w.equals(endWord)) {
                            return count + 1;
                        }
                        if (!visited.containsKey(w)) {
                            queue.add(w);
                            visited.put(w, true);
                        }
                    }
                }
                size--;
            }
            count++;
        }

        return 0;
    }
}
