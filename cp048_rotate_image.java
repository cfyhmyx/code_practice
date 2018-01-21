//You are given an n x n 2D matrix representing an image.
//Rotate the image by 90 degrees (clockwise).
//Note: You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
//DO NOT allocate another 2D matrix and do the rotation.

public class Leetcode048 {
    public static void main(String args[]) {

    }

    public void rotate(int[][] matrix) {
        int s = 0, e = matrix.length - 1;
        while(s < e){
            int[] temp = matrix[s];
            matrix[s] = matrix[e];
            matrix[e] = temp;
            s++; e--;
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = i+1; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

}
