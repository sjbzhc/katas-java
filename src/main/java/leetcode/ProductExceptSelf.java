package leetcode;

/*
* The multiplications are offset:
*
* For:
* [1 2 3 4]
*
* We have:
* l = [1  1  2 4]
* r = [24 12 4 1]
*
* By offsetting l i + 1 to the right, we ensure the element at i is not included in the final multiplication
*
* Time: O(n)
* Space: O(n)
* */

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int n = nums.length;
        left[0] = 1;
        right[n - 1] = 1;

        for (int i=1;i<n; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        for (int i=n - 2;i>=0; i--) {
            right[i] = right[i+ 1] * nums[i + 1];
        }

        for (int i=0; i< n; i++) {
            nums[i] = left[i] * right[i];
        }

        return nums;
    }

    /*
    * Time: O(n)
    * Memory: O(1)
    * */

    public int[] productExceptSelfConstantMemory(int[] nums) {
        int n = nums.length;

        int[] answer = new int[n];

        answer[0] = 1;

        for (int i=1; i<n; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        int r = 1;

        for (int i = n-1; i>=0; i--) {
            answer[i] = answer[i] * r;
            r *= nums[i];
        }

        return answer;
    }
}
