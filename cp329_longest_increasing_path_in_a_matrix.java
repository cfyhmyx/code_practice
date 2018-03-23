//Given an integer matrix, find the length of the longest increasing path.
//From each cell, you can either move to four directions: left, right, up or down.
//You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

public class Leetcode329 {
    public static void main(String args[]) {
        int[][] matrix = {{3,4,5},{3,2,6},{2,2,1}};
        int result = longestIncreasingPath(matrix);
        System.out.println(result);
    }

    public static int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int max = dfs(matrix, Integer.MIN_VALUE, i, j, m, n, cache);
                res = Math.max(res, max);
            }
        }
        return res;
    }

    private static int dfs(int[][] matrix, int min, int i, int j, int m, int n, int[][] cache) {
        if(i<0 || j<0 || i>=m || j>=n || matrix[i][j] <= min) return 0;
        if(cache[i][j] != 0) {
            return cache[i][j];
        }
        min = matrix[i][j];
        int a = dfs(matrix, min, i-1, j, m, n, cache) + 1;
        int b = dfs(matrix, min, i+1, j, m, n, cache) + 1;
        int c = dfs(matrix, min, i, j-1, m, n, cache) + 1;
        int d = dfs(matrix, min, i, j+1, m, n, cache) + 1;
        int max = Math.max(a, Math.max(b, Math.max(c, d)));
        cache[i][j] = max;
        return max;
    }

    /*public static int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] cache = new int[matrix.length][matrix[0].length];
        int result = 0;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                int temp = helper(i,j,matrix, cache);
                if(temp>result) result = temp;
            }
        }
        return result;
    }

    public static int helper(int row, int col, int[][]matrix, int[][]cache) {
        if(cache[row][col] > 0) {
            return cache[row][col];
        }
        int temp = 0;
        if(col-1>=0 && matrix[row][col-1] > matrix[row][col]) {
            temp = Math.max(helper(row, col-1, matrix, cache), temp);
        }
        if(col+1<matrix[row].length && matrix[row][col+1] > matrix[row][col]) {
            temp = Math.max(helper(row, col+1, matrix, cache), temp);
        }
        if(row-1>=0 && matrix[row-1][col] > matrix[row][col]) {
            temp = Math.max(helper(row-1, col, matrix, cache), temp);
        }
        if(row+1<matrix.length && matrix[row+1][col] > matrix[row][col]) {
            temp = Math.max(helper(row+1, col, matrix, cache), temp);
        }
        cache[row][col] = ++temp;
        return cache[row][col];
    }*/

}
