//https://leetcode.com/problems/bricks-falling-when-hit/description/

import java.util.ArrayList;
import java.util.List;

public class Leetcode802 {
    public static void main(String args[]) {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer> res = eventualSafeNodes(graph);
        System.out.println(res);
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        if(graph == null || graph.length == 0)  return res;

        int nodeCount = graph.length;
        int[] color = new int[nodeCount];

        for(int i = 0;i < nodeCount;i++){
            if(dfs(graph, i, color))    res.add(i);
        }

        return res;
    }
    public static boolean dfs(int[][] graph, int start, int[] color){
        if(color[start] != 0)   return color[start] == 1;

        color[start] = 2;
        for(int newNode : graph[start]){
            if(!dfs(graph, newNode, color))    return false;
        }
        color[start] = 1;

        return true;
    }

    //TLE
    /*public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<graph.length; i++) {
            boolean[] visited = new boolean[graph.length];
            visited[i] = true;
            if(!hasCycle(graph, i, visited)) {
                res.add(i);
            }
        }
        return res;
    }

    private static boolean hasCycle(int[][] graph, int index, boolean[] visited) {
        for(int num : graph[index]) {
            if(visited[num]) return true;
            visited[num] = true;
            if(hasCycle(graph, num, visited)) {
                return true;
            }
            visited[num] = false;
        }
        return false;
    }*/

}
