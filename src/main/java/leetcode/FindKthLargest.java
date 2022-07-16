package leetcode;

/*
* Time: O(n) avg case
* Space: O(1)
* */
public class FindKthLargest {
    int[] nums;
    int targetIndex;
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        this.targetIndex = nums.length - k;
        return quickSelect(0, nums.length - 1);
    }

    private int quickSelect(int l, int r) {
        int pivotValue = nums[r];
        int j = l;
        for (int i=l; i<r; i++) {
            if (nums[i] < pivotValue) {
                swap(i, j);
                j++;
            }
        }
        swap(j, r);

        if (targetIndex < j) return quickSelect(l, j - 1);
        else if (targetIndex > j) return quickSelect(j + 1, r);
        return nums[j];
    }

    private void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
