//Given an m * n matrix M initialized with all 0's and several update operations.
//Operations are represented by a 2D array, and each operation is represented by an array with two positive integers a and b,
//which means M[i][j] should be added by one for all 0 <= i < a and 0 <= j < b.
//You need to count and return the number of maximum integers in the matrix after performing all the operations.

public class Leetcode598 {
    public static void main(String args[]) {

    }

    public static int maxCount(int m, int n, int[][] ops) {
        int a = 40000;
        int b = 40000;
        for(int[] ab : ops) {
            a = Math.min(ab[0], a);
            b = Math.min(ab[1], b);
        }
        return Math.min(a*b, m*n);
    }
}
