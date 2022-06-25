package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
* Time: O(n!)
* Space: O(n!)
* */
public class Permute {
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

        for (int i=0; i<nums.length; i++) {
            if (temp.contains(nums[i])) continue;

            temp.add(nums[i]);
            backtrack(temp);
            temp.remove(temp.size() - 1);
        }
    }
}
