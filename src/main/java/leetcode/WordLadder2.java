package leetcode;

import java.util.*;

public class WordLadder2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Map<String, List<String>> wildcardToWords = new HashMap<>();
        int count = 1;

        for (String word : wordList) {
            for (int i=0; i<word.length();i++) {
                String wildCard = word.substring(0, i) + "*" + word.substring(i + 1, word.length());
                List<String> words = wildcardToWords.getOrDefault(wildCard, new ArrayList<>());
                words.add(word);
                wildcardToWords.put(wildCard, words);
            }
        }

        Queue<String> queue = new LinkedList<>();
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        queue.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String currentWord = queue.poll();
                for (int i=0; i<currentWord.length();i++) {
                    String wildCard = currentWord.substring(0, i) + "*" + currentWord.substring(i + 1, currentWord.length());
                    for (String word : wildcardToWords.getOrDefault(wildCard, new ArrayList<>())) {
                        if (word.equals(endWord)) {
                            return count + 1;
                        }

                        if (!visited.getOrDefault(word, false)) {
                            visited.put(word, true);
                            queue.add(word);
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
