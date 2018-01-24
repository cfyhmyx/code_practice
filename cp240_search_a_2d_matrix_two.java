//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//Integers in each row are sorted in ascending from left to right.
//Integers in each column are sorted in ascending from top to bottom.

public class Leetcode240 {
    public static void main(String args[]) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n-1;
        while(row<m && col>=0) {
            if(matrix[row][col] > target) {
                col--;
            } else if(matrix[row][col] <target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }

}
