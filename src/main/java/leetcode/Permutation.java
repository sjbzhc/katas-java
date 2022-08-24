package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
* Time: O(n!)
* Space: O(n!)
* */
public class Permutation {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        backtrack(new ArrayList<>());
        return res;
    }

    private void backtrack(List<Integer> temp) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        // We start from 0 for each new call to backtrack. That guarantees that for example, for [1,2,3]
        // when we start the permutation with 2, we can create [2,1,3]
        // since we don't have duplicates, it's easy to know if adding an element is possible
        for (int i=0; i<nums.length; i++) {
            if (temp.contains(nums[i])) continue;

            temp.add(nums[i]);
            backtrack(temp);
            temp.remove(temp.size() - 1);
        }
    }
}
