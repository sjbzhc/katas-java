package leetcode;

/*
* Time O(n)
* Space: O(1)
*
* saaan, abbr = s3n
*   first loop: go to else, wordIndex++
*   second loop: in if, read abbLen = 3
*   third loop: go to else
*       we compare 'saaan'.charAt(4) (n) with c (from abbr), which is n as well, to if is not triggered
* if wordindex + abbLen == word.length(), that means the abbreviation matches
* */

public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordIndex = 0;
        int abbreviationLen = 0;

        for (char c : abbr.toCharArray()) {
            if (Character.isDigit(c)) {
                // leading 0 is not valid
                if (abbreviationLen == 0 && c == '0') return false;
                abbreviationLen = 10 * abbreviationLen + (c - '0');
            } else {
                // We compare the char after the abbreviation with the corresponding char in the word
                wordIndex += abbreviationLen;
                if (wordIndex < word.length() && word.charAt(wordIndex) != c) return false;

                abbreviationLen = 0;
                wordIndex++;
            }
        }

        return wordIndex + abbreviationLen == word.length();
    }

}
