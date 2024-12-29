package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Time: O(2^n)WS
* Space: O(2^n)
* */

public class CombinationSumII {
    List<List<Integer>> res = new ArrayList<>();
    int target;
    int[] candidates;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;
        this.candidates = candidates;
        Arrays.sort(candidates);
        backtrack(0, new ArrayList<>(), target);

        return res;
    }

    public void backtrack(int pos, List<Integer> current, int sum) {
        if (sum == 0) res.add(new ArrayList<>(current));
        if (sum < 0) return;

        int prev = 0;
        for (int i=pos; i <candidates.length;i++) {
            // skip repeated elements
            if (candidates[i] == prev) continue;
            current.add(candidates[i]);
            backtrack(i + 1, current, sum - candidates[i]);
            current.remove(current.size() - 1);
            prev = candidates[i];
        }
    }
}
