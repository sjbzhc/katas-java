package leetcode;

/*
* Space: O(n * k)
* Time: O(n)
* */
public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];

        for (int[] u: updates) {
            int lower = u[0];
            int upper = u[1];
            int increment = u[2];
            for (int i = lower; i<=upper; i++) {
                res[i] += increment;
            }
        }
        return res;
    }

    /*
    * When we store a value in arr[start], with partialSum, we are propagating the value until the end of the array, so
    * all entries after start will have the value added.
    *
    * We handle the end of the boundary by removing the value we added from end + 1. This way, the value we added with
    * start is removed from end + 1 on, and we effectively have 0.
    * */

    public int[] getModifiedArrayWithCaching(int length, int[][] updates) {
        int[] res = new int[length];

        for (int[] u : updates) {
            int lower = u[0];
            int upper = u[1] + 1;
            int increment = u[2];
            res[lower] += increment;
            if (upper < length - 1) {
                res[upper] -= increment;
            }
        }
        partialSum(res);
        return res;
    }

    private void partialSum(int[] res) {
        for (int i=1; i< res.length;i++) {
            res[i] = res[i-1] + res[i];
        }
    }
}
