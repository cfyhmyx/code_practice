//Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map,
//compute the volume of water it is able to trap after raining.
//Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.

//complexity: We put m + n elements into the heap during the heapify process, so it's O(m + n) run time.
//During the while loop, every cell is put into and take out of the heap at most once, and we are doing so in a BFS style,
//meaning that there is m + n elements in the heap at the worst case. So it is O(m * n * log(m + n)) in the worst case.
//So the run time complexity would be O(m * n * log(m + n)).
//The space complexity is obviously O(m * n) because of the visited array.

import java.util.*;

public class Leetcode407 {
    public static void main(String args[]) {
    }

    public static int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
            return 0;

        PriorityQueue<Cell> queue = new PriorityQueue<>(new Comparator<Cell>(){
            public int compare(Cell a, Cell b) {
                return a.height - b.height;
            }
        });

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            queue.offer(new Cell(i, 0, heightMap[i][0]));
            queue.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }

        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            queue.offer(new Cell(0, i, heightMap[0][i]));
            queue.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
        }

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0;
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            for (int[] dir : dirs) {
                int row = cell.row + dir[0];
                int col = cell.col + dir[1];
                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
                    visited[row][col] = true;
                    res += Math.max(0, cell.height - heightMap[row][col]);
                    queue.offer(new Cell(row, col, Math.max(heightMap[row][col], cell.height)));
                }
            }
        }

        return res;
    }

    public static class Cell {
        int row;
        int col;
        int height;
        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

}
