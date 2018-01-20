//https://leetcode.com/problems/walls-and-gates/description/

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode286 {
    public static void main(String args[]) {
        int[][] grid = {{Integer.MAX_VALUE,-1,0,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,-1},
                {Integer.MAX_VALUE,-1,Integer.MAX_VALUE,-1},
                {0,-1,Integer.MAX_VALUE,Integer.MAX_VALUE}};
        wallsAndGates(grid);
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                System.out.print(grid[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    //bfs O(number of elements)
    public static void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = m == 0 ? 0 : rooms[0].length;
        int[][] dirs = {{-1,0}, {0,1}, {0,-1}, {1,0}};
        Queue<int[]> queue = new LinkedList<>();
        // add all gates to the queue
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[] {i,j});
                }
            }
        }
        // update distance from gates
        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            for (int[] dir: dirs) {
                int X = curPos[0] + dir[0];
                int Y = curPos[1] + dir[1];
                if (X<0 || Y <0 || X >= m || Y >= n || rooms[X][Y] <= rooms[curPos[0]][curPos[1]]+1) continue;
                rooms[X][Y] = rooms[curPos[0]][curPos[1]]+1;
                queue.offer(new int[] {X, Y});
            }
        }
    }

    //dfs slower >O(number of elements)
    /*public static void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if(m==0) return;
        int n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    findDistance(i, j, m, n, rooms, 0);
                }
            }
        }
    }

    private static void findDistance(int row, int col, int m, int n, int[][] rooms, int dis) {
        if(row<0 || col<0 || row>=m || col>=n || rooms[row][col]==-1 || rooms[row][col]<dis) return;
        rooms[row][col] = dis;
        findDistance(row-1, col, m, n, rooms, dis+1);
        findDistance(row+1, col, m, n, rooms, dis+1);
        findDistance(row, col-1, m, n, rooms, dis+1);
        findDistance(row, col+1, m, n, rooms, dis+1);
    }*/
}
