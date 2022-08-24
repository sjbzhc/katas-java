package leetcode;

import java.util.*;

/*
* Time: O(n!)
* Space: O(n)
*
* */

public class PermutationII {
    List<List<Integer>> results = new ArrayList<>();
    HashMap<Integer, Integer> freq = new HashMap<>();
    int n;
    public List<List<Integer>> permuteUnique(int[] nums) {
        n = nums.length;

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        backtrack(new ArrayList<>());
        return results;
    }

    protected void backtrack(ArrayList<Integer> current) {
        if (current.size() == n) {
            results.add(new ArrayList<>(current));
            return;
        }

        for (int num : freq.keySet()) {
            int count = freq.get(num);
            if (count == 0) continue;

            current.add(num);
            freq.put(num, count - 1);

            backtrack(current);

            current.remove(current.size() - 1);
            freq.put(num, count);
        }
    }
}
