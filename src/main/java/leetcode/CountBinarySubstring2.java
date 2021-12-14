package leetcode;

import java.util.Arrays;

public class CountBinarySubstring2 {
    public static int countBinarySubstrings(String s) {
        int[] sequences = createSequences(s);
        int[] temp = new int[sequences.length];
        for (int i = 1; i< sequences.length; i++) {
            temp[i - 1] = Math.min(sequences[i-1], sequences[i]);
        }
//        return Arrays.stream(temp).reduce((acc, curr) -> acc + curr).getAsInt();

        int res = 0;
        for (int i : temp) {
            res += i;
        }
        return res;
    }

    public static int[] createSequences(String s) {
        int[] sequences = new int[s.length()];
        int count = 1;
        int index = 0;

        for(int i=1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                count++;
            } else {
                sequences[index] = count;
                index++;
                count=1;
            }
        }

        sequences[index] = count;

        return sequences;
    }
}
