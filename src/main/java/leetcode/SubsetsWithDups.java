package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Time: O(n 2^n)
* Space: O(2^n)
* */
public class SubsetsWithDups {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        backtrack(0, new ArrayList<>());
        return res;
    }

    private void backtrack(int i, ArrayList<Integer> list) {
        if (i == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[i]);
        backtrack(i + 1, list);
        list.remove(list.size() - 1);

        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        backtrack(i + 1, list);
    }
}
