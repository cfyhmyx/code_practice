//Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

public class Leetcode059 {
    public static void main(String args[]) {
        int[][] matrix = generateMatrix(3);
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;
        int index = 1;
        while(true) {
            for(int i=left; i<=right; i++) {
                matrix[top][i] = index++;
            }
            if(++top > bottom) break;
            for(int i=top; i<= bottom; i++) {
                matrix[i][right] = index++;
            }
            if(--right < left) break;
            for(int i=right; i>=left; i--) {
                matrix[bottom][i] = index++;
            }
            if(--bottom < top) break;
            for(int i=bottom; i>=top; i--) {
                matrix[i][left] = index++;
            }
            if(++left > right) break;
        }
        return matrix;
    }
}
