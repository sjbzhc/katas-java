package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
* Time: O(n^m)
* Space: O(n)
* */

public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();
    int target;
    int[] candidates;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        this.candidates = candidates;
        backtrack(0, new ArrayList<>(), 0);
        return res;
    }

    public void backtrack(int i, List<Integer> current, int total) {
        if (total == target) {
            res.add(new ArrayList<>(current));
            return;
        }

        if (i >= candidates.length || total > target) {
            return;
        }

        current.add(candidates[i]);
        // having i with the same index means we repeat the same candidate number
        backtrack(i, current, total + candidates[i]);
        current.remove(current.size() - 1);
        // skip the current element and explore the next one
        backtrack(i + 1, current, total);
    }
}