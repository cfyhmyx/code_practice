//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
//An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
//You may assume all four edges of the grid are all surrounded by water.

public class Leetcode200 {
    public static void main(String args[]) {
        char[][] grid = {{'1','1','0','0','0'}, {'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        int result = numIslands(grid);
        System.out.println(result);
    }

    public static int numIslands(char[][] grid) {
        int result = 0;
        int m = grid.length;
        if(m == 0) return result;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    getIsland(i, j, m, n, grid, visited);
                    result++;
                }
            }
        }
        return result;
    }

    public static void getIsland(int row, int col, int m, int n, char[][] grid, boolean[][] visited) {
        visited[row][col] = true;
        if(row>0 && grid[row-1][col]=='1' && !visited[row-1][col]) {
            getIsland(row-1, col, m, n, grid, visited);
        }
        if(row<m-1 && grid[row+1][col] == '1' && !visited[row+1][col]){
            getIsland(row+1, col, m, n, grid, visited);
        }
        if(col>0 && grid[row][col-1] == '1' && !visited[row][col-1]){
            getIsland(row, col-1, m, n, grid, visited);
        }
        if(col<n-1 && grid[row][col+1] == '1' && !visited[row][col+1]){
            getIsland(row, col+1, m, n, grid, visited);
        }
    }

}
