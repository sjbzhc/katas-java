package leetcode;

import java.util.*;

/*
* We first build a dictionary to map all possible strings in the wordList that stem from a wildcard char:
* *og -> {dog, cog}, d*g -> {dog}
*
* Then we do bfs, adding the beginWord to the queue.
*
* In the loop, we create all wildcard strings: dog -> *og, d*g, do* for each entry.
*   We then query the allComboDict to find the corresponding words for the wildcard: do* -> {dog, dot}
*   If one of the words matches the endWord, we return the count + 1.
*   Otherwise, if the word has not been visited yet, we add it to the visited map and to the queue.
* */

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = beginWord.length();
        int count = 1;

        Map<String, List<String>> wildcardStringToWords = new HashMap<>();

        wordList.forEach(word -> {
            for (int i = 0; i < n; i++) {
                String wildcardString = word.substring(0, i) + '*' + word.substring(i + 1, n);
                List<String> words = wildcardStringToWords.getOrDefault(wildcardString, new ArrayList<>());
                words.add(word);
                wildcardStringToWords.put(wildcardString, words);
            }
        });

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        Map<String, Boolean> visitedWords = new HashMap<>();
        visitedWords.put(beginWord, true);

        while (!q.isEmpty()) {
            int size = q.size();

            while (size > 0) {
                String word = q.remove();

                for (int i = 0; i < n; i++) {
                    String wildcardString = word.substring(0, i) + '*' + word.substring(i + 1, n);

                    for (String adjacentWord : wildcardStringToWords.getOrDefault(wildcardString, new ArrayList<>())) {
                        if (adjacentWord.equals(endWord)) {
                            return count + 1;
                        }

                        if (!visitedWords.containsKey(adjacentWord)) {
                            visitedWords.put(adjacentWord, true);
                            q.add(adjacentWord);
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
