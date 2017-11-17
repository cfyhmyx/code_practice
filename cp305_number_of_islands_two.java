//A 2d grid map of m rows and n columns is initially filled with water.
//We may perform an addLand operation which turns the water at position (row, col) into a land.
//Given a list of positions to operate, count the number of islands after each addLand operation.
//An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
//You may assume all four edges of the grid are all surrounded by water.

import java.util.*;

public class Leetcode305 {
    public static void main(String args[]) {
        int[][] positions = {{0,0},{0,1},{1,2},{2,1}};
        List<Integer> result = numIslands2(3,3,positions);
        System.out.println(result);
    }

    private static int island = 0;
    private static int[] rank;
    private static Map<Integer, Integer> map = new HashMap<>();

    private static List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new LinkedList();
        if (m == 0 || n == 0) return res;
        rank = new int[m * n];
        int[][] step = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] p : positions) {
            int row = p[0], col = p[1];
            int node = row * n + col;
            if(map.containsKey(node)) {
                res.add(island);
                continue;
            }
            map.put(node, node);
            island += 1;
            for (int[] s : step) {
                int i = row + s[0], j = col + s[1];
                int neighbor = i * n + j;
                if (i >= 0 && i < m && j >= 0 && j < n && map.containsKey(neighbor)) {
                    union(node, neighbor);
                }
            }
            res.add(island);
        }
        return res;
    }

    private static int union(int n1, int n2) {
        int root1 = find(n1), root2 = find(n2);
        if (root1 == root2) return root1;
        island--;
        if (rank[root1] >= rank[root2]) {
            map.put(root2, root1);
            if (rank[root1] == rank[root2])
                rank[root1]++;
            return root1;
        }
        else {
            map.put(root1,root2);
            return root2;
        }
    }

    private static int find(int node) {
        int parent = map.get(node);
        if(node == parent) {
            return node;
        }
        int ancestor = find(parent);
        map.put(node, ancestor);
        return ancestor;
    }

}
