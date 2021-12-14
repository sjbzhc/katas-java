package leetcode;

public class CountBinarySubstring {

    public static int countBinarySubstrings(String s) {
        // 0011 returns 2
        /*
        * We create an array to represent contiguous occurrences of chars:
        * [2,2]
        * The min of [2,2] determines the number of combinations, since no more 'onions' can be build than that
        * */
        int[] substringsCounts = new int[s.length()];
        int index = 0;

        substringsCounts[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) == s.charAt(i)) {
                substringsCounts[index]++;
            } else {
                index++;
                substringsCounts[index] = 1;
            }
        }

        int result = 0;

        for (int i=0; i < index; i++) {
            result += Math.min(substringsCounts[i], substringsCounts[i+1]);
        }

        return result;
    }
}
