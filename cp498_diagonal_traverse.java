//description: https://leetcode.com/problems/diagonal-traverse/description/
public class Leetcode498 {
    public static void main(String args[]) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[] result = findDiagonalOrder(matrix);
        for(int i=0; i<result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        int row = 0;
        int col = 0;
        boolean directUp = true;
        int m = matrix.length;
        if(m == 0) return new int[0];
        int n = matrix[0].length;
        int[] result = new int[m*n];
        int index = 0;
        result[index] = matrix[row][col];
        while(true) {
            if(directUp) {
                if(row-1>=0 && col+1<n) {
                    row--;
                    col++;
                    index++;
                    result[index] = matrix[row][col];
                } else if(col+1<n) {
                    col++;
                    index++;
                    directUp = false;
                    result[index] = matrix[row][col];
                } else if(row+1<m) {
                    row++;
                    index++;
                    directUp = false;
                    result[index] = matrix[row][col];
                } else {
                    break;
                }
            } else {
                if(row+1<m && col-1>=0) {
                    row++;
                    col--;
                    index++;
                    result[index] = matrix[row][col];
                } else if(row+1<m) {
                    row++;
                    index++;
                    directUp = true;
                    result[index] = matrix[row][col];
                } else if(col+1<n) {
                    col++;
                    index++;
                    directUp = true;
                    result[index] = matrix[row][col];
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
