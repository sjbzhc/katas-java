package leetcode;

/*
* Start with square's angles
*
* start with tl
* tl moves one spot to the right
* bl moves one spot up
* br moves one spot left
*
* We do the order counter clockwise to save tmp vars.
* We start with tl
* Then put bl in tl
* Then put br in bl
* Then put tr in br
* Then put tl in tr
*
* We add the i accordingly:
* tl right: + i to col index
* bl up: - i to row index
* br left: - i in col index
* tr down: + i in row
*
* */

public class RotateImage {
    public void rotate(int[][] matrix) {
        int l = 0;
        int r = matrix.length - 1;

        while (l < r) {
            for (int i=0; i < r - l; i++) {
                int top = l;
                int bottom = r;

                // Save tl in tmp
                int tmp = matrix[top][l + i];

                // Move bl into tl
                matrix[top][l + i] = matrix[bottom - i][l];

                // Move br into bl
                matrix[bottom - i][l] = matrix[bottom][r - i];

                // Move tr into br
                matrix[bottom][r - i] = matrix[top + i][r];

                // Move tl into tr
                matrix[top + i][r] = tmp;
            }
            r--;
            l++;
        }

    }





//    public void rotate(int[][] matrix) {
//        int n = matrix.length;
//        int n0 = n - 1;
//        for (int i=0; i< (n+1) / 2; i++) {
//            for (int j=0 ; j < n / 2; j++) {
//                int temp = matrix[n0 - j][i];
//                matrix[n0 - j][i] = matrix[n0 - i][n0 - j];
//                matrix[n0 - i][n0 - j] = matrix[j][n0 -i];
//                matrix[j][n0 - i] = matrix[i][j];
//                matrix[i][j] = temp;
//            }
//        }
//    }


}
