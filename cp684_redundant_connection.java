//https://leetcode.com/problems/redundant-connection/description/

import java.util.HashMap;
import java.util.Map;

public class Leetcode684 {
    public static void main(String args[]) {

    }

    private Map<Integer, Integer> rank;
    private Map<Integer, Integer> root;

    public int[] findRedundantConnection(int[][] edges) {
        rank = new HashMap<>();
        root = new HashMap<>();
        int[] result = new int[2];
        for(int[] edge : edges) {
            if(!rank.containsKey(edge[0])) {
                rank.put(edge[0], 0);
                root.put(edge[0], edge[0]);
            }
            if(!rank.containsKey(edge[1])) {
                rank.put(edge[1], 0);
                root.put(edge[1], edge[1]);
            }
            if(!union(edge[0], edge[1])) {
                result[0] = edge[0];
                result[1] = edge[1];
                break;
            }
        }
        return result;
    }

    private int find(int num) {
        if(root.get(num) == num) {
            return num;
        }
        int rootVal = find(root.get(num));
        root.put(num, rootVal);
        return rootVal;
    }

    private boolean union(int num1, int num2) {
        int root1 = find(num1);
        int root2 = find(num2);
        if(root1 == root2) return false;
        if(rank.get(root1) >= rank.get(root2)) {
            if(rank.get(root1) == rank.get(root2)) {
                rank.put(root1, rank.get(root1)+1);
            }
            root.put(root2, root1);
        } else {
            root.put(root1, root2);
        }
        return true;
    }
}
