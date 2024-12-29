package leetcode;

/*
* Assumption: the list to the right of the pivot is in descending order
*
* The permutation is the next one in increasing lexicographic order. Therefore, when considering the next one, we need
* to look for the section that is decreasing, as that section cannot change order anymore.
* Example:
* 6,2,1,5,4,3,0
* After 1, decreasing order so that part has no next permutation. Therefore, we focus on 1.
* We find the next biggest element, which is 3 (as any element smaller than 1 would have been placed before 1).
* We swap 1 and 3
* 6,2,3,5,4,1,0
* We reverse the elements from 5 to 0 (since they are already sorted in descending order, this means sorting them asc)
* We obtain 6,2,3,0,1,4,5
*
* Find decreasing section:
* First we move an index i from right to left, until we find a number on the left that is smaller than the one to it's right:
* 1,2,3: we start at 3 and stop at 2
*
* Find the next bigger number in the increasing sequence (bigger than 1 in this case: 3)
* if i is >= 0, we initiate a second index j
* We move j until it points to a number bigger than nums[i]. When this number is found (or end of loop), swap i and j
*
* Reverse to place in ascending order
* Finally, reverse al elements from i to the end of the array
* Time: O(n)
* Space: O(1)
* */

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        // we are looking from an increase left to right, e.g. 1, 5
        while (i >= 0 && nums[i+1] <= nums[i]) i--;

        if (i >= 0) {
            // find the next bigger element than nums[i]. Since descending, go as far left as possible
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }

        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;

        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

    }
}
