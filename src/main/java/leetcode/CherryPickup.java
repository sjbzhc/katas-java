package leetcode;

public class CherryPickup {

    int n;
    int[][][] dp;
    int[][] grid;

    public int cherryPickup(int[][] grid) {
        n = grid.length;
        dp = new int[n][n][n];
        this.grid = grid;
        int max = func(0,0,0);
        return max < 0 ? 0 : max;
    }

    public int func(int r1, int c1, int c2) {
        /*
        * Due to constrained movement (only down and right), we can assume:
        * c1 + r1 = r2 + c2
        * */
        int r2 = r1 + c1 - c2;

        if (r1 >=n || r2 >= n || c1 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }

        if (dp[r1][c1][c2] != 0) return dp[r1][c1][c2];

        // Base case: bottom right
        if (r1 == n-1 && c1 == n-1) return grid[r1][c1];

        int ans = 0;
        // If r1 == r2, it means c1 and c2 are the same as well due to constrains in movement
        // therefore, we are at the same spot and only need to add it once
        if (r1 != r2) ans = grid[r1][c1] + grid[r2][c2];
        else ans = grid[r1][c1];

        int downDown = func(r1+1, c1, c2);
        int downRight = func(r1+1, c1, c2+1);
        int rightDown = func(r1, c1+1, c2);
        int rightRight = func(r1, c1+1, c2+1);

        dp[r1][c1][c2] = ans + Math.max(
                downDown, Math.max(
                        downRight, Math.max(
                                rightDown, rightRight
                        )
                )
        );

        return dp[r1][c1][c2];
    }


    int max = 0;
    int m;
//    int n;
//    int[][] grid;

    public int cherryPickupBacktrack(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        check(0,0,0);
        return max;
    }

    public void check(int i, int j, int cherries) {
        if (i == m -1 && j == n-1) {
            checkRev(i, j, cherries);
            return;
        }

        cherries += grid[i][j];
        int tmp = grid[i][j];
        grid[i][j] = 0;

        // Can explore below, as not blocked
        if (i<m-1 && grid[i+1][j] != -1) {
            check(i+1, j, cherries);
        }

        // Can explore to the right
        if (j<n-1 && grid[i][j+1] != -1) {
            check(i, j+1, cherries);
        }

        grid[i][j] = tmp;
    }

    public void checkRev(int i, int j, int cherries) {
        if (i == 0 && j == 0) {
            max = Math.max(max, cherries);
            return;
        }

        int tmp = grid[i][j];
        cherries += tmp;
        grid[i][j] = 0;

        if (i>0 && grid[i-1][j] != -1) {
            checkRev(i-1, j, cherries);
        }

        if (j>0 && grid[i][j-1] != -1) {
            checkRev(i, j-1, cherries);
        }

        grid[i][j] = tmp;
    }


}
