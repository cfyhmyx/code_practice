//Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

import java.util.ArrayList;
import java.util.List;

public class Leetcode054 {
    public static void main(String args[]) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> result = spiralOrder(matrix);
        System.out.println(result);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0) return res;
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        while(true) {
            for(int i=left; i<=right; i++) {
                res.add(matrix[top][i]);
            }
            if(++top > bottom) break;
            for(int i=top; i<= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if(--right < left) break;
            for(int i=right; i>=left; i--) {
                res.add(matrix[bottom][i]);
            }
            if(--bottom < top) break;
            for(int i=bottom; i>=top; i--) {
                res.add(matrix[i][left]);
            }
            if(++left > right) break;
        }
        return res;
    }
}
