//There are a total of n courses you have to take, labeled from 0 to n - 1.
//Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

import java.util.*;

public class Leetcode207 {
    public static void main(String args[]) {
        int[][] edges = {{1,0},{0,1}};
        boolean result = canFinish(2, edges);
        System.out.println(result);
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue queue = new LinkedList();
        int count=0;

        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        for(int i=0; i<prerequisites.length;i++){
            degree[prerequisites[i][0]]++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for(int i=0; i<degree.length;i++){
            if(degree[i] == 0){
                queue.add(i);
                count++;
            }
        }

        while(queue.size() != 0){
            int course = (int)queue.poll();
            for(int i=0; i<graph[course].size();i++){
                int pointer = (int)graph[course].get(i);
                degree[pointer]--;
                if(degree[pointer] == 0){
                    queue.add(pointer);
                    count++;
                }
            }
        }
        if(count == numCourses)
            return true;
        else
            return false;
    }

    //dfs, need to prune
    /*public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        createMap(prerequisites, graph);
        int[] path = new int[numCourses];   //very important: 0: hasn't been visited, 1: on the current circle path, 2: visited
        for(int i=0; i<numCourses; i++) {
            if(hasCircle(graph, i, path)) {
                return false;
            }
        }
        return true;
    }

    private static void createMap(int[][] prerequisites, Map<Integer, List<Integer>> graph) {
        for(int[] pre : prerequisites) {
            if(!graph.containsKey(pre[1])) {
                graph.put(pre[1], new ArrayList<>());
            }
            graph.get(pre[1]).add(pre[0]);
        }
    }

    private static boolean hasCircle(Map<Integer, List<Integer>> graph, int cur, int[] path) {
        if(path[cur] == 1) return true;
        if(path[cur] == 2) return false;
        path[cur] = 1;
        if(graph.get(cur) != null) {
            for (int course : graph.get(cur)) {
                if(hasCircle(graph, course, path)){
                    return true;
                }
            }
        }
        path[cur] = 2;
        return false;
    }*/
}
