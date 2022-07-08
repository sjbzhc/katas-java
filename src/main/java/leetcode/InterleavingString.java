package leetcode;

/*
* Time: O(mn)
* Space: O(mn)
* */

public class InterleavingString {
    static String one;
    static String two;
    static String three;
    public boolean isInterleave(String s1, String s2, String s3) {
        one = s1;
        two = s2;
        three = s3;
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        Boolean[][] cache = new Boolean[s1.length() + 1][s2.length() + 1];
        return helper(0, 0, cache);
    }

    private static boolean helper(int i, int j, Boolean[][] cache) {
        if (cache[i][j] != null) return cache[i][j];
        int k = i + j;

        if (k == three.length()) return true;


        if ((i < one.length()) && (one.charAt(i) == three.charAt(k))) {
            cache[i][j] = helper( i + 1, j, cache);
            if (cache[i][j]) return true;

        }

        if ((j < two.length()) && (two.charAt(j) == three.charAt(k))) {
            cache[i][j] = helper(i, j + 1, cache);
            if(cache[i][j]) return true;
        }
        cache[i][j] = false;
        return cache[i][j];
    }
}
