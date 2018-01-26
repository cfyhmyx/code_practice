//A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
//Now given an M x N matrix, return True if and only if the matrix is Toeplitz.

public class Leetcode766 {
    public static void main(String args[]) {
        int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        boolean result = isToeplitzMatrix(matrix);
        System.out.println(result);
    }

    //O(m*n)
    public static boolean isToeplitzMatrix(int[][] matrix) {
         if(matrix.length == 0) return false;
         for(int i=0; i<matrix.length-1; i++) {
             for(int j=0; j<matrix[0].length-1; j++) {
                 if(matrix[i][j] != matrix[i+1][j+1]){
                     return false;
                 }
             }
         }
         return true;
    }

}
