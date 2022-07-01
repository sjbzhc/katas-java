package leetcode;

/*
* Time: O(log mn)
* Space: O(1)
* */

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;

        int n = matrix[0].length;

        int l = 0;
        int r = m * n - 1;
        int pivotIndex;
        int pivotElement;

        while (l <= r) {
            pivotIndex = (l + r) / 2;
            pivotElement = matrix[pivotIndex / n][pivotIndex % n];

            if (target == pivotElement) return true;
            else if (target < pivotElement) r = pivotIndex - 1;
            else l = pivotIndex + 1;
        }
        return false;
    }
}
