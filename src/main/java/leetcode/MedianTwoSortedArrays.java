package leetcode;

/*
* We want to achieve following:
*
*     bl   br
* [1 2 3 | 4 5 6 7 8]
*     al   ar
* [1 2 3 | 4]
*
* al <= br && bl <= ar
* */

/*
* Time: O(log m + n)
* Space: O(1)
* */

public class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Have nums1 as the shorter one
        // we only run the binary search in one of the arrays, so we want to do it on the shorter one
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int combinedLength = nums1.length + nums2.length;
        int l = 0;
        int r = nums1.length;

        while (l <= r) {
            int partitionA = (l + r) / 2;
            // this is the remainder to have the left partition of the combined array, which is made of
            // partitionA + partitionB = (combinedLength + 1) / 2
            int partitionB = (combinedLength + 1) / 2 - partitionA;

            // these are the values left and right of the partition
            // [a b | c d]: aLeft is b, aRight is c
            int aLeft = getLeft(nums1, partitionA);
            int aRight = getRight(nums1, partitionA);

            int bLeft = getLeft(nums2, partitionB);
            int bRight = getRight(nums2, partitionB);

            if (aLeft <= bRight && bLeft <= aRight) {
                if (combinedLength % 2 == 0) {
                    return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
                }
                return Math.max(aLeft, bLeft);
            }

            // A's partition is too large. We need to make it smaller, so we decrease r
            if (aLeft > bRight) {
                r = partitionA - 1;
            } else {
                l = partitionA + 1;
            }
        }
        return -1;
    }

    public int getLeft(int[] nums, int partition) {
        if (partition == 0) {
            return (int) Double.NEGATIVE_INFINITY;
        } else {
            return nums[partition - 1];
        }
    }

    public int getRight(int[] nums, int partition) {
        if (partition == nums.length) {
            return (int) Double.POSITIVE_INFINITY;
        } else {
            return nums[partition];
        }
    }
}
