//For a undirected graph with tree characteristics, we can choose any node as the root.
//The result graph is then a rooted tree.
//Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs).
//Given such a graph, write a function to find all the MHTs and return a list of their root labels.

import java.util.*;

public class Leetcode310 {
    public static void main(String args[]) {
        int[][] edges = {{0,3},{1,3},{2,3},{4,3},{5,4}};
        List<Integer> result = findMinHeightTrees(6, edges);
        for(int i=0; i<result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) return Arrays.asList(0);

        HashSet[] map =  new HashSet[n];
        for(int i=0; i<n; i++) {
            map[i] = new HashSet();
        }
        for(int[] edge : edges) {
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(map[i].size() == 1) {
                leaves.add(i);
            }
        }
        while(n>2) {
            n = n-leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int leave : leaves){
                int next = (int)map[leave].iterator().next();
                map[next].remove(leave);
                if(map[next].size()==1) {
                    newLeaves.add(next);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }

}
