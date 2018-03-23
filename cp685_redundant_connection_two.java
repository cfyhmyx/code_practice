//https://leetcode.com/problems/redundant-connection-ii/description/

import java.util.HashMap;
import java.util.Map;

public class Leetcode685 {
    public static void main(String args[]) {
        int[][] edges = {{6,3},{8,4},{9,6},{3,2},{5,10},{10,7},{2,1},{7,6},{4,5},{1,8}};
        int[] result = findRedundantDirectedConnection(edges);
        for(int i=0; i<result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static Map<Integer, Integer> root;

    public static int[] findRedundantDirectedConnection(int[][] edges) {
        root = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();
        int[] candidate1 = null;
        int[] candidate2 = null;
        for(int[] edge : edges) {
            if(!parent.containsKey(edge[0])) {
                parent.put(edge[0], edge[0]);
            }
            if(!parent.containsKey(edge[1]) || parent.get(edge[1]) == edge[1]) {
                parent.put(edge[1], edge[0]);
            } else if(parent.get(edge[1]) != edge[1]) {
                candidate1 = new int[]{parent.get(edge[1]), edge[1]};
                candidate2 = new int[]{edge[0], edge[1]};
                edge[0] = -1;
                edge[1] = -1;
            }
        }

        for(int[] edge : edges) {
            if(edge[0]<0 || edge[1]<0) continue;
            if(!root.containsKey(edge[0])) {
                root.put(edge[0], edge[0]);
            }
            if(!root.containsKey(edge[1])) {
                root.put(edge[1], edge[1]);
            }
            if(!union(edge[0], edge[1])) {
                return candidate1 == null ? edge : candidate1;
            }
        }
        return candidate2;
    }

    private static int find(int num) {
        if(root.get(num) == num) {
            return num;
        }
        int rootVal = find(root.get(num));
        root.put(num, rootVal);
        return rootVal;
    }

    private static boolean union(int num1, int num2) {
        int root1 = find(num1);
        int root2 = find(num2);
        if(root1 == root2) return false;
        root.put(root2, root1);
        return true;
    }
}
