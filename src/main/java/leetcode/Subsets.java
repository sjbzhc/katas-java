package leetcode;

import java.util.ArrayList;
import java.util.List;


/*
* Backtracking works like a tree and we take the decision to include/exclude one element at each node
* Time: O(n 2^n)
* Space: O(n^2)
* */

public class Subsets {
    List<List<Integer>> list = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        backtrack(0, new ArrayList<>());
        return list;
    }

    public void backtrack(int i, List<Integer> subset) {
        // i refers to the element current being visited, so we check if we are at the end of the tree
        if (i == nums.length) {
            list.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        // decision to include the current number in the final array
        backtrack(i + 1, subset);
        // decision not to include the current number in the final array
        subset.remove(subset.size() - 1);
        backtrack(i + 1, subset);
    }
}
