//Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally
//(horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
//Count the number of distinct islands.
//An island is considered to be the same as another if and only if one island can be translated
//(and not rotated or reflected) to equal the other.

import java.util.*;

public class Leetcode694 {
    public static void main(String args[]) {
        int[][] grid = {{1,1,0}, {0,1,1},{0,0,0},{1,1,1},{0,1,0}};
        int result = numDistinctIslands(grid);
        System.out.println(result);
    }

    public static int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    getIsland(i, j, m, n, grid, sb, "o");
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    public static void getIsland(int row, int col, int m, int n, int[][] grid, StringBuilder sb, String dir) {
        if(row<0 || col<0 || row>=m || col>= n || grid[row][col] != 1) return;
        grid[row][col] = 0;
        sb.append(dir);
        getIsland(row-1, col, m, n, grid, sb, "u");
        getIsland(row+1, col, m, n, grid, sb, "d");
        getIsland(row, col-1, m, n, grid, sb, "l");
        getIsland(row, col+1, m, n, grid, sb, "r");
        sb.append("b");
    }

}
