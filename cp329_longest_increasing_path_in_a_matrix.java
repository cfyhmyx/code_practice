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
    }

}
