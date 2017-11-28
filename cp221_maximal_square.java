//Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

import java.util.Arrays;

public class Leetcode221 {
    public static void main(String args[]) {
        //char[][] matrix = {{'1','0','1','0', '0'}, {'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] matrix = {{'0','1'}};
        int result = maximalSquare(matrix);
        System.out.println(result);
    }

    public static int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, result = 0;
        int[] dp = new int[m];
        for(int i=0; i<m; i++) {
            dp[i] = matrix[i][0] - '0';
            result = Math.max(result, dp[i]);
        }
        for(int j=1; j<n; j++) {
            int pre = dp[0];
            dp[0] = matrix[0][j]-'0';
            result = Math.max(result, dp[0]);
            for(int i=1; i<m; i++) {
                int temp = dp[i];
                if(matrix[i][j] == '1') {
                    dp[i] = Math.min(dp[i], Math.min(pre, dp[i-1]))+1;
                    result = Math.max(result, dp[i]);
                } else {
                    dp[i] = 0;
                }
                pre = temp;
            }
        }
        return result*result;
    }

    /*public static int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, result = 0;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1 ; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1] , dp[i-1][j-1]), dp[i-1][j]) + 1;
                    result = Math.max(dp[i][j], result);
                }
            }
        }
        return result*result;
    }*/

    /*public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int result = 0;
        if(m<1) return result;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        Arrays.fill(right, n);
        for(int i=0; i<m; i++) {
            int cur_left = 0;
            int cur_right = n;

            for(int j=0; j<n; j++) {
                if(matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], cur_left);
                } else {
                    left[j] = 0;
                    cur_left = j+1;
                }
            }

            for(int j=n-1; j>=0; j--) {
                
                if(matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], cur_right);
                } else {
                    right[j] = n;
                    cur_right = j;
                }
            }

            for(int j=0; j<n; j++) {
                if(matrix[i][j] == '1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }

            for(int j=0; j<n; j++) {
                int edge = Math.min((right[j] - left[j]), height[j]);
                result = Math.max(result, edge*edge);
            }
        }
        return result;
    }*/

}
