package leetcode;

import java.util.*;

public class GuessTheWord {

    static class Master {
        public List<String> wordList;
        public String word;
        int allowedGuesses;
        public Master(List<String> wordList, String word, int allowedGuesses) {
            this.wordList = wordList;
            this.word = word;
            this.allowedGuesses = allowedGuesses;
        }

        public int guess(String w) {
            if (allowedGuesses == 0) System.out.println("No more guesses");
            allowedGuesses--;
            int count = 0;
            for (int i=0; i<w.length(); i++) {
                if (w.charAt(i) == word.charAt(i)) count++;
            }
            if (count == 6) System.out.println("Solution found");
            return count;
        }
    }

    /*
     * Time: O(n2)
     * Space: O(n)
     * */

    public Set<String> deleted;
    public void findSecretWord(String[] wordlist, Master master) {
        deleted = new HashSet<>();
        ArrayList<String> words = new ArrayList<>();
        for (int i=0; i<wordlist.length; i++) {
            words.add(wordlist[i]);
        }

        Collections.shuffle(words);
        for (String word : words) {
            if (!deleted.contains(word)) {
                int matchLen = master.guess(word);
                deleted.add(word);

                if (matchLen == 6) break;

                if (matchLen == 0) {
                    deleteWordWithNoMatch(word, words);
                    continue;
                }

                deleteWordsWithLowerMatch(word, words, matchLen);
            }
        }
    }

    public void deleteWordWithNoMatch(String source, ArrayList<String> words) {
        for (String word : words) {
            if (word.equals(source)) continue;
            int matchLen = getMatchLen(source, word);
            // if the word matches with source, it cannot match with secret, as source and secret share no common char
            if(matchLen > 0) {
                deleted.add(word);
            }
        }
    }
    public void deleteWordsWithLowerMatch(String source, ArrayList<String> words, int sourceAndSecretMatchLen) {
        for (String word : words) {
            if (word.equals(source)) continue;
            int currMatchLen = getMatchLen(source, word);
            if (currMatchLen < sourceAndSecretMatchLen) deleted.add(word);
        }
    }
    public int getMatchLen(String source, String word) {
        int count = 0;
        for(int i=0; i<word.length(); i++) {
            if(word.charAt(i) == source.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
