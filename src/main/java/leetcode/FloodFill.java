package leetcode;

/*
* Time: O(n)
* Sace: O(n)
* */

public class FloodFill {
    int[][] img;
    int[][] visited;
    int ROWS;
    int COLS;
    int color;
    int originalColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0) return image;
        img = image;
        ROWS = image.length;
        COLS = image.length;
        color = newColor;
        visited = new int[ROWS][COLS];

        if (image[sr][sc] == newColor) return image;
        originalColor = image[sr][sc];
        dfs(sr, sc);
        return img;
    }

    private void dfs(int row, int col) {
        visited[row][col] = 1;
        img[row][col] = color;

        int[] rowOffsets = {-1,0,1,0};
        int[] colOffsets = {0,-1,0,1};

        for (int d=0;d<4;d++) {
            int newRow = row + rowOffsets[d];
            int newCol = col + colOffsets[d];

            if (newRow >= ROWS || newRow < 0 || newCol >= COLS || newCol < 0 || visited[newRow][newCol] == 1 || img[newRow][newCol] != originalColor) continue;
            dfs(newRow, newCol);
        }
    }
}
