package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LogFiles {

    /*
    * Time: O(M * N log N): NlogN for Arrays.sort, M (max length of a log) for each invocation of the compareTo function.
    * Space: O(M log N)
    *
    *
    * Create 2 arrays: 1 for chars, one for numbers
    * Chars: sort by contents, if contents the same, by ids
    * Numbers: don't sort
    * */

    public static String[] arrange(String[] logs) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                if (!isDigit1 && !isDigit2) {
                    int cmp = split1[1].compareTo(split2[1]);
                    if (cmp != 0) {
                        return cmp;
                    } else {
                        return split1[0].compareTo(split2[0]);
                    }
                }

                if (!isDigit1 && isDigit2) {
                    return -1;
                } else if (isDigit1 && !isDigit2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };

        Arrays.sort(logs, comparator);
        return logs;
    }
}
