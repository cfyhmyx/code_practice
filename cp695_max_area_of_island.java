//Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
//You may assume all four edges of the grid are surrounded by water.
//Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

public class Leetcode695 {
    public static void main(String args[]) {
        int[][] grid = {{1,1,1}, {0,1,1},{0,0,0},{1,1,1},{1,1,1}};
        int result = maxAreaOfIsland(grid);
        System.out.println(result);
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    int area = getIsland(i, j, m, n, grid);
                    result = Math.max(result, area);
                }
            }
        }
        return result;
    }

    public static int getIsland(int row, int col, int m, int n, int[][] grid) {
        if(row<0 || col<0 || row>=m || col>= n || grid[row][col] != 1) return 0;
        grid[row][col] = 0;
        int up = getIsland(row-1, col, m, n, grid);
        int down = getIsland(row+1, col, m, n, grid);
        int left = getIsland(row, col-1, m, n, grid);
        int right = getIsland(row, col+1, m, n, grid);
        return 1+up+down+left+right;
    }

}
