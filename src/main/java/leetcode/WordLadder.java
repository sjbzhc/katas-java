package leetcode;

import java.util.*;

/*
* Time: O(n2 * m). For each word (n) we create all substrings of m (a matrix, with * in the diagonal)
* Space: O(n2 * m). For each of the word, we will have the wildcard word with the same original word.
*
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

/*
* Time: O(n2 m)
* Space: O(n2 m)
* */

public class WordLadder {
    public static String beginWord;
    public static String endWord;
    public Map<String, List<String>> wildcardStringToWords;
    int n;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        n = beginWord.length();
        this.beginWord = beginWord;
        this.endWord = endWord;
        wildcardStringToWords = new HashMap<>();

        wordList.forEach(word -> {
            for (int i = 0; i < n; i++) {
                String key = word.substring(0, i) + '*' + word.substring(i + 1, n);
                List<String> words = wildcardStringToWords.getOrDefault(key, new ArrayList<>());
                words.add(word);
                wildcardStringToWords.put(key, words);
            }
        });
        return bfs();
    }

    private int bfs() {
        int count = 1;
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(beginWord);
        visited.add(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();

            while (size > 0) {
                String word = q.poll();

                for (int i = 0; i < word.length(); i++) {
                    String key = word.substring(0, i) + '*' + word.substring(i + 1, n);

                    for (String adjacentWord : wildcardStringToWords.getOrDefault(key, new ArrayList<>())) {
                        if (adjacentWord.equals(endWord)) return count + 1;

                        if (!visited.contains(adjacentWord)) {
                            visited.add(adjacentWord);
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
