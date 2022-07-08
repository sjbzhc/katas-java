package leetcode;

public class CountSubmatricesWithAllOnes {
    public int numSubmat(int[][] mat) {
        int ROWS = mat.length;
        int COLS = mat[0].length;

        // This counts the vertical sub-matrices
        // If the previous row also has a 1 we add it to the current row
        for(int i=1; i < ROWS; i++) {
            for(int j=0; j < COLS; j++) {
                if(mat[i][j] == 1) {
                    mat[i][j] += mat[i-1][j];
                }
            }
        }


        int tmp=0;
        int res=0;
        for(int i=0 ;i < ROWS; i++) {
            for(int j=0; j < COLS; j++) {
                if (mat[i][j] > 0) {
                    // checking the elements to the right of the matrix starting from the current cell
                    for (int c = j + 1; c < COLS; c++) {
                        tmp = mat[i][j];
                        if (mat[i][c] > 0) {
                            tmp = Math.min(mat[i][c], tmp);
                            mat[i][j] += tmp;
                        } else {
                            break;
                        }
                    }

                }
                res += mat[i][j];
            }
        }
        return res;
    }
}
