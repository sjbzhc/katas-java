package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*
* Time: O(m n log n)
* Space: O(m log n)
* */

public class LogFiles2 {
    public static void arrange(String[] arr) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] l1 = o1.split(" ", 2);
                String[] l2 = o2.split(" ", 2);

                boolean isL1Digit = Character.isDigit(l1[1].charAt(0));
                boolean isL2Digit = Character.isDigit(l2[1].charAt(0));

                if (!isL1Digit && !isL2Digit) {
                    int cmp = l1[1].compareTo(l2[1]);
                    if (cmp == 0) {
                        return l1[0].compareTo(l2[0]);
                    } else {
                        return cmp;
                    }
                }

                if (!isL1Digit && isL2Digit) {
                    return -1;
                }
                if (isL1Digit && !isL2Digit) {
                    return 1;
                }
                return 0;
            }
        };

        Arrays.sort(arr, comparator);
    }
}
