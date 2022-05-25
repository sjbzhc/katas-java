package leetcode;

/*
* Time: O(n)
* Space: O(1)
* */

public class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        /*
        create frequency map char -> List<index>
        get all chars with list.length == 1
        iterate through each one, keeping track of the shortest
        */
        int[] counts = new int[27];

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        for (int i=0;i<s.length();i++) {
            if (counts[s.charAt(i) - 'a'] == 1) return i;
        }

        return -1;

    }
}
