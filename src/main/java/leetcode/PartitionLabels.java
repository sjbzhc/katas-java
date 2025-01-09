package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    /*
     * Time: O(n)
     * Space: O(1)
     *
     * */
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastOccurrence = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<s.length(); i++) lastOccurrence.put(s.charAt(i), i);

        // Start and end of current partition
        int start = 0;
        int end = 0;

        for (int i=0; i<s.length(); i++) {
            end = Math.max(end, lastOccurrence.get(s.charAt(i)));

            // When i reaches end, we can finalize this partition
            if (i == end) {
                res.add(i - start + 1);
                // start at next partition
                start = i + 1;
            }
        }

        return res;
    }
    public List<Integer> partitionLabels2(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i) {
            last[S.charAt(i) - 'a'] = i;
        }

        int j = 0;
        int anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }
}
