//Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
//The distance between two adjacent cells is 1.
//Note:
//The number of elements of the given matrix will not exceed 10,000.
//There are at least one 0 in the given matrix.
//The cells are adjacent in only four directions: up, down, left and right.

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode542 {
    public static void main(String args[]) {

    }

    //BFS
    public static int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
                else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n ||
                        matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) continue;
                queue.add(new int[] {r, c});
                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
            }
        }

        return matrix;
    }

    //DFS, slower
    /*public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return matrix;
        int n = matrix[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 1) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    helper(matrix, i, j, m, n, 0);
                }
            }
        }
        return matrix;
    }

    private void helper(int[][] matrix, int row, int col, int m, int n, int dis) {
        if(row<0 || row>=m || col<0 || col>=n || matrix[row][col]<dis) return;
        matrix[row][col] = dis;
        helper(matrix, row, col-1, m, n, dis+1);
        helper(matrix, row, col+1, m, n, dis+1);
        helper(matrix, row-1, col, m, n, dis+1);
        helper(matrix, row+1, col, m, n, dis+1);
    }*/
}
