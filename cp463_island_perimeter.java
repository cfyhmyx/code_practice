//You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
//Grid cells are connected horizontally/vertically (not diagonally).
//The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
//The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
//One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
//Determine the perimeter of the island.

public class Leetcode463 {
    public static void main(String args[]) {
        int[][] grid = {{1,1,1}, {0,1,1},{0,0,0},{0,0,0},{0,0,0}};
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
                    int up = getLength(i-1, j, m, n, grid);
                    int down = getLength(i+1, j, m, n, grid);
                    int left = getLength(i, j-1, m, n, grid);
                    int right = getLength(i, j+1, m, n, grid);
                    result = result+up+down+left+right;
                }
            }
        }
        return result;
    }

    public static int getLength(int row, int col, int m, int n, int[][] grid) {
        if(row<0 || col<0 || row>=m || col>= n || grid[row][col] != 1) return 1;
        else return 0;
    }

}
