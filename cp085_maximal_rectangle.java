//Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

import java.util.Arrays;

public class Leetcode085 {
    public static void main(String args[]) {
        char[][] matrix = {{'1','0','1','0', '0'}, {'1','0','1','0','0'},{'1','0','1','1','1'},{'1','0','1','1','1'},{'1','0','0','1','0'}};
        int result = maximalRectangle(matrix);
        System.out.println(result);
    }

    public static int maximalRectangle(char[][] matrix) {
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
                result = Math.max(result, (right[j]-left[j])*height[j]);
            }
        }
        return result;
    }
}
